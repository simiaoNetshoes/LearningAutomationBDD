package br.com.yaman.automacao.funcionalidade;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

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
		command.screenShot(mlPaginaInicialPage.getCarrinhoDeCompras());
	}

	public void realizaPesquisaSimples(DataTable dataTable) {
		String itemPesquisado = null;
		for (Map<String, String> map : dataTable.asMaps(String.class, String.class)) {
			itemPesquisado = map.get("itemPesquisado");
		}
		
		command.inputValue(mlPaginaInicialPage.getInputBusca(), itemPesquisado);
		command.click(mlPaginaInicialPage.lupaPesquisar());
		
		if(mlPesquisaPage.getItemPesquisado().getText().contains(itemPesquisado.toLowerCase())) {
			command.screenShot(mlPesquisaPage.getItemPesquisado());
			logger.info("Pesquisa realizada com sucesso...");
		}else {
			logger.info("Pesquisa realizada não retornou itens para verificação...");
			throw new RuntimeException(); 
		}
	}

	public void imprimirDadosCincoPrimeirosResultados() {
		 mlPesquisaPage.getListItensPesquisados();
		//	mlPesquisaPage.get
		
	}
}
