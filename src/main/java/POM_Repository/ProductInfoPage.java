package POM_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Generic_Utilities.WebDriver_Utility;


public class ProductInfoPage extends WebDriver_Utility {
	public ProductInfoPage(WebDriver driver) {
		
		PageFactory.initElements(driver,this);
	}
	
	//Declaration
	
	@FindBy(xpath="//input[@title='Delete [Alt+D]']")
	private WebElement DeleteProduct;
	
	//getter methods
	public WebElement getDeleteProduct() {
		return DeleteProduct;
	}
	
	//Business logic for delete product
	public void deleteProduct(WebDriver driver)
	{
		DeleteProduct.click();
		switchToAlertAndAccept(driver);
	}

}
