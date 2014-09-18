package br.fucapi.bean;

import java.sql.Date;
import java.util.ArrayList;

import br.fucapi.persistencia.Css;


public class Post {
	
	private Css layout;
	private ArrayList<Comentario> listaComentarios;
	private String conteudo;
	private Date data;
	private String uriPost;
	
	public Post(String conteudo, Date data, String uriPost, String border, String hight, String margin, String padding, String width) {
		this.layout = new Css(hight, width, border, margin, padding);
		this.conteudo = conteudo;
		this.data = data;
		this.uriPost = uriPost;
	}
	
	@Override
	public String toString() {
		return "Post [layout=" + layout + ", data=" + data + ", uriPost="
				+ uriPost + "]";
	}
	
	public Css getLayout() {
		return layout;
	}
	public void setLayout(Css layout) {
		this.layout = layout;
	}
	
	public ArrayList<Comentario> getListaComentarios() {
		return listaComentarios;
	}

	public void setListaComentarios(ArrayList<Comentario> listaComentarios) {
		this.listaComentarios = listaComentarios;
	}

	public String getConteudo() {
		return conteudo;
	}
	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public String getUriPost() {
		return uriPost;
	}
	public void setUriPost(String uriPost) {
		this.uriPost = uriPost;
	}
	
	public void adicionarComentario(Comentario comentario){
		listaComentarios.add(comentario);
	}
	
	public void removerComentarios(Comentario comentario){
		listaComentarios.remove(comentario);
	}
	
	public void exibirComentarios(){
		if(listaComentarios.isEmpty()){
			System.out.println("\nNão há comentários");
		}
		else{
			int i = 0;
			while(! listaComentarios.isEmpty()){
				System.out.println(listaComentarios.get(i).toString());
				i++;
			}
		}
	}
	


}
