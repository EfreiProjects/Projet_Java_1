package data;

import java.util.ArrayList;
import java.util.List;

public class Classe {
	
	private String nom, description, races;
	private List<Attaque> attaques = new ArrayList<Attaque>();
	
	public Classe(){}
	
	public String getNom(){ return this.nom; }
	public String getDescription(){ return this.description; }
	public String getRaces(){ return this.races; }
	public List<Attaque>getAttaques(){ return this.attaques; }
	public Attaque getAttaque1(){ return this.attaques.get(0); }
	public Attaque getAttaque2(){ return this.attaques.get(1); }
	public Attaque getAttaque3(){ return this.attaques.get(2); }
	public Attaque getAttaque(int id){ return this.attaques.get(id); }
	
	public void setNom(String nom){ this.nom = nom; }
	public void setDescription(String description){ this.description = description; }
	public void setRaces(String races){ this.races = races; }
	public void setAttaques(List<Attaque> attaques){ this.attaques = attaques;}
	public void addAttaque(Attaque attaque){ this.attaques.add(attaque); }
	
	public String toString(){
		StringBuffer display = new StringBuffer(nom).append(" \n")
				.append(description+"\n")
				.append(races+"\n");
		int i = 1;
		for(Attaque p : attaques){
			display.append(" ->"+p.getNom()+"\n")
			.append("   "+p.getCaracteristique()+"+"+p.getBonus()+" contre "+p.getDefense()+"\n")
			.append("   Degats : "+p.getNombre()+"D"+p.getDegat()+"\n")
			.append("   Nombre d'utilisations restantes : ");
			if(p.getRepetition() == -1)
				display.append("a volonte");
			else
				display.append(p.getRepetition());
			display.append("\n");
		}
		return display.toString();
	}
}