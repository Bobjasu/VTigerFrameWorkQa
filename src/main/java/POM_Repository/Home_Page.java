package POM_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Generic_Utilities.WebDriver_Utility;

public class Home_Page extends WebDriver_Utility
    {
	  WebDriver driver;
	  public Home_Page(WebDriver driver){
		  this.driver=driver;
		  PageFactory.initElements(driver,this);
	  }
	  
	  //Declaration
	  @FindBy (xpath="//a[text()='Calendar']")
	  private WebElement CalenderLink;
	  
	  @FindBy(xpath="//a[text()='Leads']")
	  private WebElement LeadsLink;
	  
	  @FindBy(xpath="//a[text()='Organizations']")
	  private WebElement OrganizationsLink;
	  
	  @FindBy(xpath="//a[text()='Contacts']")
	  private WebElement ContactsLink;
	  
	  @FindBy(xpath="//a[text()='Opportunities']")
	  private WebElement Opportunities;
	  
	  @FindBy(xpath="//a[text()='Products']")
	  private WebElement ProductsLink;
	  
	  @FindBy(xpath="//a[text()='Documents']")
	  private WebElement DocumentsLink;
	  
	  @FindBy(xpath="//a[text()='Email']")
	  private WebElement EmailLink;
	  
	  @FindBy(xpath="//a[text()='Trouble Tickets']")
	  private WebElement Trouble_TicketsLink;
	  
	  @FindBy(xpath="//a[text()='Dashboard']")
	  private WebElement DashboardLink;
	  
	  @FindBy(xpath="//a[text()='More']")
	  private WebElement MoreLink;
	  
	  @FindBy(name="Campaigns")
	  private WebElement CampaignLink;
	  
	  @FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	  private WebElement SignOutImg;
	  
	  @FindBy(xpath="//a[@href='index.php?module=Users&action=Logout']")
	  private WebElement SignOutLink;

	public WebElement getCalenderLink() {
		return CalenderLink;
	}

	public WebElement getLeadsLink() {
		return LeadsLink;
	}

	public WebElement getOrganizationsLink() {
		return OrganizationsLink;
	}

	public WebElement getContactsLink() {
		return ContactsLink;
	}

	public WebElement getOpportunities() {
		return Opportunities;
	}

	public WebElement getProductsLink() {
		return ProductsLink;
	}

	public WebElement getDocumentsLink() {
		return DocumentsLink;
	}

	public WebElement getEmailLink() {
		return EmailLink;
	}

	public WebElement getTrouble_TicketsLink() {
		return Trouble_TicketsLink;
	}

	public WebElement getDashboardLink() {
		return DashboardLink;
	}

	public WebElement getMoreLink() {
		return MoreLink;
	}
	
	public WebElement getCampaignLink() {
		return CampaignLink;
	}

	public WebElement getSignOutimg() {
		return SignOutImg;
	}

	public WebElement getSignOutLink() {
		return SignOutLink;
	}
	
	
	//Business logic for Organization
	public void clickOrganization()
	{
	   OrganizationsLink.click();
	}
	
	//Business logic for Product
	public void clickProductLink()
	{
		ProductsLink.click();
	}
	
	//Business logic for morelink
	public void clickOnMore()
	{
		MoreLink.click();
	}
	
	//Business logic for campaign
	public void clickOnCampaign(WebDriver driver)
	{
	    mouseOverOnElement(driver,MoreLink);
	    CampaignLink.click();
      }
	
	//Business logic for logout
	public void logout(WebDriver driver)
	{
		mouseOverOnElement(driver,SignOutImg);
		SignOutLink.click();;
	}
	
	
}
