package it.polimi.deib.se.ex01.morracinese;

import java.io.InputStream;
import java.util.Random;
import java.util.Scanner;

public class GameLogic {	
	
	private final Scanner scanner;
	
	public GameLogic(InputStream input) {
		this.scanner = new Scanner(input);
	}
	
	private Outcome choiceSubmitted(Choice userChoice){
		Choice computerChoice = Choice.getRandomChoice(new Random());
		System.out.println("Ho scelto " + computerChoice + "!");
		return userChoice.resultAgainst(computerChoice);
	}

	public void close() {
		scanner.close();		
	}

	public boolean round() {
		System.out.println("Che scelta fai?");
		String input = scanner.next();
		try{
			Choice choice = Choice.parseInput(input);
			System.out.println("Hai scelto " + choice + "!");
			System.out.println(choiceSubmitted(choice));
		}catch(IllegalArgumentException e){
			System.out.println("Scelta non valida!");
		}
		return true; //Attualmente il gioco va avanti all'infinito
					 //TODO Modificare l'implementazione per chiedere all'utente se continare o meno.
	}
	
	public static void main(String[] args) {
		GameLogic gameLogic = new GameLogic(System.in);
		boolean cont;
		do{
			cont = gameLogic.round();
		}while(cont);
		gameLogic.close();
	}

}
