package TestNGPack;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
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
import aJio.BagAddToCart;
import aJio.CheckAddToBagProduct;
import aJio.HP2ProductPage;
import aJio.HomePage;
import aJio.ScreenShot;
import setUp.Base;
import utils.Utility;

public class TestNGClass3 extends Base {
 private ChromeOptions options ;
 private WebDriver driver;
 private CheckAddToBagProduct checkAddToBagProduct;
 private AddToCartProductPage addToCartProductPage;
 private BagAddToCart bagAddToCart;
 private HP2ProductPage hP2ProductPage;
 private HomePage homePage;
 private SoftAssert soft;
 int testId;
 
 @Parameters("browser")
 
 @BeforeTest
 public void lounchBrowser(String browserName) {
 	
	 if(browserName.equals("Chrome"))
		{
			driver= openChromeBrowser();
		}
		
	 if(browserName.equals("MicroSoftEdge"))
	 	{
	 		 driver= openMicrosoftEdgexBrowser();

	     }
	 if(browserName.equals("Opera"))
	 	{
	 		 driver=openOperaBrowser();

	     }
 	driver.manage().window().maximize();
 	driver.manage().timeouts().implicitlyWait(6,TimeUnit.SECONDS);
 }
 
@BeforeClass
	public void lounchBrowser() {
	  options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		
		  homePage=new HomePage(driver);
		  hP2ProductPage =new HP2ProductPage(driver);
		  addToCartProductPage =new AddToCartProductPage(driver);
		  bagAddToCart =new BagAddToCart(driver);
		  checkAddToBagProduct =new CheckAddToBagProduct(driver);
	}
	
@BeforeMethod
  public void lounchURL() {
	 driver.get("https://www.ajio.com/");
	 soft=new SoftAssert();
}
	
@Test (priority=1)
public void openProductPage() throws IOException {
      testId=1005;
	homePage.sendSearchInput();
	homePage.clickOnSearchIcon();
 
 
	 hP2ProductPage.selectProduct();
	 
	ArrayList<String> addrList = new ArrayList<String> (driver.getWindowHandles());
	 driver.switchTo().window(addrList.get(1));
	
	
	addToCartProductPage.selectProductSize();
	addToCartProductPage.clickonAddToCartProduct();
	
	 
    addToCartProductPage.clickOnGoToBagButton();
    
    String title2=driver.getTitle();
	  
	 soft.assertEquals(title2, "Your Shopping Bag | AJIO");
	 soft.assertAll();
	 
}
	
@Test (priority =2 ,dependsOnMethods="openProductPage")
	public void checkAddToCartBag() throws InterruptedException, IOException {
      testId=1006;
	
	    bagAddToCart.clickOnBagIcon();
	    Thread.sleep(4000);
	    String title3=driver.getTitle();
		 
		 soft.assertEquals(title3, "Your Shopping Bag | AJIO");
		 
	 
		checkAddToBagProduct.changeProductSize();
		checkAddToBagProduct.selectProductSize();
		checkAddToBagProduct.selectProductQuantity();
		checkAddToBagProduct.clickOnUpdateButton();
		
		 String title4=driver.getTitle();
		 System.out.println(title4);
		 soft.assertEquals(title4, "Your Shopping Bag | AJIO");
		 soft.assertAll();
		 
	}
	
@AfterMethod
	public void captureScreenshot(ITestResult result1) throws IOException {
	if (ITestResult.FAILURE==result1.getStatus()) {
		Utility.capture(driver, testId);
	}
	}
@AfterClass
public void cleanPomObject() {

	   homePage=null;
	   hP2ProductPage =null;
	   addToCartProductPage =null;
	   bagAddToCart =null;
	   checkAddToBagProduct =null;
	  
}

@AfterTest
public void closedBrowser() {
	driver.quit();
	driver=null;
	System.gc();
}
	
	
}

//<class name="TestNGPack.TestNGClass2"/>
//<class name="TestNGPack.TestNGClass3"/>





