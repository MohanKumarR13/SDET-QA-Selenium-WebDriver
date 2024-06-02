package selenium.datepicker;

import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DatePickerDemo {
	static WebDriver driver;
	static String year = "2026";
	static String month = "May";
	static String date = "10";

	static void selectFutureMonthAndYearDate(WebDriver driver, String year, String month, String date) {
		while (true) {

			String currentMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
			String currentYeart = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();

			if (currentMonth.equals(month) && currentYeart.equals(year)) {
				break;
			}
			driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
			// driver.findElement(By.xpath("//span[@class='ui-icon
			// ui-icon-circle-triangle-w']")).click();

		}
		List<WebElement> allDates = driver
				.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//tr/td//a"));
		for (WebElement dt : allDates) {
			if (dt.getText().equals(date)) {
				dt.click();
				break;
			}
		}
	}

	static void selectPastMonthAndYearDate(WebDriver driver, String year, String month, String date) {
		while (true) {

			String currentMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
			String currentYeart = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();

			if (currentMonth.equals(month) && currentYeart.equals(year)) {
				break;
			}
			 driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']")).click();

		}
		List<WebElement> allDates = driver
				.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//tr/td//a"));
		for (WebElement dt : allDates) {
			if (dt.getText().equals(date)) {
				dt.click();
				break;
			}
		}
	}
	
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws Exception {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		URL url = new URL("https://jqueryui.com/datepicker");
		driver.navigate().to(url);
		Thread.sleep(5000);
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//input[@id='datepicker']")).click();
		selectFutureMonthAndYearDate(driver, year, month, date);
		

	}
}
