package it.polimi.deib.se.ex01.morracinese;

public enum Outcome {
	WINNER("Hai vinto!"), LOSER("Hai perso!"), DRAW("Parita'!");
	private final String message;

	private Outcome(String message){
		this.message = message;
	}
	
	@Override
	public String toString() {
		return message;
	}
	
	public static Outcome winsIfTrue(boolean condition){
		return (condition)?Outcome.WINNER:Outcome.LOSER;
	}


}
