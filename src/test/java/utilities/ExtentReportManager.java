package utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager implements ITestListener {

	public ExtentSparkReporter sparkReporter;
	public ExtentReports extent ;
	public ExtentTest test ;
	
	String repName;
	public void onStart(ITestContext testContext) {
	String timeStamp = new SimpleDateFormat("yyyt.MM.dd.HH.mm.ss").format(new Date());
			repName = "Test-Report" + timeStamp + ".html";
			sparkReporter = new ExtentSparkReporter(".\\reports\\" + repName);

}
			
}
