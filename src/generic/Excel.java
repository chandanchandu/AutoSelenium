package generic;

import java.io.File;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel implements AutoConst{
	
	public static String getCellData(String path,String sheet,int r,int c) throws Exception{
		
		String v ="";
		
		try{
			Workbook wb = WorkbookFactory.create(new File(path));
			v=wb.getSheet(sheet).getRow(r).getCell(c).toString();
		}
		catch(Exception e){
			
		}
		
		return v;	
	}
	
	public static int getRowCount(String path,String sheet) throws Exception {
		
		int rc=0;
		
		try{
			Workbook wb = WorkbookFactory.create(new File(path));
			rc=wb.getSheet(sheet).getLastRowNum();			
		}
		catch(Exception e){
			
		}
		
		return rc;
		
	}
	
}
