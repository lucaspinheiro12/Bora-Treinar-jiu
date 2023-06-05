package Desafio.Andre.Desafio.Web;

import java.io.IOException;
import java.util.List;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class DadosUol extends ExtruturaMateria implements ManipulaDados{

	@Override
	public void buscaDados(String url, List<String> linkVisitas) {
		try {
			Connection con = Jsoup.connect(url);
			Document doc = con.get();	
			if(con.response().statusCode() == 200) {	
				Elements div = doc.getElementsByClass(Links.Uol.getHref());
				for(Element elemento : div) {	
					recebeMateria(elemento, Links.Uol);
				}
				for(Element todos : div) {
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
