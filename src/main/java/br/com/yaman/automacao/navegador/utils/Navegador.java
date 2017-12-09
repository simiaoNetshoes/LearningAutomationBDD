package br.com.yaman.automacao.navegador.utils;

public enum Navegador {
	   FIREFOX("fireFox"),
	    CHROME("chrome"),
	    IE("internetExplorer");
	 
	    private String descricao;
	 
	    Navegador(String descricao) {
	        this.descricao = descricao;
	    }
	 
	    public String getDescricao() {
	        return descricao;
	    }
}
