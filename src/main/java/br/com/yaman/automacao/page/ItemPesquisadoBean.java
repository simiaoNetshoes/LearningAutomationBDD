package br.com.yaman.automacao.page;

/**
 * 
 * Propósito da classe: Gerar objetos correspondentes aos produtos exibidos na
 * pagina arqmazenando seus principais atributos
 *
 * @since 10 de Dez de 2017 11:01:05
 * @author Daniel Simião<BR>
 *         DesafioYaman<BR>
 * 
 */
public class ItemPesquisadoBean {
	String valor;
	String nome;
	int posicao;

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getPosicao() {
		return posicao;
	}

	public void setPosicao(int posicao) {
		this.posicao = posicao;
	}
}
