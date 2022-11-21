package loginTestCases;

import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class DataDrivenUsingApache {
	
	public void readexcel() throws IOException {
	FileInputStream excel=new FileInputStream("D:\\New folder\\TestData1.xlsx");
	Workbook workbook=new XSSFWorkbook(excel);
	Sheet sheet=workbook.getSheetAt(0);
	
	Iterator<Row> rowiterator=sheet.iterator();
	while(rowiterator.hasNext()) {
		Row rowvalue=rowiterator.next();
		
	Iterator<Cell> columniterator=rowvalue.iterator();
		while(columniterator.hasNext()) {
			Cell cellvalue=columniterator.next();
			
			System.out.println(cellvalue);
		}
	}
	}
	public static void main(String[] args) throws IOException {
		// example for using excel with apache
		DataDrivenUsingApache usingapache=new DataDrivenUsingApache();
		usingapache.readexcel();
	}
}
