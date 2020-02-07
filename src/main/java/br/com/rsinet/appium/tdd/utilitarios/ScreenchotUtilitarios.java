package br.com.rsinet.appium.tdd.utilitarios;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenchotUtilitarios {
	
	public static String getScreenshot(WebDriver driver) {

		TakesScreenshot ts = (TakesScreenshot) driver;
		
		File src = ts.getScreenshotAs(OutputType.FILE);
		
		String path = System.getProperty("user.dir")+"/Screenchot/"+System.currentTimeMillis()+".png";
		
		File destination = new File(path);
		
		try
		
		{
			FileUtils.copyFile(src, destination);
		
		}catch  (IOException e) {
		
			System.out.println("Capture Failed" + e.getMessage());
			}
		
		return path;
	}

}

