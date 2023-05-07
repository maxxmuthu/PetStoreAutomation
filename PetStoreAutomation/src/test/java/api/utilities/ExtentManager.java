package api.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {

    private static ExtentReports extent;

    public static ExtentReports getInstance() {
        if (extent == null)
            createInstance();
        return extent;
    }

    public static ExtentReports createInstance() {
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("test-output/ExtentReport/ExtentReport.html");
        htmlReporter.config().setDocumentTitle("Automation Test Results");
        htmlReporter.config().setReportName("Rest Assured Test Report");
        htmlReporter.config().setTheme(Theme.DARK);

        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        extent.setSystemInfo("Host Name", "TestAPI");
        extent.setSystemInfo("Environment", "QA");
        extent.setSystemInfo("User Name", "maxxmuthu");
		extent.setSystemInfo("ProjectName", "Pet Store");
		extent.setSystemInfo("Tester", "Muthu");
		extent.setSystemInfo("OS", "Win10");
		extent.setSystemInfo("Software", "Eclipse");
        
        
        return extent;
    }
}