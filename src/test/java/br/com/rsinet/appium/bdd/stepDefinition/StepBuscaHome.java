package br.com.rsinet.appium.bdd.stepDefinition;

import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;

import br.com.rsinet.appium.bdd.ScreenFactory.ScreenCadastro;
import br.com.rsinet.appium.bdd.ScreenFactory.ScreenHome;
import br.com.rsinet.appium.bdd.ScreenFactory.ScreenLogin;
import br.com.rsinet.appium.bdd.excel.MassaDeDados;
import br.com.rsinet.appium.bdd.utilitarios.Acoes;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class StepBuscaHome {
	
	private AndroidDriver<MobileElement> driver;
	private ScreenCadastro cadastro;
	private ScreenHome telaInicial;
	private ScreenLogin novaConta;
	private Acoes acao;
	
	@Dado("^cliente esta no aplicativo da AdvantageDEMO$")
	public void cliente_esta_no_aplicativo_da_AdvantageDEMO() throws Throwable {

		telaInicial = new ScreenHome(driver);
		cadastro = new ScreenCadastro(driver);
		novaConta = new ScreenLogin(driver);
		acao = new Acoes(driver);

	}
	
	@Quando("^deve selecionar um produto na tela inicial$")
	public void deve_selecionar_um_produto_na_tela_inicial() throws Throwable {
		
		
	}

	@Quando("^pode escolher um produto$")
	public void pode_escolher_um_produto() throws Throwable {


	}

	@Entao("^aparecerar o produto que foi escolhido$")
	public void aparecerar_o_produto_que_foi_escolhido() throws Throwable {


	}

	@Quando("^fizer o cadastro$")
	public void fizer_o_cadastro() throws Throwable {


	}

	@Quando("^selecionar o categoria de produto desejado$")
	public void selecionar_o_categoria_de_produto_desejado() throws Throwable {


	}

	@Quando("^escolher o produto$")
	public void escolher_o_produto() throws Throwable {


	}

	@Quando("^escolher a quantidade$")
	public void escolher_a_quantidade() throws Throwable {


	}

	@Quando("^incluir no carrinho$")
	public void incluir_no_carrinho() throws Throwable {


	}

	@Entao("^tera uma quantidade divergente do solicitado$")
	public void tera_uma_quantidade_divergente_do_solicitado() throws Throwable {


	}
	
}