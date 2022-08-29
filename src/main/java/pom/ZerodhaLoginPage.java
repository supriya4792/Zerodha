package pom;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ZerodhaLoginPage {
	
	@FindBy (xpath= "//input[@id='userid']") private WebElement userid;
	@FindBy (xpath= "//input[@id='password']") private WebElement password ;
	@FindBy (xpath= "//button[@type='submit']") private WebElement login;
	@FindBy (xpath = "//a[text() = 'Forgot user ID or password?']") private WebElement forgot;
	@FindBy (xpath = "//a[text() = \"Don't have an account? Signup now!\"]") private WebElement signup;
    @FindBy (xpath = "//input[@id='pin'] ") private WebElement pin;
    @FindBy (xpath = "//button[@type='submit'] ") private WebElement submitPin;
    
	
	public ZerodhaLoginPage (WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void enterUserId(String user) {
		
		userid.sendKeys(user);
	}
	
	public void enterPassword(String pass) {
		
		password.sendKeys(pass);
	}
	
	public void clickOnLogin() {
		
		login.click();
	}
	
	
	public void clickOnForgot() {
		
		forgot.click();
	}
	
	public void clickOnSignup() {
		signup.click();
		
	}
	
	public void enterPin(WebDriver driver , String pinvalue) {
		
		//Explicit Wait
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(1000));
	//	wait.until(ExpectedConditions.visibilityOf(pin));
		//pin.sendKeys(pinvalue);
		
		//Fluent Wait
		
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
		wait.withTimeout(Duration.ofMillis(2000)); //this is the maximum time of wait
		wait.pollingEvery(Duration.ofMillis(100)); //this is the pooling time
		wait.ignoring(Exception.class); //this will handle exception
		wait.until(ExpectedConditions.visibilityOf(pin));
		pin.sendKeys(pinvalue);
		
	}
	
	public void clickOnContinue() {
		 submitPin.click();
		
	}
	
	public void switchToSignUpPage(WebDriver driver) {
		
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> i = handles.iterator();
		while(i.hasNext())
				{
			
			String handle = i.next();
			driver.switchTo().window(handle);
			String title = driver.getTitle();
			
			if(title.equals("Signup and open a Zerodha trading and demat account online and star..."));
				}
			//{
			//	break;
			
			//}
		//
	}
		
		public void switchToForgotPasswordPage(WebDriver driver) {
			
			Set<String> handles1 = driver.getWindowHandles();
			Iterator<String> ite = handles1.iterator();
			while(ite.hasNext())
			{
		
		String handle = ite.next();
		driver.switchTo().window(handle);
		String title = driver.getTitle();
		
		if(title.equals("forgot password/kite"));
			}
			
		}
		
		
		
		
			
	}
	
			
	
	
	
	
	
	
	
	
		

