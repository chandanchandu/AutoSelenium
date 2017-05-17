package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import generic.BasePage;

public class LoginPage extends BasePage {
	
	// declaration
	@FindBy(id="username")
	private WebElement username;
	
	@FindBy(name="pwd")
	private WebElement password;
	
	@FindBy(xpath="//div[text()='Login ']")
	private WebElement login;
	
	@FindBy(xpath="(//nobr[contains(.,'actiTIME')])[1]")
	private WebElement version;
	
	@FindBy(xpath="//span[contains(.,'invalid')]")
	private WebElement errMsg;

	//Initialization
	public LoginPage(WebDriver driver){
		super(driver);
		
		PageFactory.initElements(driver, this);
	}
	
	// Utilization
	public void setUsername(String un) {
		username.sendKeys(un);
	}
	
	public void setPassword(String pw) {
		password.sendKeys(pw);
	}
	
	public void clickLogin(){
		login.click();
	}
	
	public void verifyVersion(String eVersion) {
		String aVersion=version.getText();
		Assert.assertEquals(aVersion, eVersion);
	}
	
	public void verifyErrMsgDisplayed() {
		WebDriverWait wait=new WebDriverWait(driver, 5);
		try{
			wait.until(ExpectedConditions.visibilityOf(errMsg));
			Reporter.log("Err Msg is Displayed:PASS",true);
		}
		catch(Exception e){
			Reporter.log("Err Msg is not Displayed:FAIL",true);
			Assert.fail();
		}
	}
}
