package Desafio.Andre.Desafio.Web.DadosPaginaWeb;

import java.io.IOException;
import java.util.List;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import Desafio.Andre.Desafio.Web.DadosEnum.Links;
import Desafio.Andre.Desafio.Web.Extrutura.ExtruturaMateria;
import Desafio.Andre.Desafio.Web.InterfaceManiputacao.ManipulaDados;

public class DadosR7 implements ManipulaDados {

	ExtruturaMateria extruturaMateria = new ExtruturaMateria();
	@Override
	public void buscaDados(String url, List<String> linkVisitas) {
		try {
			Connection con = Jsoup.connect(url);
			Document doc = con.get();
			if(con.response().statusCode() == 200) {	
				Elements div = doc.getElementsByClass(Links.R7.getHref());
				for(Element elemento : div) {	
					extruturaMateria.recebeMateria(elemento, Links.R7);
				}
				Elements todosLinks = doc.getElementsByClass("toolkit-side-menu__link").select("a[href");
				for(Element todos : todosLinks) {
					String proximoLink = todos.attr("href");
					if(extruturaMateria.pegaProximoLink(proximoLink, linkVisitas)) {
						 linkVisitas.add(proximoLink);
						 buscaDados(proximoLink, linkVisitas);

					}
				}
			}
		}catch(IOException e){
			 new IOException(e);
		}
	}		
}
