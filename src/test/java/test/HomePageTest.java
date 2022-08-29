package test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pojo.LaunchBrowser;
import pom.ZerodhaHomePage;
import pom.ZerodhaLoginPage;
import utility.Parametrization;

public class HomePageTest {
	
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
		

}
	@Test
	public void searchStockTest() {
		
		ZerodhaHomePage zerodhahomepage = new ZerodhaHomePage(driver);
		zerodhahomepage.SeachStock("TATA", driver);
		int number=zerodhahomepage.getSearchResult();
		System.out.println(number);
		
		Assert.assertTrue(number>0);
	}
	
	
	@Test
	
	public void searchStockAndClickOnBuy() {
			ZerodhaHomePage zerodhahomepage = new ZerodhaHomePage(driver);
			zerodhahomepage.SeachStock("Tata", driver);
			zerodhahomepage.searchAndSelectDesiredStock(driver, "TATAPOWER");
			zerodhahomepage.clickOnSearchBuy();
			
			WebElement w=driver.findElement(By.xpath("//span[@class='transaction-type']"));
			//String s =w.getText();
			//Assert.assertEquals(s,"TATAPOWER");
			Assert.assertTrue(w.isDisplayed());
			System.out.println("Buy window displyed");
	}
	
	@Test
	public void searchStockAndClickOnSell() {
		ZerodhaHomePage zerodhahomepage = new ZerodhaHomePage(driver);
		zerodhahomepage.SeachStock("Tata", driver);
		zerodhahomepage.searchAndSelectDesiredStock(driver, "TATAPOWER");
		zerodhahomepage.clickOnSearchSell();
		
	//	WebElement s = driver.findElement(By.xpath("//span[@class='transaction-type']"));
		WebElement s =driver.findElement(By.xpath("(//span[text()='Sell'])[1]"));
		//String str = s.getText();
		Assert.assertTrue(s.isDisplayed());
		System.out.println("Sell window displyed");
	}
	
	@Test
	
	public void searchStockAndClickOnChart() {
		ZerodhaHomePage zerodhahomepage = new ZerodhaHomePage(driver);
		zerodhahomepage.SeachStock("Tata", driver);
		zerodhahomepage.searchAndSelectDesiredStock(driver, "TATAPOWER");
		zerodhahomepage.clickOnSearchChart();
		
		
	}
	
	@Test
	
	public void searchStockAndClickOnMarketDepth() {
		ZerodhaHomePage zerodhahomepage = new ZerodhaHomePage(driver);
		zerodhahomepage.SeachStock("Tata", driver);
		zerodhahomepage.searchAndSelectDesiredStock(driver, "TATAPOWER");
		zerodhahomepage.clickOnSearchMarketDepth();
		
		
	}
	
	@Test
	public void searchStockAndClickOnAdd() {
		ZerodhaHomePage zerodhahomepage = new ZerodhaHomePage(driver);
		zerodhahomepage.SeachStock("Tata", driver);
		zerodhahomepage.searchAndSelectDesiredStock(driver, "TATAPOWER");
		zerodhahomepage.clickOnSearchAdd();
		
		
	}
	@Test
	public void searchStockAndDelete() throws InterruptedException {
		ZerodhaHomePage zerodhahomepage = new ZerodhaHomePage(driver);
		zerodhahomepage.searchAndDeletDesiredStock("WIPRO", driver);
		zerodhahomepage.clickOnSearchDelete();
	}
	}
