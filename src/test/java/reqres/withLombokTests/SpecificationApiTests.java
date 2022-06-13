package reqres.withLombokTests;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class SpecificationApiTests {

    public static RequestSpecification reqSpec(){
        return new RequestSpecBuilder()
                .setBaseUri("https://reqres.in")
                .setBasePath("/api")
                .setContentType(ContentType.JSON)
                .build();
    }


    public static ResponseSpecification castomResponce(int status){
        return new ResponseSpecBuilder()
                .expectStatusCode(status)
                .build();
        }

      static public void addSpec(RequestSpecification request, ResponseSpecification response){
            RestAssured.requestSpecification = request;
            RestAssured.responseSpecification = response;
        }

    }

