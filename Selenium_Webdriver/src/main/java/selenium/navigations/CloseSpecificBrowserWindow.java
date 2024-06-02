package selenium.navigations;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CloseSpecificBrowserWindow {
	static WebDriver driver;

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws MalformedURLException {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		URL url = new URL("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.navigate().to(url);

		JavascriptExecutor j = (JavascriptExecutor) driver;
		j.executeScript("window.scrollBy(0,500)");
		driver.findElement(By.linkText("OrangeHRM, Inc")).click();
		// Approch1
		Set<String> windowsId = driver.getWindowHandles();
		
		for (String winId : windowsId) {
			String title = driver.switchTo().window(winId).getTitle();
			if (title.equals("Human Resources Management Software | OrangeHRM")||title.equals("OrangeHRMm")) {
				System.out.println(driver.getCurrentUrl());
				driver.quit();
			}
		}
	}
}
