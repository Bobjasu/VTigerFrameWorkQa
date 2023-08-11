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
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import Generic_Utilities.BaseClass;
import Generic_Utilities.Excel_Utility;
import Generic_Utilities.Java_Utility;
import Generic_Utilities.Property_Utility;
import Generic_Utilities.WebDriver_Utility;
import Generic_Utilities.WebDriver_Utility;
import POM_Repository.CreateProductPage;
import POM_Repository.Home_Page;
import POM_Repository.Login_Page;
import POM_Repository.Product;
import POM_Repository.ProductInfoPage;

public class CreateProductDeleteProductTest extends BaseClass {
	@Test(groups="SmokeTest")
	public void CreateProductDeleteProduct() throws Throwable {
		/*String key = "webdriver.chrome.driver";
		String value = "src/main/resources/chromedriver.exe";
		
		System.setProperty(key, value);
		WebDriver driver=new ChromeDriver();
		
		
		Property_Utility plib=new Property_Utility();
        String Url = plib.getkeyValue("url");
        String User_Name = plib.getkeyValue("UserName");
        String PWD = plib.getkeyValue("Password");
        FileInputStream fi=new FileInputStream("./src/test/resources/commondata.properties.txt");
		Properties prop=new Properties();
		prop.load(fi);
		String URL = prop.getProperty("url");
		String UN = prop.getProperty("UserName");
		String PWD = prop.getProperty("Password");
		
		driver.get(Url);*/
		WebDriver_Utility wlib=new WebDriver_Utility();
		
		//driver.manage().window().maximize();
		
		//login
		/*Login_Page login=new Login_Page(driver);
		login.LoginToApp(User_Name, PWD);*/
		/*driver.findElement(By.xpath("//input[@type='text']")).sendKeys(User_Name);
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys(PWD);
	    driver.findElement(By.xpath("//input[@type='submit']")).click();*/
		
		//navigate to Product Page
		Home_Page home=new Home_Page(driver);
		home.clickProductLink();
		
		//navigate to create product page
		Product pro=new Product(driver);
		pro.clickProduct();
		/*driver.findElement(By.linkText("Products")).click();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();*/
		
		Java_Utility jlib=new Java_Utility();
		int ranNum = jlib.getRanDomNum();
		/*Random ran=new Random();
		int ranNum = ran.nextInt(2000);*/
		
		Excel_Utility elib=new Excel_Utility();
		String Product_Name=elib.getExcelData("Product", 0, 0)+ranNum;
		/*FileInputStream fis=new FileInputStream("./src/test/resources/Vtiger.xlsx");
		Workbook book=WorkbookFactory.create(fis);
		Sheet Sheet_Name = book.getSheet("Product");
		Row Row_Num = Sheet_Name.getRow(0);
		Cell Cell_Num = Row_Num.getCell(0);
		String Product_Name = Cell_Num.getStringCellValue()+ranNum;*/
		
		CreateProductPage cpp=new CreateProductPage(driver);
		cpp.CreateNewProduct(Product_Name);
		/*driver.findElement(By.xpath("//input[@name='productname']")).sendKeys(Product_Name);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();*/
		
		//Thread.sleep(2000);
		
		ProductInfoPage proin=new ProductInfoPage(driver);
		proin.deleteProduct(driver);
				
		/*driver.findElement(By.xpath("//input[@title='Delete [Alt+D]']")).click();
		wlib.switchToAlertAndAccept(driver);*/
		
		/*Alert alt=driver.switchTo().alert();
		alt.accept();
		
		home.logout(driver);
		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		driver.findElement(By.xpath("//a[.='Sign Out']")).click();*/
		
	}
	

}
