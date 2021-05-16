package SeleniumUtils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class IRetryAnalyzer_test implements IRetryAnalyzer {

	private int retryCnt = 0;
	private int maxRetryCnt = 2;

	public boolean retry(ITestResult result) {

		if (retryCnt <= maxRetryCnt) {
			System.out.println("Retrying.........");
			retryCnt = retryCnt + 1;
			return true;
		} else
			return false;
	}

}
