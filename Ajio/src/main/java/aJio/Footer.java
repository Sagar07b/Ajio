package aJio;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Footer {

	private WebDriver driver;
	
	@FindBy(xpath="//a[text()='Facebook']")
	private WebElement facebook; 
	
	@FindBy(xpath="//a[text()='Instagram- AJIOlife']")
	private WebElement instgram; 
	
	@FindBy(xpath="//div[text()='Follow us']")
	private WebElement followUs; 
	
	
	
	public Footer(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	public void clickOnFacebook() {
		facebook.click();
	}
	
	public void clickOnInstagram() {
		instgram.click();
	}
	
	public void scrollInToView() {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);",followUs);
	}
}
