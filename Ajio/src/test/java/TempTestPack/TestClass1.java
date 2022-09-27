package TempTestPack;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import aJio.AddToCartProductPage;
import aJio.HP2ProductPage;
import aJio.HomePage;

public class TestClass1 {
 
public static void main(String[] args) throws InterruptedException {
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		
		System.setProperty("webdriver.chrome.driver", "D:\\Software Testing\\Automation notes\\Selenium\\chromedriver_win32\\chromedriver.exe");
		
	     WebDriver driver = new ChromeDriver(options);
		
	     driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		
	     driver.get("https://www.ajio.com/");
	
	     HomePage homePage= new HomePage(driver);
	     homePage.clickOnMen();
	     String title0 = driver.getTitle();
	   //  System.out.println(title0);
	     if(title0.equals("Men Watches"))
	     {
	    	 System.out.println("Title is Verified");
	     }
	     else
	     {
	    	 System.out.println("Title is Wrong");
	     }
	     Thread.sleep(8000);
	     HP2ProductPage hP2ProductPage =new HP2ProductPage(driver);
	     
	     hP2ProductPage.clickOnWatch();
	     ArrayList<String> listAddr = new  ArrayList<String> (driver.getWindowHandles());
	     driver.switchTo().window(listAddr.get(1));
	     
	     String title = driver.getTitle();
	   //  System.out.println(title);
	     if(title.equals("Buy Black Watches for Men by Fire-Boltt Online | Ajio.com"))
	     {
	    	 System.out.println("Title is Verified");
	     }
	     else
	     {
	    	 System.out.println("Title is Wrong");
	     }
	     AddToCartProductPage addToCartProductPage = new AddToCartProductPage(driver);
	     addToCartProductPage.addToCartProduct();
	     String title1 = driver.getTitle();
	   //  System.out.println(title1);
	     if(title1.equals("Buy Black Watches for Men by Fire-Boltt Online | Ajio.com"))
	     {
	    	 System.out.println("Title is Verified");
	     }
	     else
	     {
	    	 System.out.println("Title is Wrong");
	     }
	     addToCartProductPage.clickOnGoToBagButton();
	
	     String title2 = driver.getTitle();
	   //  System.out.println(title2);
	     if(title2.equals("Your Shopping Bag | AJIO"))
	     {
	    	 System.out.println("Title is Verified");
	     }
	     else
	     {
	    	 System.out.println("Title is Wrong");
	     }
	
}
}
 
	
 
