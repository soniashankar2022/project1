package com.vcentry.lab.initilizer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DriverFunction extends Initilizer {

	public static WebElement getElementByName(String name) {
		try {
			return wd.findElement(By.name(locatorProp.getProperty(name)));

		} catch (Exception e) {
			System.out.println("Failed to find element by name -" + e.getMessage());

		}
		return null;

	}

	public static WebElement getElementById(String id) {
		try {
			return wd.findElement(By.id(locatorProp.getProperty(id)));

		} catch (Exception e) {
			System.out.println("Failed to find element by name -" + e.getMessage());

		}
		return null;

	}

	public static WebElement getElementByXpath(String xpath) {
		try {
			return wd.findElement(By.xpath(locatorProp.getProperty(xpath)));

		} catch (Exception e) {
			System.out.println("Failed to find element by name -" + e.getMessage());

		}
		return null;

	}

	public static WebElement getElementByCssSelector(String css) {
		try {
			return wd.findElement(By.cssSelector(locatorProp.getProperty(css)));

		} catch (Exception e) {
			System.out.println("Failed to find element by name -" + e.getMessage());

		}
		return null;

	}

	public static WebElement getElementByLinkText(String link) {
		try {
			return wd.findElement(By.linkText(locatorProp.getProperty(link)));

		} catch (Exception e) {
			System.out.println("Failed to find element by name -" + e.getMessage());

		}
		return null;

	}

	public static WebElement getElementByPartialLinkText(String partiallink) {
		try {
			return wd.findElement(By.partialLinkText(locatorProp.getProperty(partiallink)));

		} catch (Exception e) {
			System.out.println("Failed to find element by name -" + e.getMessage());

		}
		return null;

	}

	public static WebElement getElementByClassName(String cname) {
		try {
			return wd.findElement(By.className(locatorProp.getProperty(cname)));

		} catch (Exception e) {
			System.out.println("Failed to find element by name -" + e.getMessage());

		}
		return null;

	}

	public static void mySelectByVisibleText(WebElement dropdown, String data) {
		try {
			Select s = new Select(dropdown);
			s.selectByVisibleText(data);
		} catch (Exception e) {
			System.out.println(" mySelectByVisibleText failed - " + e.getMessage());
		}
	}

	public static void mySelectByValue(WebElement dropdown, String data) {
		
		try {
		Select s = new Select(dropdown);
		s.selectByValue(data);
		}catch (Exception e) {
			System.out.println(" mySelectByVisibleText failed - " + e.getMessage());
		}
	}

	public static void mySelectByIndex(WebElement dropdown, int data) {
		try {
		Select s = new Select(dropdown);
		s.selectByIndex(data);
		}catch (Exception e) {
			System.out.println(" mySelectByVisibleText failed - " + e.getMessage());
		}
	}

}