package SmokeTestCases;

import org.testng.annotations.Test;

import SmokeTestPages.FindUsedCarsSubMenu;
import SmokeTestPages.SignInButton;
import SmokeTestPages.UpcomingBikesSubMenu;

public class SmokeTest {

	@Test(priority=1)
	public void signInButtonTest(){
		SignInButton button = new SignInButton();
		button.clickSignIn();
		System.out.println("Sign In Button functionality passed");
	}
	
	@Test(priority=2)
	public void upcomingSubMenuTest(){
		
		UpcomingBikesSubMenu subMenu = new UpcomingBikesSubMenu();
		subMenu.upcomingSubMenu();
		System.out.println("Upcoming Bikes submenu test passed");
	}
	
	@Test(priority=3)
	public void findUsedCarsSubMenu(){
		
		FindUsedCarsSubMenu subMenu = new FindUsedCarsSubMenu();
		subMenu.findUsedCarsSubMenu();
		System.out.println("Find Used Cars submenu test passed");
	}
	
}
