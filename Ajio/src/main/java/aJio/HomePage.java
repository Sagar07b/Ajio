package aJio;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
      private WebDriver driver;
	
	 @FindBy(xpath="//input[@name='searchVal']")
	 private WebElement sarchInput;
	 
	 @FindBy(xpath="//span[@class='ic-search']")
	 private WebElement sarchButton;
		
	 @FindBy(xpath="//a[@title='MEN']")
	 private WebElement menButton;
	 
	 @FindBy(xpath="//a[text()='Watches'] ")
	 private WebElement watches;
 
	 @FindBy(xpath="(//a[text()='Sports Shoes'])[1]")
	 private WebElement sportSoose; 
	 
	 
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	public void sendSearchInput() {
		sarchInput.sendKeys("shirt");
		}
		
	public void clickOnSearchIcon() {
			sarchButton.click();
		}
 
	public void clickOnMen() {
		Actions act=new Actions(driver);

		act.moveToElement(menButton).moveToElement(watches).click().build().perform();
		
	}
		
	public void clickOnMenShoose() {
		Actions act=new Actions(driver);

		act.moveToElement(menButton).moveToElement(sportSoose).click().build().perform();
		
	}
		
		
}

