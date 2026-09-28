package Tests;


import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import BasePackage.BaseClass;
import PomRepository.PracticeClass;


public class PracticeTests extends BaseClass {
	
	
	
	PracticeClass pc;
	@BeforeClass
	public void setUpMethod() {
		System.out.println("step1");
		setUp("https://demoqa.com/broken","chrome");
		System.out.println("step2");
		pc=new PracticeClass(driver);
		System.out.println("step3");
	}
	
	
	@Test(priority=1)
	public void clickOnCrossIcon() throws InterruptedException {
		System.out.println("step4");
		Thread.sleep(3000);
		pc.clickOnCrossIcon();
	}
	
	
	
	
	
	@Test(priority=2)
	public void clickOnPracticeMenu() throws InterruptedException {
		Thread.sleep(3000);
		pc.clickOnPracticeMenu();
	}
	

	
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
