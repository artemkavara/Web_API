package Web_API.Web_API_Test;

import java.util.HashMap;
import java.util.Map;
import static io.restassured.RestAssured.*;
import org.junit.Test;

public class WebAPI_Test 
{
  
	String accessToken = "oCcjtxZ_n9UAAAAAAAAAAZts7hYyqMwJBKi_4nUiqDePylDt6UI6fFxvUk058tws";
    @Test
    public void get_meta_data(){
    Map<String, String> path = new HashMap<>();
    path.put("path", "/Get Started with Dropbox.pdf");
    given()
       .headers("Authorization", "Bearer " + accessToken,
    		   "Content-Type", "application/json")
       .body(path)
       .when()
       .post("https://api.dropboxapi.com/2/files/get_metadata")
       .then()
       .statusCode(200); 
    }
    @Test
    public void get_list_folders() {
    	
    }
}
