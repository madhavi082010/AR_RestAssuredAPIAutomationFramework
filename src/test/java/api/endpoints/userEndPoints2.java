package api.endpoints;

import static io.restassured.RestAssured.given;

import java.util.ResourceBundle;

import api.payload.user;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class userEndPoints2 {
	
	//How to Read url's from properties file using a Method using resource bundle
	
	static ResourceBundle getURL() { //Creation of a Method to read URL's from a property file
		
		//Below we are creating a ResourceBundle of the object
		ResourceBundle routes = ResourceBundle.getBundle("Routes"); //Load Routes.properties file
		
		return routes; //This will return all the routes data like post_url, get_url
		
	}
	
	public static Response createUser(user payload)
	
	{		
		String post_url = getURL().getString("post_url"); //Creation of string variable with the name "post_url"
		Response response = given() //This is the Request Pre Requisite
		.accept(ContentType.JSON) //accept shows that which type of content is accepted
		.contentType(ContentType.JSON) //contentType shows which type of content is being sent with the request
		.body(payload) //request body we can receive it from the above payload
		
		
		.when() //This is used to send the Request to the URL in Routes.java class
		.post(post_url); //here we have sent the URL as well from the Routes.java class
		
		return response;	
				
	}
	
	public static Response GetUser(String userName) //Since no Payload for Get request, hence request .body "user payload" is removed
	
	{	
		String get_url = getURL().getString("get_url");
		Response response = given() //This is the Request Pre Requisite
		.accept(ContentType.JSON) //accept shows that which type of content is accepted			
		.pathParam("username", userName) //here we are setting the path parameter
		
		
		.when() //This is used to send the Request to the URL in Routes.java class
		.get(get_url); //here we have sent the URL as well from the Routes.java class
		
		return response;	
				
	}
	
    public static Response UpdateUser(String userName, user payload)
	
	{		
    	String put_url = getURL().getString("update_url");
		Response response = given() //This is the Request Pre Requisite
		.accept(ContentType.JSON) //accept shows that which type of content is accepted
		.contentType(ContentType.JSON) //contentType shows which type of content is being sent with the request	
		.pathParam("username", userName) //here we are setting the path parameter
		.body(payload) //request body we can receive it from the above payload
		
		
		.when() //This is used to send the Request to the URL in Routes.java class
		.put(put_url); //here we have sent the URL as well from the Routes.java class
		
		return response;	
				
	}
    
    public static Response DeleteUser(String userName) //Since no Payload for Get request, hence request .body "user payload" is removed
	
	{		
    	String del_url = getURL().getString("delete_url");
		Response response = given() //This is the Request Pre Requisite
		.accept(ContentType.JSON) //accept shows that which type of content is accepted		
		.pathParam("username", userName) //here we are setting the path parameter		
		
		
		.when() //This is used to send the Request to the URL in Routes.java class
		.delete(del_url); //here we have sent the URL as well from the Routes.java class
		
		return response;	
				
	}

}
