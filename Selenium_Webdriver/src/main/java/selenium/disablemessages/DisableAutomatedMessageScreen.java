package selenium.disablemessages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class DisableAutomatedMessageScreen {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		EdgeOptions edgeOptions = new EdgeOptions();
		edgeOptions.setExperimentalOption("excludeSwitches", new String[] { "enable-automation" });
		WebDriver driver = new EdgeDriver(edgeOptions);
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
