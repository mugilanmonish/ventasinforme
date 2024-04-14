package com.tyss.ventasInforme.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genricUtility.WebDriverUtitlity;

public class AccountsPage {
	
	public AccountsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//h4/a[@type='button']")
	private WebElement plusIcon;
	
	@FindBy(xpath = "(//input[@name='username'])[2]")
	private WebElement usernameTxtFld;
	
	@FindBy(xpath = "(//input[@name='password'])[2]")
	private WebElement passwordTxtFld;
	
	@FindBy(xpath = "(//button[text()='Save'])[5]")
	private WebElement save;
	
	@FindBy(name = "empid")
	private WebElement employeeDropDown;
	
	public WebElement getUsernameTxtFld() {
		return usernameTxtFld;
	}

	public WebElement getPasswordTxtFld() {
		return passwordTxtFld;
	}

	public WebElement getSave() {
		return save;
	}

	public WebElement getPlusIcon() {
		return plusIcon;
	}
	
	public void createUserAccount(String username, String password, String ddValue, WebDriverUtitlity wUtil) throws InterruptedException {
		plusIcon.click();
		wUtil.handleDropDown(employeeDropDown, ddValue);
		Thread.sleep(700);
		usernameTxtFld.sendKeys(username);
		passwordTxtFld.sendKeys(password);
		save.click();
	}
}
