package br.com.yaman.automacao.navegador.utils;

public enum Sites {
	   MERCADOLIVRE("https://www.mercadolivre.com.br/"),
	    OLX("https://www.olx.com.br/");
	 
	    private String descricao;
	 
	    Sites(String descricao) {
	        this.descricao = descricao;
	    }
	 
	    public String getDescricao() {
	        return descricao;
	    }
}
