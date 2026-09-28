package Tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class AlertsHandling {
	
	
	@Test(enabled=false)
	public void handleAlert() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\eclipse-workspace\\March30Automation\\exece\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.astrovidhan.com/newdemo.html");
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//button[@data-target=\"#alerts\"]")).click();
		driver.findElement(By.xpath("//a[text()='alerts']")).click();
		driver.findElement(By.xpath("//button[@onclick=\"myalert()\"]")).click();
		
		driver.switchTo().alert().accept();
		
		driver.findElement(By.xpath("//button[@onclick=\"aftersec5()\"]")).click();
		Thread.sleep(6000);
	driver.switchTo().alert().accept();
	driver.findElement(By.xpath("//button[@onclick=\"myconfirm()\"]")).click();
	driver.switchTo().alert().accept();
	Thread.sleep(6000);
	driver.findElement(By.xpath("//button[@onclick=\"myconfirm()\"]")).click();
	driver.switchTo().alert().dismiss();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//button[@onclick=\"myprompt()\"]")).click();
	Thread.sleep(2000);
	driver.switchTo().alert().sendKeys("Govind");
	driver.switchTo().alert().accept();
	
	
	}
	
	@Test(enabled=false)
	public void dropdownHandleByVisibleText() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\eclipse-workspace\\March30Automation\\exece\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.astrovidhan.com/newdemo.html");
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//button[@data-target=\"#widget\"]")).click();
		driver.findElement(By.xpath("//a[text()='select menu']")).click();
		WebElement firstDropdown=driver.findElement(By.xpath("//label[text()='Select Value']/../descendant::select"));
		Select sel=new Select(firstDropdown);
		sel.selectByVisibleText("Group 2, Option 2");
	
	
	}
	
	
	@Test
	public void dropdownHandleByIndex() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\eclipse-workspace\\March30Automation\\exece\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.astrovidhan.com/newdemo.html");
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//button[@data-target=\"#widget\"]")).click();
		driver.findElement(By.xpath("//a[text()='select menu']")).click();
		WebElement firstDropdown=driver.findElement(By.xpath("//label[text()='Select Value']/../descendant::select"));
		Select sel=new Select(firstDropdown);
		sel.selectByIndex(4);
	
	
	}
	
	
	@Test
	public void dropdownHandleByValue() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\eclipse-workspace\\March30Automation\\exece\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.wikipedia.org/");
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		WebElement countryDropdown=driver.findElement(By.xpath("//select[@name=\"language\"]"));
		Select sel=new Select(countryDropdown);
		sel.selectByVisibleText("Afrikaans");
		Thread.sleep(10000);
		sel.selectByIndex(1);//shqiq
		Thread.sleep(10000);
		sel.selectByValue("ar");
	
	
	}
	
	
	

}
