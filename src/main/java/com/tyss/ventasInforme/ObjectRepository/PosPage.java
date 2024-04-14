package com.tyss.ventasInforme.ObjectRepository;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genricUtility.WebDriverUtitlity;

public class PosPage {

	public PosPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[.='Others']")
	private WebElement othersTab;

	@FindBy(xpath = "//a[.='Mouse']")
	private WebElement mouseOption;

	@FindBy(xpath = "//h6[.='A4tech OP-720']/following-sibling::input[@name='addpos']")
	private WebElement product;

	@FindBy(xpath = "//button[.='SUBMIT']")
	private WebElement submitBtn;

	@FindBy(xpath = "//input[@placeholder='ENTER CASH']")
	private WebElement enterCash;

	@FindBy(xpath = "//button[.='PROCEED TO PAYMENT']")
	private WebElement payment;

	@FindBy(name = "customer")
	private WebElement customer;
	
	@FindBy(xpath = "//a[@id='userDropdown']/span")
	private WebElement userName;

	public WebElement getOthersTab() {
		return othersTab;
	}

	public WebElement getMouseOption() {
		return mouseOption;
	}

	public WebElement getProduct() {
		return product;
	}

	public WebElement getSubmitBtn() {
		return submitBtn;
	}

	public WebElement getEnterCash() {
		return enterCash;
	}

	public WebElement getPayment() {
		return payment;
	}

	public void buyProduct(WebDriverUtitlity wUtil, String ddValue, String amount) {
		mouseOption.click();
		product.click();
		wUtil.handleDropDown(customer, ddValue);
		submitBtn.click();
		enterCash.sendKeys(amount);
		payment.click();
		String popMsg = wUtil.getTextInAlert();
		if(popMsg.equals("Success."))
			System.out.println("PASS --> Admin is able to sell a product");
		else
			System.out.println("PASS --> Admin is not able to sell a product");
		wUtil.acceptAlert();
	}
	
	public void verifyAdmin() {
		String name = userName.getText();
		assertEquals(name, "Prince Ly Cesar", "The user is not able to login");
	}
	
	public void verifyUser() {
		String name = userName.getText();
		assertEquals(name, "Mugi Mugi", "The user is not able to login");
	}
}
