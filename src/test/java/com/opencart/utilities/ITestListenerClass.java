package com.opencart.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;

public class ITestListenerClass implements ITestListener {
    private ExtentSparkReporter htmlReporter;
    private ExtentReports reports;
    private ExtentTest test;

    /**
     * Configures the Extent Reports settings.
     */
    public void configureReport() {
        htmlReporter = new ExtentSparkReporter("ExtentListenerReportDemo.html");
        reports = new ExtentReports();
        reports.attachReporter(htmlReporter);

        reports.setSystemInfo("Machine", "KiranPc");
        reports.setSystemInfo("OS", "Windows");

        htmlReporter.config().setDocumentTitle("Extent Opencart Report");
        htmlReporter.config().setReportName("First Report");
        htmlReporter.config().setTheme(Theme.DARK);
    }

    @Override
    public void onTestStart(ITestResult result) {
        test = reports.createTest(result.getName());
        test.log(Status.INFO, MarkupHelper.createLabel("Test started: " + result.getName(), ExtentColor.BLUE));
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.log(Status.PASS, MarkupHelper.createLabel("Test passed: " + result.getName(), ExtentColor.GREEN));
    }

    @Override
    public void onTestFailure(ITestResult result) {
        test.log(Status.FAIL, MarkupHelper.createLabel("Test failed: " + result.getName(), ExtentColor.RED));
        String screenShotPath = System.getProperty("user.dir") + "\\Screenshots\\" + result.getName() + ".png";
        File screenShotFile = new File(screenShotPath);

        if (screenShotFile.exists()) {
            test.fail("Captured Screenshot: " + test.addScreenCaptureFromPath(screenShotPath));
        } else {
            test.fail("Screenshot not found for failed test case.");
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        test.log(Status.SKIP, MarkupHelper.createLabel("Test skipped: " + result.getName(), ExtentColor.YELLOW));
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // Handle case if needed
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        onTestFailure(result);
    }

    @Override
    public void onStart(ITestContext context) {
        configureReport();
    }

    @Override
    public void onFinish(ITestContext context) {
        reports.flush(); // Finalize the report
    }
}
