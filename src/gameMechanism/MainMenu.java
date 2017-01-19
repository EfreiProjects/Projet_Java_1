package gameMechanism;

import java.util.List;
import java.util.Scanner;

import data.Classe;
import data.Race;

public class MainMenu extends Menu{

	@Override
	void displayMenu() {
		Scanner scanner = new Scanner(System.in);
		int bufferInt;
		
		System.out.println(this.getLogo());
		System.out.println("0. Jouer !\n1. Consulter l'encyclopédie");
		do{
			System.out.println("Veuillez saisir 0 ou 1");
			bufferInt = scanner.nextInt();
		}while(bufferInt < 0 || bufferInt > 1);
		if(bufferInt == 0)
			this.startGame();
		else if(bufferInt == 1)
			this.displayXML();
	}
	private void startGame(){
		Game partie = new gameMechanism.Game();
	}
	private void displayXML(){
		data.RaceParser raceParser = new data.RaceParser();
		List<Race> races = raceParser.parse();
		data.ClasseParser classeParser = new data.ClasseParser();
		List<Classe> classes = classeParser.parse();
		System.out.println(this.getDescription());
		System.out.println("Voici quelques unes des caractéristiques de ces combattants de légende !");
		System.out.println("== Races ==");
		for(Race r : races)
			System.out.println(r.toString());
		System.out.println("\n== Classes ==");
		for(Classe c : classes)
			System.out.println(c.toString());
	}
}
