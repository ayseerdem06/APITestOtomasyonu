import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class C11_Post_JsonPathIleBodyTesti {

    @Test
    public void test01() {

         /*
        https://restful-booker.herokuapp.com/booking url'ine asagidaki body'ye
        sahip bir POST Request gonderdigimizde,
         {
         "firstname": "Betul",
         "lastname": "Erdem",
         "totalprice": 500,
         "depositpaid" : false,
         "bookingdates": {
             "checkin": "2023-01-10",
             "checkout": "2023-01-20"},
         "additionalneeds": "wi-fi"
         }
          donen Response'un,
        status code'unun 200,
        ve content type'inin application-json,
        ve response body'sindeki,
        ve "firstname" in "Betul",
        ve "lastname" in "Erdem",
        ve "totalprice" in 500,
        ve "depositpaid" in false,
        ve "checkin" tarihinin 2023-01-10,
        ve "checkout" tarihinin 2023-01-20,
        ve "additionalneeds"in, "wi-fi" oldugunu test edin.

         */

        //1- Endpoint ve request body olustur
        String url = "https://restful-booker.herokuapp.com/booking";

        JSONObject reqestBody = new JSONObject();
        JSONObject rezervasyonTarihleriJson = new JSONObject();

        rezervasyonTarihleriJson.put("checkin", "2023-01-10");
        rezervasyonTarihleriJson.put("checkout", "2023-01-20");

        reqestBody.put("firstname", "Betul");
        reqestBody.put("lastname", "Erdem");
        reqestBody.put("totalprice", 500);
        reqestBody.put("depositpaid", false);
        reqestBody.put("bookingdates", rezervasyonTarihleriJson);
        reqestBody.put("additionalneeds", "wi-fi");

        // 2-Expected data olustur

        // Request gonder , donen responsu kaydet

        Response response = given().contentType(ContentType.JSON).
                when().body(reqestBody.toString()).post(url);
        response.prettyPrint();

        /* post olarak olusturdugumuz bookingid'miz;
        {
    "bookingid": 2348,
    "booking": {
        "firstname": "Betul",
        "lastname": "Erdem",
        "totalprice": 500,
        "depositpaid": false,
        "bookingdates": {
            "checkin": "2023-01-10",
            "checkout": "2023-01-20"
        },
        "additionalneeds": "wi-fi"
    }
}         */

        // Assertion
        response.then().assertThat().statusCode(200).contentType(ContentType.JSON).
                body("booking.firstname", equalTo("Betul"),
                        "booking.lastname", equalTo("Erdem"),
                        "booking.totalprice", equalTo(500),
                        "booking.depositpaid", equalTo(false),
                        "booking.bookingdates.checkin", equalTo("2023-01-10"),
                        "booking.bookingdates.checkout", equalTo("2023-01-20"),
                        "booking.additionalneeds", equalTo("wi-fi"));

    }
}
