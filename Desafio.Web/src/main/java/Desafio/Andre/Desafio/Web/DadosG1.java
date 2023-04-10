package Desafio.Andre.Desafio.Web;

import java.io.IOException;
import java.util.List;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class DadosG1 extends ExtruturaMateria implements ManipulaDados {

	//g1.pegaProximoLink("https://g1.globo.com/", "feed-post-link", "noticia", "post", "content-head__subtitle",
	//	"content-publication-data__from", "content-publication-data__updated", new ArrayList<>());
	

	@Override
	public void buscaDados(String url, List<String> linkVisitas) {
		try {
			Connection con = Jsoup.connect(url);
			Document doc = con.get();	
			if(con.response().statusCode() == 200) {	
				Elements div = doc.getElementsByClass(Links.G1.getHref());
				for(Element elemento : div) {	
					recebeMateria(elemento, Links.G1);
				}
				Elements todosLinks = doc.getElementsByClass("menu-item-link").select("a[href");
				for(Element todos : todosLinks) {
					String proximoLink = todos.attr("href");
					if(pegaProximoLink(proximoLink, linkVisitas)) {
						 linkVisitas.add(proximoLink);//fazer um for para add todos os links
						 buscaDados(proximoLink, linkVisitas);

					}
				}
			}
		}catch(IOException e){
			 new IOException(e);
		}
	}
}