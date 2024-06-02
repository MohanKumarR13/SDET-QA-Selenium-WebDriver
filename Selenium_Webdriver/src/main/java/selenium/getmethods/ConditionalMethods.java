package selenium.getmethods;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ConditionalMethods {
	static WebDriver driver;

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws Exception {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.nopcommerce.com/en/register?returnUrl=%2Fadmin%2F");
		// isDisplayed
		WebElement logo = driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']"));
		System.out.println("Display status of logo" + logo.isDisplayed());

		boolean status = driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']")).isDisplayed();
		System.out.println("Display status" + status);

		boolean statusEnable = driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']")).isEnabled();
		System.out.println("Enable status" + statusEnable);
		driver.quit();

		// isSelected()
		WebElement male = driver.findElement(By.xpath("//input[@id='gender-male']"));
		WebElement female = driver.findElement(By.xpath("//input[@id='gender-female']"));
		System.out.println("Before Selection");
		System.out.println(male.isSelected());
		System.out.println(female.isSelected());
		System.out.println("After selecting male...");
		male.click();
		System.out.println(male.isSelected());
		System.out.println(female.isSelected());

		System.out.println("After selecting female...");
		female.click();
		System.out.println(male.isSelected());
		System.out.println(female.isSelected());

		boolean newsLetters = driver.findElement(By.xpath("//input[@id='Newsletter']")).isSelected();
		System.out.println("News letter checkbox status" + newsLetters);

	}

}
