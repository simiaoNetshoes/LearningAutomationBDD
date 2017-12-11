package br.com.yaman.automacao.funcionalidade;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import br.com.yaman.automacao.navegador.selenium.browser.WebDriverFactory;
import br.com.yaman.automacao.navegador.selenium.command.CommandWeb;
import br.com.yaman.automacao.navegador.selenium.searchElement.SearchElement;
import br.com.yaman.automacao.navegador.utils.Navegador;
import br.com.yaman.automacao.navegador.utils.Sites;
import br.com.yaman.automacao.page.ItemPesquisadoBean;
import br.com.yaman.automacao.page.MlPaginaInicialPage;
import br.com.yaman.automacao.page.MlPesquisaPage;
import br.com.yaman.automacao.utils.LoggerUtils;
import cucumber.api.DataTable;

public class MlPaginaInicialFunc {
	LoggerUtils logger = new LoggerUtils(MlPaginaInicialFunc.class);

	WebDriverFactory webDriverFactory = new WebDriverFactory();
	protected WebDriver webDriver = webDriverFactory.setWebDriver(Navegador.CHROME).getWebDriver();

	CommandWeb command = new CommandWeb(webDriver);
	SearchElement searchElement = new SearchElement(webDriver);

	MlPaginaInicialPage mlPaginaInicialPage = new MlPaginaInicialPage(command, searchElement);
	MlPesquisaPage mlPesquisaPage = new MlPesquisaPage(command, searchElement);

	public void acessaPaginaInicialMl() {
		command.goToSite(Sites.MERCADOLIVRE);
		command.hightLight(mlPaginaInicialPage.getInputBusca());
	}

	public void realizaPesquisaSimples(DataTable dataTable) {
		String itemPesquisado = null;
		for (Map<String, String> map : dataTable.asMaps(String.class, String.class)) {
			itemPesquisado = map.get("itemPesquisado");
		}
		
		command.inputValue(mlPaginaInicialPage.getInputBusca(), itemPesquisado);
		command.hightLight(mlPaginaInicialPage.getInputBusca());
		command.click(mlPaginaInicialPage.getLupaPesquisar());
		
		if(mlPesquisaPage.getItemPesquisado().getText().contains(itemPesquisado.toLowerCase())) {
			command.hightLight(mlPesquisaPage.getItemPesquisado());
			logger.info("Pesquisa realizada com sucesso...");
		}else {
			logger.info("Pesquisa realizada não retornou itens para verificação...");
			throw new RuntimeException(); 
		}
	}

	public void imprimirDadosCincoPrimeirosResultados() {
		List<ItemPesquisadoBean> listaItens = mlPesquisaPage.getListItensPesquisadosValues();
		
		if (listaItens.size()<5) {
			logger.info("\n A pesquisa retornou menos de 5 resultados! \n"); 
		}
		
		for (int i = 0; i < 5; i++) {
			logger.info("\n"
					+ "**********************************[Item - "+listaItens.get(i).getPosicao()+" ]***********************************\n"
					+ "*                                                                              *\n"
					+ "*  Nome do produto: "+listaItens.get(i).getNome()+"\n"
					+ "*  Valor do produto: "+listaItens.get(i).getValor()+"                                                  *\n"
					+ "*                                                                              *\n"
					+ "********************************************************************************");
		}
		webDriver.quit();
	}

	public void paginarTo(DataTable dataTable) {
		String numPagina = null;
		for (Map<String, String> map : dataTable.asMaps(String.class, String.class)) {
			numPagina = map.get("paginacao");
		}
		paginaPesquisa(numPagina);
		
	}
	
	/*
	 * Realiza paginação para a pagina informada como parêmetro
	 */
	private void paginaPesquisa(String numPagina) {
		mlPesquisaPage.getPaginacaoElement(numPagina).click();
	}

	/*
	 * 
	 */
	public void evidenciaPenultimoAnuncio() {
		List<WebElement> listaItens = mlPesquisaPage.getListItensPesquisadosElements();
		WebElement penultimoItem = listaItens.get(listaItens.size()-2);
		searchElement.rollToElement(penultimoItem);
		command.screenShot(penultimoItem);
		webDriver.quit();
	}
}
