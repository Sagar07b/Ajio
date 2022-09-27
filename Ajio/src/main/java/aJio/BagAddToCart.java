package aJio;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BagAddToCart {

	@FindBy(xpath="//div[@class='ic-cart ']")
	private WebElement clickOnBag;
	
	public   BagAddToCart(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	 
		 
	
	public void clickOnBagIcon() {
		clickOnBag.click();
	}
	
	
}
