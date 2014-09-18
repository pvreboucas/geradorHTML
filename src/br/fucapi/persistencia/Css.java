package br.fucapi.persistencia;

public class Css {
	
	private String hight;
	private String width;
	private String border;
	private String margin;
	private String padding;
	
	public Css(String hight, String width, String border, String margin, String padding) {
		this.hight = hight;
		this.width = width;
		this.border = border;
		this.margin = margin;
		this.padding = padding;
	}

	@Override
	public String toString() {
		return "Layout [hight=" + hight + ", width=" + width + ", border="
				+ border + ", margin=" + margin + ", padding=" + padding + "]";
	}

	public void setHight(String hight) {
		this.hight = hight;
	}

	public void setWidth(String width) {
		this.width = width;
	}

	public void setBorder(String border) {
		this.border = border;
	}

	public void setMargin(String margin) {
		this.margin = margin;
	}

	public void setPadding(String padding) {
		this.padding = padding;
	}

	public String getHight() {
		return hight;
	}

	public String getWidth() {
		return width;
	}

	public String getBorder() {
		return border;
	}

	public String getMargin() {
		return margin;
	}

	public String getPadding() {
		return padding;
	}
	
	

}
