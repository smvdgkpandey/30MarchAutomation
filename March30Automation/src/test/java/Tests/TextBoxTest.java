package Tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import BasePackage.BaseClass;
import PomRepository.PracticeClass;
import PomRepository.TextBoxPage;

public class TextBoxTest  extends BaseClass{
	
	PracticeClass pc1;
	
	TextBoxPage pc;
	@BeforeClass
	public void setUpMethod() {
		System.out.println("step1");
		setUp("https://www.astrovidhan.com/newdemo.html","chrome");
		System.out.println("step2");
		pc=new TextBoxPage(driver);
		pc1=new PracticeClass(driver);
		System.out.println("step3");
	}
	
	
	

	
	
	@Test(priority=2)
	public void  clickOnnavigateToTextBoxPage() throws InterruptedException {
		pc.clickOnElementBtn();
		System.out.println("clicked on elementButton");
		
		pc.clickOntextBoxBtn();
		
		
	}
	
//	@Test(priority=3,dataProvider = "textBoxData",enabled=false)
//	public void filltheForm(String firstname, String email,String current, String permanent) throws InterruptedException {
//		pc.enterFirstName(firstname);
//		pc.enterEmail(email);
//		pc.enterFullAddress(current);
//		pc.enterPermanent(permanent);
//		//pc.clickOnSubmit();
//		
//		
//		Thread.sleep(3000);
//		
//	}
	
	
	
	@Test(priority=4 ,dataProvider = "firstDataProvider")
	public void fillFormUsingExcel(String first,String email,String fulladd,String perm) throws InterruptedException {
		
		String path="C:\\Users\\HP\\eclipse-workspace\\March30Automation\\TestData\\ExcelTestDAta.xlsx";
		pc.enterFirstName(first);
		pc.enterEmail(email);
		pc.enterFullAddress(fulladd);
		pc.enterPermanent(perm);
		pc.clickOnSubmit();
		
		
		Thread.sleep(3000);
		
	}
	
	
	@DataProvider(name="firstDataProvider")
	public Object[][]   getData(){
		return new Object[][] {
			{"name1","lastname1@gmail.com","addressssssss1","permanentaddress1"},
			{"name2","lastname2@gmail.com","addressssssss2","permanentaddress2"}
		};
	}
	
	@DataProvider(name="secondDataProvider")
	public Object[][]   getData1(){
		return new Object[][] {
			{"name3","lastname3@gmail.com","addresssssss3","permanentaddress3"},
			{"name4","lastname4@gmail.com","addresssssss4","permanentaddress4"}
		};
	}
	
	
	
	
	
	
	
	
//	@DataProvider(name="textBoxData")
//	public Object[][] getData(){
//		return new Object[][] {
//			{"Govind","email@gmail.com","absygyuuihiuftyg","ftyfyugyughuihui"},
//			{"Govind1","email1@gmail.com","fxfywghu9hiuwxd","ygywegyughuyhbuibixw"},
//			{"Govind2","email2@gmail.com","ftgywge7g87hx8xwed","gxgw8h8h8u8u8uhxw"}
//		};
//	}
	
	

}
