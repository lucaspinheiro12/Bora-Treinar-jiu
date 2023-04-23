package Desafio.Andre.Desafio.Web;

import java.io.IOException;
import java.util.List;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class DadosTerra implements ManipulaDados   {

	ExtruturaMateria extruturaMateria = new ExtruturaMateria();
	@Override
	public void buscaDados(String url, List<String> linkVisitas) {
		
		try {
			Connection con = Jsoup.connect(url);
			Document doc = con.get();	
			if(con.response().statusCode() == 200) {	
				Elements div = doc.getElementsByClass(Links.Terra.getHref());
				for(Element elemento : div) {
					extruturaMateria.recebeMateria(elemento, Links.Terra);	 
				}
				for(Element todos : div) {	
					String proximoLink = todos.select("a[href").attr("href");
					if(extruturaMateria.pegaProximoLink(proximoLink, linkVisitas)) {
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