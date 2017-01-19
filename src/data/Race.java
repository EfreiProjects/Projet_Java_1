package data;

public class Race {
	private String race, taille;
	private int force, constitution, dexterite, intelligence, sagesse, charisme;
	
	public Race(){}
	
	public String getRace(){return this.race;}
	public String getTaille(){return this.taille;}
	public int getForce(){return this.force;}
	public int getConstitution(){return this.constitution;}
	public int getDexterite(){return this.dexterite;}
	public int getIntelligence(){return this.intelligence;}
	public int getSagesse(){return this.sagesse;}
	public int getCharisme(){return this.charisme;}
	
	public void setRace(String race){ this.race = race;}
	public void setTaille(String taille){ this.taille = taille;}
	public void setForce(int force){ this.force = force;}
	public void setConstitution(int constitution){ this.constitution = constitution;}
	public void setDexterite(int dexterite){ this.dexterite = dexterite;}
	public void setIntelligence(int intelligence){ this.intelligence = intelligence;}
	public void setSagesse(int sagesse){ this.sagesse = sagesse;}
	public void setCharisme(int charisme){ this.charisme = charisme;}

	public String toString(){
		return new StringBuffer("race : ").append(race).append(", ")
			.append("taille : ").append(taille).append(", ")
			.append("force : ").append(force).append(", ")
			.append("constitution : ").append(constitution).append(", ")
			.append("dexterite : ").append(dexterite).append(", ")
			.append("intelligence : ").append(intelligence).append(", ")
			.append("sagesse : ").append(sagesse).append(", ")
			.append("charisme : ").append(charisme)
			.toString();
	}
}