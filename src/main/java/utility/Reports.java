package utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Reports {
	
	public static ExtentReports generateReprts() {
		
		ExtentSparkReporter htmlReportor = new 	ExtentSparkReporter("ProjectReport.html");
		ExtentReports reports = new ExtentReports();
		reports.attachReporter(htmlReportor);
		reports.setSystemInfo("Suite", "Regression");
		reports.setSystemInfo("TestedBy", "Supriya");
		return reports;
	}

}
