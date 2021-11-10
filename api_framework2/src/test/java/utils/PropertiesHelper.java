package utils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesHelper {

	public static String getProperty(String key) {
		try {
			FileReader reader=new FileReader("src/test/resources/global.properties");
			Properties p=new Properties();  
		    p.load(reader); 
		    return p.getProperty(key);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "ERROR - KEY NOT FOUND";  
	}
}
