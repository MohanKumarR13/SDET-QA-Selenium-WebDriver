package selenium.keyboardactions;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class KeyBoardActions {
	static WebDriver driver;

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws Exception {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		URL url = new URL("https://text-compare.com/");
		driver.navigate().to(url);
		driver.findElement(By.xpath("//textarea[@id='inputText1']")).sendKeys("WELCOME");
		 Actions actions=new Actions(driver);
		 actions.keyDown(Keys.CONTROL).sendKeys("A").keyUp(Keys.CONTROL).perform();
		 
		 actions.keyDown(Keys.CONTROL).sendKeys("C").keyUp(Keys.CONTROL).perform();
		 
		 actions.keyDown(Keys.TAB).keyUp(Keys.TAB).perform();
		 
		 actions.keyDown(Keys.CONTROL).sendKeys("V").keyUp(Keys.CONTROL).perform();



	}
}