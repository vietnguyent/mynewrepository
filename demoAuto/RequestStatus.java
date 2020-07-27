package demoAuto;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RequestStatus {
	public boolean isInactiveDisplayed(WebDriver driver) {
		boolean flag = true;
		String expectedText = "Inactive";
		List<WebElement> elements = driver.findElements(By.xpath(StudentPageUI.REQUEST_STATUS_COLUMN));
		for (WebElement element : elements) {
			
			if (element.getText().equals(expectedText)) {
				flag = true;
			} else {
				flag = false;
				break;
			}
		}
		return flag;
	}
}
