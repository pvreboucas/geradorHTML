package br.fucapi.negocio;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;

import br.fucapi.bean.BarraLateral;
import br.fucapi.bean.Cabecalho;
import br.fucapi.bean.Comentario;
import br.fucapi.bean.Pagina;
import br.fucapi.bean.Post;
import br.fucapi.bean.Rodape;
//import br.fucapi.persistencia.Css;
import br.fucapi.persistencia.Html;



public class Fachada {

	public void exibirPagina(Pagina pagina){
		System.out.println("\nP�gina:");
		System.out.println(pagina.getCabecalho().toString());
		System.out.println(pagina.getBarraLateralEsquerda().toString());
		System.out.println(pagina.getBarraLateralDireita().toString());
	
		System.out.println(pagina.getRodape().toString());
		
		if(pagina.getListaPost()==null ){
			System.out.println("\nN�o h� posts");
		}
		else{
			for(int i = 0; i<pagina.getListaPost().size();i++){
				System.out.println(pagina.getListaPost().get(i).toString());
			}
		}
		
	}
	
	public void exibirPaginaPost(Pagina pagina){
		System.out.println("\nP�gina:");
		System.out.println(pagina.getCabecalho().toString());
		System.out.println(pagina.getRodape().toString());
		
		if(pagina.getListaPost()==null ){
			System.out.println("\nN�o h� coment�rios");
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
			System.out.println("N�o h� coment�rios!");
		}else{
			for(int i=0; i< post.getListaComentarios().size();i++){
				System.out.println(post.getListaComentarios().get(i).toString());
			}
		}
		
		System.out.println(post.getUriPost());
	}
		
	public Pagina criarPaginaPrincipal(Cabecalho cabecalho, BarraLateral barraLateralDireita,
			BarraLateral barraLateralEsquerda, Rodape rodape,
			ArrayList<Post> listaPost, String uri/*, String border, String height, String margin, String padding, String width*/){
	
		Pagina pagina = new Pagina(cabecalho, barraLateralDireita, barraLateralEsquerda, rodape, listaPost, uri/*, border, height, margin, padding, width*/); 
		
		return pagina;
		
	}
	
	public Pagina criarPaginaPost(Cabecalho cabecalho, Rodape rodape, Post post, String uri/*,
			String border,String height,String margin,String padding,String width*/){
	
		Pagina pagina = new Pagina(cabecalho, rodape, post, uri/*, border, height, margin, padding, width*/);
		return pagina;
		
	}

	public Cabecalho criarCabecalho(String tituloCabecalho/*, String height, String width, String border, String margin, String padding*/){
		Cabecalho cabecalho = new Cabecalho(tituloCabecalho/*, border, height, margin, padding, width*/);
		
		return cabecalho;
	}
	
	public Post criarPost(String conteudo, Date dataPost/*, String height, 
			String width, String border, String margin, String padding*/, String uriPost, ArrayList<Comentario> listaComentario){
		
		Post post = new Post(conteudo, dataPost, uriPost, listaComentario/*, border, height, margin, padding, width*/);
		
		return post;
	}
	
	public Comentario criarComentario(String nome, String email, String texto, Date dataComentario/*, 
			String height, String width, String border, String margin, String padding*/){
		
		Comentario comentario = new Comentario(nome, email, texto, dataComentario/*, border, height, margin, padding, width*/);
		return comentario;
		
	}
	
	public void adicionarComentarioNoPost(Post post, Comentario comentario){
		ArrayList<Comentario> listaComentario = post.getListaComentarios(); 
		listaComentario.add(comentario);
		post.setListaComentarios(listaComentario);
	}
	
	public void removerComentarioNoPost(Post post, Comentario comentario){
		ArrayList<Comentario> listaComentario = post.getListaComentarios(); 
		listaComentario.remove(comentario);
		post.setListaComentarios(listaComentario);
	}
	
	public BarraLateral criarBarraLateral(String conteudo/*, String border, String hight, String margin, String padding, String width*/){
		BarraLateral barraLateral = new BarraLateral(conteudo/*, border, hight, margin, padding, width*/);
		return barraLateral;
	}
	
	public Rodape criarRodape(String contatoTelefone, String contatoEmail,
			String contatoEndereco, String copyright/*, String border, String height, String margin, String padding, String width*/) {
		
		Rodape rodape = new Rodape(contatoTelefone, contatoEmail, contatoEndereco, copyright/*, border,
				height, margin, padding, width*/);
		
		return rodape;
		
	}
	

