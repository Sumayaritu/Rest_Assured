package api_Tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import endPoint.Posts;
import io.restassured.http.ContentType;
import utils.Configuration;

public class Posts_Test {
	Posts posts;

	@BeforeTest
	public void init() {
		Configuration.loadProperties(Posts_Test.class);
		posts = new Posts();
	}

	@Test
	public void get_Posts() {
		posts.logRequest();
		posts.getPosts();
		posts.logResponse();
		posts.response_CodeValidation(200);
		posts.response_BodyValidation("author[3]", "Bard");
	}

	@Test
	public void create_Posts() {
		posts.logRequest();
		posts.set_ContentType(ContentType.JSON);
		posts.add_RequestBody("{\r\n" + "    \"id\": 12,\r\n" + "    \"title\": \"Contributing to JSON-server\",\r\n"
				+ "    \"author\": \"Sumaya Ritu\"\r\n" + "}");
		posts.request_POST("/posts");
		posts.logResponse();
		posts.response_CodeValidation(201);
		posts.response_HeadersValidation("Expires", "-1");

	}

	@Test
	public void put_Posts() {
		posts.logRequest();
		posts.set_ContentType(ContentType.JSON);
		posts.add_RequestBody("{\r\n" + "    \"id\": 3,\r\n" + "    \"title\": \"JSON-server vs Express\",\r\n"
				+ "    \"author\": \"John Doe\"\r\n" + "}");
		posts.request_PUT("/posts/3");
		posts.logResponse();
		posts.response_CodeValidation(200);
		posts.response_HeadersValidation("Expires", "-1");
	}

	@Test
	public void delete_Posts() {
		posts.logRequest();
		posts.add_RequestBody("{\r\n" + "      \"id\": 8,\r\n" + "      \"title\": \"Testing JSON-server\",\r\n"
				+ "      \"author\": \"Bard\"\r\n" + "    }");
		posts.request_DELETE("/posts/8");
		posts.logResponse();
		posts.response_CodeValidation(200);
		posts.response_HeadersValidation("Expires", "-1");
	}

}
