package BasePackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

import GenericUtility.ExcelUtility;
import GenericUtility.PropertyUtility;

public class BaseClass implements PropertyUtility,ExcelUtility {
	
	protected WebDriver driver;
	String configPath="C:\\Users\\HP\\eclipse-workspace\\March30Automation\\TestData\\config.properties";
	
	
	
	
	public void setUp(String url,String browser) {
		if(browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\eclipse-workspace\\March30Automation\\exece\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		System.out.println("initialised");
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
	}
	
	
	
	public void tearDown() {
		driver.quit();
	}



	@Override
	public String getDataFromProperty(String key) throws IOException {
		FileInputStream fis=new FileInputStream(configPath);
		Properties prop=new Properties();
		prop.load(fis);
		return prop.getProperty(key);
		
	}



	@Override
	public String getreadData(String path, int sheetno, int colno, int rowno) {
		String value="";
		try {
			FileInputStream fis = new  FileInputStream(path);
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			XSSFSheet sheet = wb.getSheetAt(sheetno);
			value=sheet.getRow(rowno).getCell(colno).getStringCellValue();
		} catch (Exception e) {
			System.out.println("issue in Get read data from excel "+e);
		}
		return value;
	}
	
	public void getScreenshot(String folder,String filename) throws IOException {
		String path=System.getProperty("user.dir");
		String finalPath=path+"//screenshots"+folder+"//"+filename+".png";
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File(finalPath));
	}
	
	@AfterMethod
	public void getResultAnalysis(ITestResult itestResult) throws IOException {
		String filename=itestResult.getMethod().getMethodName();
		if(itestResult.getStatus()==ITestResult.FAILURE) {
			getScreenshot("failed",filename);
		}
		else if(itestResult.getStatus()==ITestResult.SUCCESS) {
			getScreenshot("success",filename);
		}
	}

}
