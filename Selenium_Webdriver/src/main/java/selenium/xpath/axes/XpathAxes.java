package selenium.xpath.axes;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class XpathAxes {

	public static void main(String[] args) {
		WebDriver driver;
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://money.rediff.com/gainers/bse/daily/groupa");
		// Self- Selects the current node
		String text = driver.findElement(By.xpath("//a[contains(text(),'L&T')]/self::a")).getText();
		System.out.println(text);

		// Parent- Selects the parent of the node(always One)
		text = driver.findElement(By.xpath("//a[contains(text(),'L&T')]/parent::td")).getText();
		System.out.println(text);

		// Child- Selects all children of the current node(One or many)
		List<WebElement> child = driver.findElements(By.xpath("//a[contains(text(),'L&T')]/ancestor::tr/child::td"));
		System.out.println("Number Of Child Elements" + child.size());

		// Ancestor Selects all ancestors(parent,grandparent,etc)
		text = driver.findElement(By.xpath("//a[contains(text(),'L&T')]/ancestor::tr")).getText();
		System.out.println("Ancestor" + text);

		// Decendant Selects all decendants(children,grandchild,etc)of current node
		List<WebElement> decendants = driver
				.findElements(By.xpath("//a[contains(text(),'L&T')]/ancestor::tr/descendant::*"));
		System.out.println("Ancestor" + decendants.size());

		// ------------------------------------------------------//
		List<WebElement> follow = driver
				.findElements(By.xpath("//a[contains(text(),'L&T')]/ancestor::tr/preceding::tr"));
		System.out.println("Ancestor" + follow.size());

		List<WebElement> sib = driver
				.findElements(By.xpath("//a[contains(text(),'L&T')]/ancestor::tr/following-sibling::tr"));
		System.out.println("Ancestor" + sib.size());

		List<WebElement> preSib = driver
				.findElements(By.xpath("//a[contains(text(),'L&T')]/ancestor::tr/preceding-sibling::tr"));
		System.out.println("Ancestor" + preSib.size());
	}
}