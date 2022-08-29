package test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pojo.LaunchBrowser;
import pom.ForgotPasswordPage;
import pom.ZerodhaLoginPage;
import utility.Parametrization;

public class ForgotPageTest {
	
	
WebDriver driver;
	
	@BeforeMethod()
		public void launchBrowser() {
		driver = LaunchBrowser.openBrowser();
		
	}
	
	
	@Test
	
	public void zerodhaForgot() throws InterruptedException, EncryptedDocumentException, IOException {
		
		ZerodhaLoginPage zerodhaloginpage = new ZerodhaLoginPage (driver);
		zerodhaloginpage.clickOnForgot();
		Thread.sleep(2000);
		zerodhaloginpage.switchToForgotPasswordPage(driver);
		
		ForgotPasswordPage forgotpasswordpage = new ForgotPasswordPage(driver);
		forgotpasswordpage.clickOnRadio2();
		forgotpasswordpage.clickOnRadio1();
		String value = Parametrization.getData("Credentials", 0, 1);
		forgotpasswordpage.enterUserId(value);
		forgotpasswordpage.enterPanNo("ABC3453");
		forgotpasswordpage.clickOnSmsRadio();
		
	}
	
	
	}
	
	


