package POM_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class Product {
	public Product(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	//declaration
	@FindBy (xpath="//img[@title='Create Product...']")
	private WebElement plusImg;

	//getter methods
	public WebElement getPlusImg() {
		return plusImg;
	}
	//Business logic for click plus for create product
	public void clickProduct()
	{
		plusImg.click();
	}
		
}
	
	

