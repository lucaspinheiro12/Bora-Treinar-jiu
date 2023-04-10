package Desafio.Andre.Desafio.Web;

import java.io.IOException;
import java.util.List;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public interface ManipulaDados  {
		
	public void buscaDados(String url, List<String> link); 
		
	
	/*public  void PegaDadosCliente() {
		Scanner scanner = new Scanner(System.in);
		
		String link;
		System.out.println("Link da pagina inicial:");
		link = scanner.nextLine();
		
		String href;
		System.out.println("Digite o valor da classe onde se encontra o Href:");
		href = scanner.nextLine();
		
		String textoLinkNoticia;
		System.out.println("digite um valor comum que tenha em links de noticia:");
		textoLinkNoticia = scanner.nextLine();
		
		String textoLinkNoticia2;
		System.out.println("digite outro valor comum que tenha em links de noticia:");
		textoLinkNoticia2 = scanner.nextLine();
		
		System.out.println("Entre em um link qualquer de noticia para pegar os proximos dados.");
		
		String classeSubTitulo;
		System.out.println("Digite o valor da classe do subtitulo:");
		classeSubTitulo = scanner.nextLine();
		
		String classeAutor;
		System.out.println("Digite o valor da classe do autor da noticia:");
		classeAutor = scanner.nextLine();
		
		String classeData;
		System.out.println("Digite o valor da classe da data da noticia:");
		classeData = scanner.nextLine();
		
		 try {
			pegaProximoLink(link, href, textoLinkNoticia, textoLinkNoticia2, classeSubTitulo, classeAutor, classeData, new ArrayList<>());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}*/
}
