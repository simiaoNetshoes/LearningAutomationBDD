package br.com.yaman.automacao.page;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;

import br.com.yaman.automacao.navegador.selenium.command.CommandWeb;
import br.com.yaman.automacao.navegador.selenium.searchElement.SearchElement;

/**
 * 
 * Propósito da classe: Encapsular metodos de captura de Elementos na tela Inicial Mercado Livre
 *
 * @since 10 de Dez de 2017 13:37:49
 * @author Daniel Simião<BR>
 *         DesafioYaman<BR>
 * 
 */
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
	public final String paginacaoElements = "//*[@id=\"results-section\"]//li[@class='pagination__page']/a";

	
	/**
	 * 
	 * Propósito do Método: retorna o elemento que evidencia qual item foi pesquisado para confirmação de sucesso na pesquisa
	 *
	 * @since 10 de Dez de 2017 13:38:19
	 * @author Daniel Simião<BR>
	 *         DesafioYaman<BR>
	 * 
	 */
	public WebElement getItemPesquisado() {
		return searchElement.getWebElement(valueItemPesquisado);
	}

	/**
	 * 
	 * Propósito do Método: retorna o elemento que evidencia qual que a pesquisa não retornou resultados
	 *
	 * @since 10 de Dez de 2017 13:46:34
	 * @author Daniel Simião<BR>
	 *         DesafioYaman<BR>
	 * 
	 */
	public WebElement getMensagemRetornoNegativo() {
		return searchElement.getWebElement(mensagemRetornoNegativo);
	}

	/**
	 * Devolve Lista de objetos do tipo ItemPesquisadoBean contendo os dados dos
	 * items retornados na tela após pesquisa
	 * 
	 * @return List<ItemPesquisadoBean>
	 */
	public List<ItemPesquisadoBean> getListItensPesquisadosValues() {
		List<ItemPesquisadoBean> listaItens = new ArrayList<ItemPesquisadoBean>();
		int quantItens = searchElement.getListWebElements(contItensLista).size();

		for (int i = 1; i <= quantItens; i++) {
			ItemPesquisadoBean item = new ItemPesquisadoBean();
			item.setNome(getNomeItemOnList(i));
			item.setValor(getValorItemOnList(i));
			item.setPosicao(i);

			listaItens.add(item);
		}
		return listaItens;
	}

	/**
	 * 
	 * Propósito do Método: retorna uma lista de elementos retornados na pesquisa realizada
	 *
	 * @since 10 de Dez de 2017 13:50:37
	 * @author Daniel Simião<BR>
	 *         DesafioYaman<BR>
	 * 
	 */
	public List<WebElement> getListItensPesquisadosElements() {
		return searchElement.getListWebElements(contItensLista);
	}

	/**
	 * 
	 * Propósito do Método: retorna o nome de um elemento retornado na pesquisa
	 *
	 * @since 10 de Dez de 2017 13:55:19
	 * @author Daniel Simião<BR>
	 *         DesafioYaman<BR>
	 * 
	 */
	private String getNomeItemOnList(int posit) {
		return searchElement.getWebElement(
				"//*[@id='searchResults']/li[" + posit + "]//h2[@class='item__title list-view-item-title']/span")
				.getText();
	}

	/**
	 * 
	 * Propósito do Método: retorna o nome de um elemento retornado na pesquisa
	 *
	 * @since 10 de Dez de 2017 13:59:53
	 * @author Daniel Simião<BR>
	 *         DesafioYaman<BR>
	 * 
	 */
	private String getValorItemOnList(int posit) {
		return searchElement.getWebElement("//*[@id='searchResults']/li[" + posit + "]//span[@class='price-symbol']")
				.getText()
				+ " "
				+ searchElement
						.getWebElement("//*[@id='searchResults']/li[" + posit + "]//span[@class='price-fraction']")
						.getText();
	}


	/**
	 * 
	 * Propósito do Método: retorna o elemento de uma pagina do container de paginação da pesquisa
	 *
	 * @since 10 de Dez de 2017 15:12:28
	 * @author Daniel Simião<BR>
	 *         DesafioYaman<BR>
	 * 
	 */
	public WebElement getPaginacaoElement(String pagina) {
		List<WebElement> itensPaginacao = searchElement.getListWebElements(paginacaoElements);
		for (WebElement webElement : itensPaginacao) {
			if (webElement.getText().equals(pagina)) {
				return webElement;
			}
		}
		return null;
	}

}
