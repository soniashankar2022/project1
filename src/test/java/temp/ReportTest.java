package temp;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.vcentry.lab.pages.HomePage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ReportTest {
	
	public static ExtentReports reports;
	public static ExtentTest log;
	
	
	
	public static  WebDriver wd;
	
	@Test(priority=1)
	public void validateGoogle(){
		
		reports=new ExtentReports("report/index.html");
		
		WebDriverManager.chromedriver().setup();
		wd=new ChromeDriver();
		wd.get("https://www.google.co.in/");
		log=reports.startTest("validateGoogle----completed");
		
	}
	
	@Test(priority=2)
	public void validateBing(){
		
		wd.get("https://www.bing.com");
		log=reports.startTest("validateBing----completed");
		
	}

	
	@Test(priority=3)
	public void validateYahoo(){
		
		wd.get("https://in.yahoo.com/");
		log=reports.startTest("validateYahoo----completed");
		
	}
	

     @AfterMethod
     public void teardown(ITestResult it) throws IOException{
    	 
    	 if(it.isSuccess())
    	 {
    	 String path=takeScreenshot(it.getName());
    	 
    	 log.log(LogStatus.PASS, it.getName()+" test case pass", log.addScreenCapture(path));
    	 }
    	 else 
    	 {
        	 String path=takeScreenshot(it.getName());
        	 log.log(LogStatus.FAIL, it.getName()+ " testcase failed", log.addScreenCapture(path));
          }
    	 reports.endTest(log);
    	 reports.flush();
    	 HomePage.logout();
     }
	
     
     
     
	public static String takeScreenshot(String name) throws IOException{
		File src=((TakesScreenshot)wd).getScreenshotAs(OutputType.FILE);
		File dst=new File("C:\\daily practise  java Vcentry\\G1_ddTest\\screenshot/"+name+"png");
		FileHandler.copy(src, dst);
		System.out.println(dst.toString());
		return dst.toString();	
	}
}
