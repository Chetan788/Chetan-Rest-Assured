package AuthManager;

import java.util.HashMap;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
public class TokenGeneration {

public static String RenewToken() {
	HashMap<String, String> HashData=new HashMap<String, String>();
	HashData.put("grant_type", "refresh_token");
	HashData.put("refresh_token", "AQBsAodSRxS4dcr46zMf9UqOXI_hESt1fNTGFX72TFKJFgEihKtU0Af4MB0TFo8iV6frrlwRI5tlu7lqjCJPjtXL7_TSOQyGXkN1k2ZbfQGjROIh9QQJG2oCWTv4pD318SY");
	HashData.put("client_id", "ff2d12e697714c7ba4b06ea7ec58fe9e");
	HashData.put("client_secret", "c5a16d1d8f9a4f35984a281c3f240d33");
	
	
	
	RestAssured.baseURI="https://accounts.spotify.com";
		Response resp = given()	
		.contentType(ContentType.URLENC)
		.formParams(HashData)
		.when()
		.post("/api/token")
		.then()
		.extract()
		.response();
		JsonPath jp = resp.jsonPath();
	String	token=jp.getString("access_token");
		System.out.println(token);
		
		if(resp.statusCode()!=200)
		{
			throw new RuntimeException("failed to generate token");
						
		}
		return token;
}



}

