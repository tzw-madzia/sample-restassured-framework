package apiHelpers;

public enum StatusCodes {
	
	// DESCRIPTION:
	// Place to can store all the status codes used in the API, along with messages associated with them.
	
	// INSTRUCTIONS:
	// Use the code as is to see how the framework works or modify it to work with your API
	
	CODE_200(200, ""),
	CODE_204(204, ""),
	CODE_400(400, ""),
	CODE_401(401, "Forbidden"),
	CODE_404(404, "Not found");
	
	private Integer code;
	private String message;
	
	StatusCodes(int code, String message) {
		this.code = code;
		this.message = message;
	}

	public Integer getCode() {
		return code;
	}
	
	public String getMessage() {
		return message;
	}
}
