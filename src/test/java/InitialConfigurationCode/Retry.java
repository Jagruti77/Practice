package InitialConfigurationCode;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer{ //connect it to only actual test case 
	int count = 0;
	int maxRetry = 1;
	@Override
	public boolean retry(ITestResult result) {
		
		
		if(count<maxRetry)
		{
			count++;  //if we want to run only once
			return true; //return true it will run the failed test case again
		}
		return false;
	}
	
	

}
