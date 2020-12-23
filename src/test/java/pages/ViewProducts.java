package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ViewProducts {
	
	public static By lgo = By.xpath("//a[@id='ctl00_logout']");	

	public static void tabverf(WebDriver driver){
		List<WebElement> rows = driver.findElements(By.xpath("//div/table/tbody/tr"));
		for(WebElement row : rows){
			 row.getText();
		}
	}
	
	public static void logoutf(WebDriver driver){
		driver.findElement(lgo).click();
	}
}
