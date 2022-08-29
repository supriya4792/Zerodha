package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ZerodhaSignUpPage {
	
	@FindBy (xpath ="//input[@id='user_mobile']") private WebElement mobno;
	@FindBy (xpath = "//button[@id='open_account_proceed_form']") private WebElement ok;
	
	


   public ZerodhaSignUpPage (WebDriver driver) {
	   
	  PageFactory.initElements(driver, this); 
   }
   
   
   public void enterMobNo(String value) {
	   
	   mobno.sendKeys(value);
	   
   }   
   
   
   
	   
	   
   }


