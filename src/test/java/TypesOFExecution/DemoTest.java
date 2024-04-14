package TypesOFExecution;

import org.testng.annotations.Test;

import genricUtility.BaseClass;

public class DemoTest  {
	
	@Test(groups ="smoke")
	public void DemoTest1() {
	//	wUtils.acceptAlert();
		System.out.println("<--DEMO TEST1-->");
	}
	@Test(groups = "functional")
	public void DemoTest2() {
	//	wUtils.acceptAlert();
		System.out.println("<--DEMO TEST2-->");
	}
	@Test
	public void DemoTest3() {
	//	wUtils.acceptAlert();
		System.out.println("<--DEMO TEST3-->");
	}
}
