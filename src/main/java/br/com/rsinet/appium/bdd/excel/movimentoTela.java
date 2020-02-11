package br.com.rsinet.appium.bdd.excel;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

public class movimentoTela {

	private TouchAction touch;
	private AndroidDriver<MobileElement> driver;

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

}
