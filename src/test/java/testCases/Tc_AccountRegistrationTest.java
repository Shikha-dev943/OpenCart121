package testCases;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class Tc_AccountRegistrationTest extends BaseClass {
    @Test(groups= {"Regression","Master"})
    public void testAccountRegistration() {
        logger.info("******* Starting TC_AccountRegistrationTest *****");
        try {
            HomePage hp = new HomePage(driver);
            hp.clickMyAccount();
            logger.info("Clicked on My Account Link");

            hp.clickRegister();
            logger.info("Clicked on Register Link");

            AccountRegistrationPage regpage = new AccountRegistrationPage(driver);
            logger.info("Providing customer details");

            String password = "xyz123456"; // Fixed Password & Confirm Password
            regpage.setFirstName(randomeString().toUpperCase());
            regpage.setLastName(randomeString().toUpperCase());
            regpage.setEmail(randomeString() + "@gmail.com");

            regpage.setTelephone("1234567890");
            regpage.setPassword(password);
            regpage.setConfirmPass(password);

            regpage.setPrivacyPolicy();
            regpage.clickContinue();

            logger.info("Validating expected message");
            String confMsg = regpage.getConfirmationMsg();
            Assert.assertEquals(confMsg, "Congratulations! Your new account has been successfully created!");
        } catch (Exception e) {
            logger.error("Test Failed", e);
            Assert.fail();
        }
        logger.info("******** Finished TC_AccountRegistrationTest *****");
    }
}
