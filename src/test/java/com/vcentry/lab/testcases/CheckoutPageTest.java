package com.vcentry.lab.testcases;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.vcentry.lab.initilizer.Initilizer;
import com.vcentry.lab.inputreader.InputReader;
import com.vcentry.lab.pages.HomePage;
import com.vcentry.lab.pages.LoginPage;
import com.vcentry.lab.pages.ProductPage;
import com.vcentry.lab.reportgenerator.ReportGenerator;


public class CheckoutPageTest extends Initilizer {
@BeforeMethod
public void setup() throws IOException {
	if(wd==null) {
		initilize();
	}
}

	@Test(dataProvider="CheckoutPageTest")
	public void validateCheckout(String header,String username,String password,String product,String mobile,String email,String cat,String qty,String purchaser) throws IOException {
		
		//step1 
		
		/*initilize();
		wd.get(envProp.getProperty("LOGIN_URL"));
		
		wd.findElement(By.name("username")).sendKeys("Sonia");
		wd.findElement(By.name("password")).sendKeys("Soniavivek@2502");
		wd.findElement(By.name("password")).submit();
		wd.get(envProp.getProperty("LAB_URL"));
		wd.findElement(By.id("element44")).click();
		wd.findElement(By.id("element45")).click();
		
		//Step2
				initilize();
				wd.get(envProp.getProperty("LOGIN_URL"));
				
				wd.findElement(By.name(locatorProp.getProperty("LOGINPAGE_TYPE_USENAME_NAME"))).sendKeys("Sonia");
				wd.findElement(By.name(locatorProp.getProperty("LOGINPAGE_TYPE_PASSWORD_NAME"))).sendKeys("Soniavivek@2502");
				wd.findElement(By.name(locatorProp.getProperty("LOGINPAGE_TYPE_PASSWORD_NAME"))).submit();
				wd.get(envProp.getProperty("LAB_URL"));
				wd.findElement(By.id(locatorProp.getProperty("HOMEPAGE_CLICK_FRAMEWORKFORM_ID"))).click();
				wd.findElement(By.id(locatorProp.getProperty("HOMEPAGE_CLICK_SIMPLEFORM_ID"))).click();
//step3
				initilize();
				wd.get(envProp.getProperty("LOGIN_URL"));
				
				DriverFunctionTest.getElementByName("LOGINPAGE_TYPE_USENAME_NAME").sendKeys("Sonia");
				DriverFunctionTest.getElementByName("LOGINPAGE_TYPE_PASSWORD_NAME").sendKeys("Soniavivek@2502");
				DriverFunctionTest.getElementByName("LOGINPAGE_TYPE_PASSWORD_NAME").submit();
				wd.get(envProp.getProperty("LAB_URL"));
				
				DriverFunctionTest.getElementById("HOMEPAGE_CLICK_FRAMEWORKFORM_ID").click();
				DriverFunctionTest.getElementById("HOMEPAGE_CLICK_SIMPLEFORM_ID").click();
				*/
				
//step 4
				
				
				
				
				
				
				//Login page
		System.err.println(header+  "initialized");
				wd.get(envProp.getProperty("LOGIN_URL"));
				LoginPage.enterUserName(username);
				LoginPage.enterPassword(password);
				LoginPage.clickLogin();
			// Home page
				wd.get(envProp.getProperty("LAB_URL"));
				HomePage.clickFrameworkForms();
				HomePage.clickSimpleForms();
				
				
				//Product page
				
				ProductPage.enterProductName(product);
				ProductPage.enterMobile(mobile);
				ProductPage.enterEmail(email);
				ProductPage.selectProdCat(cat);
				ProductPage.enterQty(qty);
				ProductPage.enterPurchaser(purchaser);
				ProductPage.clickGst();
				ProductPage.clickCod();
				ProductPage.clickPlaceOrder();

				System.err.println(header+ "completed");
				log=reports.startTest(header+"----completed");


			}
	
	@DataProvider(name="CheckoutPageTest")
	public static Object[][] getproductdata() throws FileNotFoundException, IOException {
		if(InputReader.getRunMode("CheckoutPageTest")) {
		Object[][] data=InputReader.selectSingleOrMultiRun("CheckoutPageTest");
		
		
		return data;
	}
		return null;
	}
	@AfterMethod
    public void teardown(ITestResult it) throws IOException{
   	 
   	 ReportGenerator.generateReport(it);
   	HomePage.logout();
	}
	
	
	}
	

	

	
