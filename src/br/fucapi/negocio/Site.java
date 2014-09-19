package br.fucapi.negocio;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Scanner;

import br.fucapi.bean.BarraLateral;
import br.fucapi.bean.Cabecalho;
import br.fucapi.bean.Comentario;
import br.fucapi.bean.Pagina;
import br.fucapi.bean.Post;
import br.fucapi.bean.Rodape;
import br.fucapi.persistencia.Html;


public class Site {

	/*GRUPO
	 * Alexander Rivas
	 * Maura Regina
	 * Paulo Victor Rebouças
	 * Wellignton Rodrigues */
	
	
	public static void main(String[] args) throws IOException {
	
		Fachada fachada = new Fachada();
		Html objHtml = new Html();
		String codHtml = "";
		String comando = "";
		Scanner s = new Scanner(System.in);
		
		BarraLateral barraLateralEsquerda = null;
		BarraLateral barraLateralDireita = null;
		Cabecalho cabecalho = null;
		Rodape rodape = null;
		Pagina paginaPrincipal = null;
		Pagina paginaPost = null;
		ArrayList<Post> listaPost = null;
		Post post = null;
		ArrayList<Comentario> listaComentario = null;
		Comentario comentario = null;
		
		System.out.println("Digite listar para conhecer os comandos");
		do{
			System.out.println("\nComando: ");
			comando = s.nextLine();
			String conteudo = "";
			//CRIA BARRA LATERAL DIREITA
			if(comando.equals("criarBarraLateralDireita")){
				conteudo += objHtml.getAbreDiv();
				do{
					System.out.println("\nComando: ");
					comando = s.nextLine();
					conteudo += fachada.inserirHtml(comando);
				}while(!comando.equals("fim"));
				conteudo += objHtml.getFechaDiv();
				barraLateralDireita = new BarraLateral(conteudo);
			}
			//CRIA BARRA LATERAL ESQUERDA
			else if(comando.equals("criarBarraLateralEsquerda")){
				conteudo += objHtml.getAbreDiv();
				do{
					System.out.println("\nComando: ");
					comando = s.nextLine();
					conteudo = fachada.inserirHtml(comando);
				}while(!comando.equals("fim"));
				conteudo += objHtml.getFechaDiv();
				barraLateralEsquerda = new BarraLateral(conteudo);
			}
			//CRIA CABEÇALHO
			else if(comando.equals("criarCabecalho")){
				conteudo += objHtml.getAbreDiv();
				do{
					System.out.println("\nComando: ");
					comando = s.nextLine();
					conteudo += fachada.inserirHtml(comando);
				}while(!comando.equals("fimConteudo"));
				conteudo += objHtml.getFechaDiv();
				System.out.println(conteudo);
				cabecalho = new Cabecalho(conteudo);
			}
			//*CRIA RODAPÉ
			else if(comando.equals("criarRodape")){
				conteudo += objHtml.getAbreDiv();
				do{
					System.out.println("\nComando: ");
					comando = s.nextLine();
					conteudo = fachada.inserirHtml(comando);
				}while(!comando.equals("fim"));
				System.out.println("\nTelefone: ");
				String contatoTelefone = s.nextLine();
				System.out.println("\nEmail: ");
				String contatoEmail = s.nextLine();
				System.out.println("\nEndereço: ");
				String contatoEndereco = s.nextLine();
				conteudo += contatoTelefone;
				conteudo += contatoEndereco;
				conteudo += contatoEmail;
				conteudo += conteudo;
				conteudo += objHtml.getFechaDiv();
				
				rodape = new Rodape(contatoTelefone, contatoEmail, contatoEndereco, conteudo);
			}
			//CRIA PÁGINA PRINCIPAL
			else if(comando.equals("criarPaginaPrincipal")){
				if(barraLateralDireita==null && barraLateralEsquerda == null && cabecalho == null && rodape == null){
					System.out.println("\nCrie as barras laterais, cabeçalho e rodape primeiro!");
				}
				else{
					System.out.println("\nURL: ");
					String uri = s.nextLine();
					System.out.println("Digite o nome do Arquivo: ");
					String nomeArquivo = s.nextLine();
					
					codHtml += objHtml.getAbreHtml()+objHtml.getAbreBody();
					codHtml += objHtml.getAbreHead()+objHtml.getAbreTitle()+nomeArquivo+objHtml.getFechaTitle()+objHtml.getFechaHead();
					
					paginaPrincipal = fachada.criarPaginaPrincipal(cabecalho, barraLateralDireita, barraLateralEsquerda, rodape, listaPost, uri);
					
					String barraD = paginaPrincipal.getBarraLateralDireita().getConteudo();
					String barraE = paginaPrincipal.getBarraLateralDireita().getConteudo();
					String cab = paginaPrincipal.getCabecalho().getTitulo();
					String rod = paginaPrincipal.getRodape().getCopyright();
					ArrayList<Post> listp = paginaPrincipal.getListaPost();
					
					codHtml += cab + barraD + barraE;
					
					codHtml += objHtml.getAbreUl();
					
					for(int i = 0; i<listp.size();i++){
						codHtml += objHtml.getAbreLi();
						codHtml += listp.get(i).getConteudo();
						codHtml += objHtml.getFechaLi();
					}
					codHtml += objHtml.getFechaUl();
					codHtml += rod;
					codHtml += objHtml.getFechaBody()+objHtml.getFechaHtml();
					fachada.criarHtml(codHtml, nomeArquivo);
					codHtml = null;
				}
				
			}
			
			
			
			
			
			
			
			//CRIA PÁGINA POST
			else if(comando.equals("criarPaginaPost")){
				if(cabecalho == null && rodape == null && post == null){
					System.out.println("\nCrie o cabeçalho, rodape e o post primeiro!");
				}
				else{
					System.out.println("\nURL: ");
					String uri = s.nextLine();
					paginaPost = fachada.criarPaginaPost(cabecalho, rodape, post, uri);
				}
			}
			//*CRIA POST
			else if(comando.equals("criarPost")){
				conteudo += objHtml.getAbreDiv();
				do{
					System.out.println("\nComando: ");
					comando = s.nextLine();
					conteudo = fachada.inserirHtml(comando);
				}while(comando != "fimConteudo");
				conteudo += objHtml.getFechaDiv();
				System.out.println("\nURL: ");
				String uriPost = s.nextLine();
				post = new Post(conteudo, new Date(System.currentTimeMillis()), uriPost, listaComentario);
				listaPost.add(post);
				/*conteudo += objHtml.getAbreUl();
				for(int i = 0; i<post.getListaComentarios().size();i++){
					conteudo += listaComentario.get(i);
				}
				conteudo += objHtml.getFechaUl();
				String texto = post.getConteudo();
				texto += conteudo;
				post.setConteudo(texto);
				conteudo += objHtml.getFechaDiv();*/
				post = null;
			}
			//CRIA COMENTÁRIO
			else if(comando.equals("criarComentario")){
				if(listaPost == null){
					System.out.println("\nCrie um Post primeiro!");
				}
				else{
					System.out.println("\nNome: ");
					String uri = s.nextLine();
					//comentario = fachada.criarComentario(nome, email, texto, dataComentario);
					listaComentario.add(comentario);
					comentario = null;
				}
			}
			//ADICIONA COMENTÁRIO A UM POST
			else if(comando.equals("adicionarComentarioNoPost")){
				if(listaPost == null){
					System.out.println("\nCrie um Post primeiro!");
				}
				else if(listaComentario == null){
					System.out.println("\nCrie um ou mais Comentários primeiro!");
				}
				else{
					fachada.adicionarComentarioNoPost(post, comentario);
				}
			}
			//REMOVE COMENTÁRIO DE UM POST
			else if(comando.equals("removerComentarioNoPost")){
				if(listaPost == null && post == null){
					System.out.println("\nCrie um Post primeiro!");
				}
				else{
					fachada.removerComentarioNoPost(post, comentario);
				}
			}
			
			
			
			
			
			
			
			
			//EXIBE CONTEÚDO DA PÁGINA PRINCIPAL
			else if(comando.equals("exibirPaginaPrincipal")){
				if(paginaPrincipal == null){
					System.out.println("\nNenhuma página principal foi criada!");
				}
				else{
					fachada.exibirPagina(paginaPrincipal);
				}
			}
			//EXIBE CONTEÚDO DA PÁGINA POST
			else if(comando.equals("exibirPaginaPost")){
				if(paginaPost == null){
					System.out.println("\nNenhuma página principal foi criada!");
				}
				else{
					fachada.exibirPaginaPost(paginaPost);
				}
			}
			//EXIBE POST
			else if(comando.equals("exibirPost")){
				if(listaPost == null){
					System.out.println("\nNenhum post foi criado!");
				}
				else{
					fachada.exibirPost(post);
				}
			}
			//LISTA DE COMANDOS
			else if(comando.equals("listar")){
				System.out.println("\n\t\tLista de Comandos"
						+ "\ncriarBarraLateralDireita"
						+ "\ncriarBarraLateralEsquerda"
						+ "\ncriarCabecalho"
						+ "\ncriarRodape"
						+ "\ncriarPost"
						+ "\ncriarPaginaPrincipal"
						+ "\ncriarPaginaPost"
						+ "\ncriarComentario"
						+ "\nadicionarComentarioNoPost"
						+ "\nremoverComentarioNoPost"
						+ "\nexibirPaginaPrincipal"
						+ "\nexibirPaginaPost"
						+ "\nexibirPost"
						+ "\nfim");
			}
			else{
				System.out.println("Comando Inexistente...");
			}
			
		}while(!comando.equals("fim"));
	}

}
