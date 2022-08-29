package utility;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenShot {
	
	
	public static void takeScreenShot(WebDriver driver, String name ) throws IOException {
		String date = ScreenShot.getdate();
		TakesScreenshot sc = ((TakesScreenshot)driver);
		File source = sc.getScreenshotAs(OutputType.FILE);
		
		File destination = new File("C:\\Users\\Admin\\eclipse-workspace\\Zerodha\\ScreenShot\\" +name+" "+date+".png");
		FileHandler.copy(source, destination);
		
	}
	
	public static String getdate() {
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm-ss");
		LocalDateTime currentdate = LocalDateTime.now();
		String date = dtf.format(currentdate); 
		return date;
		
	}
	

}
