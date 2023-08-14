package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AbstractClass {
    WebDriver driver;
    public AbstractClass(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }
@FindBy(xpath="//a[text()='My Quote']")
    WebElement myQuote;
@FindBy(xpath ="//a[@data-dropdown='cart-preview-dropdown']")
    WebElement cartLogo;
@FindBy(xpath ="//a[text()='Sign out']")
    WebElement signOut;

    @FindBy(xpath ="//a[text()='Order History']")
        WebElement orderHistory;
    @FindBy(xpath ="//a[text()='Payment Methods']")
        WebElement paymentMethods;
    @FindBy(xpath ="//a[text()='Recently Viewed']")
        WebElement recentlyViewed;
    @FindBy(xpath ="//a[text()='Account Settings']")
        WebElement accountSettings;
    @FindBy(xpath ="//a[text()='Addresses']")
        WebElement address;

    @FindBy(xpath ="//a[text()='Buy Again']")
     WebElement buyAgain;
    @FindBy(xpath ="//a[text()='Start a Quote']")
     WebElement StartQuote;
    @FindBy(xpath ="//a[text()='Quote History']")
     WebElement quoteHistory;

    @FindBy(xpath ="//a[@href='/cart.php']")
     WebElement viewCart;


}
