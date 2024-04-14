package com.tyss.ventasInforme.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//span[.='Customer']")
	private WebElement customerLink;
	
	@FindBy(xpath = "//span[.='Employee']")
	private WebElement employeeLink;
	
	@FindBy(xpath = "//span[.='Product']")
	private WebElement productLink;
	
	@FindBy(xpath = "//span[.='Inventory']")
	private WebElement inventoryLink;
	
	@FindBy(xpath = "//span[.='Transaction']")
	private WebElement transactionLink;
	
	@FindBy(xpath = "//span[.='Supplier']")
	private WebElement supplierLink;
	
	@FindBy(xpath = "//a[.='View All Products']")
	private WebElement viewAllProduct;
	
	@FindBy(xpath = "//span[.='POS']")
	private WebElement posLink;
	
	@FindBy(xpath = "//a[@id='userDropdown']")
	private WebElement userIcon;
	
	@FindBy(xpath = "//a[@data-target='#logoutModal']")
	private WebElement logoutLink;
	
	@FindBy(xpath = "//a[text()='Logout']")
	private WebElement logoutButton;
	
	@FindBy(xpath = "//span[text()='Accounts']")
	private WebElement accountsLink;
	
	@FindBy(xpath = "//span[.='Home']")
	private WebElement homeLink;
	
	public WebElement getHomeLink() {
		return homeLink;
	}


	public WebElement getAccountsLink() {
		return accountsLink;
	}


	public WebElement getCustomerLink() {
		return customerLink;
	}


	public WebElement getEmployeeLink() {
		return employeeLink;
	}


	public WebElement getProductLink() {
		return productLink;
	}


	public WebElement getInventoryLink() {
		return inventoryLink;
	}


	public WebElement getTransactionLink() {
		return transactionLink;
	}


	public WebElement getSupplierLink() {
		return supplierLink;
	}


	public WebElement getViewAllProduct() {
		return viewAllProduct;
	}


	public WebElement getPosLink() {
		return posLink;
	}


	public WebElement getUserIcon() {
		return userIcon;
	}


	public WebElement getLogoutLink() {
		return logoutLink;
	}


	public WebElement getLogoutButton() {
		return logoutButton;
	}


	public void logoutToApp() {
		userIcon.click();
		logoutLink.click();
		logoutButton.click();
	}
}
