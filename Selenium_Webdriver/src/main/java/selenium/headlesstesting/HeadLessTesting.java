package selenium.headlesstesting;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HeadLessTesting {
	static WebDriver driver;

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws Exception {
		EdgeOptions edgeOptions = new EdgeOptions();
		edgeOptions.addArguments("--headless=new");
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver(edgeOptions);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.navigate().to("https://demo.nopcommerce.com/");

		String act_title = driver.getTitle();
		if (act_title.equals("nopCommerce demo store")) {
			System.out.println("Test Passed");
		} else {
			System.out.println("Test Failed");
		}
	}

}
