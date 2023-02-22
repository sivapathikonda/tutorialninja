package com.tutorialninja.qA.utiliy;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class readconfig {
Properties pro;
public readconfig() {
	try {
	File fis=new File("./config/config.txt");
	FileInputStream src=new FileInputStream(fis);
	pro=new Properties();
	pro.load(src);
	}
	catch(Exception e) {
		System.out.print("Exception is"+e.getMessage());
		
	}
}
public String getApplicationURL()
{
	String url=pro.getProperty("baseUrl");
	return url;
}
public String getuserName() {
	String userName=pro.getProperty("userName");
	return userName;
	}
public String getpassword() {
	String password=pro.getProperty("password");
	return password;
}
public String getchromePath() {
	String chromePath=pro.getProperty("chromePath");
	return chromePath ;
}
}
