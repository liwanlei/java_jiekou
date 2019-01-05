package com.testapi.until;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.testapi.until.TestNGRetry;
public class TestRunnerListener extends  TestListenerAdapter   {
	 @Override
	    public void onTestSuccess(ITestResult tr) {
	        TestNGRetry retryAnalyzer = (TestNGRetry) tr.getMethod().getRetryAnalyzer();
	        retryAnalyzer.reSetCount();
	    }

	    @Override
	    public void onTestFailure(ITestResult tr) {
	    	TestNGRetry retryAnalyzer = (TestNGRetry) tr.getMethod().getRetryAnalyzer();
	        retryAnalyzer.reSetCount();
	    }
}