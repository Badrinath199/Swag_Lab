package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractCompenent.AbstractCompenet;


public class AddtoCartPage extends AbstractCompenet {
	WebDriver driver;
	public AddtoCartPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath ="//button[@id='checkout']")
	WebElement checkout;
	
	public void checkOut()
	{
		
		checkout.click(); 
	}
	

}
