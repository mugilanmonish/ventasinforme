package com.tyss.ventasInforme.ObjectRepository;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genricUtility.WebDriverUtitlity;

public class SupplierPage {

	public SupplierPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath = "//h4/a[@type='button']")
	private WebElement plusIcon;
	
	@FindBy(name = "companyname")
	private WebElement companyName;
	
	@FindBy(xpath = "(//select[@name='province'])[1]")
	private WebElement provinceName;
	
	@FindBy(xpath = "(//select[@name='city'])[1]")
	private WebElement city;
	
	@FindBy(xpath = "(//input[@name='phonenumber'])[1]")
	private WebElement phonenumber;
	
	@FindBy(xpath = "(//button[text()='Save'])[1]")
	private WebElement saveBtn;
	
	@FindBy(xpath = "//input[@type='search']")
	private WebElement searchBar;
	
	@FindBy(xpath = "//a[@class='btn btn-warning bg-gradient-warning btn-block']")
	private WebElement editBtn;
	
	public void createSupplier(WebDriver driver, WebDriverUtitlity wUtil, String cName, String cityName, String pName, String pNumber, String sValue) {
		plusIcon.click();
		companyName.sendKeys(cName);
		wUtil.handleDropDown(provinceName, pName);
		wUtil.handleDropDown(city, cityName);
		phonenumber.sendKeys(pNumber);
		saveBtn.click();
		searchBar.sendKeys(cName);
		driver.findElement(By.xpath("//td[text()='"+cName+"']/ancestor::tr//a[@data-toggle='dropdown' and @style='color:white;']")).click();
		editBtn.click();
	}
	
	public void searchSupplier(WebDriver driver, String UpdatedUniqueCompany) {
		driver.findElement(By.xpath("//input[@type='search']")).sendKeys(UpdatedUniqueCompany);
		String companyName = driver.findElement(By.xpath("//td[text()='"+UpdatedUniqueCompany+"']")).getText();
		assertTrue(companyName.contains(UpdatedUniqueCompany), "FAIL --> Customer is created and updated details is NOT visible");
//		if(companyName.contains(UpdatedUniqueCompany))
//			System.out.println("PASS --> Customer is created and updated details is visible");
//		else
//			System.out.println("FAIL --> Customer is created and updated details is NOT visible");
	}
}
