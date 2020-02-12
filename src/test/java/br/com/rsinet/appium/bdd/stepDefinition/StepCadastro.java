package br.com.rsinet.appium.bdd.stepDefinition;

import static br.com.rsinet.appium.bdd.driver.DriverAplicacaoAdvantage.iniciarDriver;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.rsinet.appium.bdd.ScreenFactory.ScreenCadastro;
import br.com.rsinet.appium.bdd.ScreenFactory.ScreenHome;
import br.com.rsinet.appium.bdd.ScreenFactory.ScreenLogin;
import br.com.rsinet.appium.bdd.utilitarios.RolagemTela;
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
	private RolagemTela rolagem;
	private WebDriverWait wait;

	@Dado("^que cliente esteja no aplicativo$")
	public void que_cliente_esteja_no_aplicativo() throws Throwable {

		driver = iniciarDriver();

		cadastro = new ScreenCadastro(driver);
		rolagem = new RolagemTela(driver);
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

	@Quando("^preencher o cadastro \"([^\"]*)\", \"([^\"]*)\" , \"([^\"]*)\" , \"([^\"]*)\" , \"([^\"]*)\" , \"([^\"]*)\" , \"([^\"]*)\" , \"([^\"]*)\" , \"([^\"]*)\" , \"([^\"]*)\" , \"([^\"]*)\" , \"([^\"]*)\"\"$")
	public void preencher_o_cadastro(String username, String email, String senha, String confirmeSenha,
			String primeiroNome, String ultimoNome, String telefone, String pais, String estado, String endereco,
			String cidade, String cartaoPostal) throws Throwable {

		cadastro.usuario(username);
		cadastro.email(email);
		cadastro.senha(senha);
		cadastro.confirmeSenha(confirmeSenha);

		cadastro.primeiroNome(primeiroNome);
		cadastro.ultimoNome(ultimoNome);
		cadastro.telefone(telefone);

		rolagem.scroll("ADDRESS");

		cadastro.pais(driver, pais);
		cadastro.estado(estado);
		cadastro.endereco(endereco);
		cadastro.cidade(cidade);
		cadastro.cartaoPostal(cartaoPostal);

	}

	@Quando("^clicar no botao de registrar$")
	public void clicar_no_botao_de_registrar() throws Throwable {

		cadastro.Registrar();
	}
	
	@Quando("^clica no menu$")
	public void clica_no_menu() throws Throwable {

		RolagemTela.scrollTempoInicialparaMenu();
		telaInicial.clicarMenu();
		
	}

	@Entao("^o cadastro estara efetuado com sucesso \"([^\"]*)\"$")
	public void o_cadastro_estara_efetuado_com_sucesso(String usuario) throws Throwable {

		WebElement element = driver.findElement(By.id("com.Advantage.aShopping:id/textViewMenuUser"));
        wait.until(ExpectedConditions.visibilityOf(element));
        assertEquals(element.getText(), usuario);

	}

	@Quando("^preencher o cadastro com falha \"([^\"]*)\", \"([^\"]*)\" , \"([^\"]*)\" , \"([^\"]*)\" , \"([^\"]*)\" , \"([^\"]*)\" , \"([^\"]*)\" , \"([^\"]*)\" , \"([^\"]*)\" , \"([^\"]*)\" , \"([^\"]*)\" , \"([^\"]*)\"\"$")
	public void preencher_o_cadastro_com_falha(String username, String email, String senha, String confirmeSenha,
			String primeiroNome, String ultimoNome, String telefone, String pais, String estado, String endereco, String cidade,
			String cartaoPostal) throws Throwable {
		
		cadastro.usuario(username);
		cadastro.email(email);
		cadastro.senha(senha);
		cadastro.confirmeSenha(confirmeSenha);

		cadastro.primeiroNome(primeiroNome);
		cadastro.ultimoNome(ultimoNome);
		cadastro.telefone(telefone);

		rolagem.scroll("ADDRESS");

		cadastro.pais(driver, pais);
		cadastro.estado(estado);
		cadastro.endereco(endereco);
		cadastro.cidade(cidade);
		cadastro.cartaoPostal(cartaoPostal);

		rolagem.scroll("ACCOUNT DETAILS");

	}

	@Entao("^ao preencher ira aparecer que foi preenchido o senha de forma errada$")
	public void ao_preencher_ira_aparecer_que_foi_preenchido_o_senha_de_forma_errada ()throws Throwable {
	 
		assertTrue(driver.getPageSource().contains("1 upper letter required"));

	}
}
