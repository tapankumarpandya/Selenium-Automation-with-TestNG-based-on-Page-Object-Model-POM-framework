package tapanhpandya.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import tapanhpandya.base.TestBase;
import tapanhpandya.util.TestUtil;

public class CartPage extends TestBase {

	public CartPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".cart")
	private List<WebElement> products;
	
	@FindBy(css=".prodTotal p")
	private List<WebElement> productPrice;
	
	@FindBy(css="li span:nth-child(2)")
	private WebElement subTotal;
	
	@FindBy(xpath="//button[text()='Checkout']")
	private WebElement checkout;
	
	public boolean priceCompare(int price) {
		int subT = Integer.getInteger(subTotal.getText());
		return price/subT == 1 ? true : false;
	}
	
	public CheckoutPage goToCheckout() {
		checkout.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtil.IMPLICIT_WAIT));
		return new CheckoutPage();
	}
	
	
}
