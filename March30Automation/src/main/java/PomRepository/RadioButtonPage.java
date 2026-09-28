package PomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RadioButtonPage {
	
	
WebDriver driver;
	
	public RadioButtonPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[text()='radio buttons']")
	private WebElement radioBtnMenu;
	
	@FindBy(xpath="//input[@id=\"yes\"]")
	private WebElement yesRadioBtn;
	
	
	@FindBy(xpath="//input[@id=\"impressive\"]")
	private WebElement impressiveBtn;
	
	
	@FindBy(xpath="//input[@id=\"no\"]")
	private WebElement noBtn;
	
	
	
	@FindBy(xpath="//p[text()='You have selected yes']")
	private WebElement yesText;
	
	
	
	@FindBy(xpath="//p[text()='You have selected impressive']")
	private WebElement impressiveText;
	
	
	
	@FindBy(xpath="//p[text()='You have selected no']")
	private WebElement noText;
	
	
	public void clickOnRadioButtonMenu() {
		radioBtnMenu.click();
	}
	
	
	public void clickOnYesButton() throws InterruptedException {
		Thread.sleep(1000);
		yesRadioBtn.click();
	}

	public String yesTextAfterClick() throws InterruptedException {
		Thread.sleep(1000);
		return yesText.getText();
	}
	
	
	public void clickOnNoButton() throws InterruptedException {
		Thread.sleep(1000);
		noBtn.click();
	}

	public String noTextAfterClick() throws InterruptedException {
		Thread.sleep(1000);
		return noText.getText();
	}
	
	
	public void clickOnImpressiveButton() throws InterruptedException {
		Thread.sleep(1000);
		impressiveBtn.click();
	}

	public String impressiveTextAfterClick() throws InterruptedException {
		Thread.sleep(1000);
		return impressiveText.getText();
	}
	
	
	
	
	
}
