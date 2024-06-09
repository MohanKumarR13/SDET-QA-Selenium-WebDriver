package handle.svgelements;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleSvgElements {
	static WebDriver driver;

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws Exception {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[@class='oxd-main-menu-item active']")).click();
		driver.findElement(By.xpath("//a[@class='oxd-main-menu-item active']//*[name()='svg']")).click();
		driver.findElement(By.xpath("//button[@title='Timesheets']//[name()='svg']")).click();

	}
}
