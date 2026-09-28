package Tests;


import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import BasePackage.BaseClass;
import PomRepository.PracticeClass;
import PomRepository.RadioButtonPage;
import PomRepository.TextBoxPage;
import PomRepository.WebTablesPage;

public class WebTableTest extends BaseClass {
	PracticeClass pc1;
	RadioButtonPage rp;
	WebTablesPage wbp;
	
	TextBoxPage pc;
	@BeforeClass
	public void setUpMethod() {
		System.out.println("step1");
		setUp("https://www.astrovidhan.com/newdemo.html","chrome");
		System.out.println("step2");
		pc=new TextBoxPage(driver);
		pc1=new PracticeClass(driver);
		System.out.println("step3");
		rp=new RadioButtonPage(driver);
		
		wbp=new WebTablesPage(driver);
		
	}
	
	
	@Test(priority=1)
	public void navigateToWebTable() throws InterruptedException {
		pc.clickOnElementBtn();
		wbp.clickOnWebTableBtn();
		wbp.swichToWebTableFrame();
	}
	
	@Test(priority=2)
	public void validateNameTable() throws InterruptedException {
		String str="Govind";
		wbp.enterfirstName(str);
		wbp.enterEmail("Govind@gmail.com");
		wbp.clickOnSaveBtn();
		Thread.sleep(2000);
		boolean result=wbp.isNamePresent(str);
		Assert.assertTrue(result);
	}
	
	
	@Test(priority=3)
		public void validateEditFunctionality() {
			wbp.editNameField("Govind", "Govinda");
			boolean resultAfterUpdate=wbp.isNamePresent("Govinda");
			Assert.assertTrue(resultAfterUpdate);
			
		}
	
}
