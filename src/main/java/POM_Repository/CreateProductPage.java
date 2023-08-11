package POM_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateProductPage {
	WebDriver driver;
	public CreateProductPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	//Declaration
	
	@FindBy(name="productname")
	private WebElement productName;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveButton;

	//Getter methods

	public WebElement getProductName() {
		return productName;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}
	
	//Business logic for create new product
	public void CreateNewProduct(String product)
	{
		productName.sendKeys(product);
		saveButton.click();
	}

}
