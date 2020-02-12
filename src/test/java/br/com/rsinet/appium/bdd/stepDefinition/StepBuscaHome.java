package br.com.rsinet.appium.bdd.stepDefinition;

import static br.com.rsinet.appium.bdd.driver.DriverAplicacaoAdvantage.iniciarDriver;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.rsinet.appium.bdd.ScreenFactory.ScreenHome;
import br.com.rsinet.appium.bdd.ScreenFactory.ScreenLogin;
import br.com.rsinet.appium.bdd.ScreenFactory.ScreenProduto;
import br.com.rsinet.appium.bdd.utilitarios.RolagemTela;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class StepBuscaHome {

	private AndroidDriver<MobileElement> driver;
	private ScreenProduto produto;
	private ScreenHome telaInicial;
	private WebDriverWait wait;
	private ScreenLogin login;
	private RolagemTela rolagem;

	@Dado("^que cliente esta no aplicativo da AdvantageDEMO$")
	public void que_cliente_esta_no_aplicativo_da_AdvantageDEMO() throws Throwable {

		driver = iniciarDriver();
	
		produto = new ScreenProduto(driver);
		wait = new WebDriverWait(driver, 20);
		telaInicial = new ScreenHome(driver);
		login = new ScreenLogin(driver);
		rolagem = new RolagemTela(driver);
	}

	@Quando("^selecionar uma categoria na tela inicial$")
	public void selecionar_uma_categoria_na_tela_inicial() throws Throwable {

		rolagem.scroll("Mice");
	}
	
	@Quando("^clica no produto$")
	public void clica_no_produto() throws Throwable {

		rolagem.scroll("MICROSOFT SCULPT TOUCH MOUSE");
	}

	@Entao("^ira aparecer o produto que foi escolhido$")
	public void ira_aparecer_o_produto_que_foi_escolhido() throws Throwable {

		WebElement element = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout[2]/android.widget.TextView"));
		wait.until(ExpectedConditions.visibilityOf(element));
		assertEquals(element.getText(), "MICROSOFT SCULPT TOUCH MOUSE");

	}

	@Dado("^clicar no botao do menu$")
	public void clicar_no_botao_do_menu() throws Throwable {
		
		telaInicial.clicarMenu();
	}
	
	@Quando("^clicar no botao do Login$")
	public void clicar_no_botao_do_Login() throws Throwable {
		
		login.clicarLogin();
		
	}
	
	@Quando("^fazer o login \"([^\"]*)\" , \"([^\"]*)\"$")
	public void fazer_o_login(String username, String senha) throws Throwable {

		login.incluirUsuario(username);		
		login.incluirSenha(senha);
		
		login.apertarBotaoEntrarLogin();

	}

	@Quando("^selecionar o categoria de produto desejado$")
	public void selecionar_o_categoria_de_produto_desejado() throws Throwable {

		telaInicial.clicarHeadphones();
	}

	@Quando("^escolher o produto$")
	public void escolher_o_produto() throws Throwable {

		produto.FoneLogitech();
	}

	@Quando("^escolher a quantidade$")
	public void escolher_a_quantidade() throws Throwable {

		produto.Quantidade();
		produto.QuantidadeDeProduto("20");
		produto.confirmarQuantidade();
	}

	@Quando("^incluir no carrinho$")
	public void incluir_no_carrinho() throws Throwable {

		produto.incluirCarrinho();
		produto.clicarCarrinho();
	}

	@Entao("^tera uma quantidade divergente do solicitado$")
	public void tera_uma_quantidade_divergente_do_solicitado() throws Throwable {

		assertTrue(driver.getPageSource().contains("10"));

	}
}
