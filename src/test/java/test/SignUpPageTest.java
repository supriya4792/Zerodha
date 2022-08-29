package test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pojo.LaunchBrowser;
import pom.ZerodhaLoginPage;
import pom.ZerodhaSignUpPage;

public class SignUpPageTest {
	
	
WebDriver driver;
	
	@BeforeMethod()
		public void launchBrowser() {
		driver = LaunchBrowser.openBrowser();
		
	}
	
	@Test
	public void zerodhaSignUp() throws InterruptedException {
		
		ZerodhaLoginPage zerodhaloginpage = new ZerodhaLoginPage (driver);
		zerodhaloginpage.clickOnSignup();

	    
		Thread.sleep(2000);
		zerodhaloginpage.switchToSignUpPage(driver);
		
		ZerodhaSignUpPage zerodhasignuppage= new ZerodhaSignUpPage(driver);
		zerodhasignuppage.enterMobNo("7767087840");
	}

}
