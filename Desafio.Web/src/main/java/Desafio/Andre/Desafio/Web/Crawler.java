package Desafio.Andre.Desafio.Web;

import java.io.IOException;

public class Crawler {
	

	public static void main(String[] args) throws IOException {
		PegaDados g1 = new PegaDados();
		g1.PegaDadosCliente();
				
		//r7.pegaProximoLink("https://www.r7.com/", "r7-flex-title-h5__link", "internacional", "foto",
				//"toolkit-subtitle", "toolkit-signature__author","toolkit-signature__publication-time",  new ArrayList<>());

		  /*terra.buscadorInformacoes("https://www.terra.com.br/", "card-news__url", "noticias", "byte", "article__header__subtitle",
	"article__header__author__item__name", "date", new ArrayList<>());*/
		
		//g1.pegaProximoLink("https://g1.globo.com/", "feed-post-link", "noticia", "post", "content-head__subtitle",
			//	"content-publication-data__from", "content-publication-data__updated", new ArrayList<>());
	}	
}
