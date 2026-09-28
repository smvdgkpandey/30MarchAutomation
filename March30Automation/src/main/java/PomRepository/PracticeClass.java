package PomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class PracticeClass  {
	WebDriver driver;
	
	public PracticeClass(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@id=\"myModal2\"]/div/div/div[1]/button")
	private WebElement crossIcon;
	
	
	
	
	@FindBy(xpath="//a[text()='Practice']")
	private WebElement practiceMenuButton;
	
	
	public void clickOnCrossIcon() {
		crossIcon.click();
	}
	
	
	
	public void clickOnPracticeMenu() {
		practiceMenuButton.click();	}
	
	
	
	
	
	

}
