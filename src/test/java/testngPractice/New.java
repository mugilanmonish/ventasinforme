package testngPractice;

import org.testng.annotations.Test;

public class New {
	
	@Test(invocationCount = 0)
	public void create() {
		System.out.println("---Create--");
	}
	
	@Test(priority = 0, dependsOnMethods = "create")
	public void edit() {
		System.out.println("---Edit--");
	}
	
	@Test(priority = -1)
	public void delete() {
		System.out.println("--Delete---");
	}
}