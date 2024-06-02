package selenium.handlealert;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleAuthenticationPopup {
	static WebDriver driver;
	static Alert alert;

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws MalformedURLException, Exception {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		URL url = new URL("https://admin:admin@the-internet.herokuapp.com/basic_auth");
		driver.navigate().to(url);
		// Syntax
		// https://the-internet.herokuapp.com/basic_auth
		// https://username:password@the-internet.herokuapp.com/basic_auth

	}
}