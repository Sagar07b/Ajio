package TempTestPack;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import aJio.AddToCartProductPage;
import aJio.BagAddToCart;
import aJio.CheckAddToBagProduct;
import aJio.HP2ProductPage;
import aJio.HomePage;
import aJio.ScreenShot;

public class TestClass {
public static void main(String[] args) throws InterruptedException, IOException {
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		
		System.setProperty("webdriver.chrome.driver", "D:\\Software Testing\\Automation notes\\Selenium\\chromedriver_win32\\chromedriver.exe");
		
	     WebDriver driver = new ChromeDriver(options);
		
	     driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
	     driver.get("https://www.ajio.com/");
		
		HomePage homePage=new HomePage(driver);
		homePage.sendSearchInput();
		homePage.clickOnSearchIcon();
	 
		ScreenShot ScreenShot =new ScreenShot(driver);
		ScreenShot.takeScreenShot();
		
		
		HP2ProductPage hP2ProductPage =new HP2ProductPage(driver);
		hP2ProductPage.selectProduct();
		
		ScreenShot ScreenShot1 =new ScreenShot(driver);
		ScreenShot1.takeScreenShot();
		
		ArrayList<String> addrList = new ArrayList<String> (driver.getWindowHandles());
		 driver.switchTo().window(addrList.get(1));
		
		AddToCartProductPage addToCartProductPage =new AddToCartProductPage(driver);
		addToCartProductPage.selectProductSize();
		addToCartProductPage.clickonAddToCartProduct();
		addToCartProductPage.clickOnGoToBagButton();
		 
		ScreenShot ScreenShot2 =new ScreenShot(driver);
		ScreenShot2.takeScreenShot();
		
		CheckAddToBagProduct checkAddToBagProduct =new CheckAddToBagProduct(driver);
		checkAddToBagProduct.changeProductSize();
		checkAddToBagProduct.selectProductSize();
		checkAddToBagProduct.selectProductQuantity();
		checkAddToBagProduct.clickOnUpdateButton();
		
		ScreenShot ScreenShot3 =new ScreenShot(driver);
		ScreenShot3.takeScreenShot();
		
		
		
}
}
