package com.tricentis.genericutility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
/**
 * 
 * @author Naveed
 *
 */
public class FileUtility {
	
	/**
	 * This Method will read data from property file and return value
	 * @param key
	 * @return
	 * @throws IOException
	 */
public String getDatafromProperty(String key) throws IOException {
	FileInputStream f= new FileInputStream("./src/test/resources/TestData/commondata.properties");
	Properties p= new Properties();
	p.load(f);
	return p.getProperty(key);
}
}
