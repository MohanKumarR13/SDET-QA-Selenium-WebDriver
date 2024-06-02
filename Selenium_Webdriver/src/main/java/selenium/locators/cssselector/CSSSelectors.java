package selenium.locators.cssselector;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CSSSelectors {
	static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("http://demo.opencart.com");
		// tag id tag#id
		driver.findElement(By.cssSelector("input#small-searchterms")).sendKeys("T-shirts");
		driver.findElement(By.cssSelector("small-searchterms")).sendKeys("T-shirts");

		// tag class tag.classname
		driver.findElement(By.cssSelector("input.search-box-text")).sendKeys("T-shirts");
		driver.findElement(By.cssSelector(".search-box-text")).sendKeys("T-shirts");

		// tag attribute tag[attribute='value']
		driver.findElement(By.cssSelector("input[placeholder='Search store']")).sendKeys("T-shirts");
		driver.findElement(By.cssSelector("[placeholder='Search store']")).sendKeys("T-shirts");

		// tag class attribute
		driver.findElement(By.cssSelector("input.search-box-text[name='q']")).sendKeys("T-shirts");
		driver.findElement(By.cssSelector(".search-box-text[name='q']")).sendKeys("T-shirts");

	}
}
