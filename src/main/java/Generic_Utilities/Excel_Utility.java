package Generic_Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel_Utility {
	
	/**
	 * this method is used to fetch data from excel
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @return
	 * @throws Throwable
	 * @author utsab
	 */
	public String getExcelData(String sheetName,int rowNum,int cellNum) throws Throwable
	{
		FileInputStream fis=new FileInputStream("./src/test/resources/Vtiger.xlsx");
		Workbook book=WorkbookFactory.create(fis);
		Sheet Sheet_Name = book.getSheet(sheetName);
		Row Row_Num = Sheet_Name.getRow(rowNum);
		Cell Cell_Num = Row_Num.getCell(cellNum);
		String Value = Cell_Num.getStringCellValue();
		return Value;
		
	}
	/**
	 * Fetching data from excel by using dataformatter
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @return
	 * @throws Throwable
	 * @author utsab
	 */
	
	public String getExcelDataByDataFormatter(String sheetName,int rowNum,int cellNum) throws Throwable
	{
		FileInputStream fi=new FileInputStream("./src/test/resources/Vtiger.xlsx");
		Workbook book1=WorkbookFactory.create(fi);
		DataFormatter format=new DataFormatter();
		String data = format.formatCellValue(book1.getSheet(sheetName).getRow(rowNum).getCell(cellNum));
		return data;
   }
   /**
    * Fetching multiple data from excel shit with the help of data provider   
    * @param SheetName
    * @return
    * @throws Throwable
    * @author utsab
    */

    public Object[][] readMultipleData(String SheetName) throws Throwable
    {
    	FileInputStream fis1=new FileInputStream("./src/test/resources/Vtiger.xlsx");
    	Workbook book2=WorkbookFactory.create(fis1);
    	
    	Sheet sheet = book2.getSheet(SheetName);
    	int lastRow = sheet.getLastRowNum()+1;
    	int lastCell=sheet.getRow(0).getLastCellNum();
    	
    	Object[][] obj=new Object[lastRow][lastCell];
    	
    	for(int i=0;i<lastRow;i++)
    	{
    		for(int j=0;j<lastCell;j++)
    		{
    			obj[i][j] =sheet.getRow(i).getCell(j).getStringCellValue();
    		}
    	}
    	
		return obj;
    	
    }
}