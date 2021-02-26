package SmokeTestPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import Common.DriverSetup;
import Common.SelectBrowser;

public class UpcomingBikesSubMenu {

	WebDriver driver;

	public void upcomingSubMenu() {
		String browser = SelectBrowser.selectBrowser();
		driver = DriverSetup.driverInstantiate(browser);
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//a[contains(text(),'New Bikes')]"))).perform();
		driver.findElement(By.xpath("//span[contains(text(),'Upcoming Bikes')]")).click();
	}
}
