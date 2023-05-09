import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;

public class C10_JsonPathKullanimi {

    @Test
    public void method1() {
        /*
        {
    "firstName": "John",
    "lastName": "doe",
    "age": 26,
    "address": {
        "streetAddress": "naist street",
        "city": "Nara",
        "postalCode": "630-0192"
    },
    "phoneNumbers": [
        {
            "type": "iPhone",
            "number": "0123-4567-8888"
        },
        {
            "type": "home",
            "number": "0123-4567-8910"
        }

         */

        JSONObject kisibilgilerijsonObj = new JSONObject();
        JSONObject adresJsonObj = new JSONObject();
        JSONArray telefonBilgileriArr = new JSONArray();
        JSONObject cepTelJsonObj = new JSONObject();
        JSONObject evTelJsonObj = new JSONObject();

        adresJsonObj.put("streetAddress", "naist street");
        adresJsonObj.put("city", "Nara");
        adresJsonObj.put("postalCode", "630-0192");

        cepTelJsonObj.put("type", "iPhone");
        cepTelJsonObj.put("number", "0123-4567-8888");
        evTelJsonObj.put("type", "home");
        evTelJsonObj.put("number", "0123-4567-8910");
        telefonBilgileriArr.put(0, cepTelJsonObj);
        telefonBilgileriArr.put(1, evTelJsonObj);

        kisibilgilerijsonObj.put("firstName", "John");
        kisibilgilerijsonObj.put("lastName", "doe");
        kisibilgilerijsonObj.put("age", 26);
        kisibilgilerijsonObj.put("address", adresJsonObj);
        kisibilgilerijsonObj.put("phoneNumbers", telefonBilgileriArr);

        System.out.println(kisibilgilerijsonObj);
        System.out.println("firstName: " + kisibilgilerijsonObj.get("firstName"));
        System.out.println("lastName :" + kisibilgilerijsonObj.get("lastName"));
        System.out.println("cadde :" + kisibilgilerijsonObj.getJSONObject("address").get("streetAddress"));
        System.out.println("city : " + kisibilgilerijsonObj.getJSONObject("address").get("city"));
        System.out.println("Cep Telefon No : " + kisibilgilerijsonObj.getJSONArray("phoneNumbers").getJSONObject(0).get("number"));
        System.out.println("Ev Telefon No : " + kisibilgilerijsonObj.getJSONArray("phoneNumbers").getJSONObject(1).get("number"));


    }
}
