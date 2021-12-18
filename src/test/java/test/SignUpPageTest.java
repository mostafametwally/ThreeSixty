package test;

import java.io.IOException;

import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;

import base.Base;
import pages.SignUpPage;

public class SignUpPageTest extends Base {
	
	SignUpPage signUpPage;
	
	@BeforeTest
	public void setupTest() {
		extent = new ExtentReports(System.getProperty("user.dir") + "/test-output/ExtentReport.html",true);	
		}
	
	@BeforeMethod
	public void setupMethod() {
		Base.initialization();
		signUpPage = new SignUpPage();
		signUpPage.openSignUpPage("SignUpPageLink");
	}
	
	@Test()
	public void VerifyEmailErrorMsg() throws InterruptedException {
		extentTest = extent.startTest("VerifyEmailErrorMsg");	
		String ActuallMsg= signUpPage.getEmailErrorMsg();
		Assert.assertEquals(ActuallMsg, "Please fill out this field.");
	}
	@Test()
	public void VerifyPassWrdErrorMsg() throws InterruptedException {
		extentTest = extent.startTest("VerifyEmailErrorMsg");	
		String ActuallMsg= signUpPage.getPassWrdErrorMsg();
		Assert.assertEquals(ActuallMsg, "Please fill out this field.");
	}
	@Test()
	public void VerifyConfirmPassWrdErrorMsg() throws InterruptedException {
		extentTest = extent.startTest("VerifyEmailErrorMsg");	
		String ActuallMsg= signUpPage.getConfirmPassWrdErrorMsg();
		Assert.assertEquals(ActuallMsg, "Please fill out this field.");
	}
	
	@Test
	public void CreateNewAccount() throws InterruptedException {
		extentTest = extent.startTest("CreateNewAccount");
		signUpPage.CreateNewAccount("moustafa5@test.com", "12345678");
		String ActuallUrl= signUpPage.getCurrentUrl();
		String ExpectedUrl ="https://utasks-main.web.app/home";
		Assert.assertEquals(ActuallUrl, ExpectedUrl);
	}
	
	@Test
	public void AddNewTaskNextWeek() {
		extentTest = extent.startTest("AddNewTaskNextWeek");
		signUpPage.addNewTask("moustafa6@test.com", "12345678", "Proj2", "Task2", "Next Week"); 
	}
	
	@Test
	public void AddNewTaskToday() {
		extentTest = extent.startTest("AddNewTaskToday");
		signUpPage.addNewTask("moustafa7@test.com", "12345678","Proj3", "Task3", "Today"); 
	}
	
	@AfterMethod
	public void tearDownMethod(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.FAILURE) { // in case of failure
			extentTest.log(LogStatus.FAIL, "FAILED:  " + result.getName()); // to add the test name to the extent report
			extentTest.log(LogStatus.FAIL, "ERROR MESSAGE:  " + result.getThrowable()); // to add error/exception 	
			String screenshotPath = Base.takeScreenShot(result.getName());
			extentTest.log(LogStatus.FAIL, extentTest.addScreenCapture(screenshotPath)); // to add screenshot 
		} 
//		else if (result.getStatus() == ITestResult.SKIP) {
//			extentTest.log(LogStatus.SKIP, "SKIPPED:  " + result.getName());
//		}else if (result.getStatus() == ITestResult.SUCCESS) {
//			extentTest.log(LogStatus.PASS, "PASSED: " + result.getName());
//		}
		driver.quit();
	}
	
	@AfterTest
	public void tearDownTest() {
		extent.endTest(extentTest);
		extent.flush();
	}
}
