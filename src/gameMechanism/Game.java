package gameMechanism;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import data.Attaque;
import data.Classe;
import data.ClasseParser;
import data.Race;

public class Game {
	public Game(){ this.main(); }
	
	public List<String> creationPerso(){
		BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in)); 
		Scanner scanner1 = new Scanner(System.in);
		Scanner scanner2 = new Scanner(System.in);
		List<String> result = new ArrayList();
		String bufferStr = new String();
		int bufferInt, i=0;
		
		data.RaceParser raceParser = new data.RaceParser();
		List<Race> races = raceParser.parse();
		data.ClasseParser classeParser = new data.ClasseParser();
		List<Classe> classes = classeParser.parse();
		 
		System.out.println("Veuillez saisir le nom de votre personnage");
		try{
			bufferStr = keyboard.readLine();
		}catch (IOException e){
			e.printStackTrace();
		}
		result.add(bufferStr);
		
		for(Race r : races){
			System.out.println(i+". "+r.getRace());
			i++;
		}
		do{
			System.out.println("Veuillez saisir la race de votre personnage");
			bufferInt = scanner1.nextInt();
		}while(bufferInt < 0 || bufferInt > 3);
		result.add(races.get(bufferInt).getRace());
		System.out.println("vous avez choisi : "+races.get(bufferInt).getRace());
		
		i=0;
		for(Classe c : classes){
			System.out.println(i+". "+c.getNom());
			i++;
		}
		do{
			System.out.println("Veuillez saisir la classe de votre personnage");
			bufferInt = scanner2.nextInt();
		}while(bufferInt < 0 || bufferInt > 3);
		result.add(classes.get(bufferInt).getNom());
		System.out.println("vous avez choisi : "+classes.get(bufferInt).getNom());
		
		return result;
	}
	
	public boolean continuerPartie(data.Personnage personnage1, data.Personnage personnage2){
		if(personnage1.getVie() < 0 || personnage2.getVie() < 0){
			if(personnage1.getVie() < 0)
				System.out.println(personnage1.getNom()+" est mort");
			else if(personnage2.getVie() < 0){
				System.out.println(personnage2.getNom()+" est mort");
			}
			return false;
		}
		else
			return true;
	}
	public void main(){
		List<String> temp = new ArrayList();
		Scanner scanner = new Scanner(System.in);
		int i=0, bufferInt=0;
		System.out.print("Premier joueur, ");
		temp = creationPerso();
		data.Personnage joueur1 = new data.Personnage(temp.get(0), temp.get(1), temp.get(2));
		System.out.println(joueur1);
		
		System.out.print("Second joueur, ");
		temp = creationPerso();
		data.Personnage joueur2 = new data.Personnage(temp.get(0), temp.get(1), temp.get(2));
		System.out.println(joueur2);
		
		while(continuerPartie(joueur1, joueur2) == true){
			i=0;
			System.out.println("Joueur 1 : "+joueur1.getNom()+" attaque");
			for(Attaque a : joueur1.getClasse().getAttaques()){
				System.out.println(i+"."+a.getNom());
				i++;
			}
			do{
				do{
					System.out.println("Veuillez saisir l'attaque choisie");
					bufferInt = scanner.nextInt();
				}while(bufferInt < 0 || bufferInt > 2);
				if(joueur1.getClasse().getAttaque(bufferInt).getRepetition() == 0){
					System.out.println("Vous ne pouvez plus utiliser cette attaque !");
				}
			}while(joueur1.getClasse().getAttaque(bufferInt).getRepetition() == 0);
			joueur2.setVie(joueur2.getVie() - joueur1.attaquer(joueur2, joueur1.getClasse().getAttaque(bufferInt), 0));
			if(joueur1.getClasse().getAttaque(bufferInt).getRepetition() != -1 || joueur1.getClasse().getAttaque(bufferInt).getRepetition() != -1)
				joueur1.getClasse().getAttaque(bufferInt).setRepetition(joueur1.getClasse().getAttaque(bufferInt).getRepetition()-1);
			
			i=0;
			System.out.println("Joueur 2 : "+joueur2.getNom()+" joue");
			for(Attaque a : joueur2.getClasse().getAttaques()){
				System.out.println(i+"."+a.getNom());
				i++;
			}
			do{
				do{
					System.out.println("Veuillez saisir l'attaque choisie");
					bufferInt = scanner.nextInt();
				}while(bufferInt < 0 || bufferInt > 3);
				if(joueur2.getClasse().getAttaque(bufferInt).getRepetition() == 0){
					System.out.println("Vous ne pouvez plus utiliser cette attaque !");
				}
			}while(joueur2.getClasse().getAttaque(bufferInt).getRepetition() == 0);
			joueur1.setVie(joueur1.getVie() - joueur2.attaquer(joueur1, joueur2.getClasse().getAttaque(bufferInt), 0));
			if(joueur2.getClasse().getAttaque(bufferInt).getRepetition() != -1 || joueur2.getClasse().getAttaque(bufferInt).getRepetition() != 0)
				joueur2.getClasse().getAttaque(bufferInt).setRepetition(joueur2.getClasse().getAttaque(bufferInt).getRepetition()-1);
		}
	}
}
