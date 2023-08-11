package POM_Repository;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataP {
	@Test(dataProvider="dataprovider_test")
	
	public void bookTicket(String src,String dest) {
		System.out.println("Book Ticket from "+src+"to"+dest+" ");
		
	}

	@DataProvider
	public Object[][] dataprovider_test() throws Throwable
	{
		
		FileInputStream fis=new FileInputStream("./src/test/resources/Vtiger.xlsx");
		Workbook book=WorkbookFactory.create(fis);
		Sheet sheetname = book.getSheet(null);
		int lastRow = sheetname.getLastRowNum();
		short lastcell = sheetname.getRow(lastRow).getLastCellNum();
		Object[][] objArr=new Object[lastRow][lastcell];
		for(int i=0;i<lastRow;i++) {
			for(int j=0;j<lastcell;j++)
			{
				objArr[i][j] =sheetname.getRow(j).getCell(j).toString();
			}
			return objArr;
		}
		
		objArr[0][0]= "Bangalore";
		objArr[0][1]="Kolkata";
		
		objArr[1][0]="Mumbai";
		objArr[1][1]="Chennai";
		return objArr;
		
	}
	
}
