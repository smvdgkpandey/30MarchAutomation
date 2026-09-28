package Tests;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import BasePackage.BaseClass;

public class Actions2 extends BaseClass {
	@Test()
	public void selectable() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\eclipse-workspace\\March30Automation\\exece\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.astrovidhan.com/newdemo.html");
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//button[@data-target=\"#interations\"]")).click();
		
		driver.findElement(By.xpath("//a[text()='selectable']")).click();
		
		WebElement firstElement=driver.findElement(By.xpath("//li[text()=\"There’s no traffic after the extra mile.\"]"));
	Actions act=new Actions(driver);
	act.doubleClick(firstElement).perform();
	
	String color=firstElement.getCssValue("background-color");
	System.out.println(color);
	Assert.assertEquals(color, "rgba(0, 0, 255, 1)");
	
	
	
	
	}
	
	
	
	
	
	
	@Test()
	public void sortable() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\eclipse-workspace\\March30Automation\\exece\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.astrovidhan.com/newdemo.html");
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//button[@data-target=\"#interations\"]")).click();
		driver.findElement(By.xpath("//a[text()='sortable']")).click();
		List<WebElement> allElements=driver.findElements(By.xpath("//table[@id=\"myTable\"]//td[1]"));
		TreeSet<String> alldata=new TreeSet<String>();
		for(WebElement ele:allElements) {
			alldata.add(ele.getText());
		}
		driver.findElement(By.xpath("//button[text()='Sort']")).click();
		List<WebElement> afterSort=driver.findElements(By.xpath("//table[@id=\"myTable\"]//td[1]"));
		
		for(WebElement ele:afterSort) {
			Assert.assertEquals(ele.getText(), alldata.pollFirst());
		}	
	
	}
	
	
	@Test()
	public void tabHandling() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\eclipse-workspace\\March30Automation\\exece\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.astrovidhan.com/newdemo.html");
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//button[@data-target=\"#alerts\"]")).click();
		driver.findElement(By.xpath("//a[text()='browser windows']")).click();
		String parent=driver.getWindowHandle();
		driver.findElement(By.xpath("//a[@href=\"https://www.google.co.in/\"]")).click();
		Set<String> handles=driver.getWindowHandles();
		System.out.println(handles);
		System.out.println(driver.getTitle());
		for(String str:handles) {
			if(!str.equals(parent)) {
				driver.switchTo().window(str);
				break;
			}
		}
		System.out.println(driver.getTitle());
		
	
	
	
	
	}
	
	
	@Test()
	public void WindowHandling() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\eclipse-workspace\\March30Automation\\exece\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.astrovidhan.com/newdemo.html");
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//button[@data-target=\"#alerts\"]")).click();
		driver.findElement(By.xpath("//a[text()='browser windows']")).click();
		String parent=driver.getWindowHandle();
		driver.findElement(By.xpath("//a[text()='New Window']")).click();
		Set<String> handles=driver.getWindowHandles();
		System.out.println(handles);
		System.out.println(driver.getTitle());
		for(String str:handles) {
			if(!str.equals(parent)) {
				driver.switchTo().window(str);
				break;
			}
		}
		System.out.println(driver.getTitle());
	
	
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
