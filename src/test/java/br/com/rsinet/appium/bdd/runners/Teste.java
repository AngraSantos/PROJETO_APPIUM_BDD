package br.com.rsinet.appium.bdd.runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions
(features = "src/test/resources/TesteFuncional", 
glue = {"br.com.rsinet.appium.bdd.stepDefinition" }, 
tags = {
		"@CadastroComSucesso ,"
		+ " @SenhaDigitadaIncorretamente"},
//		"@BuscaPelaLupaComSucesso",
//		"@BuscaPelaLupaComFalhaPorProdutoInexistente", 
//		"@BuscaDeProdutoComSucesso",
//		"@BuscaDeProdutoComFalhaPorQuantidadeNoCarrinhoDivergente"},
//plugin = { "pretty", "com.cucumber.listener.ExtentCucumberFormatter:target/reports.html"},
		monochrome = true)

public class Teste {

//	@AfterClass
//	 public static void writeExtentReport() {
//	 Reporter.loadXMLConfig(new File("./extension-config.xml"));
//	 }

}
