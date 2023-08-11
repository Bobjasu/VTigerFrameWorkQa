package Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Random;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Generic_Utilities.Property_Utility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DataProviderFromExcel {
	@Test (dataProvider="getData")
	public void companyDetails(String name,String phoneNum,String Email) throws Throwable
	{
		Property_Utility plib=new Property_Utility();
		String BROWSER = plib.getkeyValue("browser");
		
		WebDriver driver;
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
		driver.manage().window().maximize();
		driver.get("http://localhost:8888/");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.xpath("(//a[.='Organizations'])[1]")).click();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		
		Random ran=new Random();
		int ranNum = ran.nextInt(10000);
		
		driver.findElement(By.name("accountname")).sendKeys(name);
		driver.findElement(By.id("phone")).sendKeys(phoneNum);
		driver.findElement(By.id("email1")).sendKeys(Email);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		driver.quit();
	}
	
	@DataProvider
	public Object[][] getData() throws Throwable
	{
		FileInputStream fis=new FileInputStream("./src/test/resources/Vtiger.xlsx");
		Workbook book=WorkbookFactory.create(fis);
		Sheet sheet = book.getSheet("DataProvider");
		int  numrow=sheet.getPhysicalNumberOfRows();
		int numcell=sheet.getRow(0).getLastCellNum();
	
	Object[][] obj=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
	for(int i=0;i<sheet.getLastRowNum();i++)
	{
		for(int j=0;j<sheet.getRow(i+1).getLastCellNum();j++)
		{
			obj[i][j]=sheet.getRow(i).getCell(j).toString();
		}
	}
	return obj;
}
}
