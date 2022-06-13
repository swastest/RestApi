package reqres.withLombokTests;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import reqres.models.lombok.*;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import static io.restassured.RestAssured.given;

public class TestsLombok {
    @Test
    void morpheusWhoPost() {
        SpecificationApiTests.addSpec(SpecificationApiTests.reqSpec(),
                SpecificationApiTests.castomResponce(201));
        MorpheusRequestLombok morpheusRequestLombok = new MorpheusRequestLombok();
        morpheusRequestLombok.setJob("leader");
        morpheusRequestLombok.setName("morpheus");
        MorpheusResponseLombok resp =
                given()
                      //  .contentType(ContentType.JSON)  лежит в спецификации
                        .body(morpheusRequestLombok)
                        .when()
                        .log().all()
                        .post("/users")
                        .then().log().body()
                       // .statusCode(201)   лежит в спецификации, ожидаемый код указываю выше
                        .extract().as(MorpheusResponseLombok.class);
        Assertions.assertEquals(morpheusRequestLombok.getJob(), resp.getJob());
        Assertions.assertEquals(morpheusRequestLombok.getName(), resp.getName());
        Assertions.assertNotNull(resp.getId());
    }


    @Test
    void updateMorphPut() {
        SpecificationApiTests.addSpec(SpecificationApiTests.reqSpec(),
                SpecificationApiTests.castomResponce(200));
        MorpheusRequestLombok morpheusRequest = new MorpheusRequestLombok();
        morpheusRequest.setName("morpheus");
        morpheusRequest.setJob("zion resident");
        MorpheusResponseLombok resp =
                given()
                        //.contentType(ContentType.JSON)
                        .body(morpheusRequest)
                        .when()
                        .put("/users/2")
                        .then().log().body()
                        //.statusCode(200)
                        .extract().as(MorpheusResponseLombok.class);
        Assertions.assertEquals(morpheusRequest.getJob(), resp.getJob());
        Assertions.assertEquals(morpheusRequest.getName(), resp.getName());
        LocalDate date = LocalDate.now();
        Assertions.assertTrue(resp.getUpdatedAt().contains(date.toString()));
    }

    @Test
    void getResource() {
        SpecificationApiTests.addSpec(SpecificationApiTests.reqSpec(),
                SpecificationApiTests.castomResponce(200));
        List<ListResponseLombok> list =
                given()
                        .when()
                        .get("/unknown")
                        .then().log().body()
                        .extract().jsonPath().getList("data", ListResponseLombok.class);
        List<Integer> years = list.stream().map(ListResponseLombok::getYear).collect(Collectors.toList());
        List<Integer> sortYears = years.stream().sorted().collect(Collectors.toList());
        Assertions.assertEquals(years, sortYears);
    }

    @Test
    void negativeAuthTest() {
        RequestAuthLombok reqAuth = new RequestAuthLombok();
        reqAuth.setPassword("12345");
        reqAuth.setPhone("79999999999");
        reqAuth.setRole("clown");


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
        List<ListUsersResponseLombok> list =
                given()
                        .when()
                        .get("https://reqres.in/api/users?page=2")
                        .then().log().body()
                        .statusCode(200)
                        .extract().jsonPath().getList("data", ListUsersResponseLombok.class);
        Assertions.assertTrue(list.stream().allMatch(x -> x.getAvatar().contains(x.getId().toString())));
        Assertions.assertTrue(list.stream().allMatch(x -> x.getEmail().endsWith("reqres.in")));
    }

}
