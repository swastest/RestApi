package reqres.withLombokTests;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.with;


// Не использую, так как пока не поняла, как сделать кастомный вариант для проверки статус кода.
//Для ДЗ использовала другую спецификацию
public class SpecificationApi {
    public static RequestSpecification request = with()
            .baseUri("https://reqres.in")
            .basePath("/api")
            .log().all()
            .contentType(ContentType.JSON);

    public static ResponseSpecification responseSpec = new ResponseSpecBuilder()
            .expectStatusCode(200)
//            .expectBody(containsString("success")) можно добавлять типовые проверки
            .build();
}
