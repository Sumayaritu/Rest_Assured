package unitTest;

import java.io.File;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class PostCall {
	@Test
	public void do_Post_500_Error() {
    RestAssured.given()
    .log().all()
    .contentType(ContentType.JSON)
    .body("{\"id\": 3,\"title\": \"JSON-server vs Express\",\"author\": \"John Doe\" }")
    .post("http://localhost:8000/posts")
    .then()
    .log().all()
    .statusCode(500);
    
}
	@Test
	public void do_Post_With_File() {
	File file=new File("src\\test\\resources\\post.json");
	RestAssured.given()
    .log().all()
    .contentType(ContentType.JSON)
    .body(file)
    .post("http://localhost:8000/posts")
    .then()
    .log().all()
    .statusCode(201);
    }
	
	@Test
	public void do_Post_With_IStream() {
	InputStream inputStream=getClass().getClassLoader().getResourceAsStream("post.json");
	RestAssured.given()
    .log().all()
    .contentType(ContentType.JSON)
    .body(inputStream)
    .post("http://localhost:8000/posts")
    .then()
    .log().all()
    .statusCode(201);
    }
	
	@Test
	public void do_Post_With_Map() {
	Map<String, Object> map=new HashMap<>();
	map.put("id", 30);
	map.put("title", "testing-json");
	map.put("author", "Salenium");
	RestAssured.given()
    .log().all()
    .contentType(ContentType.JSON)
    .body(map)
    .post("http://localhost:8000/posts")
    .then()
    .log().all()
    .statusCode(201);
    }






}