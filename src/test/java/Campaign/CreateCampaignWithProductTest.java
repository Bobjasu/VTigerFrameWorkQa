package Campaign;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
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
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import Generic_Utilities.BaseClass;
import Generic_Utilities.Excel_Utility;
import Generic_Utilities.Java_Utility;
import Generic_Utilities.Property_Utility;
import Generic_Utilities.WebDriver_Utility;
import POM_Repository.Campaigns;
import POM_Repository.CampaignsInfoPage;
import POM_Repository.CreateCampaignPage;
import POM_Repository.CreateProductPage;
import POM_Repository.Home_Page;
import POM_Repository.Login_Page;
import POM_Repository.Product;
import POM_Repository.ProductInfoPage;
import POM_Repository.Validation;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateCampaignWithProductTest extends BaseClass {
	@Test(groups="RegressionTest")
	public  void CreateCampaignWithProduct () throws Throwable {
		
		//Launching the Browser
		/*Property_Utility plib=new Property_Utility();
		String BROWSER = plib.getkeyValue("browser");
		
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
		String value = "src/main/resources/chromedriver.exe";
		System.setProperty(key, value);
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		//Fetching the data from Property_file
        String Url = plib.getkeyValue("url");
        String User_Name = plib.getkeyValue("UserName");
        String PWD = plib.getkeyValue("Password");
		FileInputStream fi=new FileInputStream("./src/test/resources/commondata.properties.txt");
		Properties prop=new Properties();
		prop.load(fi);
		String URL = prop.getProperty("url");
		String UN = prop.getProperty("UserName");
		String PWD = prop.getProperty("Password");
		
		//Login to Vtiger Application
        driver.get(Url);
        Login_Page login=new Login_Page(driver);
        login.LoginToApp(User_Name, PWD);*/
		/*driver.get(Url);
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(User_Name);
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(PWD);
		driver.findElement(By.xpath("//input[@type='submit']")).click();*/
		
		/*WebDriver_Utility wlib=new WebDriver_Utility();
		wlib.maximize(driver);*/
		
	   
		
        Home_Page home=new Home_Page(driver);
		home.clickProductLink();
		//driver.findElement(By.linkText("Products")).click();
		Product pro=new Product(driver);
		CreateProductPage cp=new CreateProductPage(driver);
		pro.clickProduct();
		//driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		
		//Random class
		Java_Utility jlib=new Java_Utility();
		int ranNum = jlib.getRanDomNum();
		/*Random ran=new Random();
		int ranNum = ran.nextInt(1000);*/
		
		//Fetching the data from excel sheet
		Excel_Utility elib=new Excel_Utility();
		String Product_name = elib.getExcelData("Product", 0, 0)+ranNum;
		/*FileInputStream fis=new FileInputStream("./src/test/resources/Vtiger.xlsx");
		Workbook book=WorkbookFactory.create(fis);
		Sheet sheetname=book.getSheet("Product");
		Row Row_num = sheetname.getRow(0);
		Cell Cell_num = Row_num.getCell(0);
		String Product_name = Cell_num.getStringCellValue()+ranNum;*/
		
		cp.CreateNewProduct(Product_name);
		//driver.findElement(By.name("productname")).sendKeys(Product_name);
		//save
		
		//driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		Validation val=new Validation(driver);
		String expPro = val.proValidation(Product_name);
		Assert.assertEquals(Product_name, expPro);
		
		home.clickOnCampaign(driver);
		
		/*WebElement More_Link = driver.findElement(By.xpath("//a[@href='javascript:;']"));
	    More_Link.click();*/
		//mousehover action
		/*Actions act=new Actions(driver);
		act.moveToElement(More_Link).perform();*/
		
		Campaigns cam=new Campaigns(driver);
		cam.clickCreate();
		/*driver.findElement(By.xpath("//a[@name='Campaigns']")).click();
		driver.findElement(By.xpath("//img[@title='Create Campaign...']")).click();*/
		
		Excel_Utility elib1=new Excel_Utility();
		String Campaign_name=elib1.getExcelData("Campaign", 0, 0)+ranNum;
		/*
		FileInputStream fis1=new FileInputStream("./src/test/resources/Vtiger.xlsx");
		Workbook wbook=WorkbookFactory.create(fis1);
		Sheet sheet_name=book.getSheet("Campaign");
		Row RowNum = sheet_name.getRow(0);
		Cell CellNum = RowNum.getCell(0);
		String Campaign_name = CellNum.getStringCellValue()+ranNum;*/
		
		CreateCampaignPage cpp=new CreateCampaignPage(driver);
		cpp.addCampaignName(Campaign_name);
		cpp.selProduct(driver,"Products&action",Product_name);
		/*driver.findElement(By.xpath("//input[@name='campaignname']")).sendKeys(Campaign_name);
		driver.findElement(By.xpath("//img[@title='Select']")).click();*/
		
		WebDriver_Utility wlib=new WebDriver_Utility();
		wlib.switchToWindow(driver,"Products&action");
		/*Set<String> allId = driver.getWindowHandles();
		Iterator<String> it = allId.iterator();
		while(it.hasNext())//org,prd,ctn,lead
		{
			String wid = it.next();//org
			driver.switchTo().window(wid);//org//prd
			String title = driver.getTitle();
			if(title.contains("Products&action"))
			{
				break;
			}
			
		}
		
		
		driver.findElement(By.name("search_text")).sendKeys(Product_name);
		driver.findElement(By.xpath("//input[@name='search']")).click();
		*/
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//a[.='"+Product_name+"']")).click();
		
		Thread.sleep(2000);
		
		WebDriver_Utility wlib1=new WebDriver_Utility();
		wlib1.switchToWindow(driver,"Campaigns&record");
		/*Set<String> allId1 = driver.getWindowHandles();
     	Iterator<String> it1 = allId1.iterator();
     	while(it1.hasNext())
     	{
     		String wid1 = it1.next();
     		driver.switchTo().window(wid1);
     		String title1 = driver.getTitle();
     		if(title1.contains("Campaigns&record"))
     		{
     			break;
     		}
     	}*/
		cpp.saveCampaign();
		//driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		//Thread.sleep(2000);
		
		Validation val1=new Validation(driver);
		String expCam = val1.CamValidation(Campaign_name);
		Assert.assertEquals(Campaign_name, expCam);
		/*String actData = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(actData.contains(Campaign_name))
		{
			System.out.println("pass");
		}
		else
		{
			System.out.println("fail");
		}
		
		home.logout(driver);
		
		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		driver.findElement(By.xpath("//a[.='Sign Out']")).click();*/
		
	}

}
