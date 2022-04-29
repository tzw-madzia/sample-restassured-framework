package apiHelpers;

public enum Route {
	
	// DESCRIPTION:
	// Place to store the paths to all of the endpoints in the API, as well as some base urls.
	
	// INSTRUCTIONS:
	// Use the code as is to see how the framework works or modify it to work with your API
	// BASE_URL - base url from the location of the API 
	// BASE_PATH - path to the API that apperas after the "/" in the base url (delete if not needed) 
	// PROJECS_PATH - a path to the Project resource in the example API, replace it if not needed and add all other paths below
	
	BASE_URL("https://api.todoist.com"), 
	BASE_PATH("/rest/v1"),
	PROJECTS_PATH("/projects");
	  
	private String path;
	  
	Route(String path) { this.path = path; }
	  
	public String getPath() { return path; }
	 

}
