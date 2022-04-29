package testHelpers;

import io.qameta.allure.Step;
import pojos.Project;

public class DataBuilder {
	
	// DESCRIPTION:
	// Place to store the reusable code that will generate payloads for all of the resources based on corresponding pojo classes
	
	// INSTRUCTIONS:
	// Use the code as is to see how the framework works or modify it to work with your API

	@Step("Generate a project payload")
	public static Project projectBuilder(String name, Integer color, boolean favorite) {
		return Project.builder().
				name(name).
				color(color).
				favorite(favorite).
				build();
	}
}
