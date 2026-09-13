package com.hooks;

import com.base.BaseTest;
import com.utility.ScreenshotUtil;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks extends BaseTest {

	@Before
	public void launchBrowser() {

	    System.out.println(
	            "Browser Launch Started");

	    setup();
	}

	@After
	public void closeBrowser(
	        Scenario scenario)
	        throws Exception {

	    if (scenario.isFailed()) {

	        ScreenshotUtil.takeScreenshot(
	                scenario.getName()
	                + "_FAIL");

	    } else {

	        ScreenshotUtil.takeScreenshot(
	                scenario.getName()
	                + "_PASS");
	    }

	    System.out.println(
	            "Scenario Completed : "
	            + scenario.getName());

	    tearDown();
	}
}