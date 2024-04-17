package genricUtility;


import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImplementationClass implements ITestListener {

	ExtentReports reports;
	ExtentTest test;
	@Override
	public void onTestStart(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		test = reports.createTest(methodName);
		Reporter.log("Actual Execution starts from here", true);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		test.log(Status.PASS, methodName);
		Reporter.log(methodName+"-->Executed Successully");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		try {
			String screenshot = WebDriverUtitlity.getScreenShot(BaseClass.sdriver, methodName);
			test.log(Status.FAIL, methodName+"-->Failed");
			test.log(Status.FAIL, result.getThrowable());
			test.addScreenCaptureFromPath(screenshot);
			Reporter.log(methodName+"-->Failed");
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		test.log(Status.SKIP, methodName+"--> Skipped");
		test.log(Status.SKIP, result.getThrowable());
		Reporter.log(methodName+"-->Skipped");
	}

	@Override
	public void onStart(ITestContext context) {
		ExtentSparkReporter htmlReport = new ExtentSparkReporter("./ExtentReport/Reports.html");
		htmlReport.config().setDocumentTitle("VentasInforme");
		htmlReport.config().setReportName("Testing");
		htmlReport.config().setTheme(Theme.STANDARD);
		
		reports = new ExtentReports();
		reports.attachReporter(htmlReport);
		reports.setSystemInfo("Base-Platform", "Windows");
		reports.setSystemInfo("Base-Broswer", "chrome");
		reports.setSystemInfo("Base-URL", "http://rmgtestingserver/domain/Sales_And_Inventory_System/pages/login.php");
		reports.setSystemInfo("ReporterName", "Mugilan");
	}

	@Override
	public void onFinish(ITestContext context) {
		reports.flush();
	}
	
}
