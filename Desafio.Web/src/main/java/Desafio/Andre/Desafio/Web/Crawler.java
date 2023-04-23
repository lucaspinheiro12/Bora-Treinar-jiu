package Desafio.Andre.Desafio.Web;

import java.util.ArrayList;

public class Crawler {
	

	public static void main(String[] args){
		ValorCliente input = new ValorCliente();
		String resposta = input.escolherSite();
		String url = input.pegaSiteEscolhido(resposta);
		ManipulaDados manipulaDados = input.pegaClasseEscolhido(resposta);		
		manipulaDados.buscaDados(url, new ArrayList<>());
	}	
}
