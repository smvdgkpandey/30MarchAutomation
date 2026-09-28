package Tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class NestedFrame {
@Test
	public void main1() throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\eclipse-workspace\\March30Automation\\exece\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.astrovidhan.com/newdemo.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@data-target=\"#alerts\"]")).click();
		//Thread.sleep(20000);
driver.findElement(By.xpath("//a[text()='nested frames']")).click();
//Thread.sleep(2000);
WebElement mainFrame=driver.findElement(By.xpath("//iframe[@src=\"target1.html\"]"));
driver.switchTo().frame(mainFrame);
WebElement textFrame=driver.findElement(By.xpath("//iframe[@src=\"text.html\"]"));
driver.switchTo().frame(textFrame);
WebElement childFrame=driver.findElement(By.xpath("//iframe[@src=\"example.html\"]"));
driver.switchTo().frame(childFrame);
driver.findElement(By.xpath("//a[text()='Click Here']")).click();
Thread.sleep(2000);
String textInsideFrame=driver.findElement(By.xpath("//p[text()='Hello']")).getText();
SoftAssert sf=new SoftAssert();
sf.assertEquals("Hello", textInsideFrame);

driver.switchTo().defaultContent();
driver.findElement(By.xpath("//button[@data-target=\"#elements\"]")).click();
//Thread.sleep(2000);
WebDriverWait wait=new WebDriverWait(driver, 10);
boolean isTextDisplayed=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='text box']"))).isDisplayed();

sf.assertTrue(isTextDisplayed);
sf.assertAll();
	}

}
