package com.tutorialninja.qA.utiliy;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Date;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public   class utillity {
	WebDriver driver;
	readconfig config=new readconfig();
public static String GenerateEmailWithTimeStamp() {
	Date date=new Date();
	String TimeStamp=date.toString().replace(" ","-").replace(":", "-");
	return "siva1512"+TimeStamp+"@gmail.com";
	
}
public static final int Implicity_Wait=10;
public static final int Page_LOad_Time=10;

public  void first() {
	
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
	driver.get(config.getApplicationURL());
	
}

public static Object[][] GetDAtaFromExcelSheet(String sheetName) {
	XSSFWorkbook workbook = null;
	File Src =new File("./tutorialninja/src/test/java/com/tutorialninja/qA/utiliy/tutorialninja.xlsx");
try{
	FileInputStream fis=new FileInputStream (Src);

   workbook=new XSSFWorkbook(fis);
}catch(Exception e) {
	e.printStackTrace();
}
  
XSSFSheet sheet=workbook.getSheet(sheetName);
  int rows=sheet.getLastRowNum();
  int colms=sheet.getRow(0).getLastCellNum();
  Object[][] data=new Object[rows][colms];
  for(int i=0;i<rows;i++) {
	 XSSFRow row = sheet.getRow(i+1);
	 for(int j=0;j<1;j++) {
		XSSFCell cell = row.getCell(j);
		CellType cellType = cell.getCellType();
		switch(cellType) {
		case STRING:
			data[i][j]=cell.getStringCellValue();
			break;
		case NUMERIC:
			data[i][j]=Integer.toString((int)cell.getNumericCellValue());
			break;
		case BOOLEAN:
			data[i][j]=cell.getBooleanCellValue();
		default:
			break;
			
		}
	 }
	  
  }
return data;
}

}
