package playlistSteps;

import static io.restassured.RestAssured.given;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Spoyify.Pojo.Playlist;


import utils.specBuilder;
public class CreatePlaylist {
	  String id;
	@Test
	public void create() {

	Playlist reqPlaylist=new Playlist();
	reqPlaylist.setName("Bollywood entertainment");
	reqPlaylist.setDescription("for entertainment");
	reqPlaylist.setPublic(false);
	
   Playlist PlaylistResponse = given(specBuilder.request())
   .body(reqPlaylist)
   .when()
   .post("/users/31eab6x7aks22h4yukp3ebbs3fnq/playlists")
   .then()
   .spec(specBuilder.response())
   .extract()
   .response()
   .as(Playlist.class);
	
   id = PlaylistResponse.getId();
   String description = PlaylistResponse.getDescription();
  String name = PlaylistResponse.getName();
	System.out.println(id);
	System.out.println(description);
	System.out.println(name);
	}	
	@Test
	public void getPlaylist() {
		Playlist playlistResp = given(specBuilder.request())
		.pathParam("Pathprm", id)
		.when()
		.get("playlists/{Pathprm}")
		.then()
		.spec(specBuilder.response())
		.extract()
		.response()
		.as(Playlist.class);
String	nameofPlaylist =playlistResp.getName();
		System.out.println(nameofPlaylist);
		
		Assert.assertEquals(nameofPlaylist, "Bollywood entertainment");
		
	}
}
