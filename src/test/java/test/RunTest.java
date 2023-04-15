package test;

import org.testng.annotations.Test;

import pageObject.HomePage;
import testComponent.BaseClass1;


public class RunTest extends BaseClass1{
	public String username="standard_user";
	public String password="secret_sauce";

	@Test
	public void run()
	{
		lp.loginApplication(username, password);
		HomePage hp= new HomePage(driver);
		hp.addCart();
	}

}
