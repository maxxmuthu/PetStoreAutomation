package api.endpoints;
import static io.restassured.RestAssured.*;
import api.payload.Store;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class StoreEndPoints  {

// Created for perform Create, Read, Update, Delete request for Store module
// Here we don't do the validation
	
	// 1. Create Store Order Endpoints
	
	public static Response createStoreOrder(Store Payload) // import the 'Store' class from api.payload package
	{
		
	Response response =	given()
	    .contentType(ContentType.JSON)
	    .accept(ContentType.JSON)
	    .body(Payload)    
	    
	.when()
	    .post(Routes.postOrder_store);
	
     return response;
	   	
	}
	
	
	// 2. Read Store Order Endpoints
	
	public static Response readStoreOrder(int id) 
	{
		
	Response response =	given()  
	    .pathParam("id", id)
	    
	.when()
	    .get(Routes.getOrder_store);
	
     return response;
	   	
	}
	
	
		
	// 3. Delete Store Order Endpoints
	public static Response deleteStoreOrder(int id) 
	{
		
	Response response =	given()  
		.pathParam("id", id)	
	        
	.when()
	    .delete(Routes.deleteOrder_store);
	
     return response;
	   	
	} 
	
	
}
