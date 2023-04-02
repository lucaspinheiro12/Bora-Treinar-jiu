package Desafio.Andre.Desafio.Web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

	public class PegaDados {
		
		public static void pegaProximoLink( String url,String claseHref ,String valorLink1, String valorLink2,String classeSubTitulo,
			String classeAutor,String classeData, List<String>visitas)throws IOException{
			Document doc = pegaInformacao(url, claseHref, valorLink1, valorLink2,classeSubTitulo, classeAutor,classeData, visitas);
			if (doc != null) {
				for(Element link : doc.select("a[href")) {
					String proximoLink = link.absUrl("href");
					if(visitas.contains(proximoLink) == false) {
						pegaProximoLink(proximoLink, claseHref, valorLink1, valorLink2, classeSubTitulo, classeAutor,classeData, visitas);
					}
				}
			}
		}
	private static Document pegaInformacao( String url, String claseHref, String valorLink1, String valorLink2,
			String classeSubTitulo, String classeAutor, String classeData, List<String>link) throws IOException {
		try {
			Connection con = Jsoup.connect(url);
			Document doc = con.get();	
			if(con.response().statusCode() == 200) {	
				Elements div = doc.getElementsByClass(claseHref);
					for(Element elemento : div) {	
						String pegaUrl = elemento.select("a[href").first().attr("href");
						if(pegaUrl.contains(valorLink1) || pegaUrl.contains(valorLink2)) {

						String tituloPagina = elemento.select("a[href").text();
	
						Connection conTeste = Jsoup.connect(pegaUrl);
						Document docTeste = conTeste.get();
						
						String subtituloDentro = docTeste.getElementsByClass(classeSubTitulo).text();
						String autor = 	docTeste.getElementsByClass(classeAutor).text();
						String data = docTeste.getElementsByClass(classeData).text();
						
						Materia materia = new Materia(pegaUrl, tituloPagina, subtituloDentro, autor, data);
						 apresentaMateria(materia);
					}
				}
					link.add(url);
					return doc;
			}
			return null;
		}catch(IOException e){
			throw new IOException(e);
		}
	}
	
	public static void apresentaMateria (Materia materia) {
		
		System.out.println("Link:  "+ materia.getLink());
		System.out.println("Titulo:  "+ materia.getTitulo());
		System.out.println("Subtitulo:  "+ materia.getSubtitulo());
		System.out.println("Autor da noticia: " + materia.getAutorNoticia());
		System.out.println("Data de publicação: " + materia.getDataPublicacao());
		System.out.println();
	}
	public static void PegaDadosCliente() {
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
	}
}
