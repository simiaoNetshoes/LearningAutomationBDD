package br.com.yaman.automacao.config;

import org.openqa.selenium.WebDriver;

import br.com.yaman.automacao.navegador.selenium.browser.WebDriverFactory;
import br.com.yaman.automacao.navegador.utils.Navegador;


public class ConfigDo extends WebDriverFactory{

	public ConfigDo setNavegador(Navegador navegador) {
		setNavegador(navegador);
		return this;
	}

	public WebDriver getWebDriver() {
		return getInstance().getWebDriver();
	}
	public void quitDriver() {
		getWebDriver().quit();
	}
}
