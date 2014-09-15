package brfucapi.negocio;

public class BarraLateral {

	private Layout layout;
	private String conteudo;
	
	public BarraLateral(String conteudo, String border, String hight, String margin, String padding, String width) {
		this.layout = new Layout(hight, width, border, margin, padding);
		this.conteudo = conteudo;
	}

	@Override
	public String toString() {
		return "BarraLateral [layout=" + layout + ", conteudo=" + conteudo
				+ "]";
	}

	public Layout getLayout() {
		return layout;
	}

	public void setLayout(Layout layout) {
		this.layout = layout;
	}

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}
	
	
}
