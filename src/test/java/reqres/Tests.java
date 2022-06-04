package reqres;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import reqres.models.*;


import java.time.Clock;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import static io.restassured.RestAssured.given;

public class Tests {
    @Test
    void morpheusWhoPost() {
        MorpheusRequest morpheusRequest = new MorpheusRequest("morpheus", "leader");
        MorpheusResponse resp =
                given()
                        .contentType(ContentType.JSON)
                        .body(morpheusRequest)
                        .when()
                        .post("https://reqres.in/api/users")
                        .then().log().body()
                        .statusCode(201)
                        .extract().as(MorpheusResponse.class);
        Assertions.assertEquals(morpheusRequest.getJob(), resp.getJob());
        Assertions.assertEquals(morpheusRequest.getName(), resp.getName());
        Assertions.assertNotNull(resp.getId());
    }


    @Test
    void updateMorphPut() {
        MorpheusRequest morpheusRequest = new MorpheusRequest("morpheus", "zion resident");
        MorpheusResponse resp =
                given()
                        .contentType(ContentType.JSON)
                        .body(morpheusRequest)
                        .when()
                        .put("https://reqres.in/api/users/2")
                        .then().log().body()
                        .statusCode(200)
                        .extract().as(MorpheusResponse.class);
        Assertions.assertEquals(morpheusRequest.getJob(), resp.getJob());
        Assertions.assertEquals(morpheusRequest.getName(), resp.getName());
        LocalDate date = LocalDate.now();
        Assertions.assertTrue(resp.getUpdatedAt().contains(date.toString()));
//        String regex = "(.{5})$";  - работает, но это тупо
//        String currentTime = Clock.systemUTC().instant().toString().replaceAll(regex,"");
//        Assertions.assertEquals(resp.getCreatedAt().replaceAll(regex,""),currentTime);
//        System.out.println("=======" +date + "======="+ currentTime);
    }

    @Test
    void getResource() {

        List<ListResponse> list =
                given()
                        .when()
                        .get("https://reqres.in/api/unknown")
                        .then().log().body()
                        .statusCode(200)
                        .extract().jsonPath().getList("data", ListResponse.class);
        List<Integer> years = list.stream().map(ListResponse::getYear).collect(Collectors.toList());
        List<Integer> sortYears = years.stream().sorted().collect(Collectors.toList());
        Assertions.assertEquals(years, sortYears);
    }

    @Test
    void negativeAuthTest() {
        RequestAuth reqAuth = new RequestAuth("12345", "clown", "79999999999");
        given()
                .body(reqAuth)
                .contentType(ContentType.JSON)
                .when()
                .post("https://backend.liveinclean.ru/api/v1/auth/login")
                .then().log().all()
                .statusCode(400);
    }

    @Test
    void listUsers() {
        List<ListUsersResponse> list =
                given()
                        .when()
                        .get("https://reqres.in/api/users?page=2")
                        .then().log().body()
                        .statusCode(200)
                        .extract().jsonPath().getList("data", ListUsersResponse.class);
        Assertions.assertTrue(list.stream().allMatch(x -> x.getAvatar().contains(x.getId().toString())));
        Assertions.assertTrue(list.stream().allMatch(x -> x.getEmail().endsWith("reqres.in")));
    }

}
