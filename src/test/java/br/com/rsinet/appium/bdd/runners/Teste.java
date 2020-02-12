package br.com.rsinet.appium.bdd.runners;

import java.io.File;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions
(features = "src/test/resources/TesteFuncional", 
glue = {"br.com.rsinet.appium.bdd.stepDefinition" }, 
tags = {
		  "@CadastroComSucesso,"
		+ "@SenhaDigitadaIncorretamente,"
		+ "@BuscaPelaLupaComSucesso,"
		+ "@FalhaPorProdutoInexistente,"
		+ "@BuscaDeProdutoComSucesso,"
		+ "@FalhaPorQuantidadeNoCarrinhoDivergente"},

plugin = { "pretty", "com.cucumber.listener.ExtentCucumberFormatter:target/reports.html"},
		monochrome = true
		)

public class Teste {

	@AfterClass
	 public static void writeExtentReport() {
	 Reporter.loadXMLConfig(new File("configuracoes/extension-config.xml"));
	 }

}
