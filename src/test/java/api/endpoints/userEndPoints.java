package api.endpoints;

import static io.restassured.RestAssured.given;



import api.payload.user;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class userEndPoints {
	
	public static Response createUser(user payload)
	
	{		
		Response response = given() //This is the Request Pre Requisite
		.accept(ContentType.JSON) //accept shows that which type of content is accepted
		.contentType(ContentType.JSON) //contentType shows which type of content is being sent with the request
		.body(payload) //request body we can receive it from the above payload
		
		
		.when() //This is used to send the Request to the URL in Routes.java class
		.post(Routes.post_url); //here we have sent the URL as well from the Routes.java class
		
		return response;	
				
	}
	
	public static Response GetUser(String userName) //Since no Payload for Get request, hence request .body "user payload" is removed
	
	{		
		Response response = given() //This is the Request Pre Requisite
		.accept(ContentType.JSON) //accept shows that which type of content is accepted			
		.pathParam("username", userName) //here we are setting the path parameter
		
		
		.when() //This is used to send the Request to the URL in Routes.java class
		.get(Routes.get_url); //here we have sent the URL as well from the Routes.java class
		
		return response;	
				
	}
	
    public static Response UpdateUser(String userName, user payload)
	
	{		
		Response response = given() //This is the Request Pre Requisite
		.accept(ContentType.JSON) //accept shows that which type of content is accepted
		.contentType(ContentType.JSON) //contentType shows which type of content is being sent with the request	
		.pathParam("username", userName) //here we are setting the path parameter
		.body(payload) //request body we can receive it from the above payload
		
		
		.when() //This is used to send the Request to the URL in Routes.java class
		.put(Routes.put_url); //here we have sent the URL as well from the Routes.java class
		
		return response;	
				
	}
    
    public static Response DeleteUser(String userName) //Since no Payload for Get request, hence request .body "user payload" is removed
	
	{		
		Response response = given() //This is the Request Pre Requisite
		.accept(ContentType.JSON) //accept shows that which type of content is accepted		
		.pathParam("username", userName) //here we are setting the path parameter		
		
		
		.when() //This is used to send the Request to the URL in Routes.java class
		.delete(Routes.del_url); //here we have sent the URL as well from the Routes.java class
		
		return response;	
				
	}

}
