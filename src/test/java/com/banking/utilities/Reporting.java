package com.banking.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.compress.harmony.pack200.NewAttribute;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reporting extends TestListenerAdapter {

	public ExtentSparkReporter sparkReporter;  // UI of the report
	public ExtentReports extent;  //populate common info on the report
	public ExtentTest test; // creating test case entries in the report and update status of the test methods

	public void onStart(ITestContext context) {
			
		String timeStamp = new SimpleDateFormat("dd.MM.yyyy.HH.mm.ss").format(new Date()); 	//teme stamp
		String repName = "Test-Report"+timeStamp+".html";
		sparkReporter= new ExtentSparkReporter(System.getProperty("user.dir")+ "/Reports/"+repName);//specify location of the report
		
		/*
		try {
			sparkReporter.loadXMLConfig(System.getProperty("user.dir")+"/extentreport.xml");
		} catch (IOException e) {
			e.printStackTrace();
		}
		*/
		
		sparkReporter.config().setDocumentTitle("Guru99 Banking Test Project"); // Title of report
		sparkReporter.config().setReportName("Functional Test Report"); // Name of the report
		sparkReporter.config().setTheme(Theme.DARK);
		
		extent=new ExtentReports();
		extent.attachReporter(sparkReporter);
		
		extent.setSystemInfo("Computer Name","localhost");
		extent.setSystemInfo("Environment","QA");
		extent.setSystemInfo("Tester Name","Shekhar");
		extent.setSystemInfo("os","Windows10");
		extent.setSystemInfo("Browser name","Chrome,Firefox,Edge");
					
	}


	public void onTestSuccess(ITestResult result) {
		
		test = extent.createTest(result.getName()); // create a new entry in the report
		test.log(Status.PASS, "Test case PASSED is:" + result.getName()); // update status p/f/s
		test.log(Status.PASS,MarkupHelper.createLabel(result.getName(), ExtentColor.GREEN)); 
	}

	public void onTestFailure(ITestResult result) {
		
		test = extent.createTest(result.getName());
		test.log(Status.FAIL, "Test case FAILED is:" + result.getName());
		test.log(Status.FAIL, "Test Case FAILED cause is: " + result.getThrowable()); 
		test.log(Status.FAIL,MarkupHelper.createLabel(result.getName(), ExtentColor.RED));
		
		String screenshotpath = System.getProperty("user.dir")+"\\Screenshots\\"+result.getName()+".png";
		
		File f = new File(screenshotpath);
		
		if(f.exists()) {
			try {
				test.fail("screenshot is below: "+test.addScreenCaptureFromPath(screenshotpath));
			} catch (Exception e) {
			}
		}
	}

	public void onTestSkipped(ITestResult result) {

		test = extent.createTest(result.getName());
		test.log(Status.SKIP, "Test case SKIPPED is:" + result.getName());
		test.log(Status.SKIP,MarkupHelper.createLabel(result.getName(), ExtentColor.ORANGE));
		
	}

	
	public void onFinish(ITestContext context) {
		
		extent.flush();
	}

	
	
	
	
	
}
