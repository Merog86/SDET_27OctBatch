package examples;

import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.testng.annotations.Test;

import com.opencsv.CSVReader;

public class CSVFileReader {
	
	@Test
	public void csvReader() throws IOException
	{
		CSVReader reader=new CSVReader(new FileReader("CSVFile.csv"));
		List<String[]> csvRows=reader.readAll();
		System.out.println("Total rows in the CSV file are: "+csvRows.size());
		
		System.out.println("Values of CSV File are as shown below: ");
		Iterator<String[]> rows=csvRows.iterator();
		while(rows.hasNext())
		{
			String[] arr=rows.next();
		//	System.out.println(rows.next());
			
			for(String s:arr)
			{
				System.out.print(s+" |");
			}
			
			System.out.println();

			/*for(int i=0;i<arr.length;i++)
			{
				System.out.println(i+" value: "+ arr[i]);
			}*/
		}
	}
	

}
