import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C02_Get_ResponseBilgilerininManuelTestEdilmesi {

    @Test
    public void test01() {
        /*
        https://restful-booker.herokuapp.com/booking/10 url'ine
        bir GET request gonderdigimizde donen Response'un,
        status code'nun 200,
        ve content type'inin application/json; charset=utf-8,
        ve Server isimli Header'in degerinin Cowboy,
        ve status Line'in HTTP/1.1 200 OK
        ve response suresinin 5 sn'den kisa oldugunu manuel olarak test ediniz.
         */

        // 1- Request body ve end-Point hazirlama
        String url = "https://restful-booker.herokuapp.com/booking/10";

        // 2- Expected body olustur
        // 3- Request gonderip, donen response'i kaydet
        Response response = given().when().get(url);
        response.prettyPrint();
        System.out.println("status code: " + response.getStatusCode() +
                "\nContent type:" + response.getContentType() +
                "\nServer Header degeri:" + response.getHeader("Server") +
                "\nStatus Line:" + response.getStatusLine() +
                "\nResponse suresi:" + response.getTime() + "ms");

        // 4- Assertion
    }
}
