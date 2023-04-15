package Swag_Lab.Swag_Lab;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v109.network.model.Initiator;
import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StandAlone {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@placeholder = 'Username']")).sendKeys("standard_user");
		driver.findElement(By.xpath("//input[@placeholder = 'Password']")).sendKeys("secret_sauce");
		driver.findElement(By.cssSelector("input[type = 'submit']")).click();
		Select st = new Select(driver.findElement(By.xpath("//select[@class='product_sort_container']")));
		// st.selectByIndex(2);
		// st.selectByValue('Name (Z to A)');
		st.selectByVisibleText("Name (Z to A)");
		WebElement text = driver
				.findElement(By.xpath("//a[@id= 'item_2_title_link']//div[@class = 'inventory_item_name']"));
		System.out.println(text.getText());
		driver.findElement(By.xpath("//button[@id='add-to-cart-test.allthethings()-t-shirt-(red)']")).click();
		driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-onesie']")).click();
		driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-bolt-t-shirt']")).click();
		driver.findElement(By.className("shopping_cart_link")).click();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)", "");

		Actions ac = new Actions(driver);
		WebElement ad= driver.findElement(By.xpath("//li[@class = 'social_linkedin']"));
		ac.moveToElement(ad).click().perform();
		
		Set<String> web = driver.getWindowHandles();
		for (String g:web)
		{
		System.out.println(g);
		}
		Iterator<String> it = web.iterator();
		while (it.hasNext())
		{
			String child= it.next();
			System.out.println(child);
			
		}
		
	
		driver.close();
		

	}

}
