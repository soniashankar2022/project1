package com.vcentry.lab.pages;

import com.vcentry.lab.initilizer.DriverFunction;

public class LoginPage {
	
public static void enterUserName(String data) {
	DriverFunction.getElementByName("LOGINPAGE_TYPE_USENAME_NAME").sendKeys(data);

}

public static void enterPassword(String data) {
	DriverFunction.getElementByName("LOGINPAGE_TYPE_PASSWORD_NAME").sendKeys(data);

}

public static void clickLogin() {
	DriverFunction.getElementByName("LOGINPAGE_TYPE_PASSWORD_NAME").submit();

}
}