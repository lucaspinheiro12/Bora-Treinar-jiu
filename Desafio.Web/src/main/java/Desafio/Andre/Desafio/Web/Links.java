package Desafio.Andre.Desafio.Web;



public enum Links {
	G1("https://g1.globo.com/", "feed-post-link","content-publication-data__from",
			"content-publication-data__updated","content-head__subtitle", "noticia", "post",new DadosG1()),
	
	Terra("https://www.terra.com.br/", "card-news__text--title", "article__header__author__item__name",
			"date", "article__header__subtitle", ",", ",", new DadosTerra()),
	
	R7("https://www.r7.com/", "r7-flex-title-h5__link", "toolkit-signature__author","toolkit-signature__publication-time",
			"toolkit-subtitle", "100", "090", new DadosR7()),
	
	Uol("https://www.uol.com.br/", "headlineSub__link","tooltip-container", "time",
			"c-content-head__subtitle", "2023", "-", new DadosUol());
	private String url;
	private String href;
	private String autor;
	private String data;
	private String subtitulo;
	private String parametro1;
	private String parametro2;
	private ManipulaDados pegaDados;
	
	Links(String url, String href, String autor, String data, String subtitulo, String parametro1,
			String parametro2, ManipulaDados pegaDados) {
		this.url = url;
		this.href = href;
		this.autor = autor;
		this.data = data;
		this.subtitulo = subtitulo;
		this.parametro1 = parametro1;
		this.parametro2 = parametro2;
		this.pegaDados = pegaDados;
	}
	
	public String getUrl() {
		return url;
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
	
	public ManipulaDados getPegaDados() {
		return pegaDados;
	}

}
