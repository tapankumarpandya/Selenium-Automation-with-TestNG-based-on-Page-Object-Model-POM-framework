package tapanhpandya.util;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestUtil {
	
	public static long IMPLICIT_WAIT = 10;
	public static int PAGE_LOAD_TIMEOUT = 20;
	
	public static boolean elementVisible(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(PAGE_LOAD_TIMEOUT));
		wait.until(ExpectedConditions.visibilityOf(element));
		return true;
	}
	
	public static boolean elementInvisibility(WebDriver driver, By byLocator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(PAGE_LOAD_TIMEOUT));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(byLocator));
		return true;
	}
	
	
}
