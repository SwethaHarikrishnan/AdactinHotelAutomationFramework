package com.utility;

import java.io.File;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.base.BaseTest;

public class ScreenshotUtil extends BaseTest {

	public static String takeScreenshot(String scenarioName) {

	    try {

	        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss")
	                .format(new Date());

	        File folder = new File("Screenshots");

	        if (!folder.exists()) {

	            boolean created = folder.mkdirs();

	            if (!created) {
	                throw new IOException("Screenshots folder not created");
	            }
	        }

	        TakesScreenshot ts = (TakesScreenshot) driver;

	        File source = ts.getScreenshotAs(OutputType.FILE);

	        String filePath = "Screenshots/"
	                + scenarioName.replaceAll(" ", "_")
	                + "_"
	                + timestamp
	                + ".png";

	        File destination = new File(filePath);

	        FileUtils.copyFile(source, destination);

	        System.out.println("Saved At : "
	                + destination.getAbsolutePath());

	        return filePath;

	    } catch (IOException e) {

	        System.out.println("Error while saving screenshot");
	        e.printStackTrace();

	        return null;
	    }
	}
}