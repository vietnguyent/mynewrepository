package demoAuto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SortingVerification {
	public boolean isFirstNameSortedDesc(WebDriver driver) {

		// Find all elements matching with xpath condition 
		List<WebElement> elementList = driver.findElements(By.xpath(StudentPageUI.FIRST_NAME_DATA_COLUMN));
		// Add element text into the arrayList
		ArrayList<String> arrayList = new ArrayList<>();		
		for (WebElement e : elementList) {
			arrayList.add(e.getText());
		}

		System.out.println("=====First Name displays in UI======");

		for (String name : arrayList) {
			System.out.println(name);
		}

		//Keep original sorted list in UI
		ArrayList<String> sortedList = new ArrayList<>();
		for (String s : arrayList) {
			sortedList.add(s);
		}

		// Sorting ASC
		Collections.sort(arrayList);

		System.out.println("====First Name sorted by ASC====");
		for (String name : arrayList) {
			System.out.println(name);
		}

		// Reverse sort DESC
		Collections.reverse(arrayList);

		System.out.println("====First Name sorted by DESC====");
		for (String name : arrayList) {
			System.out.println(name);
		}

		// Compare 2 array

		return sortedList.equals(arrayList);
	}
	
	public boolean isFirstNameSortedASC(WebDriver driver) {

		// Find all elements matching with xpath condition 
		List<WebElement> elementList = driver.findElements(By.xpath(StudentPageUI.FIRST_NAME_DATA_COLUMN));
		// Add element text into the arrayList
		ArrayList<String> arrayList = new ArrayList<>();		
		for (WebElement e : elementList) {
			arrayList.add(e.getText());
		}

		System.out.println("=====First Name displays in UI======");

		for (String name : arrayList) {
			System.out.println(name);
		}

		// Keep original sorted list in UI
		ArrayList<String> sortedList = new ArrayList<>();
		for (String s : arrayList) {
			sortedList.add(s);
		}

		// Sorting ASC
		Collections.sort(arrayList);

		System.out.println("====First Name sorted by ASC====");
		for (String name : arrayList) {
			System.out.println(name);
		}

		/* Reverse sort DESC
		Collections.reverse(arrayList);

		System.out.println("====First Name sorted by DESC====");
		for (String name : arrayList) {
			System.out.println(name);
		}*/

		// Compare 2 array
		return sortedList.equals(arrayList);
	}
}

