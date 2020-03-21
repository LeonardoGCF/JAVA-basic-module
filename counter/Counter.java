package it.polimi.deib.se.ex01.counter;

public class Counter {
	
	//Contatore condiviso tra tutte le istanze
	private static int counter = 0;
	
	//Numero della specifica istanza
	private final int number;

	
	public Counter(){
		number = counter;
		counter=counter+1;
	}
	
	public int getNum() {
		return number;
	}
    
	// nota il metodo toString puo' essere generato automaticamente in eclipse sfruttando source > generateToString();
	@Override
	public String toString(){
        	return number + " of " + counter;
	}
}