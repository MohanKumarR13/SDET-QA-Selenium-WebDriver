package selenium.shadowdomelements;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ShadowDomElement {
	static WebDriver driver;

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws Exception {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.navigate().to("https://books-pwakit.appspot.com/");
		/*
		 * String cssSelectorForHost1 = "book-app[apptitle='BOOKS']";
		 * Thread.sleep(4000);
		 */
		SearchContext shadow = driver.findElement(By.cssSelector("book-app[apptitle='BOOKS']")).getShadowRoot();
		Thread.sleep(4000);
		shadow.findElement(By.cssSelector("#input")).sendKeys("WELCOME");

	}

}
