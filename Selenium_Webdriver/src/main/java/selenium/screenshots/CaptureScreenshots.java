package selenium.screenshots;

import java.io.File;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CaptureScreenshots {
	static WebDriver driver;
	static File sourceFile;
	static File targetFile;

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws Exception {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		URL url = new URL("https://demo.nopcommerce.com/");
		driver.navigate().to(url);

		TakesScreenshot screenshot = (TakesScreenshot) driver;
		sourceFile = screenshot.getScreenshotAs(OutputType.FILE);
		targetFile = new File(System.getProperty("user.dir") + "\\screenshots\\fullpage.png");
		sourceFile.renameTo(targetFile);

		WebElement featureProducts = driver
				.findElement(By.xpath("//div[@class='product-grid home-page-product-grid']"));

		sourceFile = featureProducts.getScreenshotAs(OutputType.FILE);
		targetFile = new File(System.getProperty("user.dir") + "\\screenshots\\featureProducts.png");
		sourceFile.renameTo(targetFile);

		WebElement logo = driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']"));

		sourceFile = logo.getScreenshotAs(OutputType.FILE);
		targetFile = new File(System.getProperty("user.dir") + "\\screenshots\\logo.png");
		sourceFile.renameTo(targetFile);

		driver.quit();
	}

}
