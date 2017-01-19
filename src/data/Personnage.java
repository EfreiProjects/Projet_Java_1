package data;

import java.util.List;
import java.util.Random;

public class Personnage {
	private String nom, race;
	private int vie;
	private String taille;
	private int[] modif = new int[20];
	
	private Classe classe;
	private Caracteristiques carac = new Caracteristiques();
	private String[] indexOfCaracteristique = {"force", "constitution", "dexterite", "intelligence", "sagesse", "charisme"};
	private String[] indexOfDefense = {"armure", "vigueur", "reflexes", "volonte"};
	private Defenses def = new Defenses();
	
	public Personnage(String nom, String race, String classePerso){
		this.nom = nom;
		this.race = race;
		
		data.RaceParser raceParser = new data.RaceParser();
		List<Race> races = raceParser.parse();
		
		data.ClasseParser classeParser = new data.ClasseParser();
		List<Classe> classeList = classeParser.parse();
		
		for(int i=0; i<classeList.size(); i++){
			if(classePerso.equals(classeList.get(i).getNom()))
				this.classe = classeList.get(i);
		}
		Random rd = new Random();
		int[] temp = new int[6];
		int average;
		do{
			average = 0;
			for(int i=0; i<6; i++){
				temp[i]=rd.nextInt(15)+5;
				average = average+temp[i];
			}
			average = average / temp.length;
		} while(average < 9);
		rd.setSeed(0);
		this.carac.setForce(temp[0]);
		this.carac.setConstitution(temp[1]);
		this.carac.setDexterite(temp[2]);
		this.carac.setIntelligence(temp[3]);
		this.carac.setSagesse(temp[4]);
		this.carac.setCharisme(temp[5]);
		
		for(Race p : races){
			if(p.getRace() == this.race){
				this.carac.setForce(this.carac.getForce()+p.getForce());
				this.carac.setConstitution(this.carac.getForce()+p.getForce());
				this.carac.setDexterite(this.carac.getForce()+p.getForce());
				this.carac.setIntelligence(this.carac.getForce()+p.getForce());
				this.carac.setSagesse(this.carac.getForce()+p.getForce());
				this.carac.setCharisme(this.carac.getForce()+p.getForce());
				this.setTaille(p.getTaille());
			}
		}
		
		int increment = -5;
		for(int i=0; i<20; i++){
			if(i%2!=0)
				increment++;
			this.modif[i]=increment;
		}
		
		this.vie = 100 + this.modif[this.carac.getConstitution()];
		
		this.def.setArmure(10+this.modif[this.carac.getDexterite()]);
		
		if(this.carac.getDexterite() >= this.carac.getIntelligence())
			this.def.setReflexes(10+this.modif[this.carac.getDexterite()]);
		else
			this.def.setReflexes(10+this.modif[this.carac.getIntelligence()]);
		
		if(this.carac.getSagesse() >= this.carac.getCharisme())
			this.def.setVolonte(10+modif[this.carac.getSagesse()]);
		else
			this.def.setVolonte(10+modif[this.carac.getCharisme()]);
		
		if(this.carac.getForce() >= this.carac.getConstitution())
			this.def.setVigueur(10+modif[this.carac.getForce()]);
		else
			this.def.setVigueur(10+modif[this.carac.getConstitution()]);
	}
	
	public String getNom(){ return this.nom; }
	public String getRace(){ return this.race; }
	public String getTaille(){ return this.taille; }
	public Classe getClasse(){ return this.classe; }
	
	public int getVie(){ return this.vie; }
	
	public void setTaille(String Taille){ this.taille = taille; }
	
	public void setVie(int vie){ this.vie = vie; }
	public void incrementVie(int value){ this.vie = vie + value; }

	public String toString(){
		return new StringBuffer(nom).append(", "+this.classe.getNom()+" "+this.race+"\n"+this.vie+" PV \nCaracteristiques : ")
				.append("\n FOR : "+this.carac.getForce()+" modif "+modif[this.carac.getForce()])
				.append("\n CONS : "+this.carac.getConstitution()+" modif "+this.modif[carac.getConstitution()])
				.append("\n DEX : "+this.carac.getDexterite()+" modif "+this.modif[carac.getDexterite()])
				.append("\n INT : "+this.carac.getIntelligence()+" modif "+this.modif[carac.getIntelligence()])
				.append("\n SAG : "+this.carac.getSagesse()+" modif "+this.modif[carac.getSagesse()])
				.append("\n CHA : "+this.carac.getCharisme()+" modif "+this.modif[carac.getCharisme()])
				.append("\nDefenses : ")
				.append("\n CA : "+this.def.getArmure())
				.append("\n REF : "+this.def.getReflexes())
				.append("\n VOL : "+this.def.getVolonte())
				.append("\n VIG : "+this.def.getVigueur())
				.toString();
	}
	public int attaquer(Personnage cible, Attaque attaque, int indexAttaqueIn){
		if(this.classe.getAttaques().get(indexAttaqueIn).getRepetition() != 0){
			Random jet = new Random();
			int indexAttaque = 0;
			int indexDefense = 0;
			int jetAttaque, jetDegat, degats;
			for(int i = 0; i<6; i++){
				if(attaque.getCaracteristique() == this.indexOfCaracteristique[i])
					indexAttaque = i;
			}
			for(int i = 0; i<4; i++){
				if(attaque.getDefense() == this.indexOfDefense[i])
					indexDefense = i;
			}
			
			System.out.println("Vous tentez d'attaquer avec "+attaque.getNom());
			System.out.print("Vous mesurez votre caracteristique "+attaque.getCaracteristique()+" a la defense "+attaque.getDefense()+" de "+cible.getNom());
			if(attaque.getBonus() != 0)
				System.out.println(" avec un bonus de "+attaque.getBonus()+".");
			else
				System.out.println(".");
			jetAttaque = jet.nextInt(20)+1;
			jetDegat = 0;
			for(int i=0; i<attaque.getNombre(); i++)
				jetDegat = jetDegat+jet.nextInt(attaque.getDegat())+1;
			jetDegat = jet.nextInt(attaque.getDegat())+1;
			System.out.println("Jet de 1D20 + "+attaque.getBonus()+" + modificateur de "+attaque.getCaracteristique()+".");
			if(jetAttaque+attaque.getBonus()+this.modif[this.carac.getTableauCaracteristiques()[indexAttaque]] > cible.carac.getTableauCaracteristiques()[indexDefense]){
				System.out.print(jetAttaque+"+"+attaque.getBonus());
				if(modif[this.carac.getTableauCaracteristiques()[indexAttaque]] >= 0)
					System.out.print("+");
				System.out.print(modif[this.carac.getTableauCaracteristiques()[indexAttaque]]+" > "+cible.carac.getTableauCaracteristiques()[indexDefense]);
				System.out.println(" attaque réussie !");
				System.out.println(attaque.getDescription());
				System.out.println("Vous infligez "+attaque.getNombre()+"D"+attaque.getDegat()+"="+jetDegat+" points de dommages a "+cible.getNom());
				return jetDegat;
			}
			else{
				System.out.println(jetAttaque+"+"+attaque.getBonus()+"+"+modif[this.carac.getTableauCaracteristiques()[indexAttaque]]+" < "+cible.carac.getTableauCaracteristiques()[indexDefense]);
				System.out.println("attaque ratée !");
				return 0;
			}
		}
		else
			return 0;
	}
}