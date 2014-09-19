package br.fucapi.negocio;
import java.io.IOException;
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

	/*Post post = fachada.criarPost("conteudo", new Date(System.currentTimeMillis()), null);
	//Comentario comentario = fachada.criarComentario("nome", "email", "texto", new Date(System.currentTimeMillis()));
	Cabecalho cabecalho = fachada.criarCabecalho("tituloCabecalho");
	Rodape rodape = fachada.criarRodape("contatoTelefone", "contatoEmail", "contatoEndereco", "copyright");
	BarraLateral barraLateralDireita = fachada.criarBarraLateral("conteudo");
	BarraLateral barraLateralEsquerda = fachada.criarBarraLateral("conteudo");
	
	ArrayList<Post> listaPost = null;
	
	Pagina paginaPrincipal = fachada.criarPaginaPrincipal(cabecalho, barraLateralDireita, barraLateralEsquerda, rodape, listaPost, "uri");
	Pagina paginaPost = fachada.criarPaginaPost(cabecalho, rodape, post, "uri");
	
	
	fachada.exibirPagina(paginaPrincipal);
	fachada.exibirPaginaPost(paginaPost); */
	
	public static void main(String[] args) throws IOException {
	
		Fachada fachada = new Fachada();
		Html objHtml = new Html();
		String codHtml = null;
		String comando = null;
		Scanner s = new Scanner(System.in);
		
		BarraLateral barraLateralEsquerda = null;
		BarraLateral barraLateralDireita = null;
		Cabecalho cabecalho = null;
		Rodape rodape = null;
		Pagina pagindaPrincipal = null;
		ArrayList<Post> listaPost = null;
		ArrayList<Comentario> listaComentario = null;
		
		do{
			System.out.println("Comando: ");
			comando = s.nextLine();
			
			if(comando == "criarBarraLateral"){
			}
			else if(comando == "criarCabecalho"){
			}
			else if(comando == "criarRodape"){
			}
			else if(comando == "criarPost"){
			}
			else if(comando == "criarPaginaPrincipal"){
			}
			else if(comando == "criarPaginaPost"){
			}
			else if(comando == "criarComentario"){
			}
			else if(comando == "adicionarComentarioNoPost"){
			}
			else if(comando == "removerComentarioNoPost"){
			}
			else if(comando == "exibirPaginaPrincipal"){
			}
			else if(comando == "exibirPaginaPost"){
			}
			else if(comando == "exibirPost"){
			}
			else if(comando == "listar"){
				System.out.println("\n\t\tLista de Comandos"
						+ "\ncriarBarraLateral"
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
						+ "\nexibirPost");
			}
			else{
				System.out.println("Comando Inexistente...");
			}
			
		}while(comando != "criarHtml");
		
		System.out.println("Digite o nome do Arquivo: ");
		String nomeArquivo = s.nextLine();
		fachada.criarHtml(codHtml, nomeArquivo);
	}

}
