package com.learnmaven.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadConfigData {
	
	Properties pro;
	
	public ReadConfigData() {
		
		File src=new File("./Configuration/Config.properties");
		
		try {
			FileInputStream fis=new FileInputStream(src);
			
			pro= new Properties();
			
			pro.load(fis);
		} 
		catch (IOException e) {
			System.out.println("Unable to Load config file >> "+ e.getMessage());
		}

		
	}
	
	public String getDataFromConfig(String keyToSearch) {
		
		return pro.getProperty(keyToSearch);
	}
	
	public String getBrowser() {
		
		return pro.getProperty("browser");
	}

	public String getURL() {
	
		return pro.getProperty("url");
    }
	

}
