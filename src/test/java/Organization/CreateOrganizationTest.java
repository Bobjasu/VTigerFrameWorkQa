package Organization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Generic_Utilities.BaseClass;
import Generic_Utilities.Excel_Utility;
import Generic_Utilities.Java_Utility;
import Generic_Utilities.Property_Utility;
import Generic_Utilities.WebDriver_Utility;
import POM_Repository.Home_Page;
import POM_Repository.Login_Page;
import POM_Repository.OrganizationCreatePage;
import POM_Repository.Organizations;
import POM_Repository.OrganizationsInfoPage;
import POM_Repository.Validation;
import io.github.bonigarcia.wdm.WebDriverManager;

@Listeners(Generic_Utilities.ListenerImplementationClass.class)
public class CreateOrganizationTest extends BaseClass {
	//@Test(groups="SomkeTest")
	@Test(retryAnalyzer=Generic_Utilities.RetryAnalayser.class)
	public void CreateOrganization() throws Throwable 
	{
		Property_Utility plib=new Property_Utility();
		/*String BROWSER = plib.getkeyValue("browser");
		
		WebDriver driver;
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
		}*/
		
		//Launching the browser
		/*String key = "webdriver.chrome.driver";
        String Value = "src\\main\\resources\\chromedriver.exe";
        System.setProperty(key, Value);
        WebDriver driver=new ChromeDriver();*/
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
        //driver.manage().window().maximize();
        
        
        //Fetching data from property file
        
       /*String Url = plib.getkeyValue("url");
        String User_Name = plib.getkeyValue("UserName");
        String PWD = plib.getkeyValue("Password");
        FileInputStream fi=new FileInputStream("./src/test/resources/commondata.properties.txt");
        Properties prop=new Properties();
        prop.load(fi);
        String Url = prop.getProperty("url");
        String User_Name = prop.getProperty("UserName");
        String PWD = prop.getProperty("Password");
        
        
        //Login to Vtiger Application
        driver.get(Url);
        Login_Page login=new Login_Page(driver);
        login.LoginToApp(User_Name, PWD);*/
        /*driver.findElement(By.xpath("//input[@type='text']")).sendKeys(User_Name);        
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys(PWD);
		driver.findElement(By.xpath("//input[@type='submit']")).click();*/
        
        //click on Organization Link
        Home_Page home=new Home_Page(driver);
        home.getOrganizationsLink().click();
        Assert.assertEquals(false, true);
		//driver.findElement(By.xpath("//a[.='Organizations']")).click();
        Organizations org=new Organizations(driver);
        OrganizationCreatePage orgpage=new OrganizationCreatePage(driver);
        
        org.clickPlusB();
		//driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		
		//Random class to avoid duplicate
		Java_Utility jlib=new Java_Utility();
		int ranNum = jlib.getRanDomNum();
		//Random ran=new Random();
		//int ranNum=ran.nextInt(1000);
		
		
		//Fetching data from excel sheet
		Excel_Utility elib=new Excel_Utility();
		String Org_Name = elib.getExcelDataByDataFormatter("Organization", 0, 0)+ranNum;
		/*FileInputStream fis=new FileInputStream("./src/test/resources/Vtiger.xlsx");
		Workbook book=WorkbookFactory.create(fis);
		Sheet Sheet_Name = book.getSheet("Organization");
		Row Row_num = Sheet_Name.getRow(0);
		Cell Cell_num = Row_num.getCell(0);
		String Org_Name = Cell_num.getStringCellValue()+ranNum;*/
		
		//Saving the application
		orgpage.CreateOrganization(Org_Name);
		/*driver.findElement(By.name("accountname")).sendKeys(Org_Name);		
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();*/
		
		
		Validation val=new Validation(driver);
		String expData = val.orgValidation(Org_Name);
		Assert.assertEquals(Org_Name, expData);
		
		//Thread.sleep(2000);
		//Validation
		//String actData=driver.findElement(By.xpath("//span[@id='dtlview_Organization Name']")).getText();
		//Assert.assertEquals(Org_Name, actData);
		/*if(actData.contains(Org_Name))
		{
			System.out.println("pass");
		}
		else
		{
			System.out.println("fail");
		}
		
		//SignOut from Vtiger
		//home.logout(driver);
	
		 driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		 driver.findElement(By.xpath("//a[.='Sign Out']")).click();*/	
		
	}

}
