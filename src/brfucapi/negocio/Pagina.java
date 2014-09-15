package brfucapi.negocio;
import java.util.ArrayList;

public class Pagina {
	
	private Cabecalho cabecalho;
	private BarraLateral barraLateralDireita;
	private BarraLateral barraLateralEsquerda;
	private Layout layout;
	private Rodape rodape;
	private ArrayList<Post> listaPost;
	private Post post;
	private String uri;
	
	public Pagina(Cabecalho cabecalho, BarraLateral barraLateralDireita,
			BarraLateral barraLateralEsquerda, Rodape rodape,
			ArrayList<Post> listaPost, String uri, String border, String height, String margin, String padding, String width) {
		this.layout = new Layout(height, width, border, margin, padding);
		this.cabecalho = cabecalho;
		this.barraLateralDireita = barraLateralDireita;
		this.barraLateralEsquerda = barraLateralEsquerda;
		this.rodape = rodape;
		this.listaPost = listaPost;
		this.uri = uri;
	}
	
	public Pagina(Cabecalho cabecalho, Rodape rodape,
			Post post, String uri, String border, String height, String margin, String padding, String width) {
		this.layout = new Layout(height, width, border, margin, padding);
		this.cabecalho = cabecalho;
		this.rodape = rodape;
		this.post = post;
		this.uri = uri;
		//this.listaPost = null;
	}

	@Override
	public String toString() {
		return "\nPagina [cabecalho=" + cabecalho + ", barraLateralDireita="
				+ barraLateralDireita + ", barraLateralEsquerda="
				+ barraLateralEsquerda + ", layout=" + layout + ", rodape="
				+ rodape + ", listaPost=" + listaPost + ", uri=" + uri + "]";
	}

	public Cabecalho getCabecalho() {
		return cabecalho;
	}

	public void setCabecalho(Cabecalho cabecalho) {
		this.cabecalho = cabecalho;
	}

	public BarraLateral getBarraLateralDireita() {
		return barraLateralDireita;
	}

	public void setBarraLateralDireita(BarraLateral barraLateralDireita) {
		this.barraLateralDireita = barraLateralDireita;
	}

	public BarraLateral getBarraLateralEsquerda() {
		return barraLateralEsquerda;
	}

	public void setBarraLateralEsquerda(BarraLateral barraLateralEsquerda) {
		this.barraLateralEsquerda = barraLateralEsquerda;
	}

	public Layout getLayout() {
		return layout;
	}

	public void setLayout(Layout layout) {
		this.layout = layout;
	}

	public Rodape getRodape() {
		return rodape;
	}

	public void setRodape(Rodape rodape) {
		this.rodape = rodape;
	}

	public ArrayList<Post> getListaPost() {
		return listaPost;
	}

	public void setListaPost(ArrayList<Post> listaPost) {
		this.listaPost = listaPost;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}
	

}
