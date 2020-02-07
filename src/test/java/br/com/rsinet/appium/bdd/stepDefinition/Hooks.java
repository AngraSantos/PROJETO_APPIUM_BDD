package br.com.rsinet.appium.bdd.stepDefinition;

import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.rsinet.appium.bdd.driver.DriverAplicacaoAdvantage;
import br.com.rsinet.appium.bdd.excel.MassaDeDados;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Hooks {
	
	private AndroidDriver<MobileElement> driver;
	private MassaDeDados massa;
	private WebDriverWait wait;
	
	@Before
	public void Driver() throws Exception {
		
		driver = DriverAplicacaoAdvantage.iniciarDriver();
		massa = new MassaDeDados();
		wait = new WebDriverWait(driver, 20);
	}
	
	@After
	public void finalizar() {
		
		DriverAplicacaoAdvantage.FechandoJanela();
	}


}
