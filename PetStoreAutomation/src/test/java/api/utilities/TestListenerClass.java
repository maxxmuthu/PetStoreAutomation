package api.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.equalTo;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.util.Arrays;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListenerClass implements ITestListener {

	private static ExtentReports extent = ExtentManager.createInstance();
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    
    public synchronized void onStart(ITestContext context) {
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("test-output/extentReport.html");
        extent.attachReporter(htmlReporter);
    }

   
    public synchronized void onFinish(ITestContext context) {
        extent.flush();
    }

   
    public synchronized void onTestStart(ITestResult result) {
        ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName());
        test.set(extentTest);
        
     // This method is called before each test method starts
     	System.out.println("Test Method started: " + result.getName());
    }

   
    public synchronized void onTestSuccess(ITestResult result) {
        test.get().log(Status.PASS, "Test passed");
        
     // This method is called when a test method succeeds
     	System.out.println("Test Method succeeded: " + result.getName());
    }

    
    public synchronized void onTestFailure(ITestResult result) {
        test.get().log(Status.FAIL, result.getThrowable());
        
     // This method is called when a test method fails
     	System.out.println("Test Method failed: " + result.getName());
    }

    
    public synchronized void onTestSkipped(ITestResult result) {
        test.get().log(Status.SKIP, "Test skipped");
        
     // This method is called when a test method is skipped
     	System.out.println("Test Method skipped: " + result.getName());
    }

   
    public synchronized void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // Do nothing
    }

    public static void logResponseDetails(Response response) {
        test.get().info("Response Status Code: " + response.getStatusCode());
        test.get().info("Response Body: " + response.getBody().asString());
    }

    public static void logRequestDetails(String httpMethod, String endpoint) {
        test.get().info("Request Method: " + httpMethod);
        test.get().info("Endpoint URL: " + endpoint);
    }
    
}