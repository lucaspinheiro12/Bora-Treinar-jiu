package Desafio.Andre.Desafio.Web;

import java.io.IOException;
import java.util.ArrayList;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Crawler {

	public static void main(String[] args) throws IOException {
		String url = "https://g1.globo.com/";
		crawl(0,url, new ArrayList<String>());
	}

	private static void crawl(int valor, String url, ArrayList<String> visita) throws IOException{
		if(valor <= 5) {
			Document doc = request(url, visita);	
			if(doc != null) {
				for(Element link : doc.select("a[href")) {
					String proximoLink = link.absUrl("href");
					if(visita.contains(proximoLink) == false) {
						crawl(valor++, proximoLink, visita);
					}
				}
			}
		}
	}
	
	private static Document request(String url,ArrayList<String> v) {
		try {
			Connection con = Jsoup.connect(url);
			Document doc = con.get();
			Elements div = doc.getElementById("bstn-fd-launcher").select(".feed-root").select(".feed-placeholder").select("._evt").select(".bstn-fd").select("._evg")
					.select("._evt").select(".bastian-page").select("._evg").select("._evt")
					.select(".bastian-feed-item").select(".bstn-item-shape").select(".feed-post-body");
			if(con.response().statusCode()== 200) {			
				for(Element elemento : div) {
					String urlDentro = elemento.select(".feed-post-body-title").select("._evt > h2 > a").first().attr("href");
					String tituloDentro = elemento.select(".feed-post-body-title").select("._evt > h2 > a").text();
					String subtituloDentro = elemento.select(".bstn-related > ul").text();
					System.out.println("Link:  "+urlDentro);
					System.out.println("Titulo:  "+ tituloDentro);
					System.out.println("Subtitulo:  "+ subtituloDentro);
					

					
					Connection conDentro = Jsoup.connect(urlDentro);
					Document docDentro = conDentro.get();
					
					System.out.println("Autor da noticia: " + docDentro.getElementsByClass("content-publication-data__text").select(".content-publication-data__from").text());
					System.out.println("Data de publicação: " + docDentro.getElementsByClass("content-publication-data__text").select(".content-publication-data__updated > time").text());
					System.out.println();
				}
				v.add(url);
				return doc;	
			}
			return null;
		}
		catch(IOException e){
			return null;
			
		}
		
	}
	
	
}
