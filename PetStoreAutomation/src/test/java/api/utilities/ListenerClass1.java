package api.utilities;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import api.test.StoreTests;

public class ListenerClass1 implements ITestListener {

	
	// Below methods will add automatically once we implement ITestListener
    // For Class Level - mention the @Listeners(ListnerClass.class) in actual class on top
	// If user implement ListnerClass, then test case needs to be run through testng.xml else error will be occurred
	
	public void onTestStart(ITestResult result) {

		// This method is called before each test method starts
		System.out.println("Test Method started: " + result.getName());

	}

	public void onTestSuccess(ITestResult result) {

		// This method is called when a test method succeeds
		System.out.println("Test Method succeeded: " + result.getName());

	}

	public void onTestFailure(ITestResult result) {

		// This method is called when a test method fails
		System.out.println("Test Method failed: " + result.getName());

	}

	public void onTestSkipped(ITestResult result) {

		// This method is called when a test method is skipped
		System.out.println("Test Method skipped: " + result.getName());

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

		// This method is called when a test method fails within the success percentage
		System.out.println("Test Method failed but within success percentage: " + result.getName());

	}

	public void onStart(ITestContext context) {

		// This method is called before the test suite starts
		System.out.println("Test Suite started: " + context.getName());

	}

	public void onFinish(ITestContext context) {

		// This method is called after the test suite finishes
		System.out.println("Test Suite finished: " + context.getName());

	}
}