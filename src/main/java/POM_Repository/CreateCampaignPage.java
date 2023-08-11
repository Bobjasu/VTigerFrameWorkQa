package POM_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Generic_Utilities.WebDriver_Utility;

public class CreateCampaignPage extends WebDriver_Utility {

	public CreateCampaignPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
  //Declaration
	
	@FindBy (name="campaignname")
	private WebElement campaignName;
	
	@FindBy(xpath="//img[@title='Select']")
	private WebElement selProImgPlus;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveButton;
	
	@FindBy(name="search_text")
	private WebElement SearchText;
	
	@FindBy(xpath="//input[@name='search']")
	private WebElement clickSelected;

	//getter methods

	public WebElement getCampaignName() {
		return campaignName;
	}

	public WebElement getSelProImgPlus() {
		return selProImgPlus;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}

	public WebElement getSearchText() {
		return SearchText;
	}

	public WebElement getClickSelected() {
		return clickSelected;
	}
	
	//Business logic for add campaign name
	public void addCampaignName(String campaignname)
	{
		campaignName.sendKeys(campaignname);
	}
	
	//Business logic for select product for campaign
	public void selProduct(WebDriver driver,String PartialWindowTitle,String ProductData)
	{
		selProImgPlus.click();
		switchToWindow(driver, PartialWindowTitle);
		SearchText.sendKeys(ProductData);
		clickSelected.click();
		
	}
	

	//Business logic for save the campaign
	public void saveCampaign()
	{
		saveButton.click();
	}
}
