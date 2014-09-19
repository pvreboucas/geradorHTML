package br.fucapi.bean;
import java.sql.Date;

public class Comentario {
	
	private String nome;
	private String email;
	private String texto;
	private Date data;
//	private Css layout;
	
	public Comentario(String nome, String email, String texto, Date data/*, String border, String hight, String margin, String padding, String width*/) {
//		this.layout.setBorder(border);
//		this.layout.setHight(hight);
//		this.layout.setMargin(margin);
//		this.layout.setPadding(padding);
//		this.layout.setWidth(width);
		this.nome = nome;
		this.email = email;
		this.texto = texto;
		this.data = data;
	}
	
	@Override
	public String toString() {
		return "Comentario [nome=" + nome + ", email=" + email + ", texto="
				+ texto + ", data=" + data + "]";
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}
/*
	public Css getLayout() {
		return layout;
	}

	public void setLayout(Css layout) {
		this.layout = layout;
	}
*/
}
