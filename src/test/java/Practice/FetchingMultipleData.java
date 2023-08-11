package Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchingMultipleData {
	public static void main(String[] args) throws Throwable {
		FileInputStream fis=new FileInputStream("src/test/resources/Vtiger.xlsx");
		Workbook book=WorkbookFactory.create(fis);
		Sheet sheetName = book.getSheet("Contacts");
		for(int i=0;i<=sheetName.getLastRowNum();i++)
		{
			Row rowNum = sheetName.getRow(i);
			for(int j=0;j<=rowNum.getLastCellNum();j++)
			{
				Cell cellNum = rowNum.getCell(j);
				DataFormatter dataFormatter=new DataFormatter();
				String data=dataFormatter.formatCellValue(cellNum);
				System.out.println(data);
			}
		}
		
	}

}
