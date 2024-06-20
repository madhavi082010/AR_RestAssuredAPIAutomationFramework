package api.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.userEndPoints;
import api.payload.user;
import api.utilities.DataProviders;
import io.restassured.response.Response;

public class UserTestDD {
	
	@Test(priority=1, dataProvider = "AllData", dataProviderClass = DataProviders.class)
	public void testCreateUser(String userId, String UserName, String fname, String lname, String email, String pwd, String phone) //The Parameters we need to execute the TC, Test Data will be created here
	{
		user userPayload = new user();		
		
		userPayload.setId(Integer.parseInt(userId));
		userPayload.setUsername(UserName);
		userPayload.setFirstName(fname);
		userPayload.setLastName(lname);
		userPayload.setEmail(email);
		userPayload.setPassword(pwd);
		userPayload.setPhone(phone);
		
		Response response = userEndPoints.createUser(userPayload);
		
		//Log response
		response.then().log().all();
		
		//Validation of Status Code that is 200 OK
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	
	@Test(priority=2, dataProvider = "UserNamesData", dataProviderClass = DataProviders.class)
	public void testGetUserData(String username)
	{
		Response response = userEndPoints.GetUser(username);
		
		System.out.println("Read User Data.");
		//Log response
		response.then().log().all();
		
		//Validation of Status Code that is 200 OK
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	
	@Test(priority=3, dataProvider = "UserNamesData", dataProviderClass = DataProviders.class)
	public void testDeleteUser(String username)
	{		
		
		Response response = userEndPoints.DeleteUser(username);
		
		System.out.println("Delete User Data.");
		//Log response
		response.then().log().all();
		
		//Validation of Status Code that is 200 OK
		Assert.assertEquals(response.getStatusCode(), 200);
	}

}
