package demoAuto;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Log_In {
	public void UserSignIn(WebDriver driver, WebDriverWait myWaitVar){

		myWaitVar.until(ExpectedConditions.visibilityOfElementLocated(By.id("formHorizontalEmail")));
		WebElement userName = driver.findElement(By.id("formHorizontalEmail"));
		userName.sendKeys("admin@test.com");
		myWaitVar.until(ExpectedConditions.visibilityOfElementLocated(By.id("formHorizontalPassword")));
		WebElement password = driver.findElement(By.id("formHorizontalPassword"));
		password.sendKeys("test123");
		WebElement submitButton = driver.findElement(By.xpath("//a[contains(text(),'LOG IN')]"));
		submitButton.click();
	}

}
