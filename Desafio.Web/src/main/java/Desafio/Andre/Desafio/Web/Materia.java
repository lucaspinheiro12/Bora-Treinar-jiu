package Desafio.Andre.Desafio.Web;

public class Materia {
	
	private String link;
	private String titulo;
	private String subtitulo;
	private String autorNoticia;
	private String dataPublicacao;
	
	

	public Materia(String link, String titulo, String subtitulo, String autorNoticia, String dataPublicacao) {
		this.link = link;
		this.titulo = titulo;
		this.subtitulo = subtitulo;
		this.autorNoticia = autorNoticia;
		this.dataPublicacao = dataPublicacao;
	}

	public String getLink() {
		return link;
	}
	
	public void setLink(String link) {
		this.link = link;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public void setSubtitulo(String subtitulo) {
		this.subtitulo = subtitulo;
	}

	public void setAutorNoticia(String autorNoticia) {
		autorNoticia = autorNoticia;
	}

	public void setDataPublicacao(String dataPublicacao) {
		dataPublicacao = dataPublicacao;
	}

	public String getTitulo() {
		return titulo;
	}
	
	public String getSubtitulo() {
		return subtitulo;
	}
	
	public String getAutorNoticia() {
		return autorNoticia;
	}
	
	public String getDataPublicacao() {
		return dataPublicacao;
	}

}
