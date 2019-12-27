package br.com.graaccjus.enums;

public enum HtmlProperties {

	DIV("div[id='divDadosResultado']"),
	TR("tr[class='fonte']"),
	TD("td[align='left']");

	private String description;

	HtmlProperties(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}
}
