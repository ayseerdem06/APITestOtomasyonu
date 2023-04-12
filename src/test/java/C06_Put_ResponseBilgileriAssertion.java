import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C06_Put_ResponseBilgileriAssertion {

    @Test
    public void test01(){
        /*

        https://jsonplaceholder.typicode.com/posts/3 url'ine
        asagidaki Json formatındaki body ile bir PUT request gonderdigimizde

        {
            "id": 1,
            "title": "Aslı",
            "body": "Han",
            "userId": 1
        }
        donen Response'un
        status code'nun 200,
        ve content type'inin application/json; charset=utf-8,
        ve Server isimli Header'in degerinin cloudflare,
        ve status Line'in HTTP/1.1 200 OK
        oldugunu test edin.

         */

        // 1- end point ve request body olustur
        String url="https://jsonplaceholder.typicode.com/posts/3";

        JSONObject requestBody=new JSONObject();
        requestBody.put("id", 1);
        requestBody.put("title", "Aslı");
        requestBody.put("body", "Han");
        requestBody.put("userId", 1);

        // 2- expected data olustur

        // 3- request gonder ve donen response'i kaydet

        Response response=given().contentType(ContentType.JSON).
                            when().body(requestBody.toString()).put(url);

        // 4- Assertion
        response.then().assertThat().
                statusCode(200).
                contentType("application/json; charset=utf-8").
                header("Server","cloudflare").
                statusLine("HTTP/1.1 200 OK");


    }
}
