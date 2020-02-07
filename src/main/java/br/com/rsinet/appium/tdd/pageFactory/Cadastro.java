package br.com.rsinet.appium.tdd.pageFactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;

public class Cadastro {

	private AndroidDriver<WebElement> driver;
	private WebDriverWait wait;
//	private WebDriver driver;


	@FindBy(how = How.XPATH, using = "//*[@resource-id='com.Advantage.aShopping:id/AosEditTextUserName']/child::*[1]")
	private WebElement txtbx_username;

	@FindBy(how = How.XPATH, using = "//*[@resource-id='com.Advantage.aShopping:id/AosEditTextEmail']/child::*[1]")
	private WebElement txtbx_Email;

	@FindBy(how = How.XPATH, using = "//*[@resource-id='com.Advantage.aShopping:id/AosEditTextPassword']/child::*[1]")
	private WebElement txtbx_Senha;

	@FindBy(how = How.XPATH, using = "//*[@resource-id='com.Advantage.aShopping:id/AosEditTextConfirmPassword']/child::*[1]")
	private WebElement txtbx_ConfirmeSenha;

	@FindBy(how = How.XPATH, using = "//*[@resource-id='com.Advantage.aShopping:id/AosEditTextFirstName']/child::*[1]")
	private WebElement txtbx_Nome;

	@FindBy(how = How.XPATH, using = "//*[@resource-id='com.Advantage.aShopping:id/AosEditTextLastName']/child::*[1]")
	private WebElement txtbx_UltimoNome;

	@FindBy(how = How.XPATH, using = "//*[@resource-id='com.Advantage.aShopping:id/AosEditTextPhoneNumber']/child::*[1]")
	private WebElement txtbx_Telefone;

	@FindBy(how = How.ID, using = "com.Advantage.aShopping:id/textViewCountries")
	private WebElement select_Pais;

	@FindBy(how = How.XPATH, using = "//*[@resource-id='com.Advantage.aShopping:id/AosEditTextState']/child::*[1]")
	private WebElement txtbx_Estado;

	@FindBy(how = How.XPATH, using = "//*[@resource-id='com.Advantage.aShopping:id/AosEditTextStreet']/child::*[1]")
	private WebElement txtbx_Endereco;

	@FindBy(how = How.XPATH, using = "//*[@resource-id='com.Advantage.aShopping:id/AosEditTextCity']/child::*[1]")
	public WebElement txtbx_Cidade;

	@FindBy(how = How.XPATH, using = "//*[@resource-id='com.Advantage.aShopping:id/AosEditTextZip']/child::*[1]")
	private WebElement txtbx_CartaoPostal;

	@FindBy(how = How.ID, using = "com.Advantage.aShopping:id/buttonRegister")
	private WebElement btn_Registrar;

	public Cadastro(AndroidDriver<WebElement> driver) {
		this.driver = (AndroidDriver<WebElement>) driver;
		PageFactory.initElements(this.driver, this);
		wait = new WebDriverWait(this.driver, 20);
		}

	public void usuario(String usuario) throws Exception {
		wait.until(ExpectedConditions.visibilityOf(txtbx_username)).click();
		txtbx_username.sendKeys(usuario);
	}

	public void email(String email) throws Exception {
		wait.until(ExpectedConditions.visibilityOf(txtbx_Email)).click();
		txtbx_Email.sendKeys(email);
	}

	public void senha(String senha) throws Exception {
		wait.until(ExpectedConditions.visibilityOf(txtbx_Senha)).click();
		txtbx_Senha.sendKeys(senha);

	}

	public void confirmeSenha(String confirmeSenha) throws Exception {
		wait.until(ExpectedConditions.visibilityOf(txtbx_ConfirmeSenha)).click();
		txtbx_ConfirmeSenha.sendKeys(confirmeSenha);
	}

	public void primeiroNome(String primeiroNome) throws Exception {
		wait.until(ExpectedConditions.visibilityOf(txtbx_Nome)).click();
		txtbx_Nome.sendKeys(primeiroNome);
	}

	public void ultimoNome(String ultimoNome) throws Exception {
		wait.until(ExpectedConditions.visibilityOf(txtbx_UltimoNome)).click();
		txtbx_UltimoNome.sendKeys(ultimoNome);
	}

	public void telefone(String telefone) throws Exception {
		wait.until(ExpectedConditions.visibilityOf(txtbx_Telefone)).click();
		txtbx_Telefone.sendKeys(telefone);
	}

	public void pais(AndroidDriver<WebElement> driver, String pais) throws Exception {

		wait.until(ExpectedConditions.visibilityOf(select_Pais)).click();
		driver.findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""
						+ pais + "\").instance(0))")
				.click();
	}

	public void cidade(String cidade) throws Exception {
		wait.until(ExpectedConditions.visibilityOf(txtbx_Cidade)).click();
		txtbx_Cidade.sendKeys(cidade);
	}

	public void endereco(String endereco) throws Exception {
		wait.until(ExpectedConditions.visibilityOf(txtbx_Endereco)).click();
		txtbx_Endereco.sendKeys(endereco);
	}

	public void estado(String estado) throws Exception {
		wait.until(ExpectedConditions.visibilityOf(txtbx_Estado)).click();
		txtbx_Estado.sendKeys(estado);
	}
	public void cartaoPostal(String cartaoPostal) throws Exception {
		wait.until(ExpectedConditions.visibilityOf(txtbx_CartaoPostal)).click();
		txtbx_CartaoPostal.sendKeys(cartaoPostal);
	}
	public void Registrar() throws Exception {
		wait.until(ExpectedConditions.visibilityOf(btn_Registrar));
		btn_Registrar.click();
	}
}
