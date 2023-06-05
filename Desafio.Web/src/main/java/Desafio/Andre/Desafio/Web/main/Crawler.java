package Desafio.Andre.Desafio.Web.main;

import java.util.ArrayList;

import Desafio.Andre.Desafio.Web.InterfaceManiputacao.ManipulaDados;
import Desafio.Andre.Desafio.Web.Retorno.ValorCliente;

public class Crawler {
	

	public static void main(String[] args){
		ValorCliente input = new ValorCliente();
		String resposta = input.escolherSite();
		String url = input.pegaSiteEscolhido(resposta);
		ManipulaDados manipulaDados = input.pegaClasseEscolhido(resposta);		
		manipulaDados.buscaDados(url, new ArrayList<>());
		
		
	}
}
