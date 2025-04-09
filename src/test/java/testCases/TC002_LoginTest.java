package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass {

    @Test(groups={"Sanity", "Master"})
    public void verify_login() {
        logger.info("******* Starting TC002_LoginTest **********");
        try {
            // HomePage
            HomePage hp = new HomePage(driver);
            hp.clickMyAccount();
            hp.clickLogin();
            

            // LoginPage
            LoginPage lp = new LoginPage(driver);
            lp.setEmail(p.getProperty("email"));
            lp.setPassword(p.getProperty("password"));
            lp.clickLogin();

            // MyAccountPage
            MyAccountPage mp = new MyAccountPage(driver);
            boolean targetPage = mp.isMyAccountPageExist();

            Assert.assertTrue(targetPage, "Login failed: MyAccount page was not displayed.");

            logger.info("******* Finished TC002_LoginTest **********");

        } catch (Exception e) {
            logger.error("Test failed due to exception: ", e);
            Assert.fail("Test failed due to exception: " + e.getMessage());
        }
    }
}
