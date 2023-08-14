package SeleniumComponents;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportNG {
    public static ExtentReports extentconfig() {

        String pathx =System.getProperty("user.dir")+"//reports//index.html";
        ExtentSparkReporter reporter = new ExtentSparkReporter(pathx);
        reporter.config().setReportName("my BSE report");
        reporter.config().setDocumentTitle("testNG report");


        ExtentReports extent = new ExtentReports();
       extent.setSystemInfo("Tester", "Raveendra");
       extent.attachReporter(reporter);
        return extent;

    }


}
