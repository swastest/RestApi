package reqres.withLombokTests;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import reqres.models.ozzi.SuggestedTag;
import reqres.models.ozzi.SuggestedTapTags;

import static io.restassured.RestAssured.given;

public class OzonTest {
    @Test
    void test01(){
        String searchTag = "lenovo";
        //         String data = "{\"text\":\"lenovo\"}";
        SuggestedTag suggestedTag = new SuggestedTag();
        suggestedTag.setText(searchTag);

        SuggestedTapTags response =
                given()
                        .body(suggestedTag)
                        .contentType(ContentType.JSON)
                        .when().log().all()
                        .post("https://www.ozon.ru/api/composer-api.bx/_action/getSuggestedTapTags")
                        .then().log().all()
                        .statusCode(200)
                        .extract().as(SuggestedTapTags.class);

        System.out.println(response);
    }
}

//https://github.com/qa-guru/ozon-tests