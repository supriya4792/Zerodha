package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgotPasswordPage {

	
	@FindBy(xpath = "(//form//label)[1]") private WebElement radio1;
	@FindBy (xpath= "(//form//label)[2]") private WebElement radio2;
	@FindBy (xpath = "//input[@placeholder='User ID']") private WebElement userid;
	@FindBy (xpath = "//input[@placeholder='PAN']") private WebElement PAN;
	@FindBy (xpath= " (//form//label)[5]") private WebElement emailradio;
	@FindBy (xpath="(//form//label)[6]") private WebElement smsradio;
	@FindBy (xpath = "//input[@placeholder='Mobile number (as on account)']") private WebElement mobno;
	@FindBy (xpath="//input[@placeholder='E-mail (as on account)'] ") private WebElement email;
	@FindBy (xpath= "//button[@type='submit']") private WebElement reset;
	


   public ForgotPasswordPage(WebDriver driver) {
	   
	   PageFactory.initElements(driver, this);
   }
   
   
   public void clickOnRadio1() {
	  radio1.click(); 
	   
   }
   public void clickOnRadio2() {
		  radio2.click(); 
   }
   
   public void enterUserId(String user) {
	    userid.sendKeys(user);
	   
   }
  public void enterPanNo(String panno) {
		PAN.sendKeys(panno);
	}
		
	public void clickOnEmailRadio() {
		emailradio.click();
			
	}
	public void enterEmailid(String emailid) {
		email.sendKeys(emailid);
		
	}
	
	public void clickOnSmsRadio() {
		smsradio.click();
	}
	
	public void enterMobNo(String mob) {
		mobno.sendKeys(mob);
	}
		  
	 public void clickOnReset() {
	  reset.click(); 
	}
	
	 public void validation() {
		 
		 
	 }
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
}