package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage  extends BasePage{
	
	 public AccountRegistrationPage(WebDriver driver) {
	        super(driver);
	    }

	    @FindBy(xpath = "//input[@name='firstname']")
	    WebElement txtFirstName;

	    @FindBy(xpath = "//input[@name='lastname']")
	    WebElement txtLastName;

	    @FindBy(xpath = "//input[@name='email']")
	    WebElement txtEmail;
	    
	    @FindBy(xpath="//input[@name=\"telephone\"]")
	    WebElement txtTelephone ;


	    @FindBy(xpath = "//input[@name='password']")
	    WebElement txtPassword;
	    
	    @FindBy(xpath= "//input[@name=\"confirm\"]")
	    WebElement txtConfirm;
        
	   
	    @FindBy(xpath = "//input[@name='agree']")
	    WebElement checkPolicy;

	    @FindBy(xpath = "//input[@value=\"Continue\"]")
	    WebElement continuebtn;

	    @FindBy(xpath ="//div[@id=\"content\"]/p[text()='Congratulations! Your new account has been successfully created!']")
	    WebElement msgConfirmation;

	    // Methods to interact with elements
	    public void setFirstName(String fname) {
	        txtFirstName.sendKeys(fname);
	    }

	    public void setLastName(String lname) {
	        txtLastName.sendKeys(lname);
	    }

	    public void setEmail(String email) {
	        txtEmail.sendKeys(email);
	    }
	    
	    public void setTelephone(String tele) {
	    	txtTelephone.sendKeys(tele);
	    }

	    public void setPassword(String pass) {  // Fixed method name
	        txtPassword.sendKeys(pass);
	    }
	    public void setConfirmPass(String conpass) {
	    	txtConfirm.sendKeys(conpass);
	    }

	    public void setPrivacyPolicy() {
	        checkPolicy.click();
	    }

	    public void clickContinue() {  // Fixed method name casing
	        continuebtn.click();
	    }

	    public String getConfirmationMsg() {
	        try {
	            return msgConfirmation.getText();
	        } catch (Exception e) {
	            return e.getMessage();
	        }
	    }
	}
