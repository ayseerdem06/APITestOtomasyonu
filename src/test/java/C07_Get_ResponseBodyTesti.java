import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C07_Get_ResponseBodyTesti {

    @Test
    public void test01() {


     /*
        https://jsonplaceholder.typicode.com/posts/44 url'ine bir GET request yolladığımızda
        donen Response'un
        status code'nun 200,
        ve content type'inin Application/JSON,
        ve response body'sinde bulunan userId'nin 5,
        ve response body'sinde bulunan title'ın "optio dolor molestias sit"
        oldugunu test edin.

         */

        // 1- Endpoint ve response body hazırla
        String url = "https://jsonplaceholder.typicode.com/posts/44";

        // 2- Expected data hazırla

        // 3- Request gonder ve response'ı kaydet
        Response response = given().when().get(url);
        response.prettyPrint();

        // Assertion
        response.then().assertThat().statusCode(200).
                contentType(ContentType.JSON).
                body("userId", Matchers.equalTo(5)).
                body("title", Matchers.equalTo("optio dolor molestias sit"));
    }
}