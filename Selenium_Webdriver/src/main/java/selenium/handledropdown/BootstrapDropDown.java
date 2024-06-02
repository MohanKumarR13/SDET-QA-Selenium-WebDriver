package selenium.handledropdown;

import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BootstrapDropDown {
	static WebDriver driver;

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws Exception {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		URL url = new URL("https://www.jquery-az.com/boots/demo.php?ex=63.0_2");
		driver.navigate().to(url);

		driver.findElement(By.xpath("//button[contains(@class,'multiselect')]")).click();

		driver.findElement(By.xpath("//input[@value='Java']")).click();

		List<WebElement> options = driver.findElements(By.xpath("//ul[contains(@class,'multiselect')]//label"));
		System.out.println("No Of Options" + options.size());

		for (WebElement op : options) {
			System.out.println(op.getText());
		}
		for (WebElement opt : options) {
			String option = opt.getText();
			if (option.equalsIgnoreCase("Java") || option.equalsIgnoreCase("Python")) {
				opt.click();
			}
		}

	}
}
