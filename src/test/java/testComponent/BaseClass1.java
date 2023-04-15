package testComponent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageObject.LoginPage;

public class BaseClass1 {
	public LoginPage lp;
	public WebDriver driver= null;
	public WebDriver initialization()
	{
		
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		return driver;
		
	}
	
	@BeforeMethod(alwaysRun = true)
	public void lunchApp()
	{
		driver=initialization();
		lp=new LoginPage(driver);
		lp.getLandingPage();
	}
	@AfterMethod(alwaysRun = true)
	public void tearDown()
	{
		driver.quit();
	}


}
