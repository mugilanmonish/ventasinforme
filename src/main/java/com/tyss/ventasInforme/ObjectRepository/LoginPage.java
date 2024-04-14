package com.tyss.ventasInforme.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//Rule 1
public class LoginPage {
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	//Declaration
	@FindBy(xpath = "//input[@placeholder='Username']")
	private WebElement usernameTxtFld;

	@FindBy(xpath = "//input[@placeholder='Password']")
	private WebElement passwordTxtFld;
	
	@FindBy(name = "btnlogin")
	private WebElement submitBtn;
	
	public WebElement getUsernameTxtFld() {
		return usernameTxtFld;
	}

	public WebElement getPasswordTxtFld() {
		return passwordTxtFld;
	}

	public WebElement getSubmitBtn() {
		return submitBtn;
	}
	
	/**Business Libraries
	 * @author Mugilan
	 * @param username
	 * @param password
	 * Login by entering username and password and click login
	 * @throws InterruptedException 
	 */
	public void loginToApp(String username, String password)  {
		usernameTxtFld.sendKeys(username);
		passwordTxtFld.sendKeys(password);
		submitBtn.click();
	}
	
	public void userLoginToApp(String username, String password) {
		usernameTxtFld.sendKeys(username);
		passwordTxtFld.sendKeys(password);
		submitBtn.click();
	}
}
