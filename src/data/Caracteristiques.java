package data;

public class Caracteristiques {
	/*
	private int force;
	private int constitution;
	private int dexterite;
	private int intelligence;
	private int sagesse;
	private int charisme;
	*/
	private int[] tableauCaracteristiques;
	
	public Caracteristiques(){
		this.tableauCaracteristiques = new int[6];
	}
	
	public int[] getTableauCaracteristiques(){ return this.tableauCaracteristiques; }
	public int getForce(){ return this.tableauCaracteristiques[0];}
	public int getConstitution(){ return this.tableauCaracteristiques[1];}
	public int getDexterite(){ return this.tableauCaracteristiques[2];}
	public int getIntelligence(){ return this.tableauCaracteristiques[3];}
	public int getSagesse(){ return this.tableauCaracteristiques[4];}
	public int getCharisme(){ return this.tableauCaracteristiques[5];}
	
	public void setTableauCharacteristique(int[] tableau){ this.tableauCaracteristiques = tableau; }
	public void setForce(int force){ this.tableauCaracteristiques[0] = force;}
	public void setConstitution(int constitution){ this.tableauCaracteristiques[1] = constitution;}
	public void setDexterite(int dexterite){ this.tableauCaracteristiques[2] = dexterite;}
	public void setIntelligence(int intelligence) { this.tableauCaracteristiques[3] = intelligence;}
	public void setSagesse(int sagesse){ this.tableauCaracteristiques[4] = sagesse;}
	public void setCharisme(int charisme){ this.tableauCaracteristiques[5] = charisme;}
}
