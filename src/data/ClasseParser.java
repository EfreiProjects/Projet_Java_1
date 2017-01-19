package data;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

// import parsingTest.RaceHandler;

public class ClasseParser {

	public List<Classe> parse(){
		List<Classe> classes = new LinkedList<Classe>();
		
		try{
			SAXParserFactory fabrique = SAXParserFactory.newInstance();
			SAXParser parseur = fabrique.newSAXParser();

			File fichier = new File("./classAttributes.xml");
			ClasseHandler gestionnaire = new ClasseHandler();
			parseur.parse(fichier, gestionnaire);
			classes = gestionnaire.getClasses();
			
		}catch(ParserConfigurationException pce){
			System.out.println("Erreur de configuration du parseur");
			System.out.println("Lors de l'appel à newSAXParser()");
		}catch(SAXException se){
			System.out.println(se);
			System.out.println("Lors de l'appel à parse()");
		}catch(IOException ioe){
			System.out.println("Erreur d'entrée/sortie");
			System.out.println("Lors de l'appel à parse()");
		}
		return classes;
	}
}
