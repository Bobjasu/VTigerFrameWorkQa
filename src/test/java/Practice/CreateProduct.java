package Practice;

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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import Generic_Utilities.Property_Utility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateProduct {
	public static void main(String[] args) throws Throwable {
		WebDriver driver;
		Property_Utility plib=new Property_Utility();
		String BROWSER = plib.getkeyValue("browser");
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else
		{
			driver=new ChromeDriver();
		}
		
		
		/*String key = "webdriver.chrome.driver";
		String value = "src/main/resources/chromedriver.exe";
		
		System.setProperty(key, value);
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();*/
		
		FileInputStream fi=new FileInputStream("./src/test/resources/commondata.properties.txt");
		Properties prop=new Properties();
		prop.load(fi);
		String Url = prop.getProperty("url");
		String User_Name = prop.getProperty("UserName");
		String PWD = prop.getProperty("Password");
		
		driver.get(Url);
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(User_Name);
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(PWD);
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.xpath("(//a[.='Products'])[1]")).click();
		driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
		
		Random ran=new Random();
		int ranNum=ran.nextInt(1000);
		
		FileInputStream fis=new FileInputStream("./src/test/resources/Vtiger.xlsx");
		Workbook book=WorkbookFactory.create(fis);
		Sheet sheetName = book.getSheet("Product");
		Row Row_Number = sheetName.getRow(0);
		Cell Cell_Number = Row_Number.getCell(0);
		String Product_Name = Cell_Number.getStringCellValue();
		
		driver.findElement(By.xpath("//input[@name='productname']")).sendKeys(Product_Name);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		Thread.sleep(2000);
		
		WebElement Sign_Out_Logo = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		
		Actions act=new Actions(driver);
		act.moveToElement(Sign_Out_Logo).perform();
		WebElement Sign_Out = driver.findElement(By.xpath("//a[.='Sign Out']"));
		Sign_Out.click();
		
				
		
	}

}
