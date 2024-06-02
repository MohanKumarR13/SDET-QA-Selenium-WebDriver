package selenium.datepicker;

import java.net.URL;
import java.time.Month;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DatePicker {

	static WebDriver driver;
	static String yearr = "2026";
	static String month = "May";
	static String date = "10";

	static Month convertMonth(String month) {
		HashMap<String, Month> monthMap = new HashMap<String, Month>();
		monthMap.put("January", Month.JANUARY);
		monthMap.put("February", Month.FEBRUARY);
		monthMap.put("March", Month.MARCH);
		monthMap.put("April", Month.APRIL);
		monthMap.put("May", Month.MAY);
		monthMap.put("June", Month.JUNE);
		monthMap.put("July", Month.JULY);
		monthMap.put("August", Month.AUGUST);
		monthMap.put("September", Month.SEPTEMBER);
		monthMap.put("October", Month.OCTOBER);
		monthMap.put("November", Month.NOVEMBER);
		monthMap.put("December", Month.DECEMBER);

		Month vmonth = monthMap.get(month);
		if (vmonth == null) {
			System.out.println("Invalid Month");
		}
		return vmonth;

	}

	static void selectDate(WebDriver driver, String yearr, String month, String date) {
		WebElement year = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']"));
		Select select = new Select(year);
		select.selectByVisibleText(yearr);

		while (true) {
			String displayMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
			Month expectedMonth = convertMonth(month);
			Month currentMonth = convertMonth(displayMonth);

			int result = expectedMonth.compareTo(currentMonth);
			if (result < 0) {
				driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']")).click();

			} else if (result > 0) {
				driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();

			} else {
				break;
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
	}

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws Exception {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		URL url = new URL("https://testautomationpractice.blogspot.com/");
		driver.navigate().to(url);
		Thread.sleep(5000);
		//driver.switchTo().frame("frame-one796456169");
        JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("window.scrollBy(0,1000)");
		driver.findElement(By.xpath("//span[@class='icon_calendar']")).click();
		selectDate(driver, yearr, month, date);

	}
}
