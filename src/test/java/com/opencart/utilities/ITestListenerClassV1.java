package com.itlearn.utility;

import java.io.File;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ITestListenerClassV1 implements ITestListener {
    private ExtentSparkReporter htmlReporter;
    private ExtentReports reports;
    private ExtentTest test;

    /**
     * Configures the ExtentReports settings and initializes the report file.
     */
    public void configureReport() {
        // Initialize the HTML reporter
        htmlReporter = new ExtentSparkReporter("ExtentListenerReportDemo.html");

        // Initialize ExtentReports
        reports = new ExtentReports();
        reports.attachReporter(htmlReporter);

        // Add system information to the reports
        reports.setSystemInfo("Machine", "RaviPc");
        reports.setSystemInfo("OS", "Windows11");

        // Set report document properties
        htmlReporter.config().setDocumentTitle("Extent Listener Report Demo");
        htmlReporter.config().setReportName("This is my first Report");
        htmlReporter.config().setTheme(Theme.DARK);
    }


    public void onTestStart(ITestResult result) {
        // Called when a test starts
        System.out.println("Test started: " + result.getName());
        test = reports.createTest(result.getName());
    }


    public void onTestSuccess(ITestResult result) {
        // Called when a test is successful
        System.out.println("Test passed: " + result.getName());
        test.log(Status.PASS, MarkupHelper.createLabel("Test case passed: " + result.getName(), ExtentColor.GREEN));
    }

    public void onTestFailure(ITestResult result) {
        // Called when a test fails
        System.out.println("Test failed: " + result.getName());
        test = reports.createTest(result.getName());

        // Log failure with screenshot if available
        String screenshotPath = System.getProperty("user.dir") + "\\Screenshots\\" + result.getName() + ".png";
        File screenshotFile = new File(screenshotPath);

        if (screenshotFile.exists()) {
            test.fail("Captured Screenshot: " + test.addScreenCaptureFromPath(screenshotPath));
        } else {
            test.fail("No screenshot available for: " + result.getName());
        }

        test.log(Status.FAIL, MarkupHelper.createLabel("Failed test case: " + result.getName(), ExtentColor.RED));
    }

    public void onTestSkipped(ITestResult result) {
        // Called when a test is skipped
        System.out.println("Test skipped: " + result.getName());
        test = reports.createTest(result.getName());
        test.log(Status.SKIP, MarkupHelper.createLabel("Skipped test case: " + result.getName(), ExtentColor.YELLOW));
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // Not implemented, can be used for tests that are partially successful
    }


    public void onTestFailedWithTimeout(ITestResult result) {
        // Handles tests that fail due to timeout
        onTestFailure(result);
    }

    public void onStart(ITestContext context) {
        // Called before any test starts
        configureReport();
        System.out.println("Report configuration started...");
    }

    public void onFinish(ITestContext context) {
        // Called after all tests have finished
        System.out.println("All tests finished...");
        reports.flush(); // Ensure all data is written to the report
    }
}
