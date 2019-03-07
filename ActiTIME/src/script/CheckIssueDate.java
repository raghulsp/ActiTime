package script;

import org.testng.annotations.Test;

import generic.BaseTest;
import generic.XL;
import page.EnterTimeTrackPage;
import page.LicensePage;
import page.LoginPage;

public class CheckIssueDate extends BaseTest {
	@Test(priority=3)
	public void testCheckIssueDate() throws InterruptedException {
		String un = XL.getData(XL_PATH, "CheckIssueDate", 1, 0);
		String pw = XL.getData(XL_PATH, "CheckIssueDate", 1, 1);
		String iDate=XL.getData(XL_PATH, "CheckIssueDate", 1, 2);
//		Enter valid Username
		LoginPage lp= new LoginPage(driver);
		lp.setUserName(un);	
//		Enter valid password
		lp.setPassword(pw);
//		Click on Login
		lp.clickLogin();
//		Click on settings
		EnterTimeTrackPage e = new EnterTimeTrackPage(driver);
		Thread.sleep(1000);
		e.clickSettings();
//		Thread.sleep(1000);
//		Click on Licenses
		e.clickLicenses(driver, ETO);
//		Check the issue Date
		LicensePage l = new LicensePage(driver);
		l.verifyIssueDate(iDate);
		
	}

}
