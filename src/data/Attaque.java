package data;

public class Attaque {
	private String nom, description, caracteristique, defense;
	private int bonus, nombre, degat, repetition;
	
	public Attaque(){
		this.nom = "unknown";
		this.description = "unknown";
		this.caracteristique = "unknown";
		this.defense = "unknown";
		this.bonus = 0;
		this.nombre = 0;
		this.degat = 0;
		this.repetition = 0;
	}
	
	public String getNom(){ return this.nom; }
	public String getDescription(){ return this.description; }
	public String getCaracteristique(){ return this.caracteristique; }
	public String getDefense(){ return this.defense; }
	public int getBonus(){ return this.bonus; }
	public int getNombre(){ return this.nombre; }
	public int getDegat(){ return this.degat; }
	public int getRepetition(){ return this.repetition; }
	
	public void setNom(String nom){ this.nom = nom;}
	public void setDescription(String description){ this.description = description; }
	public void setCaracteristique(String caracteristique){ this.caracteristique = caracteristique; }
	public void setDefense(String defense){ this.defense = defense; }
	public void setBonus(int bonus){ this.bonus = bonus; }
	public void setNombre(int nombre){ this.nombre = nombre; }
	public void setDegat(int degat){ this.degat = degat; }
	public void setRepetition(int repetition){ this.repetition = repetition; }
	
}
