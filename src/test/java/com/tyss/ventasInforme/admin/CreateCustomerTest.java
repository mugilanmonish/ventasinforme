package com.tyss.ventasInforme.admin;

import org.testng.annotations.Test;

import com.tyss.ventasInforme.ObjectRepository.CustomerPage;
import com.tyss.ventasInforme.ObjectRepository.HomePage;

import genricUtility.BaseClass;

public class CreateCustomerTest extends BaseClass {
		@Test(retryAnalyzer = genricUtility.RetryImplementationClass.class)
		public void CreateCustomer() throws Throwable {
		int uniqueNumber = jUtils.getRandomNumber();
		String name = eUtils.readDataFromExcel("admin", 5, 0)+uniqueNumber;
		String lastname = eUtils.readDataFromExcel("admin", 5, 1);
		String phone = eUtils.readDataFromExcel("admin", 5, 2); 
		String firstNameUpdate = eUtils.readDataFromExcel("admin", 6, 0)+uniqueNumber;
		CustomerPage customer = new CustomerPage(driver);
		HomePage home = new HomePage(driver);
		wUtils.acceptAlert();
		home.getCustomerLink().click();
		customer.createCustomer(driver, name, lastname, phone, wUtils);
		customer.searchAndUpdateCustomer(driver, name, firstNameUpdate, lastname, phone, wUtils);
		customer.checkUpdatedCustomer(driver, firstNameUpdate, name);
		// Changes by mugilan
		//make change
		// Again made changes by mugilan.
	}
}