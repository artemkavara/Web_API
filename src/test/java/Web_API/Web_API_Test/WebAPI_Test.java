package Web_API.Web_API_Test;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import static io.restassured.RestAssured.*;
import static io.restassured.config.EncoderConfig.encoderConfig;
import org.junit.Test;

import io.restassured.RestAssured;

public class WebAPI_Test 
{
  
    @Test
    public void get_meta_data(){
    Map<String, String> path = new HashMap<>();
    path.put("path", Identifiers.file_meta);
    given()
       .headers("Authorization", "Bearer " + Identifiers.accessToken,
    		   "Content-Type", "application/json")
       .body(path)
       .when()
       .post("https://api.dropboxapi.com/2/files/get_metadata")
       .then()
       .statusCode(200); 
    }
    @Test
    public void get_list_folders() {
    	Map<String, String> path = new HashMap<>();
        path.put("path", "");
        given()
           .headers("Authorization", "Bearer " + Identifiers.accessToken,
        		   "Content-Type", "application/json")
           .body(path)
           .when()
           .post("https://api.dropboxapi.com/2/files/list_folder")
           .then()
           .statusCode(200);	
    }
    @Test
    public void upload_file() {
    	String dropbox_api_args = "{\"mode\":\"add\",\"autorename\":true,\"mute\":false,\"path\":\"/file.jpg\"}";
    	RestAssured.config = RestAssured.config().encoderConfig(encoderConfig().appendDefaultContentCharsetToContentTypeIfUndefined(false));
        File file = new File(Identifiers.upload_file);
    	given()
        .headers("Authorization", "Bearer " + Identifiers.accessToken,
     		   "Content-Type", "application/octet-stream", 
     		   "Dropbox-API-Arg", dropbox_api_args)
        .body(file)
    	.when()
    	.post("https://content.dropboxapi.com/2/files/upload")
    	.then()
    	.statusCode(200);
    }
    @Test
    public void delete_file() {
    	Map<String, String> path = new HashMap<>();
        path.put("path", Identifiers.delete_file);
        given()
        .headers("Authorization", "Bearer " + Identifiers.accessToken,
     		   "Content-Type", "application/json")
        .body(path)
    	.when()
    	.post("https://api.dropboxapi.com/2/files/delete_v2")
    	.then()
    	.statusCode(200);
    }
}

