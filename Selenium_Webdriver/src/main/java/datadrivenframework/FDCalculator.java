package datadrivenframework;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FDCalculator {
	static WebDriver driver;

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws Exception {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.navigate().to(
				"https://www.moneycontrol.com/fixed-income/calculator/state-bank-of-india/fixed-deposit-calculator-SBI-BSB001.html");
		String filePath = System.getProperty("user.dir") + "\\testdata\\caldata.xlsx";
		int rows = ExcelUtils.getRowCount(filePath, "Sheet1");
		for (int i = 1; i <= rows; i++) {
			String price = ExcelUtils.getCellData(filePath, "Sheet1", i, 0);
			String rateOfInterest = ExcelUtils.getCellData(filePath, "Sheet1", i, 1);
			String per1 = ExcelUtils.getCellData(filePath, "Sheet1", i, 2);
			String per2 = ExcelUtils.getCellData(filePath, "Sheet1", i, 3);
			String fre = ExcelUtils.getCellData(filePath, "Sheet1", i, 4);
			String expectedValue = ExcelUtils.getCellData(filePath, "Sheet1", i, 5);

			driver.findElement(By.xpath("//input[@id='principal']")).sendKeys(price);
			driver.findElement(By.xpath("//input[@id='interest']")).sendKeys(rateOfInterest);
			driver.findElement(By.xpath("//input[@id='tenure']")).sendKeys(per1);
			driver.findElement(By.xpath("//input[@id='principal']")).sendKeys(price);

			Select select = new Select(driver.findElement(By.xpath("//select[@id='tenurePeriod']")));
			select.selectByVisibleText(per2);

			Select fredrp = new Select(driver.findElement(By.xpath("//select[@id='frequency']")));
			fredrp.selectByVisibleText(fre);
			driver.findElement(By.xpath("//div[@class='cal_div']//a[1]")).click();

			String actualValue = driver.findElement(By.xpath("//span[@id='resp_matval']//strong")).getText();
			if (Double.parseDouble(expectedValue) == Double.parseDouble(actualValue)) {
				System.out.println("Test Passed");
				ExcelUtils.setCellData(filePath, "Sheet1", i, 7, "Passed");
				ExcelUtils.fillGreenColour(filePath, "Sheet1", i, 7);

			} else {
				System.out.println("Test failed");
				ExcelUtils.setCellData(filePath, "Sheet1", i, 7, "Failed");
				ExcelUtils.fillGreenColour(filePath, "Sheet1", i, 7);
			}
			driver.findElement(By.xpath("//img[@class='PL5']")).click();

		}
		driver.quit();
	}

}
