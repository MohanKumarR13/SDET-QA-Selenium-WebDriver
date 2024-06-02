package selenium.mouseactions;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DragAndDropAction {
	static WebDriver driver;

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws Exception {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		URL url = new URL("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");
		driver.navigate().to(url);
		Actions act = new Actions(driver);
		WebElement rome = driver.findElement(By.xpath("//*[@id='box6']"));
		WebElement italy = driver.findElement(By.xpath("//*[@id='box106']"));
		act.dragAndDrop(rome, italy).perform();

		WebElement washington = driver.findElement(By.xpath("//*[@id='box3']"));
		WebElement us = driver.findElement(By.xpath("//*[@id='box103']"));
		act.dragAndDrop(washington, us).perform();

	}
}
