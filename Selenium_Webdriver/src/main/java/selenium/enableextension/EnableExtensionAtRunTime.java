package selenium.enableextension;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class EnableExtensionAtRunTime {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		EdgeOptions edgeOptions = new EdgeOptions();
		File extension=new File(".\\SelectorHub.crx");
		edgeOptions.addExtensions(extension);
		
		WebDriver driver = new EdgeDriver(edgeOptions);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.navigate().to("https://text-compare.com/");
	}

	}


