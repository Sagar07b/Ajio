package aJio;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HP2ProductPage {

	private WebDriver driver;
	
	 @FindBy(xpath="(//div[@class='preview'])[5]")
	 private WebElement selectProduct;
	 
	 @FindBy(xpath="//div[text()='RWS0042S Analogue Watch with Contrast Dial']")
	 private WebElement selectWatch;
	 
	 @FindBy(xpath="(//div[ @class='contentHolder'])[1]")
	 private WebElement selectShoose;
	
	 public  HP2ProductPage(WebDriver driver) {
			PageFactory.initElements(driver, this);
			this.driver =driver;
		}
	 
	 
	 public void selectProduct() {
		 WebDriverWait wait= new WebDriverWait(driver,10);
		 wait.until(ExpectedConditions.visibilityOf (selectProduct));
		 
  	   selectProduct.click();
	 }
	 
	 public void clickOnWatch() {
		 WebDriverWait wait= new WebDriverWait(driver,10);
		 wait.until(ExpectedConditions.visibilityOf(selectWatch));
		 
		 selectWatch.click();
	 }
	 
	 public void clickOnSportShoose() {
		 WebDriverWait wait= new WebDriverWait(driver,15);
		 wait.until(ExpectedConditions.visibilityOf(selectShoose));
		 
		 selectShoose.click();
}
}