package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage extends AbstractClass {
    WebDriver driver;
    public LandingPage(WebDriver driver){
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(id="login_email")
    private WebElement loginId;

    @FindBy(id="login_pass")
    private WebElement loginPassword;

    @FindBy(id="onetrust-accept-btn-handler")
    private WebElement allCookie;

    @FindBy(xpath = "//input[@type='submit']")
    private WebElement submitButton;




    public HomePage login(String id, String password) throws InterruptedException {
        goTo();
        loginId.sendKeys(id);
        loginPassword.sendKeys(password);
        allCookie.click();
        submitButton.click();
        HomePage hp = new HomePage(driver);
        Thread.sleep(20000);
        return hp;
    }

    public void  goTo(){
        driver.get("https://uat.riversideinsights.com/login.php");
    }



}
