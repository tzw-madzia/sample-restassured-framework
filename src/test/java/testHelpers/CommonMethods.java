package testHelpers;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import io.qameta.allure.Step;

public class CommonMethods {
	
	// DESCRIPTION:
	// Place to store the commont methods used in more than one test class
		
	// INSTRUCTIONS:
	// Use the code as is to see how the framework works or modify it to work with your API
	
	@Step("Assert that status code of the response is equal to {expectedStatusCode}")
	public static void assertStatusCode(int actualStatusCode, int expectedStatusCode) {
		assertThat(actualStatusCode, equalTo(expectedStatusCode));
	}
	
	@Step("Assert that message in the response is equal to \"{expectedMessage}\"")
	public static void assertMessageBody(String actualMessage, String expectedMessage) {
		assertThat(actualMessage, equalTo(expectedMessage));
	}

}
