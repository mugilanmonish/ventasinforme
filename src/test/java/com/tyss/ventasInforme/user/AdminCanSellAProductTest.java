package com.tyss.ventasInforme.user;


import org.testng.annotations.Test;

import com.tyss.ventasInforme.ObjectRepository.HomePage;
import com.tyss.ventasInforme.ObjectRepository.PosPage;

import genricUtility.BaseClass;

public class AdminCanSellAProductTest extends BaseClass{
	@Test
	public void AdminCanSellAProduct() throws Throwable {
		String dropDown = eUtils.readDataFromExcel("user", 7, 0);
		String amount = eUtils.readDataFromExcel("user", 7, 1);
		HomePage home = new HomePage(driver);
		PosPage pos = new PosPage(driver);
		wUtils.acceptAlert();
		home.getPosLink().click();;
		pos.buyProduct(wUtils, dropDown, amount);
		pos.verifyAdmin();
	}
}
