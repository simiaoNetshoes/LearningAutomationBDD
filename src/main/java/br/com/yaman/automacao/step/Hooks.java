package br.com.yaman.automacao.step;

import java.nio.file.Paths;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;

import br.com.yaman.automacao.config.ConfigDo;
import br.com.yaman.automacao.navegador.selenium.browser.WebDriverFactory;
import br.com.yaman.automacao.navegador.utils.Navegador;
import br.com.yaman.automacao.utils.LoggerUtils;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;


public class Hooks {
	LoggerUtils logger = new LoggerUtils(Hooks.class);

	@Before
	public void initialize(Scenario scenario) throws Throwable {
		PropertyConfigurator
				.configure(Paths.get("").toAbsolutePath().toString() + "/src/main/resources/drivers/log4j.properties");
		logger.info("Iniciando test");
	}

	@After
	public void finalize(Scenario scenario) throws Throwable {
		logger.info("Finalizado test");
	
	}

}
