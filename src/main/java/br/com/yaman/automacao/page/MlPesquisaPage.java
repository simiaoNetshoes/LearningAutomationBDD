package br.com.yaman.automacao.page;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;

import br.com.yaman.automacao.navegador.selenium.command.CommandWeb;
import br.com.yaman.automacao.navegador.selenium.searchElement.SearchElement;

public class MlPesquisaPage {
	CommandWeb command;
	SearchElement searchElement;

	public MlPesquisaPage(CommandWeb command, SearchElement searchElement) {
		this.command = command;
		this.searchElement = searchElement;
	}

	public final String valueItemPesquisado = ".//*[@id='inner-main']/aside/div[1]/h1";
	public final String mensagemRetornoNegativo = "*//h3[contains(text(),'Não há anúncios que coincidam com a sua busca.')]";
	public final String listaDeResultadosPesquisa = ".//*[@id='searchResults']";
	public final String nomeProdutoDaLista = "//*[@id=\"searchResults\"]/li[1]/div/div[2]/div/h2/a/span";
	public final String contItensLista = "//*[@id='searchResults']/li";

	public WebElement getItemPesquisado() {
		return searchElement.getWebElement(valueItemPesquisado);
	}

	public WebElement getMensagemRetornoNegativo() {
		return searchElement.getWebElement(mensagemRetornoNegativo);
	}

	public List<ItemPesquisadoBean> getListItensPesquisados() {
		List<ItemPesquisadoBean> listaItens = new ArrayList<ItemPesquisadoBean>();

		for (WebElement itemLista : searchElement.getListWebElements(contItensLista)) {
			ItemPesquisadoBean item = new ItemPesquisadoBean();
			item.setNome(getNomeItemOnList(1));
			item.setValor(getValorItemOnList(1));
			item.setPosicao(1);

			listaItens.add(item);
		}

		return listaItens;
	}

	private String getNomeItemOnList(int posit) {
		return searchElement.getWebElement(
				"//*[@id='searchResults']/li[" + posit + "]//h2[@class='item__title list-view-item-title']/span")
				.getText();
	}

	private String getValorItemOnList(int posit) {
		return searchElement.getWebElement("//*[@id='searchResults']/li[" + posit + "]//span[@class='price-symbol']")
				.getText()
				+ " "
				+ searchElement
						.getWebElement("//*[@id='searchResults']/li[" + posit + "]//span[@class='price-fraction']")
						.getText();
	}

}
