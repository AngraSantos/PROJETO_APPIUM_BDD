package br.com.rsinet.appium.bdd.ScreenFactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class ScreenHome {

	private AndroidDriver<MobileElement> driver;
	private WebDriverWait wait;

	@FindBy(how = How.ID, using = "com.Advantage.aShopping:id/imageViewMenu")
	private WebElement txtbx_menu;

	@FindBy(how = How.XPATH, using = "//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.support.v7.widget.RecyclerView/android.widget.RelativeLayout[3]/android.widget.ImageView")
	private WebElement txtbx_tablets;

	@FindBy(how = How.XPATH, using = "//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.support.v7.widget.RecyclerView/android.widget.RelativeLayout[2]/android.widget.ImageView")
	private WebElement txtbx_headphones;

	@FindBy(how = How.XPATH, using = "//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.support.v7.widget.RecyclerView/android.widget.RelativeLayout[4]/android.widget.ImageView")
	private WebElement txtbx_mouse;

	@FindBy(how = How.XPATH, using = "//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.support.v7.widget.RecyclerView/android.widget.RelativeLayout[3]/android.widget.ImageView")
	private WebElement txtbx_CaixaDeSom;
	
	@FindBy(how = How.ID, using = "com.Advantage.aShopping:id/editTextSearch")
	private WebElement txtbx_Buscar;

	@FindBy(how = How.ID, using = "com.Advantage.aShopping:id/imageViewSearch")
	private WebElement txtbx_clicarBuscar;
	
	public ScreenHome(AndroidDriver<MobileElement> driver) {
		this.driver = (AndroidDriver<MobileElement>) driver;
		PageFactory.initElements(this.driver, this);
		wait = new WebDriverWait(this.driver, 20);
	}

	public void clicarMenu() throws Exception {
		wait.until(ExpectedConditions.visibilityOf(txtbx_menu));
		txtbx_menu.click();
	}

	public void clicarTablet() {
		wait.until(ExpectedConditions.elementToBeClickable(txtbx_tablets));
		txtbx_tablets.click();
	}

	public void clicarHeadphones() {
		wait.until(ExpectedConditions.elementToBeClickable(txtbx_headphones));
		txtbx_headphones.click();
	}

	public void buscarLupa(String produto) {
		wait.until(ExpectedConditions.elementToBeClickable(txtbx_Buscar));
		txtbx_Buscar.click();
		txtbx_Buscar.sendKeys(produto);
		txtbx_clicarBuscar.click();
	}
}