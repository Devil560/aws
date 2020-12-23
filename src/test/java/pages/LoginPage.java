package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	public static By loginlab = By.xpath("//input[@id='ctl00_MainContent_login_button']");
	
	
	public static void loginver(WebDriver driver){
		
		driver.findElement(loginlab).isDisplayed();
	}

}
