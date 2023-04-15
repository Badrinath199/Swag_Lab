package test;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources.ExtendReportNG;
import testComponent.BaseClass1;


public class Listeners extends BaseClass1 implements ITestListener{
	
	ExtentTest test;
	ExtentReports extend= ExtendReportNG.getReportObject();
	ThreadLocal<ExtentTest> extendTest= new ThreadLocal<ExtentTest>();
			
	@Override
	public void onTestStart(ITestResult result) {
		test = extend.createTest(result.getMethod().getMethodName());
		extendTest.set(test);
	System.out.println("Method started");	
	}
	
	@Override
	public void onTestSuccess(ITestResult result) {
		extendTest.get().log(Status.PASS, "Test Passed");
		System.out.println("Method sucess");
	}
	
	@Override
		public void onTestFailure(ITestResult result) {
			
		System.out.println("Method Fail");
		}
	
	@Override
	public void onFinish(ITestContext context) {
		extend.flush();
		System.out.println("Method Finish");
		
	}

}
