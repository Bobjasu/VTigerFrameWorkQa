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
import org.openqa.selenium.chrome.ChromeDriver;

public class CreateContactwithOrganization 
{
	public static void main(String[] args) throws Throwable 
	{
		String key = "wedriver.chrome.driver";
		String value = "./src/main/resources/chromedriver.exe";
		
		System.setProperty(key, value);
		WebDriver driver= new ChromeDriver();
		
		driver.get("http://localhost:8888/");
		
		FileInputStream fi=new FileInputStream("./src/test/resources/commondata.properties.txt");
		Properties prop=new Properties();
		prop.load(fi);
		String Url = prop.getProperty("url");
		String UN = prop.getProperty("UserName");
		String PWD = prop.getProperty("Password");
		
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(Url);
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(UN);
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.xpath("//a[@href='index.php?module=Accounts&action=index']")).click();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		
		Random ran=new Random();
		int ranNum = ran.nextInt();
		
		FileInputStream fis=new FileInputStream("./src/test/resources/Vtiger.xlsx");
		Workbook book=WorkbookFactory.create(fis);
		Sheet SheetName = book.getSheet("");
		Row RowNum = SheetName.getRow(0);
		Cell CellNum = RowNum.getCell(0);
		String OrgName = CellNum.getStringCellValue()+ranNum;
		
		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(OrgName);
		
		
		
		
		
	}

}
