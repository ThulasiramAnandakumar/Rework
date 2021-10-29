package Task_Sep24;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Post_Create_New_User 
{
	
	@Test
	void CreateUser()
	{
		RestAssured.baseURI="https://gorest.co.in";
		RequestSpecification request=RestAssured.given();
		
		JSONObject json=new JSONObject();
		json.put("name", "ThulasiramAnandakumar");
		json.put("email", "thuasiHa@gmail.com");
		json.put("gender", "Male");
		json.put("status", "active");
		
		System.out.println(json.toJSONString());
		
		request.header("Content-Type","application/json");
		request.body(json.toJSONString());
		Response response=request.post("public/v1/users?access-token=51e45659b17436f2804dee7db56facf715d7843757726c610225da60694f3162");
		System.out.println(response.getBody().asPrettyString());

		Assert.assertEquals(response.statusCode(), 201);
		int statusCode=response.statusCode();
		System.out.println(statusCode);
		
		
	}

}
