package selenium.handlecheckbox;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleCheckBoxes {
	static WebDriver driver;

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws MalformedURLException, Exception {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		URL url = new URL("https://testautomationpractice.blogspot.com/");
		driver.navigate().to(url);
		JavascriptExecutor j = (JavascriptExecutor) driver;
		j.executeScript("window.scrollBy(0,500)");
		driver.findElement(By.xpath("//input[@id='sunday']")).click();
		List<WebElement> checkBox = driver
				.findElements(By.xpath("//input[@class='form-check-input' and @type='checkbox']"));
		for (int i = 0; i < checkBox.size(); i++) {
			checkBox.get(i).click();
		}

		for (WebElement checkBoxes : checkBox) {
			checkBoxes.click();
		}

		for (int i = 4; i < checkBox.size(); i++) {
			checkBox.get(i).click();
		}

		for (int i = 0; i < 3; i++) {
			checkBox.get(i).click();
		}

		for (int i = 0; i < 3; i++) {
			checkBox.get(i).click();
		}

		Thread.sleep(5000);
		for (int i = 0; i < checkBox.size(); i++) {
			if (checkBox.get(i).isSelected())
				checkBox.get(i).click();
		}
	}
}