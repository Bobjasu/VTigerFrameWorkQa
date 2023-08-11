package Campaign;

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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import Generic_Utilities.BaseClass;
import Generic_Utilities.Excel_Utility;
import Generic_Utilities.Java_Utility;
import Generic_Utilities.Property_Utility;
import POM_Repository.Campaigns;
import POM_Repository.CampaignsInfoPage;
import POM_Repository.CreateCampaignPage;
import POM_Repository.Home_Page;
import POM_Repository.Validation;

public class CreateCampaignTest extends BaseClass {
    @Test(groups={"SmokeTest","RegressionTest"})
	public void CreateCampaign() throws Throwable {
		
		/*String key = "webdriver.chrome.driver";
		String value = "src/main/resources/chromedriver.exe";
		
		System.setProperty(key, value);
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		Property_Utility plib=new Property_Utility();
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
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(User_Name);
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(PWD);
		driver.findElement(By.xpath("//input[@type='submit']")).click();*/
		
    	
		Home_Page home=new Home_Page(driver);
		home.clickOnCampaign(driver);
		/*WebElement more_button = driver.findElement(By.xpath("//img[@src='themes/softed/images/menuDnArrow.gif']"));
        
		Actions act=new Actions(driver);
		act.moveToElement(more_button).perform();
		WebElement campaign = driver.findElement(By.xpath("//a[@href='index.php?module=Campaigns&action=index']"));
		campaign.click();*/
		
		Campaigns cam=new Campaigns(driver);
		cam.clickCreate();;
		//driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		
		Java_Utility jlib=new Java_Utility();
		int ranNum = jlib.getRanDomNum();
		
		Excel_Utility elib=new Excel_Utility();
		String Campaign_name=elib.getExcelData("Campaign",0,0)+ranNum;
		/*FileInputStream fis=new FileInputStream("./src/test/resources/Vtiger.xlsx");
		Workbook book=WorkbookFactory.create(fis);
		Sheet Sheet_Name = book.getSheet("Campaign");
		Row Row_Num = Sheet_Name.getRow(0);
		Cell Cell_Num = Row_Num.getCell(0);
		String Campaign_name = Cell_Num.getStringCellValue()+ranNum;*/
		
		CreateCampaignPage ccp=new CreateCampaignPage(driver);
		ccp.addCampaignName(Campaign_name);
		ccp.saveCampaign();
		/*driver.findElement(By.xpath("//input[@name='campaignname']")).sendKeys(Campaign_name);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();*/
		
		Validation val=new Validation(driver);
		String expData = val.CamValidation(Campaign_name);
		Assert.assertEquals(Campaign_name, expData);
		//Thread.sleep(2000);
		
		//home.logout(driver);
		
       /* WebElement Sign_Out_Logo = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		
		Actions act1=new Actions(driver);
		act1.moveToElement(Sign_Out_Logo).perform();
		WebElement Sign_Out = driver.findElement(By.xpath("//a[.='Sign Out']"));
		Sign_Out.click();*/
		
	}

}
