package utils;

import java.io.IOException;

import java.io.InputStream;
import java.util.Properties;


public class Configuration {
   static Properties properties;
	
	
	public static void loadProperties(Class classs) {
		properties=new Properties();
		InputStream iStream=classs.getClassLoader().getResourceAsStream("config.properties");
		try {
			properties.load(iStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public String getUrl() {
		return properties.getProperty("url");
	}
	
	

}
