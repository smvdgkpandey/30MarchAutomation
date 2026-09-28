package PomRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WebTablesPage {
	
WebDriver driver;
	
	public WebTablesPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	@FindBy(xpath="//a[text()='web tables']")
	private WebElement webTableBtn;
	
	@FindBy(xpath="/html/body/div/form/div[1]/input")
	private WebElement nameInput;
	@FindBy(xpath="/html/body/div/form/div[2]/input")
	private WebElement emailInput;
	@FindBy(xpath="//button[text()='Save']")
	private WebElement saveButton;
	
	@FindBy(xpath="//iframe[@src=\"Webtable.html\"]")
	private WebElement webTableIframe;
	
	
	
	
	@FindBy(xpath="//table[@class=\"table table-bordered data-table\"]//tbody//tr/td[1]")
	private List<WebElement> nameData;
	
	public void clickOnWebTableBtn() {
		webTableBtn.click();
	}
	
	public void swichToWebTableFrame() {
		driver.switchTo().frame(webTableIframe);
	}
	
	
	public void enterfirstName(String name) {
		nameInput.sendKeys(name);
	}
	
	public void enterEmail(String email) {
		emailInput.sendKeys(email);
	}
	
	
	public void clickOnSaveBtn() {
		saveButton.click();
	}
	
	
	public boolean   isNamePresent(String name) {
		for(WebElement ele:nameData) {
			String str=ele.getText();
			if(str.equals(name)) {
				return true;
				
			}
		}
		return false;
	}
	
	
	public void editNameField(String name,String updateName) {
		driver.findElement(By.xpath("//td[text()='"+name+"']/parent::tr/descendant::button[text()='Edit']")).click();
	WebElement updateNameField=driver.findElement(By.xpath("//input[@value='"+name+"']"));
	updateNameField.clear();
	updateNameField.sendKeys(updateName);
	driver.findElement(By.xpath("//input[@value='"+name+"']/ancestor::tr/descendant::button[text()='Update']")).click();
	
	
	}

}
