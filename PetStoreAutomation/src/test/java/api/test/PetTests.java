package api.test;

import org.testng.annotations.BeforeClass;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.equalTo;
import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.core.config.Configurator;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.PetEndPoints;
import api.endpoints.StoreEndPoints;
import api.endpoints.UserEndPoints;
import api.payload.Pet;
import api.payload.Store;
import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PetTests {

	private static final Logger logger = LogManager.getLogger(PetTests.class);
	
// Here we created the tests only for Pet module
	
	Faker faker;
	Pet petPayload;
	
	@BeforeClass
	public void setupData() 
	{
		faker = new Faker();
		petPayload = new Pet();
		
		// Set the values for the properties
		petPayload.setId(faker.number().randomNumber());
        
        Map<String, Object> category = new HashMap<>();
        category.put("id", faker.number().randomNumber());
        category.put("name", faker.animal().name());
        petPayload.setCategory(category);

        petPayload.setName(faker.name().firstName());

        List<String> photoUrls = new ArrayList<>();
        photoUrls.add(faker.internet().url());
        photoUrls.add(faker.internet().url());
        petPayload.setPhotoUrls(photoUrls);

        List<Map<String, Object>> tags = new ArrayList<>();
        Map<String, Object> tag1 = new HashMap<>();
        tag1.put("id", faker.number().randomNumber());
        tag1.put("name", faker.commerce().productName());
        tags.add(tag1);

        Map<String, Object> tag2 = new HashMap<>();
        tag2.put("id", faker.number().randomNumber());
        tag2.put("name", faker.commerce().productName());
        tags.add(tag2);
        petPayload.setTags(tags);

        petPayload.setStatus(faker.options().option("available", "pending", "sold"));
        
		//System.out.println("Log4j configuration file path: " + new File("src/test/resources/log4j2.xml").getAbsolutePath());
		System.setProperty("log4j.configurationFile", "src/test/resources/log4j2.xml");	
		Configurator.initialize(null, "src/test/resources/log4j2.xml");
		LoggerContext context = (LoggerContext) LogManager.getContext(false);
		boolean isInitialized = context.isInitialized();
		System.out.println("Log4j is initialized: " + isInitialized);
	
	}

	
	@Test(priority=1)
	public void testPostNewPet() 
	{
		// Create the Pet details
		
		logger.info("-------------- Pet Test 1 Start --------------------");
					
		Response response = PetEndPoints.createNewPet(petPayload);	
		response.then().log().all();

		System.out.println(response);
		
		Assert.assertEquals(response.getStatusCode(), 200);

		System.out.println("<---- New Pet is created with below ID details ---->");
		
		int id1 = response.jsonPath().getInt("id");
		System.out.println("Main id: " + id1);
		
		int id2 = response.jsonPath().getInt("category.id");
		System.out.println("Category id: " + id2);
		
		int id3 = response.jsonPath().getInt("tags[0].id");
		System.out.println("Tag1 id: " + id3);
		
		int id4 = response.jsonPath().getInt("tags[1].id");
		System.out.println("Tag2 id: " + id4);
		
		logger.info("-------------- Pet Test 1 End --------------------");
		
	}	
	

	@Test(priority=2, description = "Get the Pet details using Pet Id")
	public void testGetPet() 
	{
       //Get the Pet details using Pet Id
				
		logger.info("-------------- Pet Test 2 Start --------------------");
		
		Response response = PetEndPoints.readPet(this.petPayload.getId());
		response.then().log().body()
		               .header("Content-Type", "application/json");
		
		Assert.assertEquals(response.getStatusCode(), 200);
		
		logger.info("-------------- Pet Test 2 End --------------------");
	}
	
	@Test(priority=3)
	public void testGetPet_ByFindStatus() 
	{	
		// Get the Pet details using status
		
		logger.info("-------------- Pet Test 3 Start --------------------");
		
		Response response = PetEndPoints.readPetByStatus(this.petPayload.getStatus());
		response.then().log().body()
		               .header("Content-Type", "application/json");
		
		Assert.assertEquals(response.getStatusCode(), 200);
		
		logger.info("-------------- Pet Test 3 End --------------------");
			
	}
	
	
	
	@Test(priority=4)
	public void testDeletePet()
	{
		
	 logger.info("-------------- Pet Test 4 Start --------------------");	

	  Response response=PetEndPoints.deletePet(this.petPayload.getId());
	  response.then().log().body()
                     .header("Content-Type", "application/json");
	  
	  
	  Assert.assertEquals(response.getStatusCode(),200);
	  
	  System.out.println("Pet is deleted Successfully ");

	  logger.info("-------------- Pet Test 4 End --------------------");
	}


	
}