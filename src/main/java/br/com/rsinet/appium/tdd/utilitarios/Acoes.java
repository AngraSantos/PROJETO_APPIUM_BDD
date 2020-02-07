package br.com.rsinet.appium.tdd.utilitarios;

import org.openqa.selenium.WebElement;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;

public class Acoes {

	private TouchAction touch;
	private AndroidDriver<WebElement> driver;

	public Acoes(AndroidDriver<WebElement> driver){

		this.driver = driver;
		this.touch = new TouchAction (this.driver);
	}

	public void scroll() {

		touch.press(PointOption.point(1051, 1773)).moveTo(PointOption.point(1042, 353)).release().perform();
	}
}
