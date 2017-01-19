package data;

public class Defenses {

	private int armure;
	private int vigueur;
	private int reflexes;
	private int volonte;
	
	public int getArmure(){ return this.armure;}
	public int getVigueur(){ return this.vigueur;}
	public int getReflexes(){ return this.reflexes;}
	public int getVolonte(){ return this.volonte;}
	
	public void setArmure(int armure){ this.armure = armure;}
	public void setVigueur(int vigueur){ this.vigueur = vigueur;}
	public void setReflexes(int reflexes){ this.reflexes = reflexes;}
	public void setVolonte(int volonte){ this.volonte = volonte;}
	
	public Defenses(){	
		armure = 0;
		vigueur = 0;
		reflexes = 0;
		volonte = 0;
	}
	
	Defenses(int armure, int vigueur, int reflexes, int volonte){
		this.armure = armure;
		this.vigueur = vigueur;
		this.reflexes = reflexes;
		this.volonte = volonte;
	}
}
