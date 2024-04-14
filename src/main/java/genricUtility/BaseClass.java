package genricUtility;

import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.tyss.ventasInforme.ObjectRepository.HomePage;
import com.tyss.ventasInforme.ObjectRepository.LoginPage;
public class BaseClass {
	
	public WebDriver driver;
	public static WebDriver  sdriver;
	public WebDriverUtitlity wUtils;
	public DatabaseUtility dUtils = new DatabaseUtility();
	public FileUtility fUtils = new FileUtility();
	public ExcelUtility eUtils = new ExcelUtility();
	public JavaUtility jUtils = new JavaUtility();
	
	@BeforeSuite(alwaysRun = true)
	public void connectToDb() throws SQLException {
		dUtils.connectToDB();
		Reporter.log("--Db connected--",true);
	}
	
//	@Parameters("Browser")
	@BeforeClass(alwaysRun = true)
	public void launchBrowser() throws Throwable {
		String Browser = fUtils.readDataFromPropertyFIle("browser");
		String URL = fUtils.readDataFromPropertyFIle("url");
		if(Browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
			Reporter.log("--CHROME BROWSSER LAUNCHED SUCCESSFULLY--");
		}
		else if (Browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}
		else if(Browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}
		else {
			Reporter.log("--INVALID BROWSER--", true);
		}
		sdriver = driver;
		wUtils = new WebDriverUtitlity(driver);
		wUtils.maximizeWindow();
		wUtils.waitForEleImplicitly(5);
		driver.get(URL);
	}
	
	@BeforeMethod(alwaysRun = true)
	public void login() throws Throwable {
		String username = eUtils.readDataFromExcel("admin", 1, 0);
		String password = eUtils.readDataFromExcel("admin", 1, 1);
		LoginPage login = new LoginPage(driver);
		login.loginToApp(username, password);
		Reporter.log("--LOGGED IN TO APPLICATION--", true);
	}
	
	@AfterMethod(alwaysRun = true)
	public void logout() {
		HomePage home = new HomePage(driver);
		home.logoutToApp();
		Reporter.log("--LOGGED OUT THE APPLICATION--", true);
	}
	
	@AfterClass(alwaysRun = true)
	public void closeBrowser() {
		driver.quit();
		Reporter.log("--BROWSER CLOSED--", true);
	}
	
	@AfterSuite(alwaysRun = true)
	public void closeDb() throws SQLException {
		dUtils.closeDb();
		Reporter.log("--DB CLOSED--", true);
	}
}
