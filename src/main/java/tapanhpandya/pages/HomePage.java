package tapanhpandya.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import tapanhpandya.base.TestBase;
import tapanhpandya.util.TestUtil;

public class HomePage extends TestBase {
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".container .row")
	private List<WebElement> products;
	
	@FindBy(css=".card-body h5 b")
	private WebElement productName;
	
	@FindBy(css=".card-body button:last-child")
	private WebElement addToCartBtn;
	
	@FindBy(xpath="//button[contains(text(), 'Cart')]")
	private WebElement cartBtn;
	
	@FindBy(css=".ngx-spinner-overlay")
	private WebElement loading;
	
	private By loadingBy = By.className(".ngx-spinner-overlay");
	
	private By productBy = By.cssSelector(".card-body h5 b");
	
	public void addToCart(String product) {
		for(WebElement p: products) {
			if(p.findElement(productBy).getText().equalsIgnoreCase(product)) {
				addToCartBtn.click();
			}
		}
	}
	
	public CartPage goToCart() {
		if(TestUtil.elementInvisibility(driver, loadingBy)) {
			cartBtn.click();
			return new CartPage();
		}
		return null;
	}

}
