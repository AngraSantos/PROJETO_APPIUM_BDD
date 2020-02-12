package br.com.rsinet.appium.bdd.stepDefinition;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.cucumber.listener.Reporter;

import br.com.rsinet.appium.bdd.driver.DriverAplicacaoAdvantage;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

	public class hooks {

		private AndroidDriver<MobileElement> driver;

		public hooks() throws Exception {
			driver = DriverAplicacaoAdvantage.iniciarDriver();
		}

		public String time() {
			return new SimpleDateFormat("dd_MM_yyyy HH.mm.ss").format(new Date());
		}
		
		@After
		public void finalizarDriver(Scenario scenario) throws IOException {


			String screenShotNome = scenario.getName().replaceAll(" ", "_");

			File sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

			String destinationPath = System.getProperty("user.dir") + "/target/report/" + screenShotNome + time()
					+ ".png";
			try {
				FileUtils.copyFile(sourcePath, new File(destinationPath));

			} catch (IOException e) {
				System.out.println("erro ao copiar arquivo para a pasta" + e.getMessage());
			}
			Reporter.addScreenCaptureFromPath(destinationPath);
			
			driver = DriverAplicacaoAdvantage.FechandoJanela();

		}
	}

