package aJio;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddToCartProductPage {

	private WebDriver driver;
	
    @FindBy(xpath="//div[@class='size-variant-block']//div[5]")
    private WebElement selectSize;
    
    @FindBy(xpath=" //span[text()='8']")
    private WebElement selectShoosSize;
 
    
    @FindBy(xpath="//div[@class='btn-gold']")
    private WebElement addToBagProduct;
	
    @FindBy(xpath=" //span[text()='GO TO BAG']")
    private WebElement goToBag;
    
    @FindBy(xpath="//span[@class='ic-pdp-add-cart']")
    private WebElement addToCartProduct;
    
    
   
  
	public AddToCartProductPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	public void selectProductSize() {
		selectSize.click();
	}
	
	public void selectShooseSize() {
		selectShoosSize.click();
	}
	
	public void clickonAddToCartProduct() {
		addToBagProduct.click();
	}
	
	public void clickOnGoToBagButton() {
		goToBag.click();
	}
	
	public void addToCartProduct() {
		WebDriverWait wait =new WebDriverWait(driver,10);
		WebElement addToCart=wait.until(ExpectedConditions.visibilityOf (addToCartProduct));
		addToCartProduct.click();
	}
	
}





