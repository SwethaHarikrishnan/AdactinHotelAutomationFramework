package com.utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

    private static ExtentReports extent;

    public static ExtentReports getInstance() {

        try {

            if (extent == null) {

                ExtentSparkReporter spark =
                        new ExtentSparkReporter(
                                "Reports/ExtentReport.html");

                extent = new ExtentReports();
                extent.attachReporter(spark);
            }

        } catch (Exception e) {
            System.out.println("Failed to create Extent Report");
            e.printStackTrace();
        }

        return extent;
    }
}