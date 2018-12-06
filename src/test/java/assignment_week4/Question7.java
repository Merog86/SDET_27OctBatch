package assignment_week4;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Properties;

import org.testng.annotations.Test;

/*Assignment Question 7 – Print values from property file using for loop. Values mentioned in
property file are-
Name=Tom
Mobile=1234567
Address-Westley street*/

public class Question7 {
	Properties prop;
	Question7() throws IOException{
	File file=new File("data.properties");
	FileInputStream fis=new FileInputStream(file);
	 prop=new Properties();
	prop.load(fis);
	}
	
	@Test
	public void printPropertyValues()
	{
		Enumeration<?> e = prop.propertyNames();
		while (e.hasMoreElements()) {
			String key = (String) e.nextElement();
			String value = prop.getProperty(key);
			System.out.println("Key : " + key + ", Value : " + value);
		}
	}
}
