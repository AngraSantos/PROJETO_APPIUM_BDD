package br.com.rsinet.appium.bdd.utilitarios;

import io.appium.java_client.MobileElement;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;

public class movimentoTela {

	private TouchAction touch;
	private static AndroidDriver<MobileElement> driver;

	public movimentoTela(AndroidDriver<MobileElement> driver){

		this.driver = driver;
		this.touch = new TouchAction (this.driver);
	}

	public void scroll(String buscar) {
		
		driver.findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""
						+ buscar  + "\").instance(0))")
		.click();
		
	}	

	public static AndroidDriver<MobileElement> scrollTempoInicial () {
		(new TouchAction((PerformsTouchActions) driver)).press(PointOption.point(1055, 378))
		.moveTo(PointOption.point(1059, 1744)).release().perform();
		
		return driver;
	}
}
