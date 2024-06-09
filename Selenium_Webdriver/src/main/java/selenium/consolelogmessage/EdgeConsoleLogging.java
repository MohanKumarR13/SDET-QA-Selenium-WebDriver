package selenium.consolelogmessage;

import java.net.URL;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EdgeConsoleLogging {

	private WebDriver driver;

	@SuppressWarnings("deprecation")
	@BeforeMethod
	public void setUp() throws Exception {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		URL url = new URL("https://mypage.com/lander");
		driver.navigate().to(url);
		EdgeOptions caps = new EdgeOptions();
		LoggingPreferences logPrefs = new LoggingPreferences();
		logPrefs.enable(LogType.PERFORMANCE, Level.ALL);
		caps.setCapability(CapabilityType.TIMEOUTS, logPrefs);
		driver = new EdgeDriver(caps);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	public void analyzeLog() {
		LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
		for (LogEntry entry : logEntries) {
			System.out.println(new Date(entry.getTimestamp()) + " " + entry.getLevel() + " " + entry.getMessage());
			// do something useful with the data
		}
	}

	@Test
	public void testMethod() {
		driver.get("https://mypage.com/lander");
		// do something on page
		analyzeLog();
	}
}
