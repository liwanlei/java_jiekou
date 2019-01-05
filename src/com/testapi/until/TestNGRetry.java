package com.testapi.until;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class TestNGRetry  implements IRetryAnalyzer {
	private int retryCount =1;
    private static final int maxRetryCount =3;
	@Override
	public boolean retry(ITestResult result) {
		if (retryCount<=maxRetryCount){
			retryCount+=1;
			return true;
		}
		return false;
	}
	public void reSetCount(){
        retryCount=1;
    }
}