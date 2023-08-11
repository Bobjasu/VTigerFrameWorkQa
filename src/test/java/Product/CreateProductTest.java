package Product;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import Generic_Utilities.BaseClass;
import Generic_Utilities.Excel_Utility;
import Generic_Utilities.Java_Utility;
import Generic_Utilities.Property_Utility;
import POM_Repository.CreateProductPage;
import POM_Repository.Home_Page;
import POM_Repository.Login_Page;
import POM_Repository.Product;
import POM_Repository.ProductInfoPage;
import POM_Repository.Validation;
import io.github.bonigarcia.wdm.WebDriverManager;


public class CreateProductTest extends BaseClass {
    @Test(groups="SmokeTest")
	public void CreateProduct() throws Throwable {
        //Launch browser
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
		}
		String key = "webdriver.chrome.driver";
		String value = "src\\main\\resources\\chromedriver.exe";
				
		System.setProperty(key, value);
		WebDriver driver=new ChromeDriver();
		
        String Url = plib.getkeyValue("url");
        String User_Name = plib.getkeyValue("UserName");
        String PWD = plib.getkeyValue("Password");
		FileInputStream fi=new FileInputStream("./src/test/resources/commondata.properties.txt");
		Properties prop=new Properties();
		prop.load(fi);
		String Url = prop.getProperty("url");
		String User_Name = prop.getProperty("UserName");
		String PWD = prop.getProperty("Password");
		
        driver.get(Url);
        Login_Page login=new Login_Page(driver);
        login.LoginToApp(User_Name, PWD);
        /*
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys(User_Name);
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys(PWD);
	    driver.findElement(By.xpath("//input[@type='submit']")).click();*/
        
        Home_Page home=new Home_Page(driver);
        Product pro=new Product(driver);
		CreateProductPage cp=new CreateProductPage(driver);
		home.clickProductLink();
		pro.clickProduct();
        /*driver.findElement(By.linkText("Products")).click();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();*/
		
		Java_Utility jlib=new Java_Utility();
		int ranNum = jlib.getRanDomNum();
		/*Random ran=new Random();
		int ranNum = ran.nextInt(1000);*/
		
		Excel_Utility elib=new Excel_Utility();
		String Product_Name=elib.getExcelData("Product", 0, 0)+ranNum;
		/*FileInputStream fis=new FileInputStream("src/test/resources/Vtiger.xlsx");
		Workbook book=WorkbookFactory.create(fis);
		Sheet SheetName = book.getSheet("Product");
		Row Row_Number = SheetName.getRow(0);
		Cell Cell_Number = Row_Number.getCell(0);
		String Product_Name = Cell_Number.getStringCellValue()+ranNum;*/
		
		cp.CreateNewProduct(Product_Name);
		/*driver.findElement(By.xpath("//input[@name='productname']")).sendKeys(Product_Name);
		driver.findElement(By.xpath("//input[@class='crmbutton small save']")).click();*/
		
		Validation val=new Validation(driver);
		String expData = val.proValidation(Product_Name);
		Assert.assertEquals(Product_Name, expData);
		
		/*String actData = driver.findElement(By.xpath("//span[@class='lvtHeaderText']")).getText();
		
		if(actData.contains(Product_Name))
		{
			System.out.println("pass");
		}
		else
		{
			System.out.println("fail");
		}
		//Thread.sleep(2000);
		
		//home.logout(driver);
		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		driver.findElement(By.xpath("//a[.='Sign Out']")).click();*/
		
	}
}
