package script;

import org.testng.annotations.Test;

import generic.BaseTest;
import generic.Excel;
import pom.EnterTimeTrackPage;
import pom.LoginPage;

public class ValidLoginLogout extends BaseTest{

	@Test(priority=1)
	public void testValidLoginLogout() throws Exception
	{
		String un = Excel.getCellData(INPUT_PATH, "ValidLoginLogout",1, 0);
		String pw = Excel.getCellData(INPUT_PATH, "ValidLoginLogout",1, 1);
		String homepage = Excel.getCellData(INPUT_PATH, "ValidLoginLogout",1, 2);
		String loginpage = Excel.getCellData(INPUT_PATH, "ValidLoginLogout",1, 3);
		
		LoginPage l=new LoginPage(driver);	
		l.setUsername(un);
		l.setPassword(pw);
		l.clickLogin();
		
		EnterTimeTrackPage e=new EnterTimeTrackPage(driver);
		e.verifyTitle(homepage);
		
		Thread.sleep(2000);
		
		e.clickLogout();
		l.verifyTitle(loginpage);
	}
}
