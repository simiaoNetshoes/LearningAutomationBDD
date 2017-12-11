package br.com.yaman.automacao.step;

import br.com.yaman.automacao.funcionalidade.MlPaginaInicialFunc;
import cucumber.api.DataTable;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;

public class PaginaInicialStep {
	MlPaginaInicialFunc paginaInicialFuncionalidade = new MlPaginaInicialFunc();
	
	@Dado("^que tenha acessado o site Mercado Livre$")
	public void queTenhaAcessadoSiteMercadoLivre() throws Throwable {
		paginaInicialFuncionalidade.acessaPaginaInicialMl();
	}

	@E("^que tenha realizado pesquisa na pagina inicial do Mercado Livre$")
	public void given(DataTable dataTable) throws Throwable {
		paginaInicialFuncionalidade.realizaPesquisaSimples(dataTable);
	}

	@Quando("^pesquisa retorna resultados esperados na pagina de pesquisa Mercado Livre$")
	public void when() throws Throwable {
	}

	@Quando("^paginar resultados ate a pagina informada$")
	public void paginarAteApaginaInformada(DataTable dataTable) throws Throwable {
		paginaInicialFuncionalidade.paginarTo(dataTable);
	}

	@Entao("^sera impresso os cinco primeiros resultados na pagina de pequisas Mercado Livre$")
	public void then() throws Throwable {
		paginaInicialFuncionalidade.imprimirDadosCincoPrimeirosResultados();
	}

	@Entao("^sera evidenciado o penultimo anuncio da pagina de pequisas Mercado Livre$")
	public void evidenciaPenultimoAnuncio() throws Throwable {
		paginaInicialFuncionalidade.evidenciaPenultimoAnuncio();
	}

}
