package Desafio.Andre.Desafio.Web;

import java.io.IOException;
import java.util.List;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;



public class ExtruturaMateria {
	
	
	public  void recebeMateria(Element elemento, Links link) throws IOException {
		
		String pegaUrl = elemento.select("a[href").attr("href");
		if(pegaUrl.contains(link.getParametro1()) || pegaUrl.contains(link.getParametro2())) {

			String tituloPagina = elemento.select("a[href").text();

			Connection conTeste = Jsoup.connect(pegaUrl);
			Document docTeste = conTeste.get();

			String subtituloDentro = docTeste.getElementsByClass(link.getSbubtitulo()).text();
			String autor = 	docTeste.getElementsByClass(link.getAutor()).text();			String data = docTeste.getElementsByClass(link.getData()).text();
			
			Materia materia = new Materia(pegaUrl, tituloPagina, subtituloDentro, autor, data);
			apresentaDados(materia);
		}
	}
	
	public void apresentaDados(Materia materia) {
		System.out.println("Link:  "+ materia.getLink());
		System.out.println("Titulo:  "+ materia.getTitulo());
		System.out.println("Subtitulo:  "+ materia.getSubtitulo());
		System.out.println("Autor da noticia: " + materia.getAutorNoticia());
		System.out.println("Data de publicação: " + materia.getDataPublicacao());
		System.out.println();
	}
	
	
	public boolean pegaProximoLink( String url, List<String>visitas) {
		if(! visitas.contains(url)) {
			return true;
		}
		return false;
	}		
}
