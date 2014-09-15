package brfucapi.negocio;
import java.sql.Date;
import java.util.ArrayList;


public class Fachada {

	public void exibirPagina(Pagina pagina){
		System.out.println("\nPágina:");
		System.out.println(pagina.getCabecalho().toString());
		System.out.println(pagina.getBarraLateralEsquerda().toString());
		System.out.println(pagina.getBarraLateralDireita().toString());
	
		System.out.println(pagina.getRodape().toString());
		
		if(pagina.getListaPost()==null ){
			System.out.println("\nNão há posts");
		}
		else{
			for(int i = 0; i<pagina.getListaPost().size();i++){
				System.out.println(pagina.getListaPost().get(i).toString());
			}
		}
		
	}
	
	public void exibirPaginaPost(Pagina pagina){
		System.out.println("\nPágina:");
		System.out.println(pagina.getCabecalho().toString());
		System.out.println(pagina.getRodape().toString());
		
		if(pagina.getListaPost()==null ){
			System.out.println("\nNão há comentários");
		}
		else{
			for(int i = 0; i<pagina.getListaPost().size();i++){
				System.out.println(pagina.getListaPost().get(i).getListaComentarios().toString());
			}
		}
		
	}
	
	/*Exibir post
	 * */
	
	public void exibirPost(Post post){
		System.out.println(post.getConteudo());
		System.out.println(post.getData());
		
		if(post.getListaComentarios()== null){
			System.out.println("Não há comentários!");
		}else{
			for(int i=0; i< post.getListaComentarios().size();i++){
				System.out.println(post.getListaComentarios().get(i).toString());
			}
		}
		
		System.out.println(post.getLayout());
		System.out.println(post.getUriPost());
	}
	
	
//	BarraLateral barraLateralDireita = new BarraLateral("Barra Lateral Direita", "100px", "100px", "1px", "1px", "1px");
//	BarraLateral barraLateralEsquerda = new BarraLateral("Barra Lateral Esquerda", "100px", "100px", "1px", "1px", "1px");
//	
//	//CABEÇALHOS
//	Cabecalho cabecalho = new Cabecalho("Titulo Cabecalho", "100px", "100px", "1px", "1px", "1px");
//	
//	//RODAPÉ
//	Rodape rodape = new Rodape("9876-8764", "mail@fucapi.br", "Rua X S/N", "copyright", "100px", "100px", "1px", "1px", "1px");
//	
//	//POSTS
//	Post post1 = new Post("Como instaciar Classes1", new Date(System.currentTimeMillis()), "/Como-instaciar-classes", "100px", "100px", "1px", "1px", "1px");
//	Post post2 = new Post("Como instaciar Classes2", new Date(System.currentTimeMillis()), "/Como-instaciar-classes", "100px", "100px", "1px", "1px", "1px");
//	Post post3 = new Post("Como instaciar Classes3", new Date(System.currentTimeMillis()), "/Como-instaciar-classes", "100px", "100px", "1px", "1px", "1px");
//	Post post4 = new Post("Como instaciar Classes4", new Date(System.currentTimeMillis()), "/Como-instaciar-classes", "100px", "100px", "1px", "1px", "1px");
//	Post post5 = new Post("Como instaciar Classes5", new Date(System.currentTimeMillis()), "/Como-instaciar-classes", "100px", "100px", "1px", "1px", "1px");
//	
//	ArrayList<Post> listPost = new ArrayList<Post>();

	public Pagina criarPaginaPrincipal(Cabecalho cabecalho, BarraLateral barraLateralDireita,
			BarraLateral barraLateralEsquerda, Rodape rodape,
			ArrayList<Post> listaPost, String uri, String border, String height, String margin, String padding, String width){
	
		Pagina pagina = new Pagina(cabecalho, barraLateralDireita, barraLateralEsquerda, rodape, listaPost, uri, border, height, margin, padding, width); 
		
		return pagina;
		
	}
	
	public Pagina criarPaginaPost(Cabecalho cabecalho, Rodape rodape, Post post,String uri,
			String border,String height,String margin,String padding,String width){
	
		Pagina pagina = new Pagina(cabecalho, rodape, post, uri, border, height, margin, padding, width);
		return pagina;
		
	}

	public Cabecalho criarCabecalho(String tituloCabecalho, String height, String width, String border, String margin, String padding){
		Cabecalho cabecalho = new Cabecalho(tituloCabecalho, border, height, margin, padding, width);
		
		return cabecalho;
	}
	
	public Post criarPost(String conteudo, Date dataPost, ArrayList<Comentario> comentario, String height, 
			String width, String border, String margin, String padding, String uriPost){
		
		Post post = new Post(conteudo, dataPost, uriPost, border, height, margin, padding, width);
		
		return post;
	}
	
	public Comentario criarComentario(String nome, String email, String texto, Date dataComentario, 
			String height, String width, String border, String margin, String padding){
		
		Comentario comentario = new Comentario(nome, email, texto, dataComentario, border, height, margin, padding, width);
		return comentario;
		
	}
	
	public BarraLateral criarBarraLateral(String conteudo, String border, String hight, String margin, String padding, String width){
		BarraLateral barraLateral = new BarraLateral(conteudo, border, hight, margin, padding, width);
		return barraLateral;
	}
	
	public Rodape criarRodape(String contatoTelefone, String contatoEmail,
			String contatoEndereco, String copyright, String border, String height, String margin, String padding, String width) {
		
		Rodape rodape = new Rodape(contatoTelefone, contatoEmail, contatoEndereco, copyright, border,
				height, margin, padding, width);
		
		return rodape;
		
	}
	
}
