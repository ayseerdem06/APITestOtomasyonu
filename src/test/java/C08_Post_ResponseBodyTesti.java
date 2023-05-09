import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.responseSpecification;

public class C08_Post_ResponseBodyTesti {

    @Test
    public void test01() {
         /*
        https://jsonplaceholder.typicode.com/posts url'ine  asagidaki body ile
         bir POST request gonderdigimizde;

        {
            "title": "API",
            "body": "API ogrenmek ne guzel",
            "userId": 10
        }
        donen Response'un
        status code'nun 201,
        ve content type'inin Application/JSON,
        ve response body'sindeki,
        "title" in "API" oldugunu
        "userId" degerinin 100 den kucuk oldugunu,
        "body" nin "API" kelimesi icerdigini  test edin.
         */

        // 1-Endpoint ve request body olustur
        String url = "https://jsonplaceholder.typicode.com/posts";
        JSONObject requestBody = new JSONObject();
        requestBody.put("title", "API");
        requestBody.put("body", "API ogrenmek ne guzel");
        requestBody.put("userId", 10);

        // 2- Expected data oluştur

        // 3- Request gonder ve respose'u kaydet
        Response response = given().contentType(ContentType.JSON).
                when().body(requestBody.toString()).post(url);
        response.prettyPrint();

        // Assertion
        response.then().assertThat().statusCode(201).
                contentType(ContentType.JSON).body("title", Matchers.equalTo("API")).
                body("userId", Matchers.lessThan(100)).
                body("body", Matchers.containsString("API"));


    }
}
