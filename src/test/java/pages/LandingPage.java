package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;

import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class LandingPage {

	@CacheLookup
	public static By usernameBox = By.xpath("//input[@id='ctl00_MainContent_username']");
	@CacheLookup
	public static By passswordBox = By.xpath("//input[@id='ctl00_MainContent_password']");
	@CacheLookup
	public static By loginBtn = By.xpath("//input[@id='ctl00_MainContent_login_button']");

	public static By ordpg = By.xpath("//a[contains(text(),'Order')]");

	public static By verorder = By.xpath("//td[contains(text(),'sanchit')]");

	public static By welcomeText = By.xpath("//tbody/tr[1]/td[2]/div[1]");

	public static By edito = By.xpath("//tbody/tr[2]/td[13]/input[1]");

	public static By cardexp = By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox1']");

	public static By updbtn1 = By.xpath("//a[@id='ctl00_MainContent_fmwOrder_UpdateButton']");

	public static By verifyexp = By.xpath("//td[contains(text(),'02/07')]");

	public static By verifycard = By.xpath("//tbody/tr[2]/td[10]");

	public static By titlead = By.xpath("//h2[contains(text(),'Edit Order')]");

	public static By editcity = By.xpath("//td[contains(text(),'delhi')]");

	public static By editzip = By.xpath("//td[contains(text(),'748')]");

	public static By lgot = By.xpath("//a[@id='ctl00_logout']");

	public static By cstcity = By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox3']");

	public static By cstZip = By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox5']");

	public static By viewprd = By.xpath("//ul/li[2]/a");

	public static void viewprdnav(WebDriver driver) {
		driver.findElement(viewprd).click();
	}

	public static void usernameBoxad(WebDriver driver) {

		driver.findElement(usernameBox).isDisplayed();

	}

	public static void passwordBoxad(WebDriver driver) {

		driver.findElement(passswordBox).isDisplayed();
	}

	public static void loginBtnad(WebDriver driver) {

		driver.findElement(loginBtn).isDisplayed();

	}

	public static void ordpgad(WebDriver driver) {

		driver.findElement(ordpg).click();
	}

	public static void usern(WebDriver driver, String username, String password) {

		driver.findElement(usernameBox).sendKeys(username);
		driver.findElement(passswordBox).sendKeys(password);
		driver.findElement(loginBtn).click();
	}

	@SuppressWarnings("deprecation")
	public static void verorderad(WebDriver driver) {

		String verm = "sanchit";

		String vern = driver.findElement(verorder).getText();

		Assert.assertEquals(verm, vern);
	}

	public static void welcomeTextad(WebDriver driver) {

		String expe = " Welcome, Tester! ";
		String wel = driver.findElement(welcomeText).getText();
		if (wel.contains(expe)) {
			System.out.println("user verified");
		}

	}

	public static void editad(WebDriver driver, String expirydate1) {

		driver.findElement(edito).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(cardexp).clear();
		driver.findElement(cardexp).sendKeys(expirydate1);
		driver.findElement(updbtn1).click();

	}

	public static void navedit(WebDriver driver) {

		driver.findElement(edito).click();
	}

	public static void verfedit(WebDriver driver) throws Throwable {
		Thread.sleep(3000);
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
		String edcity = driver.findElement(editcity).getText();
		String edzip = driver.findElement(editzip).getText();
		if (edcity.equals(edcity1)) {
			System.out.println("city verified");
		}

	}

	public static void lgout(WebDriver driver) {

		driver.findElement(lgot).click();
	}

	public static void verifyfnl(WebDriver driver) {

		String carde = " VISA ";
		String expd = " 12/19 ";
		String expd1 = driver.findElement(verifyexp).getText();
		String carde1 = driver.findElement(verifycard).getText();
		if (carde1.contains(carde)) {
			System.out.println("card verified");
		}
		if (expd1.contains(expd)) {
			System.out.println("date verified");
		}
	}
}
