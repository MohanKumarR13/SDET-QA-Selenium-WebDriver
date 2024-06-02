package selenium.handleautosuggestiondropdown;

import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleAutoSuggestionDropDown {
	static WebDriver driver;

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws Exception {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		URL url = new URL("https://www.google.com");
		driver.navigate().to(url);
		driver.findElement(By.name("q")).sendKeys("selenium");
		Thread.sleep(5000);
		List<WebElement> list = driver.findElements(By.xpath("//ul[@role='listbox']//li//div[@role='option']"));
		System.out.println(list.size());
		for (int i = -0; i < list.size(); i++) {
			System.out.println(list.get(i).getText());
			if (list.get(i).getText().equals("selenium")) {
				list.get(i).click();
				break;
			}
		}
		driver.quit();
	}

}
