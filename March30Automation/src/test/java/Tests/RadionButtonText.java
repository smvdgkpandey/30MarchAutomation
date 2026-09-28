package Tests;

import org.junit.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import BasePackage.BaseClass;
import PomRepository.PracticeClass;
import PomRepository.RadioButtonPage;
import PomRepository.TextBoxPage;

public class RadionButtonText extends BaseClass {
	PracticeClass pc1;
	RadioButtonPage rp;
	
	
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
		
		
	}
	
	
	

	
	
	@Test(priority=2)
	public void  clickOnnavigateToTextBoxPage() throws InterruptedException {
		pc.clickOnElementBtn();
		rp.clickOnRadioButtonMenu();
		
	}
	
	
	@Test(priority=3)
	public  void validateNoRadioButton() throws InterruptedException {
		rp.clickOnNoButton();
		String text=rp.noTextAfterClick();
		Assert.assertTrue(text.contains("no"));
	}
	
	
	@Test(priority=3)
	public  void validateimpessiveRadioButton() throws InterruptedException {
		rp.clickOnImpressiveButton();
		String text=rp.impressiveTextAfterClick();
		Assert.assertTrue(text.contains("impressive"));
	}
	
	
	@Test(priority=3)
	public  void validateYesRadioButton() throws InterruptedException {
		rp.clickOnYesButton();
		String text=rp.yesTextAfterClick();
		Assert.assertTrue(text.contains("yes"));
	}

}
