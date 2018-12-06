package examples;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import org.testng.annotations.Test;

public class DemoFile {
	@Test
	public void test()
	{
		String pattern = "yyyy-MM-dd";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

		String date = simpleDateFormat.format(new Date());
		System.out.println(date);

		System.out.println(LocalDate.now().plusDays(3));
	}

}
