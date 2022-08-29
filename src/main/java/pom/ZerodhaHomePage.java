package pom;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

 public class ZerodhaHomePage {
	
	@FindBy (xpath= "//input[@type='text']") private WebElement search;
    @FindBy (xpath = "//span[@class='tradingsymbol'] ") private List<WebElement> searchresult;
    @FindBy(xpath="//button[@data-balloon='Buy']") private WebElement searchBuy;
    @FindBy(xpath="//button[@data-balloon='Sell']") private WebElement searchsell;
    @FindBy(xpath="(//span[@class='icon icon-trending-up'])[1]") private WebElement searchchart;
    @FindBy(xpath="//span[@class='icon icon-align-center']") private WebElement searchMarketdepth;
    @FindBy(xpath="//span[@class='icon icon-plus']") private WebElement searchAdd;
 //   @FindBy (xpath="//input[@icon='search']") private  WebElement searchtodelete;
    @FindBy(xpath="//span[@class='nice-name']") private  List<WebElement> addedstock;
    @FindBy(xpath="//span[@class='icon icon-trash']") private WebElement searchdelete;

 
  public ZerodhaHomePage (WebDriver driver) {
	  PageFactory.initElements(driver, this);
 }
  
  public void SeachStock(String stock, WebDriver driver) {
	  WebDriverWait wait = new WebDriverWait(driver , Duration.ofMillis(2000));
	  wait.until(ExpectedConditions.visibilityOf(search));
	  search.sendKeys(stock);
	  
  }
  
   public int getSearchResult() {
	   
	 int listsize= searchresult.size();
	  return listsize;
  }
   
   public void searchAndSelectDesiredStock(WebDriver driver, String RequiredStock) {
	   
	   for(int i=0;i<searchresult.size();i++) {
		   
		   WebElement s= searchresult.get(i);
		  String stockname = s.getText();
		  
		  if(stockname.equalsIgnoreCase(RequiredStock))
		  {
			  Actions action = new Actions(driver);
			  action.moveToElement(s);
			  action.perform();
			  break;
		   }
		  }
		
	   
   }
 
   
   public void clickOnSearchBuy() {
	   searchBuy.click();
	   
   }
   
   public void clickOnSearchSell() {
	   
	   searchsell.click();
   }
   
   public void clickOnSearchChart() {
	   
	   searchchart.click();
 
   }
   
   public void clickOnSearchMarketDepth() {
	   
	   searchMarketdepth.click();
   }
   
   public void clickOnSearchAdd() {
	   
	   searchAdd.click();
   }
 
 
   public void searchAndDeletDesiredStock(String ReqStock, WebDriver driver){
	 for(int j=0;j<addedstock.size();j++)
	 {
		   WebElement a= addedstock.get(j);
	  String stockname1 = a.getText();
	  
	  if(stockname1.equals(ReqStock))
	  {
		  Actions action = new Actions(driver);
		  action.moveToElement(a);
		  action.perform();
		  break;
	   }
	 }
   }
	  
	
	  
		  public void clickOnSearchDelete() throws InterruptedException {
	
    	Thread.sleep(2000);
    	searchdelete.click();
    	
    }

	
}
 
 
 
 