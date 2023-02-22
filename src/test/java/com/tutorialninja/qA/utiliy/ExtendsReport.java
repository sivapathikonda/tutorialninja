package com.tutorialninja.qA.utiliy;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtendsReport {
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest logger;
	
      public static void GenerateExtendReport() {
    	 
    	 String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());//time stamp
			String repName="Test-Report-"+timeStamp+".html";
			
			htmlReporter=new ExtentHtmlReporter(System.getProperty("user.dir")+ "/test-output/"+repName);//specify location of the report
			htmlReporter.loadXMLConfig(System.getProperty("user.dir")+ "/extent-report.xml");
			
			extent=new ExtentReports();
			
			extent.attachReporter(htmlReporter);
			extent.setSystemInfo("Host name","localhost");
			extent.setSystemInfo("Environemnt","DEV");
			extent.setSystemInfo("user","SivaKumar.P");
			
			htmlReporter.config().setDocumentTitle("Banking Test Project"); // Tile of report
			htmlReporter.config().setReportName("Banking Test Automation Report"); // name of the report
			htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP); //location of the chart
			htmlReporter.config().setTheme(Theme.STANDARD);
		
		
		
 	
		
		
 	 
 	 
 	 
	  
    
    
    		
    
			
    	
      }
}
