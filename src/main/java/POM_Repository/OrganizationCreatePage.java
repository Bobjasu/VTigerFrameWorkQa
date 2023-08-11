package POM_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationCreatePage {
	
	public OrganizationCreatePage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	//Declaration
	@FindBy(name="accountname")
	private WebElement OrgName;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveButton;

	//getter methods

	public WebElement getOrgName() {
		return OrgName;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}
	

	//Business logic for create  new org 
	public void CreateOrganization(String orgName)
	{
		OrgName.sendKeys(orgName);
		saveButton.click();
	}
}
