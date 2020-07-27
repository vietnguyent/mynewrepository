package demoAuto;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Student_TestCases {
	WebDriver driver;
	WebDriverWait myWaitVar;
	String baseURL = "http://ktvn-test.s3-website.us-east-1.amazonaws.com/";
	@BeforeTest
	public void startLogin() throws InterruptedException{
		System.setProperty("webdriver.gecko.driver", "E:/Selenium/geckodriver-v0.24.0-win64/geckodriver.exe");
		driver = new FirefoxDriver();
		myWaitVar = new WebDriverWait(driver, 10);
		driver.get(baseURL);	
		driver.manage().window().maximize();
		Thread.sleep(5000);//wait for 5 sec to view the maximize browser
		Log_In logIn = new Log_In();
		logIn.UserSignIn(driver, myWaitVar);	  
	}	
	//Verify filter Student Access Request with INACTIVE
	@Test
	public void TC1(){
		System.out.println("************TC1 verification*************");
		//Open filters page
		myWaitVar.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(StudentPageUI.FILTER_BUTTON)));
		WebElement filterButton = driver.findElement(By.xpath(StudentPageUI.FILTER_BUTTON));
		filterButton.click();
		//Select Request status as Inactive
		myWaitVar.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(StudentPageUI.REQUEST_STATUS_DROPDOWN)));
		WebElement requestStatus = driver.findElement(By.xpath(StudentPageUI.REQUEST_STATUS_DROPDOWN));
		requestStatus.click();
		Select status = new Select(requestStatus);
		status.selectByVisibleText("Inactive");
		// Apply filter
		WebElement applyButton = driver.findElement(By.xpath(StudentPageUI.APPLY_FILTER_BUTTON));
		applyButton.click();

		//Verify request list with Inactive status
		RequestStatus element = new RequestStatus();
		if(element.isInactiveDisplayed(driver)){
			System.out.println("TC1_PASSED");
		}
		else {

			System.out.println("TC1_FAILED");}


	}
	//Verify sorting of First Name column
	@Test
	public void TC2(){
		System.out.println("************TC2A verification*************");
		//Click first name column
		myWaitVar.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(StudentPageUI.FIRST_NAME_HEADER_COLUMN)));
		WebElement firstName = driver.findElement(By.xpath(StudentPageUI.FIRST_NAME_HEADER_COLUMN));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", firstName);
		//firstName.click();
		// Verify data are sorted by DESC accordingly
		SortingVerification element = new SortingVerification();
		if(element.isFirstNameSortedDesc(driver)){
			System.out.println("TC2A_PASSED");
		}
		else {

			System.out.println("TC2A_FAILED");}
		System.out.println("************TC2B verification*************");
		//Click first name column
		myWaitVar.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(StudentPageUI.FIRST_NAME_HEADER_COLUMN)));
		WebElement firstName1 = driver.findElement(By.xpath(StudentPageUI.FIRST_NAME_HEADER_COLUMN));
		JavascriptExecutor executor1 = (JavascriptExecutor)driver;
		executor1.executeScript("arguments[0].click();", firstName1);
		//firstName.click();
		// Verify data are sorted by ASC accordingly
		SortingVerification element1 = new SortingVerification();
		if(element1.isFirstNameSortedASC(driver)){
			System.out.println("TC2B_PASSED");
		}
		else {

			System.out.println("TC2B_FAILED");}

	}
	@AfterTest
	public void terminateBrowser(){
		driver.quit();
	}
}
