package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteExcel {
	public static void writeExcel(String value ) throws IOException
	{
		try
		{
		String excelPath="src/test/resources/logiin.xlsx";
	FileInputStream file= new FileInputStream(excelPath);
	XSSFWorkbook book = new XSSFWorkbook(file);
	XSSFSheet sheet=book.getSheetAt(0);
	sheet.createRow(0).createCell(1).setCellValue(value);
	FileOutputStream fos= new FileOutputStream(new File(excelPath));
	book.write(fos);
	book.close();
	fos.close();
	      
		}
		catch (FileNotFoundException e){
			e.printStackTrace();
		}
	
	
	}

}
