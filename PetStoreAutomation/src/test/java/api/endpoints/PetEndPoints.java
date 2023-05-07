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

import api.payload.Pet;
import api.payload.Store;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PetEndPoints {

// Created for perform Create, Read, Update, Delete request for Pet module
// Here we don't do the validation
	
	// 1. Create New Pet Endpoints
	public static Response createNewPet(Pet Payload) // import the 'Pet' class from api.payload package
	{
		
	Response response =	given()
	    .contentType(ContentType.JSON)
	    .accept(ContentType.JSON)
	    .body(Payload)    
	    
	.when()
	    .post(Routes.postNew_pet);
	
     return response;
	   	
	}
	

	
	// 2. Read Pet Endpoints
	public static Response readPet(long id) 
	{
		
	Response response =	given()  
	    .pathParam("id", id)
	    
	.when()
	    .get(Routes.get_pet);
	
     return response;
	   	
	}
	
	
	// 3. Read All the Pets using Status Endpoints
		public static Response readPetByStatus(String status) 
		{
			
		Response response =	given()  
		    .queryParam("status", status)
		    
		.when()
		    .get(Routes.get_pet_find_by_Status);
		
	     return response;
		   	
		}
	
			
	// 5. Delete Pet Endpoints
	public static Response deletePet(long id) 
	{
		
	Response response =	given()  
		.pathParam("id", id)	
		.queryParam("api_key", "special-key")
	        
	.when()
	    .delete(Routes.delete_pet);
		
     return response;
	   	
	} 
	
	
}
