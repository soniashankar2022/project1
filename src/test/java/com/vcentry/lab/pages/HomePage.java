package com.vcentry.lab.pages;

import com.vcentry.lab.initilizer.DriverFunction;


public class HomePage {



	public static void clickFrameworkForms() {
		DriverFunction.getElementById("HOMEPAGE_CLICK_FRAMEWORKFORM_ID").click();

	}

	public static void clickSimpleForms() {
		DriverFunction.getElementById("HOMEPAGE_CLICK_SIMPLEFORM_ID").click();

	}
	
	public static void logout() {
		DriverFunction.getElementByLinkText("HOMEPAGE_CLICK_LOGOUT_LINKTXT").click();

	}
}
