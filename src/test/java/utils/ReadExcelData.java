package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

public class ReadExcelData {
	
	
	@DataProvider(name="loginData")
	public String[][] getLoginData(Method m) throws EncryptedDocumentException, IOException {
		
		String eSheetData=m.getName();
		File f=new File(System.getProperty("user.dir")+"/src/test/resources/testdata/testdata.xlsx");
		FileInputStream fis=new FileInputStream(f);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sName=wb.getSheet(eSheetData);
		
		int totalRows=sName.getLastRowNum();
		System.out.println(totalRows);
		Row rowCells=sName.getRow(0);
		int totalCols=rowCells.getLastCellNum();
		System.out.println(totalCols);
		
		DataFormatter format=new DataFormatter();
		
		String testData[][]=new String[totalRows][totalCols]; 
		
		for(int i=1;i<=totalRows;i++){
			for(int j=0;j<totalCols;j++) {
				testData[i-1][j]=format.formatCellValue(sName.getRow(i).getCell(j));
				//System.out.println(testData[i-1][j]);
				
			}
		}
		return testData;
		
		
	}
	
	/*public static void main(String[] args) throws EncryptedDocumentException, IOException {
		ReadExcelData rED=new ReadExcelData();
		rED.getLoginData("loginData");
	}*/
	

}
