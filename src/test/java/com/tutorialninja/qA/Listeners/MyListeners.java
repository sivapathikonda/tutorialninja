package com.tutorialninja.qA.Listeners;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class MyListeners implements ITestListener{
	
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest logger;
	public void onStart(ITestContext context) {
		
		
		extent=new ExtentReports();
		File ExtentReportFile=new File(System.getProperty("user.dir")+"\\test-output\\extend-report.html");
		ExtentHtmlReporter htmlReporter=new ExtentHtmlReporter(ExtentReportFile);
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host name","localhost");
		extent.setSystemInfo("Environemnt","DEV");
		extent.setSystemInfo("user","aradhya");
		
		htmlReporter.config().setDocumentTitle("Banking Test Project"); // Tile of report
		htmlReporter.config().setReportName("Banking Test Automation Report"); // name of the report
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP); //location of the chart
		htmlReporter.config().setTheme(Theme.STANDARD);
		
	}
		
	public void onTestSuccess(ITestResult result) {
		logger=extent.createTest(result.getName());
		logger.log(Status.PASS, MarkupHelper.createLabel(result.getName(), ExtentColor.GREEN));
		
		 
	}

	public void onTestFailure(ITestResult result)  {
		logger=extent.createTest(result.getName()); 
		logger.log(Status.FAIL,MarkupHelper.createLabel(result.getName(),ExtentColor.RED)); 
	
		
		WebDriver driver=null;
		try {
			driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (IllegalArgumentException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (NoSuchFieldException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SecurityException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir")+"\\Screenshot\\"+result.getName() +".png";
		
	    try {
			FileUtils.copyFile(source, new File(destination));
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	    
	
	try {
		logger.addScreenCaptureFromPath(destination);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
		
	
	
}
	

	public void onTestSkipped(ITestResult result) {
		
			logger=extent.createTest(result.getName());
			logger.log(Status.SKIP,MarkupHelper.createLabel(result.getName(),ExtentColor.BLUE));
		
		
	}
	
	public void onFinish(ITestContext context) {
		extent.flush();
		String PathOfExtentReport=System.getProperty("user.dir")+"\\test-output\\extent-report.xml";
		File extentReport=new File(PathOfExtentReport);
		try {
			Desktop.getDesktop().browse(extentReport.toURI());
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}

	

	

}
