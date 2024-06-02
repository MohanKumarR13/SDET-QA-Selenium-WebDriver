package selenium.handledropdown;

import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectDropDown {
	static WebDriver driver;

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws Exception {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		URL url = new URL("https://testautomationpractice.blogspot.com/");
		driver.navigate().to(url);

		WebElement dropdown = driver.findElement(By.xpath("//select[@id='country']"));
		Select select = new Select(dropdown);
		/*
		 * select.selectByVisibleText("France"); select.selectByValue("Japan");
		 */
		select.selectByIndex(1);
		List<WebElement> options = select.getOptions();
		System.out.println("No Of Options" + options);
		for (int i = 0; i < options.size(); i++) {
			options.get(i).click();
			System.out.println(options.get(i).getText());
		}
		
		for (WebElement opt:options) {
			System.out.println(opt.getText());
		}

		//

	}
}
