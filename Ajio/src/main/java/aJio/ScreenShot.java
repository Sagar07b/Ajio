package aJio;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.PageFactory;

public class ScreenShot {

	private WebDriver driver;
	
	 
	
	SimpleDateFormat format=new SimpleDateFormat("MM-dd-yyyy_hh-mm-ss");
	Date date=new Date();
	String dm= format.format(date);
	
	public ScreenShot(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver =driver;
	}
	
	public void takeScreenShot() throws IOException {
		TakesScreenshot take=(TakesScreenshot)driver;
		File src=take.getScreenshotAs(OutputType.FILE);
		File dest=new File("D:\\Software Testing\\Screenshot\\Test"+dm+".jpg");
		FileHandler.copy(src, dest);
	}
	
	
	
	
	
	
	
	
	
}
