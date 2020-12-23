package util;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class utilities {
	public static WebDriver driver;

	public static void launchBrowser(String browserName) throws IOException {

		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");

			driver = new ChromeDriver();

		}

		else if (browserName.equalsIgnoreCase("firefox")) {

			System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver.exe");

			driver = new FirefoxDriver();
		}

		else if (browserName.equals("IE")) {
			System.setProperty("webdriver.ie.driver",
					System.getProperty("user.dir") + "src\\test\\resources\\drivers\\IEDriverServer.exe");
			driver = new FirefoxDriver();
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

	}

	public static void screenshot(WebDriver driver) {
		Date date = new Date();
		String dateStr = date.toString().replace(":", "-");

		TakesScreenshot screenshot = (TakesScreenshot) driver;

		File file = screenshot.getScreenshotAs(OutputType.FILE);

		file.renameTo(new File("src/test/resources/resources/Screenshots/screenshot " + dateStr + ".png"));
	}

}
