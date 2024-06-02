package selenium.dynamictable;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DynamicTable {
	static WebDriver driver;

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws Exception {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		URL url = new URL("https://demo.opencart.com/admin/index.php");
		driver.navigate().to(url);
		driver.findElement(By.xpath("//*[@id='input-username']")).sendKeys("demo");
		driver.findElement(By.xpath("//*[@id='input-password']")).sendKeys("demo");
		driver.findElement(By.xpath("//*[normalize-space()='Login']")).click();
		if (driver.findElement(By.xpath("//*[@class='btn-close']")).isDisplayed()) {
			driver.findElement(By.xpath("//*[@id='input-password']")).click();
		}
		driver.findElement(By.xpath("//*[@class='parent']")).sendKeys("demo");
		driver.findElement(By.xpath("//ul[@id='collapse-5']//a[contains(text(),'Customers')]")).click();

		String text = driver.findElement(By.xpath("//*[contains(text(),'Pages')]")).getText();
		int total_pages = Integer.parseInt(text.substring(text.indexOf("(") + 1, text.indexOf("Pages") - 1));
		for (int p = 1; p < total_pages; p++) {
			if (p > 1) {
				WebElement active_page = driver.findElement(By.xpath("//ul[@class='pagination']//*[text()=" + p + "]"));
				active_page.click();

				int noOfRows = driver
						.findElements(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr")).size();
				for (int i = 1; i <= noOfRows; i++) {

					String customerName = driver
							.findElement(By.xpath(
									"//table[@class='table table-bordered table-hover']//tbody//tr[" + i + "]//td[2]"))
							.getText();
					String email = driver
							.findElement(By.xpath(
									"//table[@class='table table-bordered table-hover']//tbody//tr[" + i + "]//td[3]"))
							.getText();

					String status = driver
							.findElement(By.xpath(
									"//table[@class='table table-bordered table-hover']//tbody//tr[" + i + "]//td[5]"))
							.getText();

					System.out.println(customerName + "\t" + email + "\t" + status);
				}
			}
		}

	}

}
