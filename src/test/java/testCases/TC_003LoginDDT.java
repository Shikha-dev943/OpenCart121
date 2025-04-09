package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_003LoginDDT  extends BaseClass {

	@Test(dataProvider="LoginData" ,dataProviderClass=DataProviders.class ,groups = "Datadriven")
	public void verify_loginDDT( String email , String pwd , String exp) {
		logger.info("******starting TC_003_LoginDDT *****");
		try {
		//HomePage
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		//Login
		LoginPage lp = new LoginPage(driver);
		lp.setEmail(email);
		lp.setPassword(pwd);
		lp.clickLogin();
		
		//MyAccount
		MyAccountPage mp = new MyAccountPage(driver);
		boolean targetPage =mp.isMyAccountPageExist();
		
		if(exp.equalsIgnoreCase("Valid")) {
			if(targetPage=true) {
				Assert.assertTrue(true);
				mp.clickLogout();
			}
			else {
				Assert.assertTrue(false);
				
			}
		}
		if(exp.equalsIgnoreCase("Invalid")) {
			if(targetPage=true) {
				mp.clickLogout();
				Assert.assertTrue(false);
			
		}
			else {
				Assert.assertTrue(true);
			}
	}
		
		}
		catch(Exception e){
			Assert.fail();
			
		}
		logger.info("******Finished TC_003_LoginDDT *****");
	}
}
