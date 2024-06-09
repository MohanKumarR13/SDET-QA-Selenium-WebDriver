package selenium.brokenlinks;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenLinks {
	static WebDriver driver;

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.navigate().to("http://www.deadlinkcity.com/");
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("Total Number Of Links" + links.size());
		int noOfBrokenLinks = 0;
		for (WebElement linkElement : links) {
			String hrefAttValue = linkElement.getAttribute("href");
			if (hrefAttValue == null || hrefAttValue.isEmpty()) {
				System.out.println("href attribute value is null or empty. So Not possible to check");
				continue;
			}
			try {
				URL linkURL = new URL(hrefAttValue);
				HttpURLConnection conn = (HttpURLConnection) linkURL.openConnection();
				conn.connect();
				if (conn.getResponseCode() >= 400) {
					System.out.println(hrefAttValue + "=====> Broken Link");
					noOfBrokenLinks++;
				} else {
					System.out.println(hrefAttValue + "=====> Not Broken Link");

				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		System.out.println("No Of Broken Links" + noOfBrokenLinks);
	}

}
