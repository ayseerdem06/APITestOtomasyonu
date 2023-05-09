import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class C12_Get_ResponseBodyTestiListKullanimi {

    @Test
    public void test01() {
        /*
        http://dummy.restapiexample.com/api/v1/employees url'ine bir GET request yolladigimizda
        donen Response'in,
         status code'unun 200,
        ve content type'inin Application.JSON,
        ve response body'sindeki,
        employees sayisinin 24,
        ve employee'lerden birinin "Ashton Cox",
        ve girilen yaslar icinde 61,21 ve 35 degerinin oldugunu test edin.
         */

        // 1-Endpoint ve request body olustur
        String url = "http://dummy.restapiexample.com/api/v1/employees";

        // 2- Expected data olustur

        // 3- Request gonder, donen responsu kaydet
        Response response = given().when().get(url);
        /*response.prettyPrint();

        donen responsun ilk sırasındaki veriler alındı.
        {
            "status": "success",
                "data": [
            {
                "id": 1,
                    "employee_name": "Tiger Nixon",
                    "employee_salary": 320800,
                    "employee_age": 61,
                    "profile_image": ""
            },
            {
                "id": 2,
                    "employee_name": "Garrett Winters",
                    "employee_salary": 170750,
                    "employee_age": 63,
                    "profile_image": ""
            },
            {
                "id": 3,
                    "employee_name": "Ashton Cox",
                    "employee_salary": 86000,
                    "employee_age": 66,
                    "profile_image": ""
            },

         */


        // 4- Assertion

        response.then().assertThat().
                statusCode(200).contentType(ContentType.JSON).
                body("data.id", hasSize(24),
                        "data.employee_name", hasItem("Ashton Cox"),
                        "data.employee_age", hasItems(61, 21, 35));


    }
}
