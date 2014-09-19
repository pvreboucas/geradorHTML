package br.fucapi.bean;

public class Cabecalho {
	
//	private Css layout;
	private String titulo;
	
	public Cabecalho(String titulo/*, String border, String height, String margin, String padding, String width*/) {
		
//		this.layout = new Css(height, width, border, margin, padding);
		this.titulo = titulo;
	}

	@Override
	public String toString() {
		return "Cabecalho [titulo=" + titulo + "]";
	}

	/*	public Css getLayout() {
		return layout;
	}

	public void setLayout(Css layout) {
		this.layout = layout;
	}
*/
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	

}
