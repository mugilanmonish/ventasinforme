package com.tyss.ventasInforme.admin;

import org.testng.annotations.Test;

import com.tyss.ventasInforme.ObjectRepository.EditSupplierPage;
import com.tyss.ventasInforme.ObjectRepository.HomePage;
import com.tyss.ventasInforme.ObjectRepository.SupplierPage;

import genricUtility.BaseClass;

public class CreateSupplierTest extends BaseClass {
	@Test
	public void CreateSupplier() throws Throwable {
		int number = jUtils.getRandomNumber();
		String uniqueCompany = eUtils.readDataFromExcel("admin", 10, 0)+number;
		String proviceDd = eUtils.readDataFromExcel("admin", 10, 1);
		String cityDd = eUtils.readDataFromExcel("admin", 10, 3);
		String phoneNumber = eUtils.readDataFromExcel("admin", 10, 2);
		String UpdatedUniqueCompany = eUtils.readDataFromExcel("admin", 11, 0)+number;
		String UpdatedProviceDd = eUtils.readDataFromExcel("admin", 11, 1);
		String UpdatedPhoneNumber = eUtils.readDataFromExcel("admin", 11, 2);
		HomePage home = new HomePage(driver);
		SupplierPage supplier = new SupplierPage(driver);
		EditSupplierPage editSupplier = new EditSupplierPage(driver);
		wUtils.acceptAlert();
		home.getSupplierLink().click();
		supplier.createSupplier(driver, wUtils, uniqueCompany, cityDd, proviceDd, phoneNumber, uniqueCompany);
		editSupplier.editSupplier(UpdatedUniqueCompany, UpdatedPhoneNumber, UpdatedProviceDd);
		wUtils.acceptAlert();
		supplier.searchSupplier(driver, UpdatedUniqueCompany);
	}
}
