package utils;

import com.aventstack.extentreports.ExtentReports;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Protocol;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.*;
import org.testng.xml.XmlSuite;

import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;

public class ExtentReporter implements ITestListener {
    private ThreadLocal<ExtentTest> extentTestThreadLocal = new ThreadLocal<>();
    private static final ExtentReports extent = new ExtentReports();


    @Override
    public void onStart(ITestContext iTestContext) {
        File file = new File("build/extent/extent-report.html");
        ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter(file);
        extentSparkReporter.config().setTheme(Theme.STANDARD); //hard coded
        extentSparkReporter.config().setDocumentTitle("Backend Tests Report");
        extentSparkReporter.config().setEncoding("utf-8");
        extentSparkReporter.config().setProtocol(Protocol.HTTPS);
        extentSparkReporter.config().setReportName("build name");
        extentSparkReporter.config().setTimeStampFormat("MMM dd, yyyy HH:mm:ss");

        extent.attachReporter(extentSparkReporter);
    }

    @Override
    public void onTestStart(ITestResult result) {
        ExtentTest test = extent.createTest(result.getName());
        extentTestThreadLocal.set(test);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentTest test = extentTestThreadLocal.get();
        test.log(Status.PASS, MarkupHelper.createLabel(result.getName() + " PASSED ", ExtentColor.GREEN));
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ExtentTest test = extentTestThreadLocal.get();
        test.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " FAILED ", ExtentColor.RED));
        test.fail(result.getThrowable());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ExtentTest test = extentTestThreadLocal.get();
        test.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " SKIPPED ", ExtentColor.ORANGE));
        test.skip(result.getThrowable());
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }
}
