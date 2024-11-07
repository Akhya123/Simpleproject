package utilities;
import org.apache.poi.ss.usermodel.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelUtil {

	private String path="C:\\Users\\AKHYAK\\eclipse-workspace\\simple\\src\\test\\resources\\PersonalInfo.xlsx";
	
	public Map<String,String> getData(int rownum) throws Exception
	{
		
		Map<String,String> data = new HashMap<>();
		
		FileInputStream fis= new FileInputStream(path);
		Workbook workbook = new XSSFWorkbook(fis);
		Sheet sheet = workbook.getSheetAt(0);
		Row headrow= sheet.getRow(0);
		Row datarow= sheet.getRow(rownum);
		
	//	System.out.println(headrow.getLastCellNum());
		
		for (int i=0; i<headrow.getLastCellNum();i++)
		{
			Cell headerCell = headrow.getCell(i);
			Cell dataCell= datarow.getCell(i);
			
			String key = headerCell.getStringCellValue();
			String value = dataCell.getStringCellValue();
			
			data.put(key, value);
		}
		
		return data;
		
		
			
			
					
	}
	
	
}
