package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelFileUtility extends Constants 
{
	 File file;
	 DataFormatter formatter;
	 FileInputStream inputStream;
	 FileOutputStream outputStream;
	 XSSFWorkbook workbook;
	 XSSFSheet sheet;
	 XSSFRow row;
     int rowCount;
	String cellv[] = null;
	
	public void setup() throws IOException
	{
		file =    new File(filename);

	    formatter = new DataFormatter();

	    inputStream = new FileInputStream(file);
	    
	    workbook = new XSSFWorkbook(inputStream);

	    sheet = workbook.getSheet("Data");
	    


	}
	
	public int getNumberOfRows()
	{
		rowCount = sheet.getLastRowNum()-sheet.getFirstRowNum();
		return rowCount;
	}
		
	public String[] cellvalues(int rownumber) 
	{
		
		   row = sheet.getRow(rownumber);
		   String s[] = new String[5];
	       for (int j = 1; j < 3 ; j++) 
	       {
	    	   s[j-1]=formatter.formatCellValue(row.getCell(j));
	    	   
	       }
	       System.out.println("------------------------------------------------------------------------------");
	       System.out.println("File Name : "+s[0].toString());
	       System.out.println("Subject   : "+s[1].toString());
	       return s;
	} 
	public void pushNoOfKeywords(int row, String[] values)
	{
		String inline = "";
		
		for(int i=1;i<values.length;i++)
		   inline=inline+values[i]+", ";
		
		sheet.getRow(row).createCell(3).setCellValue(values[0]);
		sheet.getRow(row).createCell(4).setCellValue(inline);
		
	}
	public void pushNoOfKeywords(int row, String msg)
	{
		System.out.println(msg);
		sheet.getRow(row).createCell(3).setCellValue(msg);
		
		
	}
	public void savefile() throws IOException
	{
		inputStream.close();
	    outputStream = new FileOutputStream(file);
		workbook.write(outputStream);
		outputStream.close();
	}
}
