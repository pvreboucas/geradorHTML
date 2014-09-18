package br.fucapi.bean;

import br.fucapi.persistencia.Css;

public class Rodape {
	
	private Css layout;
	private String contatoTelefone;
	private String contatoEmail;
	private String contatoEndereco;
	private String copyright;
	
	public Rodape(String contatoTelefone, String contatoEmail,
			String contatoEndereco, String copyright, String border, String height, String margin, String padding, String width) {
		this.layout = new Css(height, width, border, margin, padding);
		this.contatoTelefone = contatoTelefone;
		this.contatoEmail = contatoEmail;
		this.contatoEndereco = contatoEndereco;
		this.copyright = copyright;
	}

	@Override
	public String toString() {
		return "Rodape [layout=" + layout + ", contatoTelefone="
				+ contatoTelefone + ", contatoEmail=" + contatoEmail
				+ ", contatoEndereco=" + contatoEndereco + ", copyright="
				+ copyright + "]";
	}

	public Css getLayout() {
		return layout;
	}

	public void setLayout(Css layout) {
		this.layout = layout;
	}

	public String getContatoTelefone() {
		return contatoTelefone;
	}

	public void setContatoTelefone(String contatoTelefone) {
		this.contatoTelefone = contatoTelefone;
	}

	public String getContatoEmail() {
		return contatoEmail;
	}

	public void setContatoEmail(String contatoEmail) {
		this.contatoEmail = contatoEmail;
	}

	public String getContatoEndereco() {
		return contatoEndereco;
	}

	public void setContatoEndereco(String contatoEndereco) {
		this.contatoEndereco = contatoEndereco;
	}

	public String getCopyright() {
		return copyright;
	}

	public void setCopyright(String copyright) {
		this.copyright = copyright;
	}

}
