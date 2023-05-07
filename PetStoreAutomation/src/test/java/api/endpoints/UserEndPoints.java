package api.endpoints;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.equalTo;
import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.Assert;
import org.testng.annotations.Test;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UserEndPoints {

// Created for perform Create, Read, Update, Delete request for User module
// Here we don't do the validation
	
	// 1. Create User Endpoints
	public static Response createUser(User payload) // import the 'User' class from api.payload package
	{
		
	Response response =	given()
	    .contentType(ContentType.JSON)
	    .accept(ContentType.JSON)
	    .body(payload)    
	    
	.when()
	    .post(Routes.post_url);
	
     return response;
	   	
	}
	
	
	// 2. Read User Endpoints
	public static Response readUser(String userName) 
	{
		
	Response response =	given()  
	    .pathParam("username", userName)
	    
	.when()
	    .get(Routes.get_url);
	
     return response;
	   	
	}
	
	
	// 3. Update User Endpoints
	public static Response updateUser(String userName, User payload) // import the 'User' class from api.payload package
	{
		
	Response response =	given()  
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.pathParam("username", userName)
		.body(payload) 			
	    	    
	.when()
	    .put(Routes.update_url);
	
     return response;
	   	
	}
		
	// 4. Delete User Endpoints
	public static Response deleteUser(String userName) 
	{
		
	Response response =	given()  
		.pathParam("username", userName)	
	        
	.when()
	    .delete(Routes.delete_url);
	
     return response;
	   	
	}
	
		
	// 5. Login User Endpoints
	public static Response loginUser(String userName, String passWord,  User payload) // import the 'User' class from api.payload package
	{
		
	Response response =	given()  
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.queryParam("username", userName)
		.queryParam("password", passWord)
		.body(payload) 			
	    	    
	.when()
	    .get(Routes.login_url);
	
     return response;
	   	
	}
	
	
	// 6. Logout User Endpoints
	public static Response LogoutUser() 
	{
		
	Response response =	given()
	    .contentType(ContentType.JSON)
	    .accept(ContentType.JSON) 
	    
	.when()
	    .post(Routes.logout_url);
	
     return response;
	   	
	}
	
}
