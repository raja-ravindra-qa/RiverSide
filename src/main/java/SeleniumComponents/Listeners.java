package SeleniumComponents;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners extends BaseClassRiverSide implements ITestListener {
ExtentTest test;

    ExtentReports ext=ExtentReportNG.extentconfig();
    ThreadLocal<ExtentTest> extTest= new ThreadLocal<ExtentTest>();


    @Override
    public void onTestStart(ITestResult result) {
      test=ext.createTest(result.getMethod().getMethodName());
      extTest.set(test);

    }

    @Override
    public void onTestSuccess(ITestResult result) {
extTest.get().log(Status.PASS, "Test Completed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        extTest.get().fail(result.getThrowable());
        String title=result.getMethod().getMethodName();
//        System.out.println("I came to see failure of "+title);
         String screeshotpath=null;
        try {

            driver = (WebDriver) result.getTestClass().getRealClass().getField("driver")
                    .get(result.getInstance());
            title=result.getMethod().getMethodName();
           screeshotpath= getScreenShot( driver, title);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(screeshotpath);
        extTest.get().addScreenCaptureFromPath(screeshotpath, title);
//        extTest.get().addScreenCaptureFromBase64String(screeshotpath,title);
    }

    @Override
    public void onTestSkipped(ITestResult result) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {

    }

    @Override
    public void onFinish(ITestContext context) {
        ext.flush();

    }
}
