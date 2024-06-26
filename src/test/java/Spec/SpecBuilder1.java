package Spec;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class SpecBuilder1 {

	public static RequestSpecification ReqSpec() {
	return	new RequestSpecBuilder()
		.addHeader("Content-Type","application/json")
		.addHeader("Authorization","Bearer BQArXaleENTrgTIl3Frk6rSDsrxDG8UIHgzZrFaoWzx-v9wUA8TeEG3Aw4eOU9F3JGL__MKkPzIMK6ENgcmSA89w2tuztEvEIqUhUDk1st1707d_locIyj0cCxfhljg3HC_9G4IIN-9PjEgu7doWIE6vG8GbeVvmx4ipAP-fENhaNhuOxMq_6Xu70lyMHNM1dw_v52MP6Mp-vGHFooeBMMCSj4Tw0iVG87anQ_YjsWitEb0i9Vulx9aqGH2hBGt28k5h3TAyhdh6yU8j")
		.setBaseUri("https://api.spotify.com")
		.setBasePath("v1")
		.log(LogDetail.ALL)
		.build();
	}
	
	public static ResponseSpecification ResBuilder() {
	return	new ResponseSpecBuilder()
		.expectContentType(ContentType.JSON)
         .log(LogDetail.ALL)
	     .build();
	
	}
	
	
	
	
	
	
	
}
