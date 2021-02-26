package SmokeTestPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import Common.DriverSetup;
import Common.SelectBrowser;

public class FindUsedCarsSubMenu {

	WebDriver driver;

	public void findUsedCarsSubMenu() {
		String browser = SelectBrowser.selectBrowser();
		driver = DriverSetup.driverInstantiate(browser);
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.linkText("Used Cars"))).perform();
		driver.findElement(By.xpath("//span[contains(text(),'Find Used Cars')]")).click();
	}
	
}
