package TempTestPack;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import aJio.Footer;

public class TestClass2 {
public static void main(String[] args) throws InterruptedException {
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		
		System.setProperty("webdriver.chrome.driver", "D:\\Software Testing\\Automation notes\\Selenium\\chromedriver_win32\\chromedriver.exe");
		
	     WebDriver driver = new ChromeDriver(options);
		
	     driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
	     driver.get("https://www.ajio.com/");
	     
	     Footer footer=new Footer(driver);
	     footer.scrollInToView();
	     footer.clickOnFacebook();
	     
	     ArrayList<String> listAddr =new  ArrayList<String> (driver.getWindowHandles());
	     driver.switchTo().window(listAddr.get(1));
	     
	      
	     String title= driver.getTitle();
	   //  System.out.println(title);
	     if(title.equals("AJIOlife - Home | Facebook"))
	     {
	    	 System.out.println("Facebook Test Pass");
	     }
	     else
	     {
	    	 System.out.println("Facebook Test Fail");
	     }
	     
	     ArrayList<String> listAdd =new  ArrayList<String> (driver.getWindowHandles());
	     driver.switchTo().window(listAdd.get(0));
	     
	     footer.clickOnInstagram();
	     
	       String title1= driver.getTitle();
		   // System.out.println(title1);
		     if(title1.equals("AJIO.com (@ajiolife) • Instagram photos and videos"))
		     {
		    	 System.out.println("Instagram Test Pass");
		     }
		     else
		     {
		    	 System.out.println("Instagram Test Fail");
		     }
	     
}	     
	     
}
