package Tests;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class AprilActions {
	
	
//	@Test(enabled=false)
//	public void draggable() {
//		
//		System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\eclipse-workspace\\March30Automation\\exece\\chromedriver.exe");
//		WebDriver driver=new ChromeDriver();
//		driver.get("https://www.astrovidhan.com/newdemo.html");
//		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
//		driver.manage().window().maximize();
//		driver.findElement(By.xpath("//button[@data-target=\"#interations\"]")).click();
//		
//		driver.findElement(By.xpath("//a[text()='draggable']")).click();
//		WebElement iframe=driver.findElement(By.xpath("//iframe[@src=\"dragable.html\"]"));
//		driver.switchTo().frame(iframe);
//		WebElement src=driver.findElement(By.xpath("//p[text()='I am draggable!']"));
//		Actions act=new Actions(driver);
//		act.dragAndDropBy(src, 500, 500).perform();
//	
//	
//	}
	
	
	@Test
	public void droppable() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\eclipse-workspace\\March30Automation\\exece\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.astrovidhan.com/newdemo.html");
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//button[@data-target=\"#alerts\"]")).click();
		driver.findElement(By.xpath("//a[text()='browser windows']")).click();
		String parent=driver.getWindowHandle();
		System.out.println(parent);
		driver.findElement(By.xpath("//a[text()='New Window Message']")).click();
		WebDriverWait wait=new WebDriverWait(driver,2);
		wait.until(ExpectedConditions.numberOfWindowsToBe(2));
		Set<String>handles=driver.getWindowHandles();
		
	
		for(String str:handles) {
//			System.out.println(str);
			if(!str.equals(parent)) {
				driver.switchTo().window(str);
				System.out.println(str);
				break;
				
			}
		}
//		String al=driver.switchTo().alert().getText();
	//	System.out.println(al);
		driver.manage().window().maximize();
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.tagName("p"))));
		String str1=driver.findElement(By.tagName("p")).getText();
		System.out.println(str1);
		driver.quit();
//		driver.findElement(By.xpath("//a[text()='droppable']")).click();
//		WebElement iframe=driver.findElement(By.xpath("//iframe[@src=\"drop.html\"]"));
//		driver.switchTo().frame(iframe);
//		WebElement src=driver.findElement(By.xpath("//*[@ondragstart=\"drag(event)\"]"));
//		WebElement dest=driver.findElement(By.xpath("//div[@ondrop=\"drop(event)\"]"));
//		Actions act=new Actions(driver);
//		
//		
//		act.clickAndHold(src).moveToElement(dest).release().build().perform();

	
	
	}
	

}
