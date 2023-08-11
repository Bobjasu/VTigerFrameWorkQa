package Practice;



import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.Test;

import Generic_Utilities.BaseClass;
import Generic_Utilities.Excel_Utility;
import Generic_Utilities.Java_Utility;
import Generic_Utilities.Property_Utility;
import Generic_Utilities.WebDriver_Utility;
import POM_Repository.Home_Page;
import POM_Repository.OrganizationCreatePage;
import POM_Repository.Organizations;
import POM_Repository.OrganizationsInfoPage;
import POM_Repository.Validation;

public class CreateOrganizationTest extends BaseClass {
	@Test
	public void CreateOrganization() throws Throwable {
		//Object Creation
		Excel_Utility elib=new Excel_Utility();
		Java_Utility jlib=new Java_Utility();
		WebDriver_Utility wlib=new WebDriver_Utility();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//step3
		//navigate to Organization
		Home_Page home=new Home_Page(driver);
		home.clickOrganization();
		
		//step4
		//navigate to create Org Page
		Organizations org=new Organizations(driver);
		org.clickPlusB();
		
		//step5
		//create organization
		int ranNum = jlib.getRanDomNum();
		String orgName = elib.getExcelData("Organization",0, 0)+ranNum;
		OrganizationCreatePage ocp=new OrganizationCreatePage(driver);
		ocp.CreateOrganization(orgName);
		
		//step6
		//validation
		Validation val=new Validation(driver);
		String expData = val.orgValidation(orgName);
		Assert.assertEquals(orgName, expData);
		
	}
	
	@Test
	public void m1()
	{
		System.out.println("m1 is running");
	}

}
