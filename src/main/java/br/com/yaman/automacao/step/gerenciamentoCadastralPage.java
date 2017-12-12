package br.com.yaman.automacao.step;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;

/**
 * 
 * Propósito da classe: Gerenciar os metodos de acesso as funcionalidades
 * da tela Gerenciamento de Funcionarios
 *
 * @since 11 de Dez de 2017 16:43:36
 * @author Daniel Simião<BR>
 *         DesafioYaman<BR>
 * 
 */
public class gerenciamentoCadastralPage {
	@Dado("^que tenha acessado o sistema$")
	public void metodo01(){
	}
	
	@Dado("^que tenha realizado login com as credencias$")
	public void metodo02() {
	}
	
	@Quando("^realizar inclusão de funcionario na tela de  gerenciamento de funcionarios do sistema$")
	public void metodo03() {
	}
	
	@Quando("^realizar pesquisa de funcionario na tela de gerenciamento de funcionarios do sistema$")
	public void metodo04() {
	}
	
	@Quando("^realizar a acao de Alteracao Cadastral para o funcionario$")
	public void metodo05() {
	}
	
	@Quando("^realizar a acao de Exclusao para o funcionario$")
	public void metodo06() {
	}
	
	@Entao("^a pagina de inclusao retorna matricula gerada com sucesso$")
	public void metodo07() {
	}
	
	@Entao("^a pagina de Alteracao Cadastral retorna alteracao realizada com sucesso$")
	public void metodo08() {
	}
	
	@Entao("^a pagina de gerenciamento de funcionarios nao retorna um funcionario no sistema$")
	public void metodo09() {
	}
	
	
	
	
	
}
