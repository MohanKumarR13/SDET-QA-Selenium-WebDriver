package selenium.keyboardactions;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OpenTheLinkInNewTab {
	static WebDriver driver;

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws Exception {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		URL url = new URL("https://demo.nopcommerce.com/");
		driver.navigate().to(url);
	WebElement registerBtn=	driver.findElement(By.xpath("//a[nomalize-space()='Register']"));
	registerBtn.click();
		 Actions actions=new Actions(driver);
		 actions.keyDown(Keys.CONTROL).click(registerBtn).keyUp(Keys.CONTROL).perform();
		 
		 List<String>ids=new ArrayList<String>(driver.getWindowHandles());
		 driver.switchTo().window(ids.get(1));
		 driver.findElement(By.xpath("//input[@id='FirstName']")).sendKeys("John KENEDY");
		 driver.switchTo().window(ids.get(0));
		 driver.findElement(By.xpath("//input[@id='small-searchitems']")).sendKeys("TShirts");




	}
}