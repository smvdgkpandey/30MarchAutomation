package Tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ActionsMethod {
	
	
	@Test()
	public void Doubleclick() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\eclipse-workspace\\March30Automation\\exece\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.astrovidhan.com/newdemo.html");
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//*[@id=\"elements-accordion\"]/div[1]/div[1]/h2/button")).click();
	driver.findElement(By.xpath("//a[text()='buttons']")).click();
	WebElement doublBtn=driver.findElement(By.xpath("//button[@ondblclick=\"doubletext()\"]"));
	
	Actions act=new Actions(driver);
	act.doubleClick(doublBtn).perform();
	WebElement rightClickBtn=driver.findElement(By.xpath("//button[@id=\"noContextMenu\"]"));
	act.contextClick(rightClickBtn).perform();
	
	
	}
	
	
	
	@Test()
	public void draggable() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\eclipse-workspace\\March30Automation\\exece\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.astrovidhan.com/newdemo.html");
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//button[@data-target=\"#interations\"]")).click();
		driver.findElement(By.xpath("//a[text()='draggable']")).click();
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@src=\"dragable.html\"]")));
		WebElement dragableElement=driver.findElement(By.xpath("//p[text()='I am draggable!']"));
	Actions act=new Actions(driver);
	act.dragAndDropBy(dragableElement, 200, 0).perform();
	
	}
	
	
	@Test()
	public void droppable() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\eclipse-workspace\\March30Automation\\exece\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.astrovidhan.com/newdemo.html");
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//button[@data-target=\"#interations\"]")).click();
		driver.findElement(By.xpath("//a[text()='droppable']")).click();
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@src=\"drop.html\"]")));
		WebElement src=driver.findElement(By.xpath("//*[@id=\"drag1\"]"));
		WebElement dest=driver.findElement(By.xpath("//div[@ondragover=\"allowDrop(event)\"]"));
	Actions act=new Actions(driver);
	act.clickAndHold(src).moveToElement(dest).release().build().perform();
	
	
	}
	
	
	@Test
	public void selectable() throws InterruptedException {
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
	
	
	
	}

}
