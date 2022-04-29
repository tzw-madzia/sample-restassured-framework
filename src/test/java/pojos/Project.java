package pojos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Value
@Jacksonized
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Project {
	
	// DESCRIPTION:
	// Sample POJO class for a single resource in the API. POJO stands for Plain Old Java Object 
	// (the way it's used in the API automation framework corresponds to page objects page object classes in the WEB/UI automation
	
	// INSTRUCTIONS:
	// Use the code as is to see how the framework works or replace it with your own file.
	// This POJO class is dedicated to the Projects resource in the example API and sadly cannot be reused
	// If you want to prepare the framework for your own API. Treat it as an example to create POJO classes for the resources in your API.
	
	Long id;
	String name;
	Integer color;
	@JsonProperty("parent_id")
	Integer parentId;
	Integer order;
	@JsonProperty("comment_count")
	Integer commentCount;
	Boolean shared;
	Boolean favorite;
	@JsonProperty("inbox_project")
	Boolean inboxProject;
	@JsonProperty("team_inbox")
	Boolean teamInbox;
	@JsonProperty("sync_id")
	Integer syncId;
	String url;
	
}
