package brfucapi.negocio;
import java.sql.Date;
import java.util.ArrayList;


public class Site {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	
		Fachada fachada = new Fachada();
	
		Post post = fachada.criarPost("conteudo", new Date(System.currentTimeMillis()), null,"height", "width", "border", "margin", "padding", "uriPost");
		//Comentario comentario = fachada.criarComentario("nome", "email", "texto", new Date(System.currentTimeMillis()), "height", "width", "border", "margin", "padding");
		Cabecalho cabecalho = fachada.criarCabecalho("tituloCabecalho", "height", "width", "border", "margin", "padding");
		Rodape rodape = fachada.criarRodape("contatoTelefone", "contatoEmail", "contatoEndereco", "copyright", "border", "height", "margin", "padding", "width");
		BarraLateral barraLateralDireita = fachada.criarBarraLateral("conteudo", "border", "hight", "margin", "padding", "width");
		BarraLateral barraLateralEsquerda = fachada.criarBarraLateral("conteudo", "border", "hight", "margin", "padding", "width");
		
		ArrayList<Post> listaPost = null;
		
		Pagina paginaPrincipal = fachada.criarPaginaPrincipal(cabecalho, barraLateralDireita, barraLateralEsquerda, rodape, listaPost, "uri", "border","hight", "margin", "padding", "width");
		Pagina paginaPost = fachada.criarPaginaPost(cabecalho, rodape, post, "uri", "border", "height", "margin", "padding", "width");
		
		
		fachada.exibirPagina(paginaPrincipal);
		fachada.exibirPaginaPost(paginaPost); 

	}

}
