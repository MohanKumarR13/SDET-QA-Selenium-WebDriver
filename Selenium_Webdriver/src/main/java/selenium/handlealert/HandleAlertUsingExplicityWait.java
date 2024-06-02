package selenium.handlealert;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleAlertUsingExplicityWait {
	static WebDriver driver;
	static Alert alert;

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws MalformedURLException, Exception {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		URL url = new URL("https://the-internet.herokuapp.com/javascript_alerts");
		driver.navigate().to(url);

		driver.findElement(By.xpath("//button[normalize-space()='Click for JS Alert']")).click();
		Thread.sleep(5000);
		alert = wait.until(ExpectedConditions.alertIsPresent());
		alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.accept();

		driver.findElement(By.xpath("//button[normalize-space()='Click for JS Confirm']")).click();
		Thread.sleep(5000);
		driver.switchTo().alert().accept();
		driver.switchTo().alert().dismiss();

		driver.findElement(By.xpath("//button[normalize-space()='Click for JS Prompt']")).click();
		Thread.sleep(5000);
		alert = driver.switchTo().alert();
		alert.sendKeys("Welcome");
		alert.accept();

	}
}