package com.hooks;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class ExtentHooks {

    public static ExtentReports extent =
            com.utility.ExtentManager.getInstance();

    public static ExtentTest test;

    @Before
    public void beforeScenario(
            Scenario scenario) {

        test = extent.createTest(
                scenario.getName());
    }

    @After
    public void afterScenario(
            Scenario scenario) {
    	

        if (scenario.isFailed()) {

            test.fail(
                    "Scenario Failed");

        } else {

            test.pass(
                    "Scenario Passed");
        }

        extent.flush();
    }
}