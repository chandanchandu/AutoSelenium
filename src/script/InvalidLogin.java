package script;

import org.testng.annotations.Test;

import generic.BaseTest;
import generic.Excel;
import pom.LoginPage;

public class InvalidLogin extends BaseTest{
	
	@Test(priority=2)
	public void testInvalidLogin() throws Exception
	{
		int rc = Excel.getRowCount(INPUT_PATH, "InvalidLogin");
		
			for(int i=1;i<=rc;i++)
			{
			
				String un = Excel.getCellData(INPUT_PATH, "InvalidLogin", 1, 0);
				String pw = Excel.getCellData(INPUT_PATH, "InvalidLogin", 1, 1);
				
				LoginPage l=new LoginPage(driver);
				l.setUsername(un);
				l.setPassword(pw);
				l.clickLogin();
				l.verifyErrMsgDisplayed();
				driver.navigate().refresh();
			}
			
	}
}
