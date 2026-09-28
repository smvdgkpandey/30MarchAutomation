package PomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TextBoxPage {
WebDriver driver;
	
	public TextBoxPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//button[@data-target=\"#elements\"]")
	private WebElement elementsBtn;
	
	@FindBy(xpath="//a[text()='text box']")
	private WebElement textBoxBtn;
	
	@FindBy(xpath="//input[@id=\"fullname1\"]")
	private WebElement fullNameTextBox;
	
	@FindBy(xpath="//input[@id=\"fullemail1\"]")
	private WebElement emailTextBox;
	
	
	@FindBy(xpath="//textarea[@id=\"fulladdresh1\"]")
	private WebElement fulladdressTextArea;
	
	
	
	@FindBy(xpath="//textarea[@id=\"paddresh1\"]")
	private WebElement permanentAddressTextArea;
	
	
	
	@FindBy(xpath="//input[@value=\"Submit\"]")
	private WebElement submitButton;
	
	
	public void clickOnElementBtn() throws InterruptedException {
		Thread.sleep(1000);
		
		elementsBtn.click();
	}
	
	
	public void clickOntextBoxBtn() throws InterruptedException {
		Thread.sleep(1000);
		
		textBoxBtn.click();
	}
	
	
	public void enterFirstName(String firstname) throws InterruptedException {
Thread.sleep(1000);
fullNameTextBox.clear();
fullNameTextBox.sendKeys(firstname);
	}
	
	
	public void enterEmail(String email) throws InterruptedException {
		Thread.sleep(1000);
			emailTextBox.clear();	
		emailTextBox.sendKeys(email);
			}
	
	
	
	public void enterFullAddress(String fuladdress) throws InterruptedException {
		Thread.sleep(1000);
		fulladdressTextArea.clear();
		fulladdressTextArea.sendKeys(fuladdress);
			}
	
	
	
	
	public void enterPermanent(String pd) throws InterruptedException {
		Thread.sleep(1000);
		permanentAddressTextArea.clear();
		permanentAddressTextArea.sendKeys(pd);
			}
	
	
	
	
	public void clickOnSubmit() throws InterruptedException {
		Thread.sleep(1000);
				
		submitButton.click();
			}
	
	
	
	
	
	
	
	
	
	

}
