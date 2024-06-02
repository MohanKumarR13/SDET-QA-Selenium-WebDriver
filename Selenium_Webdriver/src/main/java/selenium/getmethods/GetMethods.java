package selenium.getmethods;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GetMethods {
	static WebDriver driver;

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		System.out.println(driver.getTitle());

		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getPageSource());
		String window = driver.getWindowHandle();
		System.out.println("Window ID" + window);
		JavascriptExecutor j = (JavascriptExecutor) driver;
		j.executeScript("window.scrollBy(0,500)");
		driver.findElement(By.linkText("OrangeHRM, Inc")).click();
		Set<String> windowId = driver.getWindowHandles();
		System.out.println(windowId);

		driver.quit();

	}

}
