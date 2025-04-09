package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {

    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h2[text()='My Account']")  // My account page heading
    WebElement msgHeading;
    
    @FindBy(xpath="//a[text()='Logout'][1]")
    WebElement linklogout;

    public boolean isMyAccountPageExist() {
        try {
            return msgHeading.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
    
    public void clickLogout() {
    	linklogout.click();
    }
}
