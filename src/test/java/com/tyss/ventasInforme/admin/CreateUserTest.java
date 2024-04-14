package com.tyss.ventasInforme.admin;


import org.testng.annotations.Test;

import com.tyss.ventasInforme.ObjectRepository.AccountsPage;
import com.tyss.ventasInforme.ObjectRepository.HomePage;
import com.tyss.ventasInforme.ObjectRepository.LoginPage;
import com.tyss.ventasInforme.ObjectRepository.PosPage;

import genricUtility.BaseClass;

public class CreateUserTest extends BaseClass{
	@Test
	public void CreateUser() throws Throwable {
		String employeeType = eUtils.readDataFromExcel("admin", 15, 0);
		String userUsername = eUtils.readDataFromExcel("admin", 15, 1);
		String userPassword = eUtils.readDataFromExcel("admin", 15, 2);
		LoginPage login = new LoginPage(driver);
		AccountsPage accounts = new AccountsPage(driver);
		HomePage home = new HomePage(driver);
		PosPage pos = new PosPage(driver);
		wUtils.acceptAlert();
		home.getAccountsLink().click();
		accounts.createUserAccount(userUsername, userPassword, employeeType, wUtils);
		home.logoutToApp();
		login.userLoginToApp(userUsername, userPassword);		
		wUtils.acceptAlert();
		pos.verifyUser();
	}
}
