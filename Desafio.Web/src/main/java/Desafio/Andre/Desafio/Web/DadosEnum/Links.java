package Desafio.Andre.Desafio.Web.DadosEnum;



public enum Links {
	G1("feed-post-link","content-publication-data__from",
			"content-publication-data__updated","content-head__subtitle", "noticia", "post"),
	
	Terra( "card-news__text--title", "article__header__author__item__name",
			"date", "article__header__subtitle", ",", ","),
	
	R7("r7-flex-title-h5__link", "toolkit-signature__author","toolkit-signature__publication-time",
			"toolkit-subtitle", "100", "090"),
	
	Uol("headlineSub__link","tooltip-container", "time",
			"c-content-head__subtitle", "2023", "-");
	
	private String href;
	private String autor;
	private String data;
	private String subtitulo;
	private String parametro1;
	private String parametro2;
	
	Links(String href, String autor, String data, String subtitulo, String parametro1,
			String parametro2) {
		this.href = href;
		this.autor = autor;
		this.data = data;
		this.subtitulo = subtitulo;
		this.parametro1 = parametro1;
		this.parametro2 = parametro2;
	}
	
	
	public String getHref() {
		return href;
	}
	
	public String getAutor() {
		return autor;
	}
	
	public String getData() {
		return data;
	}
	
	public String getSbubtitulo() {
		return subtitulo;
	}
	
	public String getParametro1() {
		return parametro1;
	}
	
	public String getParametro2() {
		return parametro2;
	}
	

}
