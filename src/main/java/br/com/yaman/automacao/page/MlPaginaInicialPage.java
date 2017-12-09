package br.com.yaman.automacao.page;

import org.openqa.selenium.WebElement;

import br.com.yaman.automacao.navegador.selenium.command.CommandWeb;
import br.com.yaman.automacao.navegador.selenium.searchElement.SearchElement;

public class MlPaginaInicialPage {
	CommandWeb command;
	SearchElement searchElement;

	public MlPaginaInicialPage(CommandWeb command, SearchElement searchElement) {
		this.command = command;
		this.searchElement = searchElement;
	}
	
	public final String carrinhoDeComprasXp = "//*[@id='nav-cart']/i";
	public final String inputBuscaXp = "html/body/header/div/form/input";
	public final String buttonPesquisar = "html/body/header/div/form/button[3]";
		
	public WebElement getCarrinhoDeCompras() {
		return searchElement.getWebElement(carrinhoDeComprasXp);
	}

	public WebElement getInputBusca() {
		return searchElement.getWebElement(inputBuscaXp);
	}

	public WebElement lupaPesquisar() {
		return searchElement.getWebElement(buttonPesquisar);
	}		
}
