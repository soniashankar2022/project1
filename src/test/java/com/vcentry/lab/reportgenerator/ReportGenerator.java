package com.vcentry.lab.reportgenerator;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.LogStatus;
import com.vcentry.lab.initilizer.Initilizer;


public class ReportGenerator extends Initilizer  {

	public static void generateReport(ITestResult it) throws IOException {
	
		 if(it.isSuccess())
    	 {
    	 String path=takeScreenshot(it.getParameters()[0].toString());
    	 
    	 log.log(LogStatus.PASS, it.getName()+" test case pass", log.addScreenCapture(path));
    	 }
    	 else 
    	 {
        	 String path=takeScreenshot(it.getParameters()[0].toString());
        	 log.log(LogStatus.FAIL, it.getName()+ " testcase failed", log.addScreenCapture(path));
          }
    	 reports.endTest(log);
    	 reports.flush();
	}
	
	public static String takeScreenshot(String name) throws IOException{
		File src=((TakesScreenshot)wd).getScreenshotAs(OutputType.FILE);
		File dst=new File("/C:\\daily practise  java Vcentry\\G1_ddTest\\screenshot/"+name+".png");
		FileHandler.copy(src, dst);
		System.out.println(dst.toString());
		return dst.toString();	
	}
}
