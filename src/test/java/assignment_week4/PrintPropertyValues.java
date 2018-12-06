package assignment_week4;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Properties;

import org.testng.annotations.Test;

public class PrintPropertyValues {
	Properties prop;
	PrintPropertyValues() throws IOException{
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
