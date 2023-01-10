package tapanhpandya.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import tapanhpandya.base.TestBase;
import tapanhpandya.util.TestUtil;

public class CheckoutPage extends TestBase {
	
	public CheckoutPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="input[placeholder='Select Country']")
	private WebElement country;
	
	@FindBy(css=".ta-results button")
	private List<WebElement> dropDownItems;
	
	@FindBy(css=".actions a")
	private WebElement placeOrder;
	
	@FindBy(css=".hero-primary")
	private WebElement successMessage;
	
	public void selectCountry(String countryName) {
		country.sendKeys(countryName);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtil.IMPLICIT_WAIT));
		for(WebElement item: dropDownItems) {
			if(item.getText().equalsIgnoreCase(countryName)) {
				item.click();
			}
		}
	}
	
	public boolean placeOrder() {
		placeOrder.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtil.IMPLICIT_WAIT));
		return successMessage.isDisplayed() ? true : false;
	}

}
