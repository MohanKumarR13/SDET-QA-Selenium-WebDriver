package selenium.handlessl;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class HandleSSL {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		EdgeOptions edgeOptions = new EdgeOptions();
		edgeOptions.setAcceptInsecureCerts(true);
		WebDriver driver = new EdgeDriver(edgeOptions);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.navigate().to("https://expired.badssl.com/");
		System.out.println(driver.getTitle());
	}

}
