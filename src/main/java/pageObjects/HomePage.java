package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends AbstractClass {
    WebDriver driver;
    public HomePage(WebDriver driver){
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);

    }

    public void cartPage() throws InterruptedException {
        Actions a=new Actions(driver);
//      a.moveToElement(cartLogo).click().build().perform();
       cartLogo.click();
       driver.navigate().to("https://uat.riversideinsights.com/"+"cart.php");
        Thread.sleep(10000);
        a.moveToElement(viewCart).click().build().perform();
    }


}
