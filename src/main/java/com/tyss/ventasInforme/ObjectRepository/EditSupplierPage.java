package com.tyss.ventasInforme.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class EditSupplierPage {
	public EditSupplierPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(name = "name")
	private WebElement cName;
	
	@FindBy(name = "province")
	private WebElement province;

	@FindBy(name = "city")
	private WebElement city;
	
	@FindBy(name = "phone")
	private WebElement phone;
	
	@FindBy(xpath = "//button[text()='Update']")
	private WebElement updateBtn;
	
	public void editSupplier(String updatedName,String updatedPhoneNumber,String updatedProvince) {
		cName.clear();
		cName.sendKeys(updatedName);
		province.clear();
		province.sendKeys(updatedProvince);
		phone.clear();
		phone.sendKeys(updatedPhoneNumber);
		updateBtn.click();
	}
	
	
}
