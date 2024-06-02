package selenium.statictable;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StaticTable {
	static WebDriver driver;

	@SuppressWarnings({ "unused", "deprecation" })
	public static void main(String[] args) throws Exception {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		URL url = new URL("https://testautomationpractice.blogspot.com/");
		driver.navigate().to(url);

		int rows = driver.findElements(By.xpath("//table[@name='BookTable']//tr")).size(); // Multiple table
		int row = driver.findElements(By.tagName("tr")).size(); // Single Table

		System.out.println("No Of Rows" + rows);

		int columns = driver.findElements(By.xpath("//table[@name='BookTable']//th")).size();
		int column = driver.findElements(By.tagName("tr")).size();

		System.out.println("No Of Columns" + columns);
		String bookName = driver.findElement(By.xpath("//table[@name='BookTable']//tr[5]//td[1]")).getText();
		System.out.println(bookName);

		for (int r = 2; r <= rows; r++) {
			for (int c = 1; c <= columns; c++) {
				String value = driver.findElement(By.xpath("//table[@name='BookTable']//tr[" + r + "]//td[" + c + "]"))
						.getText();
				System.out.println(value + "\t");

			}
			System.out.println();
		}
		for (int r = 2; r <= rows; r++) {
			String authorName = driver.findElement(By.xpath("//table[@name='BookTable']//tr[" + r + "]//td[2]"))
					.getText();
			System.out.println(authorName);

			if (authorName.equals("Mukesh")) {
				String book = driver.findElement(By.xpath("//table[@name='BookTable']//tr[" + r + "]//td[1]"))
						.getText();
				System.out.println(book + "\t" + authorName);
			}
		}
		int total = 0;
		for (int r = 2; r <= rows; r++) {
			String price = driver.findElement(By.xpath("//table[@name='BookTable']//tr[" + r + "]//td[4]")).getText();
			total = total + Integer.parseInt(price);

		}
		System.out.println("Total Price Of the Books " + total);
		driver.quit();
	}

}
