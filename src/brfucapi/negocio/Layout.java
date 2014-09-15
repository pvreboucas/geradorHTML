package brfucapi.negocio;

public class Layout {
	
	private String hight;
	private String width;
	private String border;
	private String margin;
	private String padding;
	
	public Layout(String hight, String width, String border, String margin, String padding) {
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

	public String getHight() {
		return hight;
	}

	public void setHight(String hight) {
		this.hight = hight;
	}

	public String getWidth() {
		return width;
	}

	public void setWidth(String width) {
		this.width = width;
	}

	public String getBorder() {
		return border;
	}

	public void setBorder(String border) {
		this.border = border;
	}

	public String getMargin() {
		return margin;
	}

	public void setMargin(String margin) {
		this.margin = margin;
	}

	public String getPadding() {
		return padding;
	}

	public void setPadding(String padding) {
		this.padding = padding;
	}

}
