package com.tyss.ventasInforme.ObjectRepository;

import static org.testng.Assert.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genricUtility.WebDriverUtitlity;

public class CustomerPage {

	public CustomerPage(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//h4/a[@type='button']")
	private WebElement plusIcon;

	@FindBy(name = "firstname")
	private WebElement firstnameTxtFld;

	@FindBy(name = "lastname")
	private WebElement lastnameTxtFld;

	@FindBy(name = "phonenumber")
	private WebElement phonenumberTxtFld;

	@FindBy(xpath = "(//button[text()='Save'])[1]")
	private WebElement saveBtn;

	@FindBy(xpath = "//input[@type='search']")
	private WebElement searchBar;

	@FindBy(xpath = "//a[@class='btn btn-warning bg-gradient-warning btn-block']")
	private WebElement editBtn;

	@FindBy(xpath ="(//input[@name='lastname'])[4]")
	private WebElement lastnameUpdate;

	@FindBy(name = "phone")
	private WebElement phoneUpdate;

	@FindBy(xpath = "//button[text()='Update']")
	private WebElement updateBtn;

	public WebElement getPlusIcon() {
		return plusIcon;
	}

	public WebElement getFirstnameTxtFld() {
		return firstnameTxtFld;
	}

	public WebElement getLastnameTxtFld() {
		return lastnameTxtFld;
	}

	public WebElement getPhonenumberTxtFld() {
		return phonenumberTxtFld;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public WebElement getSearchBar() {
		return searchBar;
	}

	public WebElement getEditBtn() {
		return editBtn;
	}

	public WebElement getLastnameUpdate() {
		return lastnameUpdate;
	}

	public WebElement getPhoneUpdate() {
		return phoneUpdate;
	}

	public WebElement getUpdate() {
		return updateBtn;
	}



	public void createCustomer(WebDriver driver, String firstname,String lastname, String phone, WebDriverUtitlity wUtil) throws InterruptedException {

		plusIcon.click();
		firstnameTxtFld.sendKeys(firstname);
		lastnameTxtFld.click();
		Thread.sleep(2000);
		lastnameTxtFld.sendKeys(lastname);
		phonenumberTxtFld.sendKeys(phone);
		saveBtn.click();
	}

	public void searchAndUpdateCustomer(WebDriver driver, String name, String firstname, String lastname, String phone,WebDriverUtitlity wUtil) {
		searchBar.sendKeys(name);
		WebElement path = driver.findElement(By.xpath("//td[text()='"+name+"']/ancestor::tr//a[@data-toggle='dropdown' and @style='color:white;']"));
		path.click();
		editBtn.click();
		firstnameTxtFld.clear();
		firstnameTxtFld.sendKeys(firstname);
		//		lastnameTxtFld.clear();
		//		lastnameTxtFld.sendKeys(lastname);
		//		phoneUpdate.clear();
		//		phoneUpdate.sendKeys(phone);
		updateBtn.click();
		wUtil.acceptAlert();
	}

	public void checkUpdatedCustomer(WebDriver driver, String firstNameUpdate,String updatedName) {
		searchBar.sendKeys(firstNameUpdate);
		WebElement name = driver.findElement(By.xpath("//td[text()='"+firstNameUpdate+"']"));
		String firstname = name.getText();
		assertTrue(firstname.contains(firstNameUpdate));
	}
}