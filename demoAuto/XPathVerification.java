package demoAuto;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class XPathVerification {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.gecko.driver", "E:/Selenium/geckodriver-v0.24.0-win64/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
		String baseUrl = "http://ktvn-test.s3-website.us-east-1.amazonaws.com/";
		//Launching the page	
		driver.get(baseUrl);
		//Login
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[1]/div[2]/form/div[3]/div[2]/a")).click();// this is a error when user does not need to enter user name and password
		//locating the list elements with Request Status = Approved && Date Submitted = 2019 and get the student ID records
		List<WebElement> xPathElements = driver.findElements(By.xpath("//tr//td//div//p[text()=\"Approved\"]//../../..//td//div[contains(text(), \"2019\")]//..//..//td[position()=5]"));
		System.out.println("Total row: " + xPathElements.size());
		for (WebElement e : xPathElements) {
			System.out.println("StudentId: " + e.getText());

		}



	}
}


