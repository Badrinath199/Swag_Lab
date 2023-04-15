package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import abstractCompenent.AbstractCompenet;


public class HomePage extends AbstractCompenet{
	WebDriver driver;
	public HomePage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//select[@class='product_sort_container']")
	WebElement select;
	
	@FindBy(xpath = "//button[@id='add-to-cart-test.allthethings()-t-shirt-(red)']")
	WebElement first;
	
	@FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-onesie']")
	WebElement sec;
	
	@FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-bolt-t-shirt']")
	WebElement thrid;
	
	@FindBy(className = "shopping_cart_link")
	WebElement addcartt;
	
	public void selectcatogery()
	{
		Select st = new Select(select);
		// st.selectByIndex(2);
		// st.selectByValue('Name (Z to A)');
		st.selectByVisibleText("Name (Z to A)");
	}
	
	public void goToCart()
	{
		selectcatogery();
		first.click();
		sec.click();
		thrid.click();
		
	}
	
	public void addCart()
	{
		goToCart();
		addcartt.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)", "");
		AddtoCartPage addcart = new AddtoCartPage(driver);
		addcart.checkOut();
	}

}
