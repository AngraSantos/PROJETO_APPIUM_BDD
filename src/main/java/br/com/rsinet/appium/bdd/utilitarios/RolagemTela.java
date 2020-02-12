package br.com.rsinet.appium.bdd.utilitarios;

import io.appium.java_client.MobileElement;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;

public class RolagemTela {

	private static TouchAction touch;
	private static AndroidDriver<MobileElement> driver;

	public RolagemTela(AndroidDriver<MobileElement> driver){

		this.driver = driver;
		this.touch = new TouchAction (this.driver);
	}

	public void scroll(String buscar) {
		
		driver.findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""
						+ buscar  + "\").instance(0))")
		.click();
		
	}	

	public static AndroidDriver<MobileElement> scrollTempoInicialparaMenu() {
		
		touch.press(PointOption.point(1051, 1773)).moveTo(PointOption.point(1042, 353)).release().perform();
		
		return driver;
	}}
