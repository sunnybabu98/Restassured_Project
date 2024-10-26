package api.endpoints;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
//user Endponts.java
//created for perform Create read update Delete requests to the user API
public class UserEndPoints {

public static Response createUser(User payload)
{
	Response response=given()
			.contentType(ContentType.JSON)
            .accept(ContentType.JSON)
            .body(payload) // Use the JSON payload here
            .when()
            .post(Routes.post_url); // Change this to your actual endpoint

        return response;
}
public static Response readUser(String userName)
{
	Response response=given()
	    .pathParam("username", userName)
    .when()
    .get(Routes.get_url);
    return response;
}
public static Response updateUser(String userName,User payload)
{
	Response response=given()
	.contentType(ContentType.JSON)
	.accept(ContentType.JSON)
	.pathParam("username", userName)
	.body(payload)
    .when()
    .put(Routes.update_url);
    return response;
}
public static Response deleteUser(String userName)
{
	Response response=given()
	    .pathParam("username", userName)
    .when()
    .delete(Routes.delete_url);
    return response;
}
	
	
}
