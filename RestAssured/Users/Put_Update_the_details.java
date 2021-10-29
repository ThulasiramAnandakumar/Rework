package Task_Sep24;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Put_Update_the_details
{
	
	@Test
	void Put()
	{
		RestAssured.baseURI="https://gorest.co.in";
		RequestSpecification request=RestAssured.given();
		
		JSONObject json=new JSONObject();
		json.put("name", "Divya");
		json.put("email", "AAAA@gmail.com");
		json.put("gender", "female");
		json.put("status", "inactive");
		
		System.out.println(json.toJSONString());
		
		request.header("Content-Type","application/json");
		request.body(json.toJSONString());
		Response response=request.put("public/v1/users/1578?access-token=51e45659b17436f2804dee7db56facf715d7843757726c610225da60694f3162");

		
		Assert.assertEquals(response.statusCode(), 200);

		int statusCode=response.statusCode();

		
		System.out.println(response.getBody().asPrettyString());
	}

}
