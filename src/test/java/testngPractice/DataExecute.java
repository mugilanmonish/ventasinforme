package testngPractice;

import org.testng.annotations.DataProvider;

public class DataExecute {

	@DataProvider
	public Object[][] data() {
		Object[][] obj = new Object[1][3];

		obj[0][0] = "Qspiders";
		obj[0][1] = "Bangalore";
		obj[0][2] ="Automation";
		return obj;
	} 

}
