package Desafio.Andre.Desafio.Web;

import java.io.IOException;
import java.util.List;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class DadosTerra extends ExtruturaMateria implements ManipulaDados   {
	
	@Override
	public void buscaDados(String url, List<String> linkVisitas) {
		try {
			Connection con = Jsoup.connect(url);
			Document doc = con.get();	
			if(con.response().statusCode() == 200) {	
				Elements div = doc.getElementsByClass(Links.Terra.getHref());
				for(Element elemento : div) {	
					recebeMateria(elemento, Links.Terra);
				}
				for(Element todos : div) {	
					String proximoLink = todos.select("a[href").attr("href");
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
	
	/*public Document buscaDados(String url, String claseHref, String classeAutor, String classeData, List<String> link) {
		try {
			Connection con = Jsoup.connect(url);
			Document doc = con.get();	
			if(con.response().statusCode() == 200) {	
				Elements div = doc.getElementsByClass(claseHref);
					for(Element elemento : div) {	
						String pegaUrl = elemento.select("a[href").first().attr("href");		
						String tituloPagina = elemento.select("a[href").text();

						Connection conTeste = Jsoup.connect(pegaUrl);
						Document docTeste = conTeste.get();
						
						String subtituloDentro = docTeste.getElementsByClass(classeSubTitulo).text();
						String autor = 	docTeste.getElementsByClass(classeAutor).text();
						String data = docTeste.getElementsByClass(classeData).text();
						
						Materia materia = new Materia(pegaUrl, tituloPagina, subtituloDentro, autor, data);
						 //apresentaMateria(materia);
					}
				}
					link.add(url);
					return doc;
		}catch(IOException e){
			throw new IOException(e);
		}
		return null;
	}*/
