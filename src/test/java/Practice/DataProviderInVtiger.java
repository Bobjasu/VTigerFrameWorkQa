package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Generic_Utilities.Java_Utility;
import Generic_Utilities.Property_Utility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DataProviderInVtiger {
	@Test(dataProvider="dataProvider_test")
	public void companyDetails(String name,String phnum,String email) throws Throwable {
		
	Property_Utility plib=new Property_Utility();
	String BROWSER = plib.getkeyValue("browser");
	
	WebDriver driver;
	if(BROWSER.contains("chrome"))
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
	}
	else if(BROWSER.contains("firefox"))
	{
		WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
	}
	else if(BROWSER.contains("edge"))
	{
		WebDriverManager.edgedriver().setup();
		driver=new EdgeDriver();
	}
	else
	{
		driver=new ChromeDriver();
	}
	
	driver.manage().window().maximize();
    driver.get("http://localhost:8888/");
    driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("admin");
    driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys("admin");
    driver.findElement(By.xpath("//input[@id='submitButton']")).click();
    
    driver.findElement(By.xpath("//a[.='Organizations']")).click();
    driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
    
    driver.findElement(By.name("accountname")).sendKeys(name);
    driver.findElement(By.name("phone")).sendKeys(phnum);
    driver.findElement(By.name("email1")).sendKeys(email);
    
    driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
    driver.quit();
	}
	
	@DataProvider
	   public Object[][] dataProvider_test()
	   {
		Java_Utility jlib=new Java_Utility();
		jlib.getRanDomNum();
		Object[][] objArr=new Object[3][3];
		objArr[0][0]="AAA1";
		objArr[0][1]="7980367991";
		objArr[0][2]="utsab@gmail.com";
		
		objArr[1][0]="BBB1";
		objArr[1][1]="8013550258";
		objArr[1][2]="tapanseba@gmail.com";
		
		objArr[2][0]="ccc1";
		objArr[2][1]="6582456812";
		objArr[2][2]="jasu@gmail.com";
		return objArr;
		
	   }
    
   
	
}