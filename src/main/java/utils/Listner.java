package utils;

import org.testng.*;

public class Listner extends TestListenerAdapter {

    @Override
    public void onStart(ITestContext testContext) {
       super.onStart(testContext);
       Reporter.log("<======= Starting the test method =======>\n"+ testContext.getName(), true);
    }

    @Override
    public void onFinish(ITestContext testContext) {
        super.onFinish(testContext);
        Reporter.log("<======= Completed the test method =======>\n"+ testContext.getName(), true);
    }

    @Override
    public void onTestSuccess(ITestResult tr) {
        super.onTestSuccess(tr);
        Reporter.log("<======= Successfully Completed the test =======>\n" + tr.getName(), true);
    }

    @Override
    public void onTestFailure(ITestResult tr) {
        super.onTestFailure(tr);
        Reporter.log("<======= The test failed =======>\n" + tr.getName(), true);
    }

    @Override
    public void onTestSkipped(ITestResult tr) {
        super.onTestSkipped(tr);
        Reporter.log("<======= The test skipped =======>\n" + tr.getName(), true);
    }

}
