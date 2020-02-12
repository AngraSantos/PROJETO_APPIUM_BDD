package br.com.rsinet.appium.bdd.ScreenFactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class ScreenProduto {

	private AndroidDriver<MobileElement> driver;
	private WebDriverWait wait;
	
	@FindBy(how = How.XPATH, using = "//android.widget.RelativeLayout[@content-desc=\"Tablets\"]/android.widget.LinearLayout/android.widget.GridView/android.widget.RelativeLayout[2]/android.widget.ImageView")
	private WebElement txtbx_tabletEliteX2;

	@FindBy(how = How.XPATH, using = "//android.widget.RelativeLayout[@content-desc=\"Speakers\"]/android.widget.LinearLayout/android.widget.GridView/android.widget.RelativeLayout[5]")
	private WebElement txtbx_LogitechX100;

	@FindBy(how = How.XPATH, using = "//android.widget.RelativeLayout[@content-desc=\"Mice\"]/android.widget.LinearLayout/android.widget.GridView/android.widget.RelativeLayout[5]/android.widget.ImageView")
	private WebElement txtbx_mouseMicrosoftSculptTouch;

	@FindBy(how = How.XPATH, using = "//android.widget.RelativeLayout[@content-desc=\"Search\"]/android.widget.LinearLayout/android.widget.GridView/android.widget.RelativeLayout[4]/android.widget.ImageView")
	private WebElement txtbx_mouseHPz4000;

	@FindBy(how = How.XPATH, using = "//android.widget.RelativeLayout[@content-desc=\"Headphones\"]/android.widget.LinearLayout/android.widget.GridView/android.widget.RelativeLayout[4]/android.widget.ImageView")
	private WebElement txtbx_foneLogitechUSB;

	@FindBy(how = How.ID, using = "com.Advantage.aShopping:id/linearLayoutProductQuantity")
	private WebElement btn_Quantidade;

	@FindBy(how = How.XPATH, using = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.EditText")
	private WebElement btn_SelecionarQuantidade;
	
	@FindBy(how = How.ID, using = "com.Advantage.aShopping:id/textViewApply")
	private WebElement txtbx_ConfirmaQuantidade;
	
	@FindBy(how = How.ID, using = "com.Advantage.aShopping:id/buttonProductAddToCart")
	private WebElement txtbx_incluirCarrinho;
	
	@FindBy(how = How.ID, using = "com.Advantage.aShopping:id/imageViewCart")
	private WebElement txtbx_clicarCarrinho;

	@FindBy(how = How.ID, using = "com.Advantage.aShopping:id/buttonCheckOut")
	private WebElement btn_finalizarCompra;
	
	public ScreenProduto(AndroidDriver<MobileElement> driver) {
		this.driver = (AndroidDriver<MobileElement>) driver;
		PageFactory.initElements(this.driver, this);
		wait = new WebDriverWait(this.driver, 20);
	}

	public void tabletEliteX2() {
		wait.until(ExpectedConditions.visibilityOf(txtbx_tabletEliteX2));
		txtbx_tabletEliteX2.click();
	}

	public void CaixaDeSomLogitechX100() {
		wait.until(ExpectedConditions.visibilityOf(txtbx_LogitechX100));
		txtbx_LogitechX100.click();
	}
	
	public void Quantidade() {
		wait.until(ExpectedConditions.visibilityOf(btn_Quantidade));
		btn_Quantidade.click();
	}
	
	public void QuantidadeDeProduto(String QuantidadeProduto) {
		btn_SelecionarQuantidade.clear();
		btn_SelecionarQuantidade.sendKeys(QuantidadeProduto);
	}
	
	public void confirmarQuantidade() {
		wait.until(ExpectedConditions.visibilityOf(txtbx_ConfirmaQuantidade));
		txtbx_ConfirmaQuantidade.click();
	}

	public void incluirCarrinho() {
		wait.until(ExpectedConditions.visibilityOf(txtbx_incluirCarrinho));
		txtbx_incluirCarrinho.click();
	}
	
	public void clicarCarrinho() throws Exception {
		wait.until(ExpectedConditions.visibilityOf(txtbx_clicarCarrinho));
		txtbx_clicarCarrinho.click();
		
		wait.until(ExpectedConditions.visibilityOf(btn_finalizarCompra));
	}
	
	public void mouseHPz4000() {
		wait.until(ExpectedConditions.visibilityOf(txtbx_mouseHPz4000));
		txtbx_mouseHPz4000.click();
	}

	public void FoneLogitech() {
		wait.until(ExpectedConditions.visibilityOf(txtbx_foneLogitechUSB));
		txtbx_foneLogitechUSB.click();
	}
	
	public void mouseMicrosoftTouch() {
		wait.until(ExpectedConditions.visibilityOf(txtbx_mouseMicrosoftSculptTouch));
		txtbx_mouseMicrosoftSculptTouch.click();
	}
	
}
