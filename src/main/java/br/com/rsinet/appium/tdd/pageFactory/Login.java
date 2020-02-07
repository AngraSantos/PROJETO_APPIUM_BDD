package br.com.rsinet.appium.tdd.pageFactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;

public class Login {
	
	private AndroidDriver<WebElement> driver;
	private WebDriverWait wait;

	@FindBy(how = How.ID, using = "com.Advantage.aShopping:id/linearLayoutLogin")
	private WebElement btn_login;

	@FindBy(how = How.ID, using = "com.Advantage.aShopping:id/textViewSingUpToday")
	private WebElement txtbx_criarConta;
	
	@FindBy(how = How.XPATH, using = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout[2]/android.widget.RelativeLayout[3]/android.widget.EditText")
	private WebElement txtbx_entrarUsuario;

	@FindBy(how = How.XPATH, using = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout[2]/android.widget.RelativeLayout[4]/android.widget.EditText\r\n" + 
			"")
	private WebElement txtbx_entrarSenha;

	@FindBy(how = How.ID, using = "com.Advantage.aShopping:id/buttonLogin")
	private WebElement btn_entrar_login;
	
	
	public Login (AndroidDriver<WebElement> driver) {
		this.driver = (AndroidDriver<WebElement>) driver;
		PageFactory.initElements(this.driver, this);
		wait = new WebDriverWait(this.driver, 20);
}
	
	public void clicarLogin() {
		wait.until(ExpectedConditions.elementToBeClickable(btn_login));
		btn_login.click();
	}

	public void criarContaNova() {
		wait.until(ExpectedConditions.elementToBeClickable(txtbx_criarConta));
		txtbx_criarConta.click();
	}

	public void incluirUsuario(String usuario) {
		wait.until(ExpectedConditions.visibilityOf(txtbx_entrarUsuario));
		txtbx_entrarUsuario.sendKeys(usuario);
	}
	
	public void incluirSenha(String senha) {
		wait.until(ExpectedConditions.visibilityOf(txtbx_entrarSenha));
		txtbx_entrarSenha.click();
		txtbx_entrarSenha.sendKeys(senha);
	}
	
	public void apertarBotaoEntrarLogin() {
		wait.until(ExpectedConditions.visibilityOf(btn_entrar_login));
		btn_entrar_login.click();
	}
	
}