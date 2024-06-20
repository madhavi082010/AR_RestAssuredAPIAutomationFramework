package api.testcases;

import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.apache.logging.log4j.LogManager;

import com.github.javafaker.Faker;

import api.endpoints.userEndPoints2;
import api.payload.user;
import io.restassured.response.Response;

public class UserTest2 {
	
	//First to Generate Test Data below and then use the test data and send the request
	//Setup Test Data
	
	Faker faker; //To create Fake data
	user userPayload; //To set fake data by calling getter and setter method, for this we need to create a user class object
	
	public static Logger logger;
	
	@BeforeClass
	public void generateTestData() 
	{
		faker = new Faker();
		userPayload = new user();		
		
		userPayload.setId(faker.idNumber().hashCode()); //Starting setting fake date from id. hashcode So that a unique id is generated everytime
		userPayload.setUsername(faker.name().username());
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());
		userPayload.setPassword(faker.internet().password(5, 10));
		userPayload.setPhone(faker.phoneNumber().cellPhone());
		
		//Setup Logger or Obtain Logger or we have to Get Logger
		
		logger = LogManager.getLogger("RestAssuredAutomationFramework_test"); 
		
		
	}	
	
	//The Create User method which was created in the user endpoint, we need to call from the userTest class
	//For that we will create a Test method below
	
	@Test(priority=1)
	public void testCreateUser()
	{
		Response response = userEndPoints2.createUser(userPayload);
		
		//Log response
		response.then().log().all();
		
		//Validation of Status Code that is 200 OK
		Assert.assertEquals(response.getStatusCode(), 200);
		
		//Log User
		logger.info("Create User Executed.");
	}
	
	@Test(priority=2)
	public void testGetUserData()
	{
		Response response = userEndPoints2.GetUser(this.userPayload.getUsername());
		
		System.out.println("Read User Data.");
		//Log response
		response.then().log().all();
		
		//Validation of Status Code that is 200 OK
		Assert.assertEquals(response.getStatusCode(), 200);
		
		//Log User
		logger.info("Get User Data Executed.");
	}
	
	@Test(priority=3)
	public void testUpdateUser()
	{
		userPayload.setFirstName(faker.name().firstName());
		Response response = userEndPoints2.UpdateUser(this.userPayload.getUsername(), userPayload);		
		
		//Log response
		response.then().log().all();
		
		//Validation of Status Code that is 200 OK
		Assert.assertEquals(response.getStatusCode(), 200);
		
		//Read User Data to check if first name is updated or not
		Response responsePostUpdate = userEndPoints2.GetUser(this.userPayload.getUsername());
		
		System.out.println("After Update User Data.");
		
		responsePostUpdate.then().log().all();
		
		//Log User
		logger.info("Update User Executed.");
	}
	
	@Test(priority=4)
	public void testDeleteUser()
	{		
		Response response = userEndPoints2.DeleteUser(this.userPayload.getUsername());
		
		System.out.println("Delete User Data.");
		//Log response
		response.then().log().all();
		
		//Validation of Status Code that is 200 OK
		Assert.assertEquals(response.getStatusCode(), 200);
		
		//Log User
		logger.info("Delete User Executed.");
	}
	

}
