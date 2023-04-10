package Desafio.Andre.Desafio.Web;

import java.util.ArrayList;

public class Crawler {
	

	public static void main(String[] args){
		//Links G1 = Links.G1;
		// G1.getPegaDados().buscaDados(G1.getUrl(), new ArrayList<>());
		Links terra = Links.Terra;
		terra.getPegaDados().buscaDados(terra.getUrl(), new ArrayList<>());
		 
		
				
		//r7.pegaProximoLink("https://www.r7.com/", "r7-flex-title-h5__link", "internacional", "foto",
				//"toolkit-subtitle", "toolkit-signature__author","toolkit-signature__publication-time",  new ArrayList<>());

		  
		
		//g1.pegaProximoLink("https://g1.globo.com/", "feed-post-link", "noticia", "post", "content-head__subtitle",
			//	"content-publication-data__from", "content-publication-data__updated", new ArrayList<>());
		
		//https://noticias.uol.com.br/,thumbnails-wrapper,internacional,ultimas-noticias,c-content-head__subtitle,author-names,
		//p-author 
		
	}	
}
