package unitTest;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import io.restassured.response.Response;

public class GetAPI {
	
	@Test
	public void getAPIstatusValidation()	{
			RestAssured
			.given().baseUri("https://reqres.in/api/users?page=2")
			.get()
			.prettyPrint();
		}
	
	@Test
	public void logAll() {
		RestAssured.given()
		.log().all()
		.get("https://reqres.in/api/users?page=2")
		.then()
		.log().all();
	}
	
	@Test
	public void assertStatusCodeAndHeaderValidation() {
		RestAssured.given()
		.log().all()
		.get("https://reqres.in/api/users?page=2")
		.then()
		.log().all()
		.statusCode(200)  //Status code validation
		.header("Connection",Matchers.equalTo("keep-alive")); //Response header validation
	}
	

	@Test
	public void assertBodyValidation() {
		RestAssured.given()
		.log().all()
		.get("https://reqres.in/api/users?page=2")
		.then()
		.log().all()
		.statusCode(200)  //Status code validation
		.header("Connection",Matchers.equalTo("keep-alive")) //Response header validation
		.body("data.id[0]", Matchers.equalTo(7));
		//.body("email [6]", Matchers.containsStringIgnoringCase("michael.lawson@reqres.in"));
	}
	

	@Test
	public void assertBodyfromServer() {
		
		
		
		RequestSpecification req = RestAssured.given();
		//.log().all()
		
		
		Response  response  = req.get("http://localhost:8000/profile"); 
		
		response.then().body("name", Matchers.equalTo("Bard"));
		
		String ss = response.asString();
		
		
		System.out.println("*****************\n"+ss);
		//Status code validation
		//.header("Connection",Matchers.equalTo("keep-alive")) //Response header validation
		///.body("data.id[0]", Matchers.equalTo(7));
		//.body("email [6]", Matchers.containsStringIgnoringCase("michael.lawson@reqres.in"));
	}
	
	@Test
	public void addAuthurization() {
	  RestAssured.given()
	  .log().all();
	  
	}
	
	
	

}
