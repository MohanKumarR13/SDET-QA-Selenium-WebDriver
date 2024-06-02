package selenium.keyboardactions;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SliderDemo {

	static WebDriver driver;

	@SuppressWarnings ("deprecation")
	public static void main(String[] args) throws Exception {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		URL url = new URL("https://www.jqueryscript.net/form/Price-Range-Slider-jQuery-UI.html");
		driver.navigate().to(url);
		driver.findElement(By.xpath("//*[normalize-space()='Demo']")).click();
		Thread.sleep(15000);
		Actions act=new Actions(driver);
		//Min Slider
		WebElement min_slider=driver.findElement(By.xpath("//div[@class='price-range-block']//span[1]"));
		System.out.println("Deafault Location of min slider :" +min_slider.getLocation());
		act.dragAndDropBy(min_slider, 100,249).perform();
		System.out.println("Location of the max slider after moving" +min_slider.getLocation());

		//Max Slider
		WebElement max_slider=driver.findElement(By.xpath("//span[2]"));
		System.out.println("Deafault Location of max slider :" +max_slider.getLocation());
		act.dragAndDropBy(max_slider, -100,249).perform();	
		System.out.println("Location of the max slider after moving" +max_slider.getLocation());
	}

}
