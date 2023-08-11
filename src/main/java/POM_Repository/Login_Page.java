package POM_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_Page 
{
	public Login_Page(WebDriver driver)
      {
	      PageFactory.initElements(driver,this);
          }
		
	//Declaration
	@FindBy(xpath="//input[@type='text']")
	private WebElement userTextField;
	
    @FindBy(xpath="//input[@type='password']")
    private WebElement passwordTextField;
    
    @FindBy(xpath="//input[@type='submit']")
    private WebElement SubmitButton;

    
  //getter methods
	public WebElement getUserTesxtField() {
		return userTextField;
	}

	public WebElement getPasswordTesxtField() {
		return passwordTextField;
	}

	public WebElement getSubmitButton() {
		return SubmitButton;
	}
	
	//Business Logics
	
	public void LoginToApp(String User_Name,String PWD)
	{
		userTextField.sendKeys(User_Name);
		passwordTextField.sendKeys(PWD);
		SubmitButton.click();
		
	   }
    
	}


