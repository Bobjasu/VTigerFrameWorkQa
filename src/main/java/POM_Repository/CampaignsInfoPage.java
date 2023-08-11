package POM_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignsInfoPage {
	public CampaignsInfoPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}

}
