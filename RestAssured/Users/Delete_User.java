package Task_Sep24;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Delete_User 
{
	@Test
	void  Delete()
	{
		RestAssured.baseURI="https://gorest.co.in";
		RequestSpecification request=RestAssured.given();
		
		Response response =request.delete("/public/v1/users/1606");
	
		Assert.assertEquals(response.statusCode(), 200);

		
		System.out.println(response.statusCode());
		
	}
	

}
