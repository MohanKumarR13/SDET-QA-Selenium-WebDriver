package selenium.addblock;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class AdBlocker {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		EdgeOptions edgeOptions = new EdgeOptions();
		File extension = new File(".\\uBlock-Orgin.crx");
		// File extension = new File(".\\AdBlocker.crx");

		edgeOptions.addExtensions(extension);

		WebDriver driver = new EdgeDriver(edgeOptions);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.navigate().to("https://text-compare.com/");
	}

}
