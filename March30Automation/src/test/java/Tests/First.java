package Tests;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class First {
	

	
	
	@Test
	public void WebTables() throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\eclipse-workspace\\March30Automation\\exece\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.astrovidhan.com/newdemo.html");
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//*[@id=\"elements-accordion\"]/div[1]/div[1]/h2/button")).click();
		driver.findElement(By.xpath("//a[text()='web tables']")).click();
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@src=\"Webtable.html\"]")));
		driver.findElement(By.xpath("/html/body/div/form/div[1]/input")).sendKeys("Govind");
		driver.findElement(By.xpath("//input[@name=\"email\"]")).sendKeys("govindregas@gmail.com");
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		boolean valiDateName=isNameAvailable(driver,"Govind");
		Assert.assertTrue(valiDateName);
		boolean validateEmail=isEmailAvailable(driver,"govindregas@gmail.com");
		Assert.assertTrue(validateEmail);
	
	}
	
	
	public static boolean isNameAvailable(WebDriver driver,String name) throws InterruptedException {
		Thread.sleep(2000);
		List<WebElement> allNames=driver.findElements(By.xpath("//table[@class=\"table table-bordered data-table\"]/descendant::tbody//td[1]"));
	for(WebElement ele:allNames) {
		String text=ele.getText();
		if(text.equals(name)) {
			return true;
		}
	}
	return false;
	}
	
	
	public static boolean isEmailAvailable(WebDriver driver,String email) throws InterruptedException {
		Thread.sleep(2000);
		List<WebElement> allNames=driver.findElements(By.xpath("//table[@class=\"table table-bordered data-table\"]/descendant::tbody//td[2]"));
	for(WebElement ele:allNames) {
		String text=ele.getText();
		if(text.equals(email)) {
			return true;
		}
	}
	return false;
	}

}
