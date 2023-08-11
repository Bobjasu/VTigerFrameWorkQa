package POM_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class Validation {
	public Validation(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	//Declarations
	@FindBy (xpath="//span[@id='dtlview_Organization Name']")
	private WebElement OrganizationHeaderInfo;
	
	@FindBy(xpath="//span[@id='dtlview_Product Name']")
	private  WebElement ProductHeaderInfo;
	
	@FindBy(xpath="//span[@id='dtlview_Campaign Name']")
	private WebElement CampaignHeaderInfo;

	//getter methods
	public WebElement getOrganizationHeaderInfo() {
		return OrganizationHeaderInfo;
	}
	
	public WebElement getProductHeaderInfo() {
		return ProductHeaderInfo;
	}

	public WebElement getCampaignHeaderInfo() {
		return CampaignHeaderInfo;
	}
	
	//Business logic for Orginfo
	public String orgValidation(String data)
	{
		String actOrg = OrganizationHeaderInfo.getText();
		return actOrg;
		
	}
	
	//Business logic for Proinfo
	public String proValidation(String data)
	{
		String actPro = ProductHeaderInfo.getText();
		return actPro;
	}
	
	//Business logic for Campaigninfo
	public String CamValidation(String data)
	{
		String actCam = CampaignHeaderInfo.getText();
		return actCam;
	}

}
