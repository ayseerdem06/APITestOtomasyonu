import org.json.JSONObject;
import org.junit.Test;

public class C05_JsonobjesiOlusturma {

    @Test
    public void test01(){

        /*
        {
         "firstname" : "Jim",
         "lastname" : "Brown",
         "totalprice" : 111,
         "depositpaid" : true,
         "bookingdates" : {
             "checkin" : "2018-01-01",
             "checkout" : "2019-01-01"
         },
          "additionalneeds" : "Breakfast"
        }
         */

        // Once Inner Json Objesini olusturalım
        JSONObject innerJsonObject=new JSONObject();
        innerJsonObject.put("checkin" , "2018-01-01");
        innerJsonObject.put("checkout" , "2019-01-01");

        // sonra outer json objesini olusturup, yeri geldiginde inner objeyi koyalım
        JSONObject outerJsonObject=new JSONObject();
        outerJsonObject.put("firstname" , "Jim");
        outerJsonObject.put("lastname" , "Brown");
        outerJsonObject.put("totalprice" , 111);
        outerJsonObject.put("depositpaid" , true);
        outerJsonObject.put("bookingdates",innerJsonObject);
        outerJsonObject.put("additionalneeds" , "Breakfast");

        System.out.println(outerJsonObject);

        /*
        Sonuc :
        {
        "firstname":"Jim",
        "additionalneeds":"Breakfast",
        "bookingdates":{
            "checkin":"2018-01-01",
            "checkout":"2019-01-01"
            },
            "totalprice":111,
            "depositpaid":true,
            "lastname":"Brown"}
            Sıralama her zaman aynısını vermeyebilir. ancak dataların hepsi aynı sonucu verir.

         */

    }
}
