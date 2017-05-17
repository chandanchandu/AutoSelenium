package script;

import org.testng.annotations.Test;

import generic.BaseTest;
import generic.Excel;
import pom.LoginPage;

public class VerifyVersion extends BaseTest {
	
	@Test(priority=3)
	public void testVerifyVersion() throws Exception
	{	
		String eVersion=Excel.getCellData(INPUT_PATH, "VerifyVersion", 1, 0);
		
		LoginPage l= new LoginPage(driver);
		l.verifyVersion(eVersion);	
	}

}
