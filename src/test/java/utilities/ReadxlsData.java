package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

public class ReadxlsData {
	
//	public static void main(String[] args) throws EncryptedDocumentException, IOException {
//		ReadxlsData red = new ReadxlsData();
//		red.getData("login");
//	}
	@DataProvider(name="rcpdata")
	public String[][] getData(Method m) throws EncryptedDocumentException, IOException {
		
		String excelsheetname = m.getName();
		File f =  new File(System.getProperty("user.dir")+"\\src\\test\\resources\\testdata\\Testdata.xlsx");
		FileInputStream fis = new FileInputStream(f);
		Workbook wb =  WorkbookFactory.create(fis);
		Sheet sheetname = wb.getSheet(excelsheetname) ;
		int totalrows = sheetname.getLastRowNum();
		System.out.println("rows are "+totalrows);
		Row rowCells = sheetname.getRow(0);
		int totalcol = rowCells.getLastCellNum();
		System.out.println("cols are "+totalcol);
		
		DataFormatter  format = new DataFormatter();
		String testData [][] = new String [totalrows][totalcol];
		for (int i=1; i<=totalrows; i++) {
			for (int j=0; j<totalcol; j++) {
				testData[i-1][j] = format.formatCellValue(sheetname.getRow(i).getCell(j));
				System.out.println(testData[i-1][j]);
			}
		}
		return testData;
		
		
		
		
		
		
		
		
	}

}
