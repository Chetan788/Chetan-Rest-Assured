package utils;

import AuthManager.TokenGeneration;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class specBuilder {
public static RequestSpecification request() {
	return new RequestSpecBuilder()
	.setBaseUri("https://api.spotify.com/")
	.setBasePath("v1")
	.addHeader("Authorization", "Bearer "+TokenGeneration.RenewToken())
	.addHeader("Content-Type", "application/json")
	.log(LogDetail.ALL)
	.build();
}

public static ResponseSpecification response() {
	return new ResponseSpecBuilder()
	.expectStatusCode(201)
	.expectContentType(ContentType.JSON)
	.build();
	
}


}
