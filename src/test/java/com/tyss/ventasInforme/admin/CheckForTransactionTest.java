package com.tyss.ventasInforme.admin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.tyss.ventasInforme.ObjectRepository.HomePage;
import com.tyss.ventasInforme.ObjectRepository.LoginPage;
import com.tyss.ventasInforme.ObjectRepository.PosPage;
import com.tyss.ventasInforme.ObjectRepository.TransactionPage;

import genricUtility.ExcelUtility;
import genricUtility.FileUtility;
import genricUtility.WebDriverUtitlity;

public class CheckForTransactionTest {
	 	WebDriver driver;
		@Test	
		public void CheckForTransaction() throws Throwable {
		ExcelUtility eUtil = new ExcelUtility();
		FileUtility fUtil = new FileUtility();
		String browser = fUtil.readDataFromPropertyFIle("browser");
		String url = fUtil.readDataFromPropertyFIle("url");
		String adminUsername = eUtil.readDataFromExcel("admin", 1, 0);
		String adminPassword = eUtil.readDataFromExcel("admin", 1, 1);
		String userUsername = eUtil.readDataFromExcel("admin", 15, 1);
		String userPassword = eUtil.readDataFromExcel("admin", 15, 2);
		String dropDown = eUtil.readDataFromExcel("user", 7, 0);
		String amount = eUtil.readDataFromExcel("user", 7, 1);
		if(browser.equals("chrome")) {
			driver = new ChromeDriver();
		} else {
			driver = new FirefoxDriver();
		}
		WebDriverUtitlity wUtil = new WebDriverUtitlity(driver);
		LoginPage login = new LoginPage(driver);
		HomePage home = new HomePage(driver);
		PosPage pos = new PosPage(driver);
		TransactionPage transaction = new TransactionPage(driver);
		wUtil.maximizeWindow();
		wUtil.waitForEleImplicitly(5);
		driver.get(url);
		login.userLoginToApp(userUsername, userPassword);		
		wUtil.acceptAlert();
		pos.buyProduct(wUtil, dropDown, amount);
		home.logoutToApp();
		login.loginToApp(adminUsername, adminPassword);
		wUtil.acceptAlert();
		home.getTransactionLink().click();
		transaction.verifyTranscation(driver, dropDown);
		home.logoutToApp();
		driver.quit();
	}
}