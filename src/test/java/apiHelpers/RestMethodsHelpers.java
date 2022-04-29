package apiHelpers;

import static io.restassured.RestAssured.given;

import io.restassured.response.Response;
import testHelpers.SpecBuilder;

public class RestMethodsHelpers {
	
	// DESCRIPTION:
	// Place to store methods that will construct appropriate requests and extract responses for all common rest methods used in APIs
	// Code below will work only when Route and SpecBuilder classes are created properly.
	
	// INSTRUCTIONS:
	// Use the code as is to see how the framework works or modify it to work with your API

	public static Response post(String path, Object payload) {
		return given(SpecBuilder.getRequestSpec()).
				body(payload).
			when().post(path).
			then().spec(SpecBuilder.getResponseSpec()).
				extract().response();
	}
	
	public static Response get(String path) {
		return given(SpecBuilder.getRequestSpec()).
			when().get(path).
			then().spec(SpecBuilder.getResponseSpec()).
				extract().response();
	}
	
	public static Response update(String path, Object payload) {
		return given(SpecBuilder.getRequestSpec()).
				body(payload).
			when().put(path).
			then().spec(SpecBuilder.getResponseSpec()).
				extract().response();
	}
	
	public static Response delete(String path) {
		return given(SpecBuilder.getRequestSpec()).
			when().delete(path).
			then().spec(SpecBuilder.getResponseSpec()).
				extract().response();
	}

}
