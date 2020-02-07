package br.com.rsinet.appium.bdd.driver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class DriverAplicacaoAdvantage {

	private static AndroidDriver<MobileElement> driver;
	private static DesiredCapabilities caps;

	private DriverAplicacaoAdvantage() {

	}

	public static  AndroidDriver<MobileElement> iniciarDriver() throws MalformedURLException  {
		if (driver == null) {

			caps = new DesiredCapabilities();

			caps.setCapability("deviceName", "simulador");
			caps.setCapability("platformName", "Android");
			caps.setCapability("platformVersion", "9");
			caps.setCapability("appPackage", "com.Advantage.aShopping");
			caps.setCapability("appActivity", "com.Advantage.aShopping.SplashActivity");
			caps.setCapability("unicodeKeyboard", true);
			caps.setCapability("resetKeyboard", true);

			driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
			driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
		}
		return driver;
	}

	public static AndroidDriver<MobileElement> FechandoJanela() {

		if (driver != null)
			driver.quit();
		 return driver = null;
	}
}