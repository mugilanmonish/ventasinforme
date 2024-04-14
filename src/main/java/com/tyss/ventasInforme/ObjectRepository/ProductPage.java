package com.tyss.ventasInforme.ObjectRepository;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genricUtility.WebDriverUtitlity;

public class ProductPage {
	
	public ProductPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath = "//h4/a[@type='button']")
	private WebElement plusIcon;
	
	@FindBy(name = "prodcode")
	private WebElement productCode;
	
	@FindBy(name = "name")
	private WebElement productName;
	
	@FindBy(xpath = "//textarea[@name='description']")
	private WebElement description;
	
	@FindBy(name = "quantity")
	private WebElement quantity;
	
	@FindBy(name = "onhand")
	private WebElement onHand;
	
	@FindBy(name = "price")
	private WebElement price;
	
	@FindBy(xpath = "//select[@name='category']")
	private WebElement category;
	
	@FindBy(xpath = "//div/select[@name='supplier']")
	private WebElement supplier;
	
	@FindBy(name = "datestock")
	private WebElement dateStock;
	
	@FindBy(xpath = "(//button[text()='Save'])[5]")
	private WebElement saveBtn;
	
	@FindBy(xpath = "//input[@type='search']")
	private WebElement searchBar;
	
	public void addProduct(WebDriverUtitlity wUtil,String pCode,String pName,String desc,String quan,String available,String amount, String categoryName,String dateStockValue,String supplierValue) {
		plusIcon.click();
		productCode.sendKeys(pCode);
		productName.sendKeys(pName);
		description.sendKeys(desc);
		quantity.sendKeys(quan);
		onHand.sendKeys(available);
		price.sendKeys(amount);
		wUtil.handleDropDown(category, categoryName);
		wUtil.handleDropDown(supplier, supplierValue);
		wUtil.sendValueUsingJs(dateStock, dateStockValue);
		saveBtn.click();
	}
	
	public void productCheck(WebDriver driver,String proCode) {
		searchBar.sendKeys(proCode);
		String expProdName = driver.findElement(By.xpath("//td[.='"+proCode+"']")).getText();
		assertEquals(expProdName, proCode, "FAIL --> Product is not available");
	}
}