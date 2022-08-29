package utility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Parametrization {
	
	
	public static String getData(String name, int row,int cell) throws EncryptedDocumentException, IOException {
		
		FileInputStream file= new FileInputStream("C:\\Users\\Admin\\eclipse-workspace\\Zerodha\\src\\test\\resources\\TestData.xlsx");
		
		String value = WorkbookFactory.create(file).getSheet(name).getRow(row).getCell(cell).getStringCellValue();

		return value;
			
		

}
}