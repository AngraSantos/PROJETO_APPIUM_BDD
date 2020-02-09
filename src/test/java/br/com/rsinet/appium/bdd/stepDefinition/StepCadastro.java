package br.com.rsinet.appium.bdd.stepDefinition;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.rsinet.appium.bdd.ScreenFactory.ScreenCadastro;
import br.com.rsinet.appium.bdd.ScreenFactory.ScreenHome;
import br.com.rsinet.appium.bdd.ScreenFactory.ScreenLogin;
import br.com.rsinet.appium.bdd.driver.DriverAplicacaoAdvantage;
import br.com.rsinet.appium.bdd.excel.Acoes;
import br.com.rsinet.appium.bdd.excel.MassaDeDados;
import cucumber.api.java.After;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class StepCadastro {
	
	private AndroidDriver<MobileElement> driver;
	private ScreenHome telaInicial;
	private ScreenLogin login;
	private ScreenCadastro cadastro;
	private MassaDeDados massa;
	private Acoes acao;
	private WebDriverWait wait;

	@Dado("^que cliente esteja no aplicativo$")
	public void que_cliente_esteja_no_aplicativo() throws Throwable {
		
		driver = DriverAplicacaoAdvantage.iniciarDriver();
	
		cadastro = new ScreenCadastro(driver);
		massa = new MassaDeDados();
		acao = new Acoes(driver);
		wait = new WebDriverWait(driver, 20);
		telaInicial = new ScreenHome(driver);
		login = new ScreenLogin(driver);
		
	}

	@Dado("^clica em login$")
	public void clica_em_login() throws Throwable {
		
		telaInicial.clicarMenu();

	}

	@Dado("^em seguida clica em criar novo usuario$")
	public void em_seguida_clica_em_criar_novo_usuario() throws Throwable {
		
		login.clicarLogin();
		login.criarContaNova();
		
	}

	@Quando("^preencher o cadastro$")
	public void preencher_o_cadastro() throws Throwable {

		cadastro.usuario(massa.usuario());
		cadastro.email(massa.email());
		cadastro.senha(massa.senha());
		cadastro.confirmeSenha(massa.confirmeSenha());

		cadastro.primeiroNome(massa.primeiroNome());
		cadastro.ultimoNome(massa.ultimoNome());
		cadastro.telefone(massa.telefone());

		acao.scroll();

		cadastro.pais(driver, "Brazil");
		cadastro.estado(massa.estado());
		cadastro.endereco(massa.endereco());
		cadastro.cidade(massa.cidade());
		cadastro.cartaoPostal(massa.cartaoPostal());

	}

	@Quando("^clicar no botao de registrar$")
	public void clicar_no_botao_de_registrar() throws Throwable {
		
		cadastro.Registrar();
	}

	@Entao("^o cadastro estara efetuado com sucesso$")
	public void o_cadastro_estara_efetuado_com_sucesso() throws Throwable {
		
		telaInicial.clicarMenu();
		
		WebElement element = driver.findElement(By.id("com.Advantage.aShopping:id/textViewMenuUser"));
		wait.until(ExpectedConditions.visibilityOf(element));
		assertEquals(element.getText(), massa.usuario());

	}

	@Quando("^preencher o pais$")
	public void preencher_o_pais() throws Throwable {
	
		cadastro.telefone(" ");
		acao.scroll();
		cadastro.pais(driver, "Brazil");

	}

	@Entao("^ao preencher o estado ira contar a quantidade de caracteres excedido$")
	public void ao_preencher_o_estado_ira_contar_a_quantidade_de_caracteres_excedido() throws Throwable {

		cadastro.estado(massa.estadoInvalido());
		cadastro.endereco(" ");
		assertTrue(driver.getPageSource().contains("Use up to 10 characters"));
		
	}
	
	@After
	public void finalizando () {
		
		driver = DriverAplicacaoAdvantage.FechandoJanela();
	}
}
