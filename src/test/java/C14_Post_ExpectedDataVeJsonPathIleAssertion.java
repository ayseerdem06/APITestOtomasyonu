import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C14_Post_ExpectedDataVeJsonPathIleAssertion {

    @Test
    public void post01() {

        /*
         https://restful-booker.herokuapp.com/booking url'ine asagidaki body'ye sahip bir POST
         REQUEST gonderdigimizde donen response'un id haric asagidaki gibi oldugunu test edin.

       Request Body    :

        {
         "firstname" : "Betul",
         "lastname" : "Erdem",
         "totalprice" : 500,
         "depositpaid" : false,
         "bookingdates" : {
             "checkin" : "2023-01-01",
             "checkout" : "2023-01-10"
         },
          "additionalneeds" : "wi-fi"
         }

        Expected Response Body :
           {
         "bookingid": 273,
         "booking": {
        "firstname": "Betul",
        "lastname": "Erdem",
        "totalprice": 500,
        "depositpaid": false,
        "bookingdates": {
            "checkin": "2023-01-01",
            "checkout": "2023-01-10"
        },
        "additionalneeds": "wi-fi"
    }
}
         */

        // 1-Endpoint ve request body olustur
        String url = "https://restful-booker.herokuapp.com/booking";
        JSONObject requestBody = new JSONObject();
        JSONObject rezTarihleriJson = new JSONObject();

        rezTarihleriJson.put("checkin", "2023-01-01");
        rezTarihleriJson.put("checkout", "2023-01-10");

        requestBody.put("firstname", "Betul");
        requestBody.put("lastname", "Erdem");
        requestBody.put("totalprice", 500);
        requestBody.put("bookingdates", rezTarihleriJson);
        requestBody.put("additionalneeds", "wi-fi");
        // System.out.println(requestBody.toString());

        // Expected data olustur
        JSONObject expectedData = new JSONObject();
        expectedData.put("bookingid", 273);
        expectedData.put("booking", requestBody);
        //System.out.println(expectedData.toString());

        //3- request gonder, donen responsu kaydet
        Response response = given().contentType(ContentType.JSON).when().body(requestBody.toString()).post(url);

        // response.prettyPrint();

        // 4- Assertion
        JsonPath responseJsonPath = response.jsonPath();
        // ilk yazilan expected ===> olusturdugumuz JsonObcject : expectedData
        // ikinci yazilan actual ===> response : responseJsonPath
        assertEquals(expectedData.getJSONObject("booking").get("firstname"),
                responseJsonPath.get("booking.firstname"));
        assertEquals(expectedData.getJSONObject("booking").get("lastname"),
                responseJsonPath.get("booking.lastname"));
        assertEquals(expectedData.getJSONObject("booking").get("totalprice"),
                responseJsonPath.get("booking.totalprice"));
        assertEquals(expectedData.getJSONObject("booking").get("depositpaid"),
                responseJsonPath.get("booking.depositpaid"));
        assertEquals(expectedData.getJSONObject("booking").get("additionalneeds"),
                responseJsonPath.get("booking.additionalneeds"));
        assertEquals(expectedData.getJSONObject("booking").getJSONObject("bookingdates").get("checkin"),
                responseJsonPath.get("booking.bookingdates.checkin"));
        assertEquals(expectedData.getJSONObject("booking").getJSONObject("bookingdates").get("checkout"),
                responseJsonPath.get("booking.bookingdates.checkout"));


    }
}
