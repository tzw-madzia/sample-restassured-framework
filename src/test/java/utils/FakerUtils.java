package utils;

import com.github.javafaker.Faker;

public class FakerUtils {
	
	// DESCRIPTION:
	// Place to store the code that will generate random data using the Faker library
	
	// INSTRUCTIONS:
	// Use the code as is to see how the framework works or modify it to work with your API
	
	public static String generateName() {
		Faker faker = new Faker();
		return faker.company().buzzword();
	}
}