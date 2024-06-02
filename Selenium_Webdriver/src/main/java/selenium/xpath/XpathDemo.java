package selenium.xpath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class XpathDemo {
	static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("http://demo.opencart.com");

		// Xpath with single attribute
		driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys("T-shirts");

		// Xpath with multiple attribute
		driver.findElement(By.xpath("//input[@name='search'][@placeholder='Search']")).sendKeys("T-shirts");

		// Xpath with and or operator
		driver.findElement(By.xpath("//input[@name='search' and @placeholder='Search']")).sendKeys("T-shirts");
		driver.findElement(By.xpath("//input[@name='search' or @placeholder='xyz']")).sendKeys("T-shirts");
		// Xpath with text() - inner text
		driver.findElement(By.xpath("//*[text()='MacBook']")).click();

		boolean display = driver.findElement(By.xpath("//h3[text()='Featured']")).isDisplayed();
		System.out.println(display);

		String value = driver.findElement(By.xpath("//h3[text()='Featured']")).getText();
		System.out.println(value);

		// xpath with contains
		// Search
		driver.findElement(By.xpath("//input[contains(@placeholder,'Sea')")).sendKeys("T-shirts");
		// xpath with starts-with()
		driver.findElement(By.xpath("//input[starts-with(@placeholder,'Sea')")).sendKeys("T-shirts");

		// chained xpath
		boolean status = driver.findElement(By.xpath("//div[@id='logo']/a/img")).isDisplayed();
		System.out.println(status);

	}
}