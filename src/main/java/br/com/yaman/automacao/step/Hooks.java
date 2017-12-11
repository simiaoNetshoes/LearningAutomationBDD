package br.com.yaman.automacao.step;

import java.nio.file.Paths;

import org.apache.log4j.PropertyConfigurator;

import br.com.yaman.automacao.utils.LoggerUtils;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

/**
 * 
 * Propósito da classe: Gerenciar os metodos executados antes e após a execução dos testes 
 *
 * @since 10 de Dez de 2017 16:43:36
 * @author Daniel Simião<BR>
 *         DesafioYaman<BR>
 * 
 */
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
