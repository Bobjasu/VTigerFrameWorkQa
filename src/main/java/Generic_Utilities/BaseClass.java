package Generic_Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import POM_Repository.Home_Page;
import POM_Repository.Login_Page;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public WebDriver driver;
	public static WebDriver sdriver;
	public Property_Utility plib=new Property_Utility();
	
	//@BeforeSuite(groups={"SmokeTest","RegressionTest"})
	@BeforeSuite
	public void BS() {
		System.out.println("DataBase Connection");
	}
	
	//@BeforeTest(groups={"SmokeTest","RegressionTest"})
	@BeforeTest
	public void BT() {
		System.out.println("Parallel Execution");
	}
	
	//@BeforeClass(groups={"SmokeTest","RegressionTest"})
	//@Parameters("BROWSER")
	@BeforeClass
	public void BC() throws Throwable
	//public void BC(String BROWSER) throws Throwable
	{
		
		String BROWSER = plib.getkeyValue("browser");
		
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		
		else if(BROWSER.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		else
		{
			driver=new ChromeDriver();
		}
		
		System.out.println("Launching the browser");
		sdriver=driver;
	}
	
	//@BeforeMethod(groups={"SmokeTest","RegressionTest"})
	@BeforeMethod
	public void BM() throws Throwable {
		//maximise
		WebDriver_Utility wlib=new WebDriver_Utility();
		wlib.maximize(driver);
		Property_Utility plib=new Property_Utility();
        String Url = plib.getkeyValue("url");
        String User_Name = plib.getkeyValue("UserName");
        String PWD = plib.getkeyValue("Password");
        //Login
        driver.get(Url);
        Login_Page login=new Login_Page(driver);
		login.LoginToApp(User_Name, PWD);
		System.out.println("Login to the application");
	}	
	
	//@AfterMethod(groups={"SmokeTest","RegressionTest"})
	@AfterMethod
	public void AM() {
		Home_Page home=new Home_Page(driver);
		home.logout(driver);
		System.out.println("Logout to the application");
	}

	//@AfterClass(groups={"SmokeTest","RegressionTest"})
	@AfterClass
	public void AC() {
		
		driver.quit();
		System.out.println("Close the browser");
	}
	
	//@AfterTest(groups={"SmokeTest","RegressionTest"})
	@AfterTest
	public void AT() {
		System.out.println("Parallel examination done");
	}
	
	//@AfterSuite(groups={"SmokeTest","RegressionTest"})
	@AfterSuite
	public void AS() {
		System.out.println("disconnect database");
	}
	

}
