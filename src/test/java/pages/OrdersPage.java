package pages;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class OrdersPage {

	public static By product = By.xpath("//select[@id='ctl00_MainContent_fmwOrder_ddlProduct']");

	public static By quantity = By.xpath("//input[@id='ctl00_MainContent_fmwOrder_txtQuantity']");

	public static By calBtn = By.xpath("//tbody/tr[1]/td[1]/ol[1]/li[5]/input[2]");

	public static By priBtn = By.xpath("//input[@id='ctl00_MainContent_fmwOrder_txtUnitPrice']");

	public static By cstname = By.xpath("//input[@id='ctl00_MainContent_fmwOrder_txtName']");

	public static By cstaddress = By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox2']");

	public static By cstcity = By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox3']");

	public static By cststate = By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox4']");

	public static By cstZip = By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox5']");

	public static By cstcard = By.xpath("//input[@id='ctl00_MainContent_fmwOrder_cardList_0']");

	public static By cstcardnum = By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox6']");

	public static By cstexpdate = By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox1']");

	public static By clkprocess = By.xpath("//a[@id='ctl00_MainContent_fmwOrder_InsertButton']");

	public static By confmsg = By.xpath("//strong[contains(text(),'New order has been successfully added.')]");

	public static By vieword = By.xpath("//a[contains(text(),'View all orders')]");

	public static void productad(WebDriver driver) {

		Select prd = new Select(driver.findElement(product));
		prd.selectByVisibleText("FamilyAlbum");
	}

	public static void quantityad(WebDriver driver, String quantity1) {

		WebElement quan = driver.findElement(quantity);
		quan.sendKeys(quantity1);

	}

	public static void calBtnad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		driver.findElement(calBtn).click();
	}

	public static void verfqu(WebDriver driver) {

		String demo = "5";

		String ver = driver.findElement(quantity).getText();
		//Assert.assertEquals(ver, demo);

	}

	public static void verfpr(WebDriver driver) {

		int demo2 = 80;

		String ver1 = driver.findElement(priBtn).getText();
		//Assert.assertEquals(demo2, ver1);

	}

	public static void cstdetails(WebDriver driver, String name, String street, String city, String state,
			String zip) {

		driver.findElement(cstname).sendKeys(name);
		driver.findElement(cstaddress).sendKeys(street);
		driver.findElement(cstcity).sendKeys(city);
		driver.findElement(cststate).sendKeys(state);
		driver.findElement(cstZip).sendKeys(zip);

	}

	public static void cstcarddet(WebDriver driver, String cardnumber, String expirydate) {
		driver.findElement(cstcard).click();
		driver.findElement(cstcardnum).sendKeys(cardnumber);
		driver.findElement(cstexpdate).sendKeys(expirydate);
	}

	public static void verconfirmation(WebDriver driver) {
		String msg = "New order has been successfully added.";
		driver.findElement(clkprocess).click();
		String msg2 = driver.findElement(confmsg).getText();
		Assert.assertEquals(msg, msg2);
	}

	public static void viewordclk(WebDriver driver) {

		driver.findElement(vieword).click();
	}
}
