package selenium.javascriptexcecuter.demo;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JavaScriptExcecuterDemo {
	static WebDriver driver;

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws Exception {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		URL url = new URL("https://testautomationpractice.blogspot.com/");
		driver.navigate().to(url);

		WebElement name = driver.findElement(By.xpath("//input[@id='name']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('value','John')", name);
		
		WebElement radioBtn = driver.findElement(By.xpath("//input[@id='male']"));
		js.executeScript("arguments[0].click()", radioBtn);

	}

}
