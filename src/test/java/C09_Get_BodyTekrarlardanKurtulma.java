import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class C09_Get_BodyTekrarlardanKurtulma {

    @Test
    public void test01() {
        /*
        https://restful-booker.herokuapp.com/booking/10 url'ine
        bir GET request gonderdigimizde donen Response'un,
        status code'unun 200,
        ve content type'inin application-json,
        ve response body'sindeki,
        ve "firstname" in "Susan",
        ve "lastname" in "Wilson",
        ve "totalprice" in 1000'den kucuk oldugu,
        ve "depositpaid" in false,
        ve "additionalneeds"in, bos birakilmadigini test edin.
         */

        //1- Endpoint ve request body hazirla
        String url = "https://restful-booker.herokuapp.com/booking/10";

        // 2- expected data olustur

        // 3- request gonderip donen response'ı kaydet
        Response response = given().when().get(url);
        response.prettyPrint();

        // Assertion
        /* İkinci yontem ile yaptigimizda bu testimizdeki yazilanlar degismesin diye yoruma aldım.
        response.
                then().
                assertThat().
                statusCode(200).
                contentType(ContentType.JSON).
                body("firstname", Matchers.equalTo("Susan")).
                body("lastname",Matchers.equalTo("Wilson")).
                body("totalprice",Matchers.lessThan(1000)).
                body("depositpaid",Matchers.equalTo(false)).
                body("additionalneeds",Matchers.nullValue());

         */

        response.
                then().assertThat().body("firstname", equalTo("Susan"),
                        "lastname", equalTo("Wilson"),
                        "totalprice", lessThan(1000),
                        "depositpaid", equalTo(false),
                        "additionalneeds", nullValue());


    }
}
