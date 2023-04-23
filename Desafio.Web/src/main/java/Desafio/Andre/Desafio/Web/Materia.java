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
