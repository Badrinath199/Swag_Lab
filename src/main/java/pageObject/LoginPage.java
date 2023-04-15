package pageObject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import abstractCompenent.AbstractCompenet;

public class LoginPage extends AbstractCompenet{
	WebDriver driver;

	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);	
	}
	@FindBy(xpath = "//input[@placeholder = 'Username']")
	WebElement username;
	
	@FindBy(xpath = "//input[@placeholder = 'Password']")
	WebElement password;
	
	@FindBy(css = "input[type = 'submit']")
	WebElement submit;
	
	
	public void getLandingPage() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
	}
	
	public void loginApplication(String userna, String pass)
	{
		username.sendKeys(userna);
		password.sendKeys(pass);
		submit.click();
		HomePage homepage= new HomePage(driver);
		homepage.selectcatogery();
	}

}
