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
	
	public String pegaSiteEscolhido(String site) {
		if(site.equals("g1")) {
			return "https://g1.globo.com/";
				
			}else if(site.equals("terra")) {
				return "https://www.terra.com.br/";
				
			}else if(site.equals("r7")) {
				return "https://www.terra.com.br/";
				
			}else if (site.equals("uol")) {
				return "https://www.uol.com.br/";
				
			}else {
				return "esse site não foi encontrado.";
			}
	}
	
	public ManipulaDados pegaClasseEscolhido(String site) {
		if(site.equals("g1")) {
			return new DadosG1();
			
		}else if(site.equals("terra")) {
			return new DadosTerra();
			
		}else if(site.equals("r7")) {
			return new DadosR7();
			
		}else if (site.equals("uol")) {
			return new DadosUol();
			
		}else {
			System.out.println("esse site não foi encontrado.");
			return null;
		}
	
	}
}