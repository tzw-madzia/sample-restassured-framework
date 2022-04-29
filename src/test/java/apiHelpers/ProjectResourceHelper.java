package apiHelpers;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import pojos.Project;

public class ProjectResourceHelper {
	
	// DESCRIPTION:
	// Place to store the reusable code that will be responsible for calling all the common rest api methods on a single resource.

	// INSTRUCTIONS:
	// Use the code as is to see how the framework works or replace it with your own file.
	// This class is created specifically for the Projects resource in the example API and sadly cannot be reused.
	// If you want to prepare the framework for your own API, treat this file as an example to create analogical files for all the resources in your API.
	
	@Step("Make a POST call to the projects path")
	public static Response post(Project projectPayload) {
		return RestMethodsHelpers.post(Route.PROJECTS_PATH.getPath(), projectPayload);
	}
	
	@Step("Make a GET call to the project {projectId} path")
	public static Response get(Long projectId) {
		return RestMethodsHelpers.get(Route.PROJECTS_PATH.getPath() + "/" + projectId);
	}
	
	@Step("Make a POST call to the project {projectId} path")
	public static Response update(Long projectId, Project projectPayload) {
		return RestMethodsHelpers.post(Route.PROJECTS_PATH.getPath() + "/" + projectId, projectPayload);
	}
	
	@Step("Make a DELETE call to the project {projectId} path")
	public static Response delete(Long projectId) {
		return RestMethodsHelpers.delete(Route.PROJECTS_PATH.getPath() + "/" + projectId);
	}
	
	
}
