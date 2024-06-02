package selenium.navigations;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleBrowserWindows {
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
		List<String> windowsList = new ArrayList<String>(windowsId);

		String parentId = windowsList.get(0);
		String childId = windowsList.get(1);

		driver.switchTo().window(childId);
		System.out.println(driver.getTitle());

		driver.switchTo().window(parentId);
		System.out.println(driver.getTitle());

		// Approch2
		for (String winId : windowsId) {
			String title = driver.switchTo().window(winId).getTitle();
			if (title.equals("OrangeHRM")) {
				System.out.println(driver.getCurrentUrl());
			}
		}
	}
}
