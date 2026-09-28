package Tests;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;



public class Widgets {
	
	
//	@Test(enabled=false)
//	public void accordian() {
//		System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\eclipse-workspace\\March30Automation\\exece\\chromedriver.exe");
//		WebDriver driver=new ChromeDriver();
//		driver.get("https://www.astrovidhan.com/newdemo.html");
//		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
//		driver.manage().window().maximize();
//		driver.findElement(By.xpath("//button[@data-target=\"#widget\"]")).click();
//		driver.findElement(By.xpath("//a[text()='accordion']")).click();
//		String str=driver.findElement(By.xpath("//div[@id=\"collapse1\"]//div")).getText();
//		System.out.println(str);
//		Assert.assertTrue(str.contains("So now we can begin adding Accordion Items (shown in green) to our new Accordion"));
//		
//	}
//	
//	
//	@Test(enabled=false)
//	public void autoComplete() throws InterruptedException {
//		System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\eclipse-workspace\\March30Automation\\exece\\chromedriver.exe");
//		WebDriver driver=new ChromeDriver();
//		driver.get("https://www.astrovidhan.com/newdemo.html");
//		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
//		driver.manage().window().maximize();
//		driver.findElement(By.xpath("//button[@data-target=\"#widget\"]")).click();
//		driver.findElement(By.xpath("//a[text()='auto complete']")).click();
//		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@src=\"Autocomplete.html\"]")));
//		String str="A";
//		driver.findElement(By.xpath("//input[@name=\"myCountry\"]")).sendKeys(str);
//		
//		List<WebElement> elemnts=driver.findElements(By.xpath("//div[@id=\"myInputautocomplete-list\"]//div//strong"));
//		for(WebElement ele:elemnts) {
//			String actualText=ele.getText();
//			Assert.assertEquals(actualText, str);
//		}
//		List<WebElement> allNames=driver.findElements(By.xpath("//div[@id=\"myInputautocomplete-list\"]//div//input"));
//		Thread.sleep(3000);
//		for(WebElement ele:allNames) {
//			Thread.sleep(1000);
//			String actualText=ele.getAttribute("value");
//			if(actualText.contains("fghanistan")) {
//				clickByJavascript(driver,ele);
//				break;
//			}
//		}
//	}
//	
//	public static void clickByJavascript(WebDriver driver,WebElement ele) {
//		JavascriptExecutor js=(JavascriptExecutor)driver;
//		js.executeScript("arguments[0].click();", ele);
//		
//	}
//	
//	@Test(enabled=false)
//	public void datePicker() {
//		System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\eclipse-workspace\\March30Automation\\exece\\chromedriver.exe");
//		WebDriver driver=new ChromeDriver();
//		driver.get("https://www.astrovidhan.com/newdemo.html");
//		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
//		driver.manage().window().maximize();
//		driver.findElement(By.xpath("//button[@data-target=\"#widget\"]")).click();
//		driver.findElement(By.xpath("//a[text()='date picker']")).click();
//		driver.findElement(By.xpath("(//input[@type=\"date\" and @class=\"form-control\"])[2]")).sendKeys("21-09-2026");
//		
//		WebElement dateandTime=driver.findElement(By.xpath("//input[@type=\"datetime-local\"]"));
//		dateandTime.sendKeys("21-09-2026");
//		dateandTime.sendKeys(Keys.TAB);
//		dateandTime.sendKeys("02:49");
//	}
	
	@Test(enabled=false)
	public void validateLinksOnSeleniumHQ() throws IOException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\eclipse-workspace\\March30Automation\\exece\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.selenium.dev/");
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		List<WebElement> allLinksElement=driver.findElements(By.tagName("img"));
		for(WebElement ele:allLinksElement) {
			String urlValue=ele.getAttribute("src");
			if(validateBroken(urlValue)) {
				System.out.println(urlValue+":       linek is working fine");
			}else {
				System.out.println(urlValue+":       linek is not working fine");
			}
		}
	}
	
	
	
	public  static boolean validateBroken(String urlValue) throws IOException {
		URL curl=new URL(urlValue);
		HttpURLConnection connection=(HttpURLConnection)curl.openConnection();
		connection.setRequestMethod("HEAD");
		int responseCode=connection.getResponseCode();
		if(responseCode==200) {
			return true;
		}else {
			return false;
		}
	}
	
	@Test(enabled=false)
	public void accordian() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\eclipse-workspace\\March30Automation\\exece\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.astrovidhan.com/newdemo.html");
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//button[@data-target=\"#widget\"]")).click();
		driver.findElement(By.xpath("//a[text()='accordion']")).click();
	String str=	driver.findElement(By.xpath("//div[@class=\"card-body\"]//p//b")).getText();
	Assert.assertEquals("Accordions are useful when you want to toggle between hiding and showing large amount of content:", str.trim());
	System.out.println(str);
	
	}
	
	
	@Test(enabled=false)
	public void autoComplete() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\eclipse-workspace\\March30Automation\\exece\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.astrovidhan.com/newdemo.html");
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//button[@data-target=\"#widget\"]")).click();
		driver.findElement(By.xpath("//a[text()='auto complete']")).click();
	driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@src=\"Autocomplete.html\"]")));
	driver.findElement(By.xpath("//input[@name=\"myCountry\"]")).sendKeys("A");
	List<WebElement> elemnts=driver.findElements(By.xpath("//div[@id=\"myInputautocomplete-list\"]//strong"));
		for(WebElement ele:elemnts) {
			Assert.assertTrue(ele.getText().contains("A"));
		}
	}
	
	
	@Test(enabled=true)
	public void datePicker() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\eclipse-workspace\\March30Automation\\exece\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.astrovidhan.com/newdemo.html");
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//button[@data-target=\"#widget\"]")).click();
		driver.findElement(By.xpath("//a[text()='date picker']")).click();
		driver.findElement(By.xpath("(//input[@type=\"date\"])[2]")).sendKeys("21-09-2026");
		WebElement ele=driver.findElement(By.xpath("//input[@type=\"datetime-local\"]"));
		ele.sendKeys("21-09-2026");
		ele.sendKeys(Keys.TAB);
		ele.sendKeys("08:38");

	}
	
	

}
