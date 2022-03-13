package org.test.failedscreenshot;

import java.io.IOException;

import org.base.BaseClass;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class FailedScreenShot extends BaseClass implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
	}
	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("=======Test Passed========");
		
	}
	@Override
	public void onTestFailure(ITestResult r) {
		System.err.println("=======Test Failed========");
		try {
			takeScreenShot(r.getName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			}
	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	@Override
	public void onStart(ITestContext context) {
		
	}
	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

}
