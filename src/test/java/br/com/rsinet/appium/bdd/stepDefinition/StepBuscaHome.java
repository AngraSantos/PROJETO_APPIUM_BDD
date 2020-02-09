package br.com.rsinet.appium.bdd.stepDefinition;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.rsinet.appium.bdd.ScreenFactory.ScreenHome;
import br.com.rsinet.appium.bdd.ScreenFactory.ScreenLogin;
import br.com.rsinet.appium.bdd.ScreenFactory.ScreenProduto;
import br.com.rsinet.appium.bdd.driver.DriverAplicacaoAdvantage;
import br.com.rsinet.appium.bdd.excel.MassaDeDados;
import cucumber.api.java.After;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class StepBuscaHome {

	private AndroidDriver<MobileElement> driver;
	private ScreenProduto produto;
	private MassaDeDados massa;
	private ScreenHome telaInicial;
	private WebDriverWait wait;
	private ScreenLogin login;

	@Dado("^que cliente esta no aplicativo da AdvantageDEMO$")
	public void que_cliente_esta_no_aplicativo_da_AdvantageDEMO() throws Throwable {

		driver = DriverAplicacaoAdvantage.iniciarDriver();

		massa = new MassaDeDados();
		produto = new ScreenProduto(driver);
		wait = new WebDriverWait(driver, 20);
		telaInicial = new ScreenHome(driver);
		login = new ScreenLogin(driver);
	}

	@Quando("^selecionar uma categoria na tela inicial$")
	public void selecionar_uma_categoria_na_tela_inicial() throws Throwable {

		telaInicial.clicarTablet();
	}

	@Quando("^ao selecionar um produto ira aparecer o que foi escolhido$")
	public void ao_selecionar_um_produto_ira_aparecer_o_que_foi_escolhido() throws Throwable {

		produto.tabletEliteX2();

		WebElement element = driver.findElement(By.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout[2]/android.widget.TextView"));
		wait.until(ExpectedConditions.visibilityOf(element));
		assertEquals(element.getText(), "HP ELITE X2 1011 G1 TABLET");

	}

	@Quando("^fazer o login$")
	public void fizer_o_login() throws Throwable {

		telaInicial.clicarMenu();
		login.clicarLogin();
		
		login.incluirUsuario(massa.usuario());
		login.incluirSenha(massa.senha());
		login.apertarBotaoEntrarLogin();

	}

	@Quando("^selecionar o categoria de produto desejado$")
	public void selecionar_o_categoria_de_produto_desejado() throws Throwable {

		telaInicial.clicarTablet();
	}

	@Quando("^escolher o produto$")
	public void escolher_o_produto() throws Throwable {

		produto.tabletEliteX2();

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
	}

	@Entao("^tera uma quantidade divergente do solicitado$")
	public void tera_uma_quantidade_divergente_do_solicitado() throws Throwable {

		produto.clicarCarrinho();
		assertTrue(driver.getPageSource().contains("10"));

	}
	
	@After
	public void finalizando () {
		
		driver = DriverAplicacaoAdvantage.FechandoJanela();
	}
}
