package api_Tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import endPoint.Comments;
import io.restassured.http.ContentType;
import utils.Configuration;

public class CommentsTest {
	Comments comments;

	@BeforeTest
	public void init() {
		Configuration.loadProperties(Comments.class);
		comments = new Comments();
	}

	@Test
	public void get_Comments() {
		comments.logRequest();
		comments.get_Comments();
		comments.logResponse();
		comments.response_CodeValidation(200);
		comments.response_BodyValidation("body[1]", "I'm having trouble deploying JSON-server. Can anyone help?");
		comments.response_HeadersValidation("Expires", "-1");
	}

	@Test
	public void create_Comments() {
		comments.logRequest();
		comments.set_ContentType(ContentType.JSON);
		comments.add_RequestBody(
				"{\r\n" + "    \"id\": 6,\r\n" + "    \"body\": \"I'm having trouble testing my new comments-6\",\r\n"
						+ "    \"postId\": 15\r\n" + "}");
		comments.request_POST("/comments");
		comments.logResponse();
		comments.response_CodeValidation(201);
		// comments.response_BodyValidation("body[1]", "I'm having trouble deploying
		// JSON-server. Can anyone help?");
		comments.response_HeadersValidation("Expires", "-1");
	}

	@Test
	public void put_Comments() {
		comments.logRequest();
		comments.set_ContentType(ContentType.JSON);
		comments.add_RequestBody("{\r\n" + "    \"id\": 2,\r\n"
				+ "    \"body\": \"This is a great tutorial on how to use JSON-server. I learned a lot!\",\r\n"
				+ "    \"postId\": 19\r\n" + "}");
		comments.request_PUT("/comments/2");
		comments.logResponse();
		comments.response_CodeValidation(200);
		// comments.response_BodyValidation("body[1]", "I'm having trouble deploying
		// JSON-server. Can anyone help?");
		comments.response_HeadersValidation("Expires", "-1");
	}

	@Test
	public void delete_Comments() {
		comments.logRequest();
		comments.set_ContentType(ContentType.JSON);
		comments.request_DELETE("/comments/2");
		comments.logResponse();
		comments.response_CodeValidation(200);
		comments.response_HeadersValidation("Expires", "-1");
	}

}
