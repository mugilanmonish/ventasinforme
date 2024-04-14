package testngPractice;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.tyss.ventasInforme.ObjectRepository.LoginPage;

public class DataTest {

	@Test(dataProviderClass = DataExecute.class, dataProvider = "data") 
	public void getData(String org, String loc, String course) {
		System.out.println(org+" "+loc+" "+course);
	}
	
	@Test(dataProviderClass = DataProviders.class, dataProvider = "readDataFromExcel") 
	public void login(String username,String password) {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("http://rmgtestingserver/domain/Sales_And_Inventory_System/pages/login.php");
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(username, password);
	}
}
