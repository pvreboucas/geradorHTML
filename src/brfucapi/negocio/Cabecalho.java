package brfucapi.negocio;

public class Cabecalho {
	
	private Layout layout;
	private String titulo;
	
	public Cabecalho(String titulo, String border, String height, String margin, String padding, String width) {
		
		this.layout = new Layout(height, width, border, margin, padding);
		this.titulo = titulo;
	}

	@Override
	public String toString() {
		return "Cabecalho [layout=" + layout + ", titulo=" + titulo + "]";
	}

	public Layout getLayout() {
		return layout;
	}

	public void setLayout(Layout layout) {
		this.layout = layout;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	

}
