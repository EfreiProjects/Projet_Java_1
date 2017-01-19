package gameMechanism;

import java.util.Scanner;

abstract class Menu {
	private String logo = new StringBuffer("                                     /   \\       \n").append("    _                        )      ((   ))     (\n").append("   (@)                      /|\\      ))_((     /|\\\n").append("   |-|                     / | \\    (/\\|/\\)   / | \\                      (@)\n").append("   | | -------------------/--|-voV---\\`|'/--Vov-|--\\---------------------|-|\n").append("   |-|                         '^`   (o o)  '^`                          | |\n").append("   | |                               `\\Y/'                               |-|\n").append("   |-|                                                                   | |\n").append("   | |                   Warlords of the Forgotten Realms                |-|\n").append("   | |                      ~.~.~.~.~.~.~.~.~.~.~.~.~                    |-|\n").append("   |-|                  Guillaume Andre & Charles Millequant             | |\n").append("   |_|___________________________________________________________________| |\n").append("   (@)              l   /\\ /         ( (       \\ /\\   l                `\\|-|\n").append("                     l /   V          \\ \\       V   \\ l                  (@)\n").append("                     l/               _) )_          \\I\n").append("                                     `\\ /'\n").toString();
	private String description = "Le continent de Feerune est vaste, mesurant plus de 5 500 km d'est en ouest et 4 000 km du nord au sud,\n incluant des deserts brûlants, de denses forêts s'etendant à perte de vue,\n d'imposantes montagnes et de brillants lacs et mers. C'est dans ce monde que les habitants de Feerune vivent chaque jour à cultiver la terre, servir de la bière aux roturiers de la taverne, entretenir l'art de la conversation,\n etudier la magie ou decouvrir des tresors caches en combattant monstres et bêtes dans les plus profonds donjons.\n Feerune est divisee en plusieurs regions ayant leurs propres particularites. Au sud du continent, les epaisses jungles de Chult cachent certains des animaux les plus feroces des Royaumes et les plaines de la savane du Shaar abritent des creatures qui ne le sont pas moins.\n Au nord, ceux qui ont visite les joyaux que sont Eauprofonde et Lunargent pourront se faire emporter par le froid penetrant des montagnes du Valbise s'ils ne prennent pas garde. Le grand desert d'Anauroch assoiffe les aventuriers en quête de tresors perdus. Les contrees des Vaux,\n de la Sembie et du Cormyr relèvent d'un cadre medieval-fantastique plus classique. Les habitants des côtes de la mer interieure des etoiles Dechues restent sur le qui-vive contre une eventuelle attaque de pirates.\n Dans ce monde d'intrigues, de misteres et d'aventures, de nombreux aventuriers cherchent a prouver leur valeur, et se battre en duel est un bon moyen de le faire...";
	
	Menu(){
		Scanner scanner = new Scanner(System.in);
		int bufferInt;
		do{
			displayMenu();
			System.out.println("Voulez-vous continuer à jouer ? (1.oui | 0.non)");
			do{
				bufferInt = scanner.nextInt();
			}while(bufferInt < 0 || bufferInt > 1);
			if(bufferInt == 0){
				System.out.println("Merci d'avoir joué !");
				return;
			}
		}while(1 == 1);
	}
	
	public void clearScreen(){
		for(int i=0; i<=100; i++)
			System.out.println();
	}
	abstract void displayMenu();
	public String getLogo(){ return this.logo; }
	public String getDescription(){ return this.description; }
}
