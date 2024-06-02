package selenium.wait;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExplicityWaitDemo {
	static WebDriver driver;

	public static void main(String[] args) throws Exception {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		WebElement name = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
		name.sendKeys("Admin");

		WebElement pwd = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
		pwd.sendKeys("admin123");

		WebElement loginBtn = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Login']")));
		loginBtn.click();
	}
}
