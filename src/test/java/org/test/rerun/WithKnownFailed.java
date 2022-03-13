package org.test.rerun;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class WithKnownFailed implements IRetryAnalyzer{

	int minCount=0, maxCount=5;
	@Override
	public boolean retry(ITestResult result) {
		if(minCount<maxCount) {  //0<5
			minCount++;
			return true;   //teestcase fail // condition true 
		}
		
		return false;  //teest case pass // condition fail
	}

}