package Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Browser {
	public static void main(String[] args) throws Throwable {
		String key = "webdriver.chrome.driver";
		String value = "src\\main\\resources\\chromedriver.exe";
		
		System.setProperty(key, value);
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		
		FileInputStream fis=new FileInputStream("./src/test/resources/commondata.properties.txt");
		Properties prop=new Properties();
		prop.load(fis);
		
		
		String Url = prop.getProperty("url");
		driver.get(Url);
		
		String UN = prop.getProperty("UserName");
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys(UN);
		
		String PWD = prop.getProperty("Password");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys(PWD);
		
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		driver.findElement(By.xpath("//a[.='Organizations']")).click();
		
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		
		FileInputStream fi=new FileInputStream("./src/test/resources/Vtiger.xsls");
		Workbook book=WorkbookFactory.create(fi);
		Sheet sheetName = book.getSheet("Organization");
		Row rowNumber = sheetName.getRow(0);
		Cell cellNumber = rowNumber.getCell(0);
		String orgName=cellNumber.getStringCellValue();
		
		driver.findElement(By.name("accountname")).sendKeys(orgName);
		
		
		
	}

}

//1st push
