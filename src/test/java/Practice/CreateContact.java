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
import org.openqa.selenium.support.ui.Select;

public class CreateContact {
	public static void main(String[] args) throws Throwable {
		String key = "webdriver.chrome.driver";
		String value = "src\\main\\resources\\chromedriver.exe";
				
		System.setProperty(key, value);
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		
		FileInputStream fi=new FileInputStream("./src/test/resources/commondata.properties.txt");
		Properties prop=new Properties();
		prop.load(fi);
		String Url = prop.getProperty("url");
		String User_Name = prop.getProperty("UserName");
		String PWD = prop.getProperty("Password");
		
		driver.get(Url);
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys(User_Name);
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys(PWD);
	    driver.findElement(By.xpath("//input[@type='submit']")).click();
	    driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		
		WebElement ele = driver.findElement(By.xpath("//select[@name='salutationtype']"));
	    Select sel=new Select(ele);
	    sel.selectByVisibleText(" Mr.");
	    
	    Random ran=new Random();
	    int ranNum = ran.nextInt();
	    
	    FileInputStream fis=new FileInputStream("./src/test/resources/Vtiger.xlsx");
		Workbook book=WorkbookFactory.create(fis);
		Sheet Sheet_Name = book.getSheet("Contacts");
		Row Row_num = Sheet_Name.getRow(1);
		Cell Cell_num = Row_num.getCell(0);
		String First_Name = Cell_num.getStringCellValue()+ranNum;
		Cell Cell_num2 = Row_num.getCell(1);
		String Last_Name = Cell_num2.getStringCellValue();
		Cell Cell_num3 =Row_num.getCell(2);
		double Ph_num = Cell_num3.getNumericCellValue();
		String Phnumber=Double.toString(Ph_num);
	    
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys(First_Name);
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(Last_Name);
		driver.findElement(By.xpath("//input[@name='mobile']")).sendKeys(Phnumber);
        driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		Thread.sleep(2000);
		
		 driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		 driver.findElement(By.xpath("//a[.='Sign Out']")).click();
		
		
	}

}
