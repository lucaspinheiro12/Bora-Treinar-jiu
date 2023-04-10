package Desafio.Andre.Desafio.Web;

import java.util.ArrayList;
import java.util.Scanner;

public class ValorCliente {
	Scanner scanner = new Scanner(System.in);
	
	public String escolherSite(){
		System.out.println("G1 - Terra - Uol - R7");
		String link;
		System.out.println("Qual site acima você dejesa buscar?");
		link = scanner.nextLine().toLowerCase();
		System.out.println("Você escolheu:" + link);
		return link;
		
	}
	
	public void pegSiteEscolhido(String site) {
		if(site.equals("g1")) {
			Links G1 = Links.G1;
			G1.getPegaDados().buscaDados(G1.getUrl(), new ArrayList<>());
			
		}else if(site.equals("terra")) {
			Links terra = Links.Terra;
			terra.getPegaDados().buscaDados(terra.getUrl(), new ArrayList<>());
			
		}else if(site.equals("r7")) {
			Links R7 = Links.R7;
			R7.getPegaDados().buscaDados(R7.getUrl(), new ArrayList<>()); 
			
		}else if (site.equals("uol")) {
			Links Uol = Links.Uol;
			Uol.getPegaDados().buscaDados(Uol.getUrl(), new ArrayList<>());
			
		}else {
			System.out.println("esse site não foi encontrado.");
		}
		
	}
}
