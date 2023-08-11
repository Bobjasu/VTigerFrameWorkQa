package POM_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Organizations {
	public Organizations(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
		@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
		private WebElement createOrgImg;
		
		//getter mehods
		public WebElement getCreateOrgImg() {
			return createOrgImg;
		}
	    //Business logic for click plus button to create org
			public void clickPlusB()
			{
				createOrgImg.click();
			}
      }
	
	    


