package br.com.rsinet.appium.bdd.stepDefinition;

import static br.com.rsinet.appium.bdd.driver.DriverAplicacaoAdvantage.iniciarDriver;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.rsinet.appium.bdd.ScreenFactory.ScreenHome;
import br.com.rsinet.appium.bdd.ScreenFactory.ScreenProduto;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class StepBuscaLupa {

	private AndroidDriver<MobileElement> driver;
	private ScreenHome telaInicial;
	private ScreenProduto produto;
	private WebDriverWait wait;

	@Dado("^cliente esta no aplicativo da AdvantageDEMO$")
	public void cliente_esta_no_aplicativo_da_AdvantageDEMO() throws Throwable {

		driver = iniciarDriver();
		telaInicial = new ScreenHome(driver);
		produto = new ScreenProduto(driver);
		wait = new WebDriverWait(driver, 50);

	}

	@Quando("^escrever o nome do item desejado \"([^\"]*)\"$")
	public void escrever_o_nome_do_item_desejado(String produto) throws Throwable {
	   
		telaInicial.buscarLupa(produto);
	}
	
	@Quando("^seleciona o produto$")
	public void seleciona_o_produto() throws Throwable {
		
		produto.mouseHPz4000();
	 
	}

	@Entao("^tera produto encontrado \"([^\"]*)\"$")
	public void tera_produto_encontrado(String nomeProduto) throws Throwable {
		
		assertTrue(driver.getPageSource().contains(nomeProduto));
	}

	
	@Quando("^escrever o nome do produto que nao existente \"([^\"]*)\"$")
	public void escrever_o_nome_do_produto_que_nao_existente(String produtoInexistente) throws Throwable {
	  
		
		telaInicial.buscarLupa(produtoInexistente);

	}

	
	@Entao("^chegara na pagina de produto nao encontrado$")
	public void chegara_na_pagina_de_produto_nao_encontrado() throws Throwable {

		WebElement NaoEncontrado = driver.findElement(By.id("com.Advantage.aShopping:id/textViewNoProductsToShow"));
		wait.until(ExpectedConditions.visibilityOf(NaoEncontrado));
		assertEquals(NaoEncontrado.getText(), "- No results for \"fone\" -");
	   
	}

}
