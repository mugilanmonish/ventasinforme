package com.tyss.ventasInforme.admin;

import org.testng.annotations.Test;

import com.tyss.ventasInforme.ObjectRepository.HomePage;
import com.tyss.ventasInforme.ObjectRepository.ProductPage;

import genricUtility.BaseClass;

public class CreatedProductTest extends BaseClass {
	@Test
	public void CreatedProduct() throws Throwable {
		String productCode = eUtils.readDataFromExcel("admin", 19, 0);
		String productName = eUtils.readDataFromExcel("admin", 19, 1);
		String description = eUtils.readDataFromExcel("admin", 19, 2);
		String quantity = eUtils.readDataFromExcel("admin", 19, 3);
		String onHand = eUtils.readDataFromExcel("admin", 19, 4);
		String price = eUtils.readDataFromExcel("admin", 19, 5);
		String categoryDd = eUtils.readDataFromExcel("admin", 19, 6);
		String supplierDd = eUtils.readDataFromExcel("admin", 19, 7);
		String dateStock = eUtils.readDataFromExcel("admin", 19, 8);
		HomePage home = new HomePage(driver);
		ProductPage product = new ProductPage(driver);
		wUtils.acceptAlert();
		home.getProductLink().click();
		product.addProduct(wUtils, productCode, productName, description, quantity, onHand, price, categoryDd, dateStock, supplierDd);
		home.getHomeLink();
		home.getViewAllProduct();
		product.productCheck(driver, productCode);
	}
}
