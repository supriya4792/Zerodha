package test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pojo.LaunchBrowser;
import pom.BuyStockPage;
import pom.ZerodhaHomePage;
import pom.ZerodhaLoginPage;
import utility.Parametrization;

public class BuyStockTest {
	
WebDriver driver;
	
	@BeforeMethod()
		public void launchBrowser() throws EncryptedDocumentException, IOException {
		driver = LaunchBrowser.openBrowser();

		ZerodhaLoginPage zerodhaloginpage = new ZerodhaLoginPage(driver);
		String user =Parametrization.getData("Credentials", 0, 1);
		String pass =Parametrization.getData("Credentials", 1, 1);
		String pinno =Parametrization.getData("Credentials", 2, 1);
		zerodhaloginpage.enterUserId(user);
		zerodhaloginpage.enterPassword(pass);
		zerodhaloginpage.clickOnLogin();
		zerodhaloginpage.enterPin(driver ,pinno);
		zerodhaloginpage.clickOnContinue();
		
		ZerodhaHomePage zerodhahomepage = new ZerodhaHomePage(driver);
		zerodhahomepage.SeachStock("Tata", driver);
		zerodhahomepage.searchAndSelectDesiredStock(driver, "TATAPOWER");
		zerodhahomepage.clickOnSearchBuy();
		
	}
		@Test
		
		public void ClickOnIntradayAndBuyStock() throws InterruptedException {
		BuyStockPage buystockpage = new BuyStockPage(driver);
		//Thread.sleep(2000);
		 buystockpage.clickOnIntraday();

}
}
