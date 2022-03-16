package com.vcentry.lab.initilizer;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.vcentry.lab.utils.optimizer;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Initilizer {
	/**
	 * @author e11
	 * @date 2nd feb 2022
	 * @purpose initilize wedriver variables
	 * 
	 */
	public static WebDriver wd=null;
	
	/**
	 * @author e11
	 * @date 7th feb 2022
	 * @purpose initialize  report variables
	 */
	public static ExtentReports reports;
	public static ExtentTest log;
	public static boolean isReport=true;
	
	
	/**
	 * @author e11
	 * @date 2nd feb 2022
	 * @purpose initilize env variables
	 * 
	 */
	
	public static FileInputStream envFis=null;
	public static Properties envProp=null;
	
	/**
	 * @author e11
	 * @date 3rd feb 2022
	 * @purpose initilize locator variables
	 * 
	 */
	public static FileInputStream locatorFis=null;
	public static Properties locatorProp=null;
	
	
	/**
	 * @author e11
	 * @date 2nd feb 2022
	 * @purpose initilizer webdrivrer, report, env, locator
	 * @throws IOException
	 */
	
	public static void initilize() throws IOException {
		
		if(isReport) {
		reports=new ExtentReports("report/index.html");
		optimizer.optimize();
		isReport=false;
		}
		
		 envFis=new FileInputStream(new File("src/test/resources/com/vcentry/lab/config/env.properties"));
		 envProp=new Properties();
		 envProp.load(envFis);
		 
		 locatorFis=new FileInputStream(new File("src/test/resources/com/vcentry/lab/config/locator.properties"));
		 locatorProp=new Properties();
		 locatorProp.load(locatorFis);
		 
		
		 
				 if(envProp.getProperty("BROWSER").equals("chrome")) {
					 WebDriverManager.chromedriver().setup();
					  wd=new ChromeDriver();
				 } else  if(envProp.getProperty("BROWSER").equals("firefox")) {
					 WebDriverManager.firefoxdriver().setup();
					  wd=new FirefoxDriver();
				 }else  if(envProp.getProperty("BROWSER").equals("safari")) {
					 WebDriverManager.safaridriver().setup();
					  wd=new SafariDriver();
				 }
				 
		 
		 
		 wd.manage().window().maximize();
		 wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 wd.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	}
	

}
