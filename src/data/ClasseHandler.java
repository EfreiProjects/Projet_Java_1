package data;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class ClasseHandler extends DefaultHandler {
	private List<Classe> classes;
	private List<Attaque> attaques = new ArrayList <Attaque>();
	private Classe personne;
	private Attaque attaque;
	
	public ClasseHandler(){ super(); }
	public List<Classe> getClasses(){return this.classes; }

	private boolean inDocument, inClasse, inDescription, inRaces, inAttaque, inNom, inDescriptionAttaque, inCaracteristique, inBonus, inDefense, inNombre, inDegat, inRepetition;
	private StringBuffer buffer;

	//détection d'ouverture de balise
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException{
		if(qName.equals("document")){
			classes = new LinkedList<Classe>();
			inDocument = true;
		}
		else if(qName.equals("classe")){
			personne = new Classe();
			try{
				String id = attributes.getValue("id");
				personne.setNom(id);
			}catch(Exception e){
				throw new SAXException(e);
			}
			inClasse = true;
		}else {
			buffer = new StringBuffer();
			if(qName.equals("description")){
				inDescription = true;
			}else if(qName.equals("races")){
				inRaces = true;
			}else if(qName.equals("attaque")){
				attaque = new Attaque();
				inAttaque = true;
			}else if(qName.equals("nom")){
				inNom = true;
			}else if(qName.equals("descriptionAttaque")){
				inDescriptionAttaque = true;
			}else if(qName.equals("caracteristique")){
				inCaracteristique = true;
			}else if(qName.equals("bonus")){
				inBonus = true;
			}else if(qName.equals("defense")){
				inDefense = true;
			}else if(qName.equals("nombre")){
				inNombre = true;
			}else if(qName.equals("degat")){
				inDegat = true;
			}else if(qName.equals("repetition")){
				inRepetition = true;
			}else{
				throw new SAXException("Balise "+qName+" inconnue.");
			}
		}
	}
	
	//détection fin de balise
	public void endElement(String uri, String localName, String qName)
			throws SAXException{
		
		if(qName.equals("document")){
			inDocument = false;
		}else if(qName.equals("classe")){
			classes.add(personne);
			personne = null;
			inClasse = false;
		}else if(qName.equals("description")){
			personne.setDescription(buffer.toString());
			buffer = null;
			inDescription = false;
		}else if(qName.equals("races")){
			personne.setRaces(buffer.toString());
			buffer = null;
			inRaces = false;
		}else if(qName.equals("attaque")){
			personne.addAttaque(attaque);
			buffer = null;
			inAttaque = false;
		}else if(qName.equals("nom")){
			attaque.setNom(buffer.toString());
			buffer = null;
			inNom = false;
		}else if(qName.equals("descriptionAttaque")){
			attaque.setDescription(buffer.toString());
			buffer = null;
			inDescriptionAttaque = false;
		}else if(qName.equals("caracteristique")){
			attaque.setCaracteristique(buffer.toString());
			buffer = null;
			inCaracteristique = false;
		}else if(qName.equals("bonus")){
			attaque.setBonus(Integer.parseInt(buffer.toString()));
			buffer = null;
			inNom = false;
		}else if(qName.equals("defense")){
			attaque.setDefense(buffer.toString());
			buffer = null;
			inDefense = false;
		}else if(qName.equals("nombre")){
			attaque.setNombre(Integer.parseInt(buffer.toString()));
			buffer = null;
			inNombre = false;
		}else if(qName.equals("degat")){
			attaque.setDegat(Integer.parseInt(buffer.toString()));
			buffer = null;
			inDegat = false;
		}else if(qName.equals("repetition")){
			attaque.setRepetition(Integer.parseInt(buffer.toString()));
			buffer = null;
			inRepetition = false;
		}else{
			throw new SAXException("Balise "+qName+" inconnue.");
		}          
	}
	//détection de caractères
	public void characters(char[] ch,int start, int length)
			throws SAXException{
		String lecture = new String(ch,start,length);
		if(buffer != null) buffer.append(lecture);       
	}
	/*
	public void startDocument() throws SAXException {
		System.out.println("Début du parsing");
	}
	*/
	//fin du parsing
	public void endDocument() throws SAXException {
	}
}
