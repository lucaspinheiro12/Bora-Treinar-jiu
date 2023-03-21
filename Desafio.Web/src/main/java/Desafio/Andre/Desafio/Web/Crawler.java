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
		crawl(url, new ArrayList<String>());
	}

	private static void crawl( String url, ArrayList<String> visita) throws IOException{

		Document doc = request(url, visita);
		System.out.println(visita.size());
		if(doc != null) {
			for(Element link : doc.select("a[href")) {
				String proximoLink = link.absUrl("href");
				if(visita.contains(proximoLink) == false) {
					if(visita.size() <= 3) {
						crawl( proximoLink, visita);
					}
				}
			}
		}
		System.out.println("Encerrado.");
	}
	
	private static Document request(String url, ArrayList<String> v) {
		try {
			Connection con = Jsoup.connect(url);
			Document doc = con.get();
			Elements div = doc.getElementById("bstn-fd-launcher").select(".feed-root").select(".feed-placeholder").select("._evt").select(".bstn-fd").select("._evg")
					.select("._evt").select(".bastian-page").select("._evg").select("._evt")
					.select(".bastian-feed-item").select(".bstn-item-shape").select(".feed-post-body");
			if(con.response().statusCode() == 200) {			
				for(Element elemento : div) {
					String urlDentro = elemento.select(".feed-post-body-title").select("._evt > h2 > a").first().attr("href");
					String tituloDentro = elemento.select(".feed-post-body-title").select("._evt > h2 > a").text();
					
					Connection conDentro = Jsoup.connect(urlDentro);
					Document docDentro = conDentro.get();
					
					String subtituloDentro = docDentro.getElementsByClass("content-head__subtitle").text();
					String autor = 	docDentro.getElementsByClass("content-publication-data__text").select(".content-publication-data__from").text();
					String data = docDentro.getElementsByClass("content-publication-data__text").select(".content-publication-data__updated > time").text();
					
					System.out.println("Link:  "+urlDentro);
					System.out.println("Titulo:  "+ tituloDentro);
					System.out.println("Subtitulo:  "+ subtituloDentro);
				
					
					System.out.println("Autor da noticia: " + autor);
					System.out.println("Data de publicação: " + data);
					System.out.println();
				}
				v.add(url);
				return doc;	
			}
			return null;
		}catch(IOException e){
			System.out.println("O ERRO É : " + e.getMessage());;
			return null;
		}

	}
	
	
}
