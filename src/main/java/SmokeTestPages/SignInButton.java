package SmokeTestPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Common.DriverSetup;
import Common.SelectBrowser;

public class SignInButton {

	WebDriver driver;

	
	public void clickSignIn(){
		String browser = SelectBrowser.selectBrowser();
		driver = DriverSetup.driverInstantiate(browser);
		driver.findElement(By.id("des_lIcon")).click();
	}
}
