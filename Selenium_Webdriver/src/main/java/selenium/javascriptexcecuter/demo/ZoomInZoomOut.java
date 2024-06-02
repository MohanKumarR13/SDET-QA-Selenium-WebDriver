package selenium.javascriptexcecuter.demo;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ZoomInZoomOut {
	static WebDriver driver;

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws Exception {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		URL url = new URL("https://www.nopcommerce.com/");
		driver.navigate().to(url);
		driver.manage().window().minimize();

		Thread.sleep(5000);
		driver.manage().window().maximize();
		Thread.sleep(5000);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.body.style.zoom='50%'");
		Thread.sleep(5000);

		js.executeScript("document.body.style.zoom='80%'");
		Thread.sleep(5000);

		System.out.println(js.executeScript("return window.pageYOffset;"));

	}

}
