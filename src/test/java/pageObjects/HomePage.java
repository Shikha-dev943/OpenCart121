package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[text()='My Account']")
    WebElement linkAccount;

    @FindBy(xpath = "//a[normalize-space()='Register']")
    WebElement linkRegister;

    @FindBy(xpath = "//a[text()='Login'][1]")
    WebElement linkLogin;

    public void clickMyAccount() {
        linkAccount.click();
    }

    public void clickRegister() {
        linkRegister.click();
    }

    public void clickLogin() {
        linkLogin.click();
    }
}
