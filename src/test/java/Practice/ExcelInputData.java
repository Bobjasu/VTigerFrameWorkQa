package Practice;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelInputData {
	
	public static void main(String[] args) throws Throwable {
		
		Workbook book=WorkbookFactory.create(new FileInputStream("./src/test/resources/Vtiger.xlsx"));
		Sheet SheetName = book.getSheet("Campaign");
		int count=SheetName.getLastRowNum();
		for(int i=0;i<=count;i++)
		{
			Row row = SheetName.getRow(i);
			String firstCellData = row.getCell(0).getStringCellValue();
			String secondCellData = row.getCell(1).getStringCellValue();
			System.out.println(firstCellData+"\t"+secondCellData);
		}
	}
}
