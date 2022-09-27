package aJio;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckAddToBagProduct {

	

	
	@FindBy(xpath="(//span[@class='ic-chevrondown'])[1]")
	private WebElement changeProductSize;
	
	@FindBy(xpath="(//div[@class='circle size-variant-item size-instock ']) [4]  ")
	private WebElement selectSize;
	
	@FindBy(xpath="//button[text()=' + ']")
	private WebElement selectQuantity;
	
	@FindBy(xpath="//button[@id='updateQuantity']")
	private WebElement clickOnUpdateButton;
	
	
	public CheckAddToBagProduct(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	
	public void changeProductSize() {
		changeProductSize.click();
	}
	
	public void selectProductSize() {
		selectSize.click();
	}
	
	public void selectProductQuantity() {
		selectQuantity.click();
	}
	
	public void  clickOnUpdateButton() {
		clickOnUpdateButton.click();
	}
	
	
	
}




 