package common;

import org.hamcrest.Matchers;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.Configuration;

public abstract class RestSteps {
	Configuration configuration = new Configuration();

	RequestSpecification request;
	Response response;

	public void init_Request() {
		request = RestAssured.given().baseUri(configuration.getUrl());
	}

	public void request_GET(String endPoint) {
		response = request.get(endPoint);
	}

	public void request_POST(String endPoint) {
		response = request.post(endPoint);
	}

	public void request_PUT(String endPoint) {
		response = request.put(endPoint);
	}

	public void request_DELETE(String endPoint) {
		response = request.delete(endPoint);
	}

	public void add_Header(Header header) {
		request.header(header);
	}

	public void set_ContentType(ContentType contentType) {
		request.contentType(contentType);
	}

	public void add_RequestBody(String body) {
		request.body(body);
	}

	public void response_CodeValidation(int statusCode) {
		response.then().statusCode(statusCode);
	}

	public void response_BodyValidation(String path, Object expected) {
		response.then().body(path, Matchers.equalTo(expected));
	}

	public void response_HeadersValidation(String path, Object expected) {
		response.then().header(path, Matchers.equalTo(expected));
	}

	public void logRequest() {
		request.log().all();// request == RestAssured.given()
	}

	public void logResponse() {
		response.then().log().all();
	}

	public Response getResponse() {
		return response;
	}

}
