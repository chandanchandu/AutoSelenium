package generic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class BasePage {
	
	public WebDriver driver;
	
	public BasePage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void verifyTitle(String eTitle)
	{
		WebDriverWait wait=new WebDriverWait(driver, 20);
		try{
			wait.until(ExpectedConditions.titleIs(eTitle));
			Reporter.log("Title is matching : PASS",true);
		}
		catch(Exception e){
			Reporter.log("Title is Not Matching : FAIL",true);
			Reporter.log(eTitle,true);
			Reporter.log(driver.getTitle(),true);
			Assert.fail();
		}
		
		// We cann't use below code
		//String aTitle = driver.getTitle();
		//Assert.assertEquals(aTitle, eTitle);
	}

}
