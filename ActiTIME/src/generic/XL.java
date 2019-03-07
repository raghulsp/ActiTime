package generic;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class XL {
	public static int getRowCount(String path, String sheet) {
		int rc=-1;
		try {
			Workbook wb = WorkbookFactory.create(new FileInputStream(path));
			rc=wb.getSheet(sheet).getLastRowNum();
		}catch (Exception e) {
			
			e.printStackTrace();
		} 
		return rc;
		
		
	}
	public static String getData(String path,String sheet,int r, int c) {
		String v="";
		Workbook wb;
		try {
			wb = WorkbookFactory.create(new FileInputStream(path));
			v = wb.getSheet(sheet).getRow(r).getCell(c).toString();
		} catch (Exception e) {
			
			e.printStackTrace();
		} 
		return v;
		
		
		
	}

}
