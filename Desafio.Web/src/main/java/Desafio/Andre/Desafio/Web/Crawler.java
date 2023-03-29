package Desafio.Andre.Desafio.Web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Crawler {
	

	public static void main(String[] args) throws IOException {
		/*Crawler g1 = new Crawler("https://g1.globo.com/", "feed-post-link", "noticia", "post",
				"content-head__subtitle", "content-publication-data__from", "content-publication-data__updated", new ArrayList<>());*/
		/*Crawler terra = new Crawler("https://www.terra.com.br/", "card-news__url", "noticias", "byte", "article__header__subtitle",
						"article__header__author__item__name", "date", new ArrayList<>());*/
	}
	
	public Crawler(String linkUrl, String claseHref, String valorLink1, String valorLink2,
			String classeSubTitulo,String classeAutor, String classeData, List<String>visitas) throws IOException {
		super();
		crawl(linkUrl, claseHref, valorLink1, valorLink2, classeSubTitulo, classeAutor,classeData, visitas);
	}

	private static Document pegaInformacao( String url, String claseHref, String valorLink1, String valorLink2,
			String classeSubTitulo, String classeAutor, String classeData, List<String>link) throws IOException {
		
		try {
			Connection con = Jsoup.connect(url);
			Document doc = con.get();	
			if(con.response().statusCode() == 200) {	
				Elements div = doc.getElementsByClass(claseHref);
					for(Element elemento : div) {	
						String pegaUrl = elemento.select("a[href").first().attr("href");
						if(pegaUrl.contains(valorLink1) || pegaUrl.contains(valorLink2)) {

						String tituloPagina = elemento.select("a[href").text();
	
						Connection conTeste = Jsoup.connect(pegaUrl);
						Document docTeste = conTeste.get();
						
						String subtituloDentro = docTeste.getElementsByClass(classeSubTitulo).text();
						String autor = 	docTeste.getElementsByClass(classeAutor).text();
						String data = docTeste.getElementsByClass(classeData).text();
							
						System.out.println("Link:  "+pegaUrl);
						System.out.println("Titulo:  "+ tituloPagina);
						System.out.println("Subtitulo:  "+ subtituloDentro);
						System.out.println("Autor da noticia: " + autor);
						System.out.println("Data de publicação: " + data);
						System.out.println();
					}
				}
					link.add(url);
					return doc;
			}
			return null;
		}catch(IOException e){
			System.out.println("O ERRO É : " + e.getMessage());;
			return null;
		}
	}

	private static void crawl( String url,String claseHref ,String valorLink1, String valorLink2,String classeSubTitulo,
			String classeAutor,String classeData, List<String>visitas)throws IOException{
				Document doc = pegaInformacao(url, claseHref, valorLink1, valorLink2,classeSubTitulo, classeAutor,classeData, visitas);
				if (doc != null) {
					for(Element link : doc.select("a[href")) {
						String proximoLink = link.absUrl("href");
							if(visitas.contains(proximoLink) == false) {
								crawl(proximoLink, claseHref, valorLink1, valorLink2, classeSubTitulo, classeAutor,classeData, visitas);
							}
					}
				}
		}
}
