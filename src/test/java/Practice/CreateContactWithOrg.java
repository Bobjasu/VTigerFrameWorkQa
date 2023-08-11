package Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import Generic_Utilities.Java_Utility;
import Generic_Utilities.Property_Utility;

public class CreateContactWithOrg {
	public static void main(String[] args) throws Throwable
	{
		
		//Launching the browser
		String key = "webdriver.chrome.driver";
		String value = "src/main/resources/chromedriver.exe";
		System.setProperty(key, value);
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		Thread.sleep(2000);
		
		//Fetching data from Property File
		Property_Utility plib=new Property_Utility();
        String Url = plib.getkeyValue("url");
        String User_Name = plib.getkeyValue("UserName");
        String PWD = plib.getkeyValue("Password");
		
		
		Thread.sleep(2000);
		
		//Login to Vtiger application
		driver.get(Url);
		driver.findElement(By.name("user_name")).sendKeys(User_Name);
		driver.findElement(By.name("user_password")).sendKeys(PWD);
		driver.findElement(By.id("submitButton")).click();
		
		Thread.sleep(2000);
		
		//Random class
		Java_Utility jlib=new Java_Utility();
		int ranNum = jlib.getRanDomNum();


		//Create Organization
		driver.findElement(By.xpath("//a[.='Organizations']")).click();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		
		
		
		//Fetching data for Org from excel sheet
		FileInputStream fis=new FileInputStream("./src/test/resources/Vtiger.xlsx");
		Workbook book=WorkbookFactory.create(fis);
		Sheet SheetName = book.getSheet("Organization");
		Row RowNo = SheetName.getRow(0);
		Cell CellNo = RowNo.getCell(0);
		String OrgName = CellNo.getStringCellValue()+ranNum;
		
		driver.findElement(By.name("accountname")).sendKeys(OrgName);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		
		Thread.sleep(2000);
		
		//Create contact
		driver.findElement(By.xpath("//a[.='Contacts']")).click();
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		
		WebElement ele = driver.findElement(By.xpath("//select[@name='salutationtype']"));
		Select sel=new Select(ele);
		sel.selectByValue("Mr.");
		
		//Fetching data for contact from Excel sheet
		Sheet Sheet2 = book.getSheet("Contacts");
		Row Row_num = Sheet2.getRow(1);
		Cell Cell_1 = Row_num.getCell(0);
		Cell Cell_2 = Row_num.getCell(1);
		String FirstName = Cell_1.getStringCellValue()+ranNum;
		String LastName = Cell_2.getStringCellValue()+ranNum;
		
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys(FirstName);
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(LastName);
		driver.findElement(By.xpath("(//img[@title='Select'])[1]")).click();
		
		Thread.sleep(2000);
		
		Set<String> allId = driver.getWindowHandles();
		Iterator<String> it = allId.iterator();
		while(it.hasNext())
		{
			String wid = it.next();
			driver.switchTo().window(wid);
			String title = driver.getTitle();
			if(title.contains("Accounts&action"))
			{
				break;
			}
		}
		driver.findElement(By.xpath("//input[@name='search_text']")).sendKeys(OrgName);
		driver.findElement(By.xpath("//input[@name='search']")).click();
				
		
		
		
	}

}
