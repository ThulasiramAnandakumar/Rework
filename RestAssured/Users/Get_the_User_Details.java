package Task_Sep24;




import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class Get_the_User_Details
{
	@Test
	public void Get()
	{
		String token="51e45659b17436f2804dee7db56facf715d7843757726c610225da60694f3162";
		
		RestAssured.baseURI="https://gorest.co.in";
//		
//		RequestSpecification http= RestAssured.given();
// 
//		io.restassured.response.Response response=http.get("/public/v1/users?id=1578");
//		
		
		
		RestAssured
		.given()
			.auth()
			.oauth2(token)
			.contentType(ContentType.JSON)
		.when()
			.get("/public/v1/users/1578")
		.then()
		.assertThat()
		 	.statusCode(200)
		.extract()
		.response()
		.prettyPrint();
		
		
		
	}
}
