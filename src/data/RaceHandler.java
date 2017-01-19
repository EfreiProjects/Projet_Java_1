package data;

import java.util.LinkedList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class RaceHandler extends DefaultHandler{
	private List<Race> races;
	private Race personne;
	private boolean inDocument, inRace, inTaille, inForce, inConstitution, inDexterite, inIntelligence, inSagesse, inCharisme;
	private StringBuffer buffer;

	public RaceHandler(){ super(); }
	public List<Race> getRaces(){ return races; }
	//détection d'ouverture de balise
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException{
		if(qName.equals("document")){
			races = new LinkedList<Race>();
			inDocument = true;
		}
		else if(qName.equals("race")){
			personne = new Race();
			try{
				String id = attributes.getValue("id");
				personne.setRace(id);
			}catch(Exception e){
				throw new SAXException(e);
			}
			inRace = true;
		}else {
			buffer = new StringBuffer();
			if(qName.equals("taille")){
				inTaille = true;
			}else if(qName.equals("force")){
				inForce = true;
			}else if(qName.equals("constitution")){
				inConstitution = true;
			}else if(qName.equals("dexterite")){
				inDexterite = true;
			}else if(qName.equals("intelligence")){
				inIntelligence = true;
			}else if(qName.equals("sagesse")){
				inSagesse = true;
			}else if(qName.equals("charisme")){
				inCharisme = true;
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
		}else if(qName.equals("race")){
			races.add(personne);
			personne = null;
			inRace = false;
		}else if(qName.equals("taille")){
			personne.setTaille(buffer.toString());
			buffer = null;
			inTaille = false;
		}else if(qName.equals("force")){
			personne.setForce(Integer.parseInt(buffer.toString()));
			buffer = null;
			inForce = false;
		}else if(qName.equals("constitution")){
			personne.setConstitution(Integer.parseInt(buffer.toString()));
			buffer = null;
			inConstitution = false;
		}else if(qName.equals("dexterite")){
			personne.setDexterite(Integer.parseInt(buffer.toString()));
			buffer = null;
			inDexterite = false;
		}else if(qName.equals("intelligence")){
			personne.setIntelligence(Integer.parseInt(buffer.toString()));
			buffer = null;
			inIntelligence = false;
		}else if(qName.equals("sagesse")){
			personne.setSagesse(Integer.parseInt(buffer.toString()));
			buffer = null;
			inSagesse = false;
		}else if(qName.equals("charisme")){
			personne.setCharisme(Integer.parseInt(buffer.toString()));
			buffer = null;
			inCharisme = false;
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