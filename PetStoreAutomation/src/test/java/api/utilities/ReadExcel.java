package api.utilities;

import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class ReadExcel {

	//This class is written for read the values in excel sheet. 

	@DataProvider(name="ExcelDataRead")
	public static String[][] getExcelData() {
		
		String Location = "./testdata/testsampledata.xlsx";
		
		XSSFWorkbook wbook = null;
		try {
			wbook = new XSSFWorkbook(Location);      //pass the excel file path in string 'location'
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		
		XSSFSheet sheet = wbook.getSheetAt(0); //this defined which sheet needs to read from excel file
		
		int lastRowNum =  sheet.getLastRowNum();  //getLastRowNum - won't consider header for total count of rows
		int physicalNumberofRows = sheet.getPhysicalNumberOfRows();   //getPhysicalNumberofRows - will consider header also for total count of rows
		
		System.out.println("No.of Rows:" + " " + lastRowNum);
		System.out.println("Inclusive of header:" + " " + physicalNumberofRows);
		
		short lastCellNum =  sheet.getRow(0).getLastCellNum();  // to identify last cell number in the excel. or total no.of.column in excel
		
		System.out.println("No.of.Cells:" + " " + lastCellNum);
		
		String[][] data = new String [lastRowNum][lastCellNum]; // string name is data
		
		for (int i = 1; i <=lastRowNum; i++) {
			XSSFRow row = sheet.getRow(i); // this line will be starting point of row in excel file from mentioned number. example {1,nn}
			
			for (int j = 0; j < lastCellNum; j++) {
			XSSFCell cell = row.getCell(j); // this line will be starting point of column with respective to starting row in excel file from mentioned number. example {1,0},{1,1}
			
			//String value = cell.getStringCellValue(); // this line will display cell value but it doesn't work if the value is numberic, hence we have to use dataformatter.
			
			// In this example, Row (1,0) is koushik350@gmail.com, Row (1,1) is Pass123$ and Row (2,0) is koushik1@letcode.in, Row (2,1) is Pass123$, 
			//Row (3,0) is Sample data - fail test, Row (3,1) is Pass123$
			
			DataFormatter dft = new DataFormatter();
			String value = dft.formatCellValue(cell);
		
			data [i-1][j] = value;		
		}	
			
		}
		
        try {
			wbook.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
          
		return data;
	}

}
