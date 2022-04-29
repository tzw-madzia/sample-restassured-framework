package testHelpers;

import utils.ConfigLoader;

import apiHelpers.Route;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class SpecBuilder {
	
	// DESCRIPTION:
	// Place to store methods that will build the common Request/Response Specification
		
	// INSTRUCTIONS:
	// Use the code as is to see how the framework works or modify it to work with your API
	
	static String accessToken = ConfigLoader.getInstance().getToken();

	public static RequestSpecification getRequestSpec() {
		return new RequestSpecBuilder().
				setBaseUri(Route.BASE_URL.getPath()).
				setBasePath(Route.BASE_PATH.getPath()).
				addHeader("Authorization", "Bearer " + accessToken).
				setContentType(ContentType.JSON).
				addFilter(new AllureRestAssured()).
				log(LogDetail.ALL).
				build();
	}

	public static ResponseSpecification getResponseSpec() {
		return new ResponseSpecBuilder().
				log(LogDetail.ALL).
				build();
	}

}
