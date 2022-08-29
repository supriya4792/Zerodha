package pojo;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LaunchBrowser {
	
	public static WebDriver openBrowser() {
		
		ChromeOptions options = new ChromeOptions ();
		options.addArguments("--disable-notifications");
		
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\SeleniumDocuments\\chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver(options);
		
		driver.navigate().to("https://kite.zerodha.com/");
		driver.manage().window().maximize();
	//	driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));
		return driver;

}
}