package tapanhpandya.pages;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import tapanhpandya.base.TestBase;
import tapanhpandya.util.TestUtil;

public class LoginPage extends TestBase {
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="userPassword")
	private WebElement passwordField;
	
	@FindBy(id="userEmail")
	private WebElement userField;
	
	@FindBy(id="login")
	private WebElement loginBtn;
	
	public void setUser(String username) {
		userField.sendKeys(username);
	}
	
	public void setPassword(String password) {
		passwordField.sendKeys(password);
	}
	
	public HomePage initLogin() {
		loginBtn.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtil.IMPLICIT_WAIT));
		return new HomePage();
	}
	
}
