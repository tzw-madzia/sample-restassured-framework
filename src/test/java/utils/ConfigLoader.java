package utils;

import java.util.Properties;

import utils.ConfigLoader;

public class ConfigLoader {
	
	// DESCRIPTION:
	// Place to store all the methods needed for the config properties to work properly
		
	// INSTRUCTIONS:
	// Use the code as is to see how the framework works or modify it to work with your API
	
    private final Properties properties;
    private static ConfigLoader configLoader;
    
    private ConfigLoader(){
        properties = PropertyUtils.propertyLoader("test/resources/config.properties");
    }
    
    public static ConfigLoader getInstance(){
        if(configLoader == null){
            configLoader = new ConfigLoader();
        }
        return configLoader;
    }
    
    public String getToken(){
        String prop = properties.getProperty("token");
        if(prop != null) return prop;
        else throw new RuntimeException("property token is not specified in the config.properties file");
    }
}
