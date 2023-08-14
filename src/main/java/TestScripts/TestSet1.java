package TestScripts;

import SeleniumComponents.BaseClassRiverSide;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;

import java.io.IOException;

public class TestSet1 extends BaseClassRiverSide {
    WebDriver driver;


    @Test
    public void login() throws IOException, InterruptedException {
        // TODO Auto-generated method stub

        lp.login("helencont2@gmail.com","test12345");

        Assert.assertFalse(true);

    }
    @Test        //(retryAnalyzer = Retry.class)
    public void cartPageNavigation() throws IOException, InterruptedException {
        // TODO Auto-generated method stub
//hi //hello just now i am diing changes

        HomePage homeLaunch = lp.login("helencont2@gmail.com", "test12345");
        homeLaunch.cartPage();
        Thread.sleep(15000);
    }


}
