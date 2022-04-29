package tests;
import apiHelpers.ProjectResourceHelper;
import apiHelpers.StatusCodes;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import io.restassured.response.Response;
import pojos.Project;
import testHelpers.CommonMethods;
import testHelpers.DataBuilder;

import utils.FakerUtils;

@Epic("EPIC: Sample Framework Test Suite")
@Feature("FEATURE: Project tests")
public class ProjectTests {
	
	// DESCRIPTION:
	// Sample test class containing test for a single resource in the API. 

	// INSTRUCTIONS:
	// Use the code as is to see how the framework works or replace it with your own file.
	// This class is created specifically for the Projects resource in the example API and sadly cannot be reused.
	// If you want to prepare the framework for your own API, treat this file as an example to create analogical files for all the resources in your API.
	
	Long projectId;
	Project defaultProjectPayload;
	
	@BeforeClass
	public void BeforeClass() {
		defaultProjectPayload = DataBuilder.projectBuilder(FakerUtils.generateName(), 33, false);	
	}
	
	@Story("STORY: Create a project")
	@TmsLink("TC-001")
	@Description("This is the test case description")
	@Test(priority = 1, description = "User should be able to create a new project")
	public void shouldBeAbleToAddAProject() {
		
		Response response = ProjectResourceHelper.post(defaultProjectPayload);
		CommonMethods.assertStatusCode(response.statusCode(), StatusCodes.CODE_200.getCode());
		
		Project returnedProject = response.as(Project.class);
		validateProject(returnedProject, defaultProjectPayload);
		
		projectId = returnedProject.getId();

	}
	
	@Story("STORY: Create a project")
	@Test(description = "User should not be able to create a project without a name")
	public void shouldNotBeAbleToAddAProjectWithoutName() {
		Project projectPayloadWithoutName = DataBuilder.projectBuilder("", 33, false);

		Response response = ProjectResourceHelper.post(projectPayloadWithoutName);
		CommonMethods.assertStatusCode(response.statusCode(), StatusCodes.CODE_400.getCode());
		CommonMethods.assertMessageBody(response.body().asString(), "Name must be provided for the project creation");
	}
	
	
	@Story("STORY: Get a project")
	@Test(priority = 2, description = "User should be able to get an existing project")
	public void shouldBeAbleToGetAProject() {

		Response response = ProjectResourceHelper.get(projectId);
		CommonMethods.assertStatusCode(response.statusCode(), StatusCodes.CODE_200.getCode());
		validateProject(response.as(Project.class), defaultProjectPayload);
	}
	
	@Story("STORY: Update a project")
	@Test(priority = 3, description = "User should be able to update a project")
	public void shouldBeAbleToUpdateAProject() {
		Project updatedProjectPayload = DataBuilder.projectBuilder(FakerUtils.generateName(), 43, true);
	
		Response response = ProjectResourceHelper.update(projectId, updatedProjectPayload);
		CommonMethods.assertStatusCode(response.statusCode(), StatusCodes.CODE_204.getCode());
		
		Response updatedResponse = ProjectResourceHelper.get(projectId);
		CommonMethods.assertStatusCode(updatedResponse.statusCode(), StatusCodes.CODE_200.getCode());
		validateProject(updatedResponse.as(Project.class), updatedProjectPayload);
	}
	
	@Story("STORY: Delete a project")
	@Test(priority = 4, description = "User should be able to delete a project")
	public void shouldBeAbleToDeleteAProject() {
		Response response = ProjectResourceHelper.delete(projectId);
		CommonMethods.assertStatusCode(response.statusCode(), StatusCodes.CODE_204.getCode());;
	}
	
	//COMMON METHODS BELOW
	@Step("Validate the response body")
	public void validateProject(Project requestProject, Project responseProject) {
		assertThat(responseProject.getName(), equalTo(requestProject.getName()));
		assertThat(responseProject.getColor(), equalTo(requestProject.getColor()));
		assertThat(responseProject.getFavorite(), equalTo(requestProject.getFavorite()));
	}
}
