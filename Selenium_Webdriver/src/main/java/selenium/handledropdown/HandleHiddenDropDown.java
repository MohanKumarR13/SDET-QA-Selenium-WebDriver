package selenium.handledropdown;

import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleHiddenDropDown {
	static WebDriver driver;

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws Exception {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		URL url = new URL("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.navigate().to(url);
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
		Thread.sleep(5000);
		driver.findElement(
				By.xpath("//span[@class='oxd-text oxd-text--span oxd-main-menu-item--name'][normalize-space()='PIM']"))
				.click();
		Thread.sleep(5000);

	WebElement list=	driver.findElement(By.xpath(
				"//body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/form[1]/div[1]/div[1]/div[6]/div[1]/div[2]/div[1]/div[1]/div[1]"))
				;list.click();
		Thread.sleep(5000);

		driver.findElement(By.xpath("//*[contains(text(),'Content Specialist')]")).click();

		List<WebElement> optionList = driver.findElements(By.xpath("//*[@role='listbox']//*"));
		System.out.println("No Of Options: " + optionList.size());

		for (WebElement op : optionList) {
			System.out.println(op.getText());
		}

	}
}
