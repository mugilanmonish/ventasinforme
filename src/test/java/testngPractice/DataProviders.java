package testngPractice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.apache.poi.ss.usermodel.Sheet;
import genricUtility.IPathConstant;

public class DataProviders {

	
	
	@Test(dataProvider = "data")
	public void getData(String org, String loc, String course) {
		System.out.println(org+" "+loc+" "+course);
	}
	
	@DataProvider
	public Object[][] data() {
		Object[][] obj = new Object[3][3];

		obj[0][0] = "Qspiders";
		obj[0][1] = "Bangalore";
		obj[0][2] ="Autmation";
		
		obj[1][0] = "Jspiders";
		obj[1][1] = "Qspiders";
		obj[1][2] = "Development";
		
		obj[2][0] = "TestYantra";
		obj[2][1] = "Katriguppe";
		obj[2][2] = "Office";
		return obj;
	} 
	
	@DataProvider (name = "readDataFromExcel")
	public Object[][] userdata() throws Throwable, IOException {
		FileInputStream fis = new FileInputStream(IPathConstant.ExcelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("dataProvider");
		int rowCount = sh.getLastRowNum();
		int cellCount = sh.getRow(0).getLastCellNum();
		System.out.println("rowCount "+rowCount);
		System.out.println("cellCount "+cellCount);
		Object[][] obj = new Object[rowCount][cellCount];
		for(int i = 0;i<rowCount; i++) {
			for(int j = 0; j<cellCount; j++) {
				obj[i][j] = sh.getRow(i).getCell(j).getStringCellValue();
			}
		}
		return obj;
	}
}
