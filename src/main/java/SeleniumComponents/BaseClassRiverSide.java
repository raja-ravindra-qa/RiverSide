package SeleniumComponents;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pageObjects.LandingPage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseClassRiverSide {
    public WebDriver driver;
    public LandingPage lp;

    public WebDriver driverinit() throws IOException {
        Properties prop=new Properties();
        //filePath= System.getProperty("user.dir")+"//src//TestData.properties";
        FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"//src//main//java//testdata//propertydata.properties");
        prop.load(fis);
        String browserName= System.getProperty("browser")!=null? System.getProperty("bowser"):prop.getProperty("browser");

        if (browserName.contains("chrome")) {

            WebDriverManager.chromedriver().setup();
            driver=new ChromeDriver();
        }
        else if (browserName.equalsIgnoreCase("firefox")) {

            WebDriverManager.firefoxdriver().setup();
            driver=new FirefoxDriver();
        }
        else if (browserName.equalsIgnoreCase("edge")) {

            WebDriverManager.edgedriver().setup();
            driver=new EdgeDriver();
        }

        driver.manage().timeouts().implicitlyWait(30000, TimeUnit.MICROSECONDS);
        driver.manage().window().maximize();
        return driver;
    }

    public String getScreenShot(WebDriver driver, String title) throws IOException {
        String path=System.getProperty("user.dir")+"/output/screenshots"+title+".png";
        TakesScreenshot ts=(TakesScreenshot)driver;
        File scr= ts.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scr, new File(path));
        return path;
    }

@BeforeMethod
    public LandingPage landingpage() throws IOException {
        driver=driverinit();
    lp=new LandingPage(driver);
    return lp;

}
@AfterMethod
    public void tearOff(){
        driver.quit();
}



}