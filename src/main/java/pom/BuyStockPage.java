package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebElement;

public class BuyStockPage {
	
	@FindBy(xpath = "//label[@for='radio-180']") private WebElement intraday;
	//@FindBy(xpath="")



  public BuyStockPage(WebDriver driver) {
	
	PageFactory.initElements(driver, this);
	
	
  }
	
	public void clickOnIntraday() throws InterruptedException {
		Thread.sleep(2000);
		intraday.click();
	}
  
}