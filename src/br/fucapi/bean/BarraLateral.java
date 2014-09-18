package br.fucapi.bean;

import br.fucapi.persistencia.Css;

public class BarraLateral {

	private Css layout;
	private String conteudo;
	
	public BarraLateral(String conteudo, String border, String hight, String margin, String padding, String width) {
		this.layout = new Css(hight, width, border, margin, padding);
		this.conteudo = conteudo;
	}

	@Override
	public String toString() {
		return "BarraLateral [layout=" + layout + ", conteudo=" + conteudo
				+ "]";
	}

	public Css getLayout() {
		return layout;
	}

	public void setLayout(Css layout) {
		this.layout = layout;
	}

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}
	
	
}
