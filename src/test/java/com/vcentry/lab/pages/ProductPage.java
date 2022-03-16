package com.vcentry.lab.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.vcentry.lab.initilizer.DriverFunction;


public class ProductPage {

	public static void enterProductName(String data) {
		DriverFunction.getElementById("PRODUCT_TYPE_PRODUCTNAME_ID").sendKeys(data);
	}

	public static void enterMobile(String data) {
		DriverFunction.getElementById("PRODUCT_TYPE_MOBILE_ID").sendKeys(data);

	}

	public static void enterEmail(String data) {
		DriverFunction.getElementById("PRODUCT_TYPE_EMAIL_ID").sendKeys(data);

	}

	public static void selectProdCat(String data) {
		
	
		WebElement dropdown= DriverFunction.getElementById("PRODUCT_SELECT_PRODCAT_ID");
//		Select s=new Select(dropdown);
//		s.selectByVisibleText(data);
		
		DriverFunction.mySelectByVisibleText(dropdown, data);
		
	}

	public static void enterQty(String data) {
		DriverFunction.getElementById("PRODUCT_TYPE_QTY_ID").sendKeys(data);

	}

	public static void enterPurchaser(String data) {
		DriverFunction.getElementById("PRODUCT_TYPE_PURCHASER_ID").sendKeys(data);

	}

	public static void clickGst() {
		DriverFunction.getElementById("PRODUCT_CLICK_GST_ID").click();

	}

	public static void clickCod() {
		DriverFunction.getElementById("PRODUCT_CLICK_COD_ID").click();

	}

	public static void clickPlaceOrder() {
		DriverFunction.getElementById("PRODUCT_CLICK_PLACEORDER_ID").click();

	}
}
