package com.tyss.ventasInforme.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TransactionPage {

	public TransactionPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@type='search']")
	private WebElement searchBar;

	@FindBy(xpath = "//h6[@class='font-weight-bold']/preceding-sibling::h6")
	private WebElement transaction;

	public void verifyTranscation(WebDriver driver,String customerName) {
		searchBar.sendKeys(customerName);
		try {
			driver.findElement(By.xpath("(//td[.='"+customerName+"']/ancestor::tr//a[contains(@class,'btn b')])[1]"));
			System.out.println("Transaction available");
		} catch(Exception e) {
			System.out.println("Transaction is not available");
		}
	}
}