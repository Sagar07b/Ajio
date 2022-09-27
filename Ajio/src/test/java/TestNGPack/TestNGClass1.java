package TestNGPack;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import aJio.AddToCartProductPage;
import aJio.HP2ProductPage;
import aJio.HomePage;
import setUp.Base;
import utils.Utility;

public class TestNGClass1 extends Base {
private WebDriver driver;
private HP2ProductPage hP2ProductPage;
private AddToCartProductPage addToCartProductPage;
private HomePage homePage;
private SoftAssert soft;
 private ChromeOptions options;
 int testId;
@Parameters ("browser")

@BeforeTest
public void launchBrowser(String browserName)
{
	if(browserName.equals("Chrome"))
	{
		driver= openChromeBrowser();
	}
	
	if(browserName.equals("MicroSoftEdge"))
 	{
 		 driver=openMicrosoftEdgexBrowser();

     }
	
	if(browserName.equals("Opera"))
 	{
 		 driver=openOperaBrowser();

     }
	
	driver.manage().timeouts().implicitlyWait(12,TimeUnit.SECONDS);
}

@BeforeClass
	public void createPOMObject() {
 
		 homePage= new HomePage(driver);
		 hP2ProductPage =new HP2ProductPage(driver);
		 homePage= new HomePage(driver);
		 hP2ProductPage =new HP2ProductPage(driver);
		 addToCartProductPage = new AddToCartProductPage(driver);
	}
	
@BeforeMethod
	public void launchUrl() {
    	 driver.get("https://www.ajio.com/");
	    soft=new SoftAssert();
}
	
@Test  
	public void selectWatch() throws IOException {
	   int testId= 1001 ;
	   
       homePage.clickOnMen();
     
       String title0 = driver.getTitle();
      Assert.assertEquals(title0, "Men Watches");
 
	     hP2ProductPage.clickOnWatch();
	     
	     ArrayList<String> listAddr = new  ArrayList<String> (driver.getWindowHandles());
	     driver.switchTo().window(listAddr.get(1));
	     
	     String title = driver.getTitle();
	     System.out.println(title);
	     soft.assertEquals(title,"Buy Silver-Toned Watches for Men by Redux Online | Ajio.com", "Title Is Not Verified");
	     soft.assertAll();
	     
	    
	     
	     
	}
 
 @Test
    public void sportShoosePage() throws IOException {
	      testId=1002;
	      homePage.clickOnMenShoose();
	      
	      String title1 = driver.getTitle();
        soft.assertEquals(title1, "Men's Sports Shoes Online: Low Price Offer on Sports Shoes for Men - AJIO");    
	
	     hP2ProductPage.clickOnSportShoose();
	     
	     ArrayList<String> listAddr = new  ArrayList<String> (driver.getWindowHandles());
	     driver.switchTo().window(listAddr.get(2));
		 
	     addToCartProductPage.selectShooseSize();
	     soft.assertAll();
	     
 }
 
 @AfterMethod
   public void addToCartProduct(ITestResult result1) throws InterruptedException, IOException {
	 
	 
	     addToCartProductPage.addToCartProduct();
	     
	     Thread.sleep(5000);
		 addToCartProductPage.clickOnGoToBagButton();
			
	      String title2 = driver.getTitle();
	      Thread.sleep(4000);
	      soft=new SoftAssert();
	      soft.assertEquals(title2,"Your Shopping Bag | AJIO");
	      soft.assertAll();
	  	if (ITestResult.FAILURE==result1.getStatus()) {
			Utility.capture(driver, testId);
		}
	 }
@AfterClass
	public void cleanPomObject() {

		 homePage= null;
		 hP2ProductPage =null;
		 homePage= null;
		 hP2ProductPage =null;
		 addToCartProductPage =null;
		  
	}
	
@AfterTest
	public void closedBrowser() {
		driver.quit();
		driver=null;
		System.gc();
	}
	
	
}





