package br.com.rsinet.appium.tdd.report;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import br.com.rsinet.appium.tdd.utilitarios.ScreenchotUtilitarios;

public class reports {

	
	private static ExtentHtmlReporter ExtentHtmlReporter;
	private static ExtentReports extentReports;
	private static ExtentTest ExtentTest;

	public static void Report() {
		ExtentHtmlReporter = new ExtentHtmlReporter("target/reports.html");
		ExtentHtmlReporter.config().setDocumentTitle("Report");
		ExtentHtmlReporter.config().setReportName("Report");

		extentReports = new ExtentReports();

		extentReports.attachReporter(ExtentHtmlReporter);
	}

	public static ExtentTest createTest(String testName) {
		ExtentTest = extentReports.createTest(testName);
		return ExtentTest;
	}

	public static void statusReport (ExtentTest test, ITestResult result, WebDriver driver) throws IOException {

		if (result.getStatus() == ITestResult.SUCCESS) {
			String temp = ScreenchotUtilitarios.getScreenshot(driver);
			test.pass("Efetuado com Sucesso: ", MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
		} else if (result.getStatus() == ITestResult.FAILURE) {
			String temp = ScreenchotUtilitarios.getScreenshot(driver);
			test.fail("Ocorreu um erro: ", MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
		}	
	}
	/* fechando */
	public static void quitExtent() {
		extentReports.flush();
	}
}
