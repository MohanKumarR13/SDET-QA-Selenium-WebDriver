package selenium.javascriptexcecuter.demo;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FileUpload {
	static WebDriver driver;

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws Exception {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		URL url = new URL("https://davidwalsh.name/demo/multiple-file-upload.php");
		driver.navigate().to(url);
		driver.findElement(By.xpath("//ul[@id='fileList']"))
				.sendKeys("C:\\Users\\91995\\git\\SDET-QA-Selenium-WebDriver\\Selenium_Webdriver\\Test1.txt");
		if (driver.findElement(By.xpath("//ul[@id='fileList']//li")).getText().equals("Test1.txt")) {
			System.out.println("File is uploaded");
		} else {
			System.out.println("Upload Failed");
		}
		String file1 = "C:\\Users\\91995\\git\\SDET-QA-Selenium-WebDriver\\Selenium_Webdriver\\Test1.txt";
		String file2 = "C:\\Users\\91995\\git\\SDET-QA-Selenium-WebDriver\\Selenium_Webdriver\\Test2.txt";

		driver.findElement(By.xpath("//ul[@id='fileList']")).sendKeys(file1 + "\n" + file2);
		int noOfFiles = driver.findElements(By.xpath("//ul[@id='fileList']//li")).size();
		if (noOfFiles == 2) {
			System.out.println("All File is uploaded");
		} else {
			System.out.println("Upload Failed");
		}
		if (driver.findElement(By.xpath("//ul[@id='fileList']//li[1]")).getText().equals("Test1.txt")
				&& driver.findElement(By.xpath("//ul[@id='fileList']//li[2]")).getText().equals("Test1.txt")) {
			System.out.println("File names are match");
		} else {
			System.out.println("File names are not match");
		}
	}

}
