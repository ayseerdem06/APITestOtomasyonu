import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C03_Get_ResponseDegerleriniOtomasyonİleTestEtme {

    @Test
    public void test02() {
      /*
        https://restful-booker.herokuapp.com/booking/10 url'ine
        bir GET request gonderdigimizde donen Response'un,
        status code'nun 200,
        ve content type'inin application/json; charset=utf-8,
        ve Server isimli Header'in degerinin Cowboy,
        ve status Line'in HTTP/1.1 200 OK
        ve response suresinin 5 sn'den kisa oldugunu manuel olarak test ediniz.
         */

        // 1- Endpoint ve request body olustur
        String url = "https://restful-booker.herokuapp.com/booking/10";

        // 2- Expected data olustur
        // 3- Request gonderip donen response'ı kaydet
        Response response = given().when().get(url);

        // 4- Assertion
        response.then().assertThat().
                statusCode(200).contentType("application/json; charset=utf-8").
                header("Server", "Cowboy").statusLine("HTTP/1.1 200 OK");


    }
}
