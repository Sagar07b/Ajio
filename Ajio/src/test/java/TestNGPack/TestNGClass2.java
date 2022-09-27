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

import aJio.Footer;
import setUp.Base;
import utils.Utility;

public class TestNGClass2 extends Base{
 private  WebDriver driver  ;
 private  Footer footer;
 private SoftAssert soft;
 private ChromeOptions options;
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
	public void lounchBrowser () {
		 options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		
		 footer=new Footer(driver);
		 
		 
	}
	
@BeforeMethod
	public void louncURL() {
       driver.get("https://www.ajio.com/");
	     
	     footer.scrollInToView();
	     soft=new SoftAssert();
	}
	
@Test (priority =1)
	public void openAjioFacebookPage() throws InterruptedException, IOException {
	  testId=1003;
        footer.clickOnFacebook();
	     
	     ArrayList<String> listAddr =new  ArrayList<String> (driver.getWindowHandles());
	     driver.switchTo().window(listAddr.get(1));
	     
	      Thread.sleep(4000);
	     String title= driver.getTitle();
	    
	    soft.assertEquals(title, "AJIOlife - Home"); 
	     soft.assertAll();
	     
	}
	
@Test (priority=2)
	public void openAjioInstagramPage() throws InterruptedException, IOException {
	  testId=1004;
		 footer.clickOnInstagram();
	     Thread.sleep(4000);
       String title1= driver.getTitle();
	    
       soft.assertEquals(title1, "AJIO.com (@ajiolife) • Instagram photos and videos");
       soft.assertAll();   
        
	}
@AfterMethod
public void captureScreenShot(ITestResult result1) throws IOException {
	if (ITestResult.FAILURE==result1.getStatus()) {
		Utility.capture(driver, testId);
	}
}
	
 @AfterClass
 public void cleanPomObject() {

	 footer= null;
	  
}

@AfterTest
public void closedBrowser() {
	driver.quit();
	driver=null;
	System.gc();
}
	
}
