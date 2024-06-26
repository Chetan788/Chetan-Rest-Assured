package playlistSteps;

import static io.restassured.RestAssured.given;

import com.Spoyify.Pojo.Playlist;

import utils.specBuilder;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class PlaylistSteps {
	
	static RequestSpecification req;
	static Response response;
	 static Playlist playData;
	 static String Name ;
	static String ID;
	
	@Given("Create Playlist API Payload")
	public void create_playlist_api_payload() {
	   
		 playData=new Playlist();
	  
		playData.setName("Bollywood Song");
	   playData.setDescription("bollywwod songs");
	   playData.setPublic(false);
		
	    req = given(specBuilder.request())
		.body(playData);
	
	}

	@When("User call with POST https request")
	public void user_call_with_post_https_request() {
	   
		 response=req.when()
	     .post("/users/31eab6x7aks22h4yukp3ebbs3fnq/playlists");
	}

	@Then("API call executed with {int} status code")
	public void api_call_executed_with_status_code(Integer int1) {
	     Playlist fetchData=response.as(Playlist.class);
	      ID=fetchData.getId();
	     Name =fetchData.getName();
	    
	     response.then()
	     .assertThat()
	     .statusCode(int1);
	}

	
	@Given("Get Palylist payload")
	public void get_palylist_payload() {
	    
		req=given(specBuilder.request())
				.pathParam("pathprm", ID)	;
				
		
		
	}

	@When("user call with GET https request")
	public void user_call_with_get_https_request() {
		response=req.when()
	     .get("playlists/{pathprm}");
	}

	@Then("API Call should executed with {int} status code")
	public void api_call_should_executed_with_status_code(Integer int1) {
		response.then()
        .assertThat()	
        .statusCode(int1);
		
	
	}

	@Given("update plalist payload")
	public void update_plalist_payload() {
		playData=new Playlist();
		  
		playData.setName("updated Bollywood Song");
	   playData.setDescription("bollywwod songs");
	   playData.setPublic(false);
		
	    req = given(specBuilder.request())
		.body(playData);
	
	
	}

	@When("user call  PUT https request")
	public void user_call_put_https_request() {
	    response=req.when()
	    .put("playlists/"+ID);
	}

	@Then("API call executes with {int} status code")
	public void api_call_executes_with_status_code(Integer int1) {
	    response.then()
	    .assertThat()
	    .statusCode(int1);
	}

}
