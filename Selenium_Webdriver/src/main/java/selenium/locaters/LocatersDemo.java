package selenium.locaters;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LocatersDemo {
	static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("http://demo.opencart.com");
		// name
		driver.findElement(By.name("search")).sendKeys("Mac");
		// id
		boolean logoDisplayStatus = driver.findElement(By.id("logo")).isDisplayed();
		System.out.println("Logo Display Status" + logoDisplayStatus);
		// linkText and partialLinkText
		driver.findElement(By.linkText("Tablets")).click();
		driver.findElement(By.partialLinkText("Table")).click();
		// className
		List<WebElement> headerLinks = driver.findElements(By.className("list-inline-item"));
		System.out.println("Total Number of header links" + headerLinks.size());
		// tagName
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("Total Number of links" + links.size());
		// image
		List<WebElement> images = driver.findElements(By.tagName("img"));
		System.out.println("Total Number of image" + images.size());

	}
}
