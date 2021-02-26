package RegressionTestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
//import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
//import org.testng.annotations.AfterTest;
//import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.BeforeSuite;
//import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
//import Common.SelectBrowser;
import Common.Wait;
import GoogleSignIn.GoogleSignIn;
import UpcomingBikes.UpcomingBikes;
import UsedCars.UsedCars;
import UtilityFiles.CaptureScreenshot;
import UtilityFiles.ReadFromExcel;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBaseReg {

	public static WebDriver driver = null;
	public String filePath = null;
	public static String browser = null;
	public static ExtentHtmlReporter reporter = new ExtentHtmlReporter(
			System.getProperty("user.dir") + "/ExtentReport/extentReportFile.html");
	public static ExtentReports extent = new ExtentReports();

	/*@BeforeSuite
	public void initBrowser() {
		// Selecting the browser for test
		browser = SelectBrowser.selectBrowser();
	}*/

	@BeforeMethod
	public void initializeTest() throws Exception {

		browser = "chrome";
		// Launching the browser according to user's choice
		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}

		Wait wait = new Wait();
		extent.attachReporter(reporter);
		ExtentTest logger = extent.createTest("Driver Test");
		logger.log(Status.INFO, "Browser launched");

		// To maximize the window
		driver.manage().window().maximize();
		wait.waitImplicit(driver);

		// To go to the webpage
		driver.get("https://www.zigwheels.com/");
		logger.log(Status.INFO, "Navigated to https://www.zigwheels.com/");

		// For capturing the screenshot
		filePath = System.getProperty("user.dir") + "/Screenshots/HomePage.png";
		CaptureScreenshot.captureTestScreenshot(driver, filePath);
		logger.log(Status.INFO, "Homepage Snapshot: ");
		logger.addScreenCaptureFromPath(filePath);

	}

	@AfterMethod
	public void closeDriver() {
		// Close the driver
		driver.close();
	}

	@AfterSuite
	public void exitDriver() {
		// Quit the driver
		driver.quit();
	}
	
	@Test(priority=1)
	public void testUpcomingBike() throws Exception {

		// Reading data from Excel file
		String manufacturerName = ReadFromExcel.readFromExcel(1, 0);
		UpcomingBikes bike = PageFactory.initElements(driver, UpcomingBikes.class);
		// Calling the newBikesMenu function
		bike.newBikesMenu();
		extent.attachReporter(reporter);
		ExtentTest logger = extent.createTest("Upcoming Bikes Test");
		logger.log(Status.INFO, "Mouse Hover on 'New Bikes'");

		// Calling the selectUpcomingBike function
		bike.selectUpcomingBike();
		logger.log(Status.INFO, "Upcoming Bikes submenu is selected");

		// Calling the selectManufacturer function
		bike.selectManufacturer(manufacturerName);
		logger.log(Status.INFO, "Manufacturer name is selected as 'Honda'");

		// Calling the viewMoreBikes function
		bike.viewMoreBikes();
		logger.log(Status.INFO, "View More button is clicked");

		// Calling the bikeModels function
		bike.bikeModels();
		logger.log(Status.INFO, "Upcoming Bikes under 4 lac is displayed on console and stored in Excel");

		logger.log(Status.PASS, "Upcoming Bikes test is passed");

		// writing everything to document.
		extent.flush();
	}
	
	@Test(priority=2)
	public void testUsedCars() throws Exception {

		UsedCars cars = PageFactory.initElements(driver, UsedCars.class);

		// Calling the usedCarsMenu function
		cars.usedCarsMenu();
		extent.attachReporter(reporter);
		ExtentTest logger = extent.createTest("Used Cars in Chennai Test");
		logger.log(Status.INFO, "Mouse Hover on 'Used Cars'");

		// Calling the selectFindUsedCars function
		cars.selectFindUsedCars();
		logger.log(Status.INFO, "Find Used Cars submenu is selected");

		// Calling the selectChennaiCity function
		cars.selectChennaiCity();
		logger.log(Status.INFO, "Chennai is selected as Location");

		// Calling the selectFirstModel function
		cars.selectFirstModel();
		logger.log(Status.INFO, "Hyundai i10 model is selected");

		// Calling the printFirstModelList function
		cars.printFirstModelList();
		logger.log(Status.INFO, "All Hyundai i10 cars are displayed on console and stored in excel");

		// Calling the selectSecondModel function
		cars.selectSecondModel();
		logger.log(Status.INFO, "Hyundai Santro model is selected");

		// Calling the printSecondModelList function
		cars.printSecondModelList();
		logger.log(Status.INFO, "All Hyundai Santro cars are displayed on console and stored in excel");

		// Calling the selectThirdModel function
		cars.selectThirdModel();
		logger.log(Status.INFO, "Mahindra XUV model is selected");

		// Calling the printThirdModelList function
		cars.printThirdModelList();
		logger.log(Status.INFO, "All Mahindra XUV cars are displayed on console and stored in excel");

		// Calling the selectForthModel function
		cars.selectForthModel();
		logger.log(Status.INFO, "Toyota Fortuner model is selected");

		// Calling the printForthModelList function
		cars.printForthModelList();
		logger.log(Status.INFO, "All Toyota Fortuner cars are displayed on console and stored in excel");

		// Calling the selectFifthModel function
		cars.selectFifthModel();
		logger.log(Status.INFO, "Toyota Innova model is selected");

		// Calling the printFifthModelList function
		cars.printFifthModelList();
		logger.log(Status.INFO, "All Toyota Innova cars are displayed on console and stored in excel");

		logger.log(Status.PASS, "Used cars in chennai test is passed");

		// writing everything to document.
		extent.flush();
	}
	
	@Test(priority=3)
	public void testGoogleSignIn() throws Exception {

		// Reading data from excel
		String emailId = ReadFromExcel.readFromExcel(0, 0);
		GoogleSignIn signInTest = PageFactory.initElements(driver, GoogleSignIn.class);

		// Calling the clickSignIn function
		signInTest.clickSignIn();
		extent.attachReporter(reporter);
		ExtentTest logger = extent.createTest("Google Sign In Test");
		logger.log(Status.INFO, "Sign In button is clicked");

		// Calling the googleSignIn function
		signInTest.googleSignIn();
		logger.log(Status.INFO, "Continue with Google button is clicked");

		// Calling the emailInput function
		signInTest.emailInput(emailId);
		logger.log(Status.INFO, "An invalid email id is entered into Email field");

		// Calling the emailNext function
		signInTest.emailNext();
		logger.log(Status.INFO, "Next button is clicked after entering the invalid email id");

		// Calling the getErrorMessage function
		signInTest.getErrorMessage();
		logger.log(Status.INFO,
				"Error message is captured successfully and stored in excel as well as displayed on console");

		logger.log(Status.PASS, "Google Sign In test is passed");

		// writing everything to document.
		extent.flush();
	}

}