	public String inserirHtml(String comando){
		String conteudo = "fimConteudo";
		Html objHtml = new Html();
		
		if(comando.equals("abreParagrafo")){
			conteudo = objHtml.getAbreP();
		}
		else if(comando.equals("fechaParagrafo")){
			conteudo = objHtml.getFechaP();
		}
		if(comando.equals("abreH1")){
			conteudo = objHtml.getAbreH1();
		}
		else if(comando.equals("fechaH1")){
			conteudo = objHtml.getFechaH1();
		}
		else if(comando.equals("listar")){
			System.out.println("\n\t\tLista de Comandos HTML"
					+ "\nabreParagrafo - <p>"
					+ "\nfechaParagrafo - </p>"
					+ "\nabreH1 - <h1>"
					+ "\nfechaH1 - </h1>"
					+ "\nfimConteudo");
		}
		else{
			conteudo = comando;
		}
		return conteudo;
	}
	
	public void criarHtml(String html, String nomeDoc){

		//Site/arquivoHtml - tem q salvar nessa pasta
		BufferedWriter br;
		try {
			br = new BufferedWriter(new FileWriter(new File(nomeDoc+".html")));
			br.write(html);  
			br.close();
			System.out.println("Arquivo "+nomeDoc+".html criado com sucesso!");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("N�o foi poss�vel criar o arquivo!");
		}  
		
	}
	
/*	public String getCssScriptBarraLateral(BarraLateral barralateral, String html){
		String css;

		css = html+"{"
				+"height:"+barralateral.getLayout().getHight()+";"
				+"width:"+barralateral.getLayout().getWidth()+";"
				+"border:"+barralateral.getLayout().getBorder()+";"
				+"margin:"+barralateral.getLayout().getMargin()+";"
				+"padding:"+barralateral.getLayout().getPadding()+";"
				+"}";
		return css;
	}
	
	public String getCssScriptCabecalho(Cabecalho cabecalho, String html){
		String css;

		css = html+"{"
				+"height:"+cabecalho.getLayout().getHight()+";"
				+"width:"+cabecalho.getLayout().getWidth()+";"
				+"border:"+cabecalho.getLayout().getBorder()+";"
				+"margin:"+cabecalho.getLayout().getMargin()+";"
				+"padding:"+cabecalho.getLayout().getPadding()+";"
				+"}";
		return css;
	}
	
	public String getCssScriptComentario(Comentario comentario, String html){
		String css;

		css = html+"{"
				+"height:"+comentario.getLayout().getHight()+";"
				+"width:"+comentario.getLayout().getWidth()+";"
				+"border:"+comentario.getLayout().getBorder()+";"
				+"margin:"+comentario.getLayout().getMargin()+";"
				+"padding:"+comentario.getLayout().getPadding()+";"
				+"}";
		return css;
	}
	
	public String getCssScriptPagina(Pagina pagina, String html){
		String css;

		css = html+"{"
				+"height:"+pagina.getLayout().getHight()+";"
				+"width:"+pagina.getLayout().getWidth()+";"
				+"border:"+pagina.getLayout().getBorder()+";"
				+"margin:"+pagina.getLayout().getMargin()+";"
				+"padding:"+pagina.getLayout().getPadding()+";"
				+"}";
		return css;
	}
	
	public String getCssScriptPost(Post post, String html){
		String css;

		css = html+"{"
				+"height:"+post.getLayout().getHight()+";"
				+"width:"+post.getLayout().getWidth()+";"
				+"border:"+post.getLayout().getBorder()+";"
				+"margin:"+post.getLayout().getMargin()+";"
				+"padding:"+post.getLayout().getPadding()+";"
				+"}";
		return css;
	}
	
	public String getCssScriptRodape(Rodape rodape, String html){
		String css;

		css = html+"{"
				+"height:"+rodape.getLayout().getHight()+";"
				+"width:"+rodape.getLayout().getWidth()+";"
				+"border:"+rodape.getLayout().getBorder()+";"
				+"margin:"+rodape.getLayout().getMargin()+";"
				+"padding:"+rodape.getLayout().getPadding()+";"
				+"}";
		return css;
	}*/

}
