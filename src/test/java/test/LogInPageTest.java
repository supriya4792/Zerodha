package test;

import java.io.IOException;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import pojo.LaunchBrowser;
import pom.ZerodhaLoginPage;
import utility.BaseTest;
import utility.Parametrization;
import utility.Reports;
import utility.ScreenShot;

@Listeners(utility.Listener.class)
public class LogInPageTest extends BaseTest {
	//WebDriver driver;
	ExtentReports reports;
	ExtentTest test; 
	
	@BeforeTest
	public void addReports() {
	reports = Reports.generateReprts();
	
	}
	
	@BeforeMethod()
		public void launchBrowser() {
		driver = LaunchBrowser.openBrowser();
		
	}
	
	@Test
	public void zerodhaLogintest() throws EncryptedDocumentException, IOException, InterruptedException {
	   test = reports.createTest("zerodhaLogintest");
		ZerodhaLoginPage zerodhaloginpage = new ZerodhaLoginPage(driver);
		String user =Parametrization.getData("Credentials", 0, 1);
		String pass =Parametrization.getData("Credentials", 1, 1);
		String pinno =Parametrization.getData("Credentials", 2, 1);
		zerodhaloginpage.enterUserId(user);
		zerodhaloginpage.enterPassword(pass);
		zerodhaloginpage.clickOnLogin();
		//Thread.sleep(1000);
		zerodhaloginpage.enterPin(driver ,pinno);
		zerodhaloginpage.clickOnContinue();
		
		Assert.assertTrue(false);
	}
	
	@DataProvider (name = "Test Data")
	public Object[] [] data(){
		return new Object[] [] {{5, 10, "Velocity"}, {30,10 , "Katraj"}, {40,2,"Pune"}};
		
	}
	
	
	@Test(dataProvider="Test Data")
	public void data(int a, int b, String s) {
		test = reports.createTest("Test");
		System.out.println(a+b);
		System.out.println(s);
		
	}
	
	
	
	@Test
	public void validateZerodhaForgotLink() {
		test=reports.createTest("validateZerodhaForgotLink(");
		ZerodhaLoginPage zerodhaloginpage = new ZerodhaLoginPage(driver);
		zerodhaloginpage .clickOnForgot();
	}

	
	@AfterMethod
	
	public void postTest(ITestResult result) {
		
		if(result.getStatus()== ITestResult.FAILURE)
		{
			
			test.log(Status.FAIL, result.getName());
	}
		else if(result.getStatus()== ITestResult.SUCCESS)
	{
		
			test.log(Status.PASS, result.getName());
		}
		
		else
		{
			
			test.log(Status.SKIP, result.getName());
		}
	}
//	
	
	
   @AfterTest

	public void flushReport() {
		
		reports.flush();
	}
	
   }
	
	
	
	

	
	
	
	
	
	
	

