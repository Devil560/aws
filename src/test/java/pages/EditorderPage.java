package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EditorderPage {

	public static By titlead = By.xpath("//h2[contains(text(),'Edit Order')]");

	public static By cstcity = By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox3']");

	public static By cstZip = By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox5']");

	public static By updbtn1 = By.xpath("//a[@id='ctl00_MainContent_fmwOrder_UpdateButton']");

	public static By editcity = By.xpath("//td[contains(text(),'delhi')]");

	public static By editzip = By.xpath("//td[contains(text(),'230222')]");
	
	public static By lgot = By.xpath("//a[@id='ctl00_logout']");

	public static void verfedit(WebDriver driver) throws Throwable {

		String tle = driver.findElement(titlead).getText();

	}

	public static void filledit(WebDriver driver, String city1, String zip1) {

		driver.findElement(cstcity).clear();
		driver.findElement(cstcity).sendKeys(city1);
		driver.findElement(cstZip).clear();
		driver.findElement(cstZip).sendKeys(zip1);
		driver.findElement(updbtn1).click();
	}

	public static void vercityzip(WebDriver driver) {

		String edcity1 = " delhi ";
		String edzip1 = " 230222 ";
		String edcity = driver.findElement(editcity).getText();
		String edzip = driver.findElement(editzip).getText();
		if (edcity.equals(edcity1)) {
			System.out.println("city verified");
		}
		if (edzip.equals(edzip1)){
			System.out.println("zip verified");
		}

	}

	public static void lgout(WebDriver driver) {

		driver.findElement(lgot).click();
	}

}
