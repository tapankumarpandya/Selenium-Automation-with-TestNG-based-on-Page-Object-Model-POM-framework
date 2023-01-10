package tapanhpandya.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import tapanhpandya.base.TestBase;
import tapanhpandya.pages.CartPage;
import tapanhpandya.pages.CheckoutPage;
import tapanhpandya.pages.HomePage;
import tapanhpandya.pages.LoginPage;

public class LoginTest extends TestBase {
	LoginPage loginPage;
	CheckoutPage checkoutPage;
	
	public LoginTest() {
		super();
	}
	
	@BeforeMethod
	public void init() {
		initialization();
		loginPage = new LoginPage();
	}
	
	@Test
	public void LoginPageTest() {
		loginPage.setUser(prop.getProperty("username"));
		loginPage.setPassword(prop.getProperty("password"));
		HomePage hp = loginPage.initLogin();
		hp.addToCart("ZARA COAT 3");
		CartPage cp = hp.goToCart();
		checkoutPage = cp.goToCheckout();
		checkoutPage.selectCountry("india");
		Assert.assertTrue(checkoutPage.placeOrder());
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}

}
