package POM_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Campaigns {
	
	public Campaigns(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	//declaration
	@FindBy (xpath="//img[@alt='Create Campaign...']")
	private WebElement plusImg;

	//getter methos
	public WebElement getPlusImg() {
		return plusImg;
	}
	
	//Business login for click on create campaign
	public void clickCreate()
	{
		plusImg.click();
	}

}
