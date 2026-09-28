package Tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Wait {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\eclipse-workspace\\March30Automation\\Executables\\chromedriver.exe");	
	WebDriver driver=new ChromeDriver();
	
	driver.get("https://www.astrovidhan.com/newdemo.html");
	WebElement elemntsBtn=driver.findElement(By.xpath("//button[@data-target=\"#elements\"]"));
	clickableWaitingElement(elemntsBtn,driver).click();
	}
	
	
	
	public static  WebElement  clickableWaitingElement(WebElement ele,WebDriver driver) {
		WebDriverWait wait=new WebDriverWait(driver, 1000);
		
		return wait.until(ExpectedConditions.elementToBeClickable(ele));
	}
	
	public void  clickableWaitingElement(By element,WebDriver driver) {
		WebDriverWait wait=new WebDriverWait(driver, 1000);
		
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

}
