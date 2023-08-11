package Practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Generic_Utilities.Excel_Utility;

public class DataProviderExcel {
	@Test (dataProvider ="getData")
	public void readData(String from,String to)
	{
		System.out.println(from+"-----------------"+to);
	}
	
	@DataProvider
	public Object[][] getData() throws Throwable
	{
		Excel_Utility elib=new Excel_Utility();
		Object[][] value = elib.readMultipleData("getdata");
		return value;
		
	}
	
	

}
