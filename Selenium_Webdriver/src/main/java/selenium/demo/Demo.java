package selenium.demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Demo {
	static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("http://demo.opencart.com");

		String actTitle = driver.getTitle();
		if (actTitle.equals("Your Store")) {
			System.out.println("Test Passed");
		} else {
			System.out.println("Test Failed");
		}
		driver.close();

	}
}
