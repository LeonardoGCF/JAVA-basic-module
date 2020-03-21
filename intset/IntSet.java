package it.polimi.deib.se.ex01.intset;

public class IntSet {
	// Rappresentazione interna: array di interi
	private final int[] elements;

	// dimensione effettiva dell'insieme
	private int currentSize;

	// costante che rappresenta la dimensione massima del set
	private final static int MAX_SIZE = 100;

	// costruttore di default, caso particolare
	// del costruttore che ha come argomento la
	// dimensione dell'insieme.
	public IntSet() {
		this(MAX_SIZE);
	}

	// costruttore che prende come argomento
	// la dimensione dell'insieme.
	public IntSet(int size) {
		this.currentSize = 0;
		this.elements = new int[size];
	}
	
	public static void main(String[] args) 
	{
		IntSet intSet = new IntSet();
		
		try {
			intSet.add(1);
			intSet.add(2);
		} catch (Exception e) 
		{
			System.err.println("Raggiunto limite massimo del set");
		}
		
		System.out.println(intSet.toString());
		
		intSet.remove(1);
		System.out.println(intSet.toString());
		
	}

	// Aggiunge un intero all'insieme.
	public void add(int n) throws Exception {
		// invoco il metodo che controlla
		// la presenza dell'elemento nel set.
		boolean containsElement = this.contains(n);

		// se e' gia' presente non faccio nulla
		if (containsElement)
			return;

		/* controllo che il set non sia pieno */
		if (this.currentSize < elements.length) {
			this.elements[currentSize] = n;
			this.currentSize++;
		} else {
			throw new Exception("Set is full");
		}
	}

	// controlla che l'elemento sia contenuto nell'insieme
	public boolean contains(int n) {
		for (int i = 0; i < this.currentSize; i++) {
			if (elements[i]==n)
				return true;
		}
		/*
		 * // alternativa NON CORRETTA, perche' mi cicla anche su elementi non allocati
		 *
		 * for (int i: elements) { if (i==n){ return true; } }
		 */

		/* default: non trovato */
		return false;
	}

	// rimuove un elemento dall'insieme.
	public void remove(int element) {
		// recupero l'elemento
		int pos = find(element);

		if (pos >= 0) {
			/*
			 * Altra soluzione:
			 * for (int i = pos; i < this.currentSize - 1; i++)
			 *	elements[i] = elements[i + 1];
			 *	this.currentSize = this.currentSize - 1;
			 */						
			this.currentSize = this.currentSize - 1;
			elements[pos] = elements[currentSize];//metto nel posto vuoto l'ultimo elemento
		}
	}

	// metodo privato. restituisce la posizione
	// di un elemento nell'array se esiste (ed e'
	// entro this.size), -1 altrimenti
	private int find(int n) {
		for (int i = 0; i < this.currentSize; i++) {
			if (elements[i]==n)
				return i;
		}
		/* default */
		return -1;
		// Perche' non ha senso che questo metodo sia pubblico?
	}

	// TODO: (facile) scrivere contains(element) usando la find.

	// restituisce la dimensione dell'insieme
	public int size() {
		return this.currentSize;
	}

	public boolean isFull() {
		return currentSize >= MAX_SIZE;
	}
	
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("[");
		for(int i=0; i< currentSize; i++){
			if(i>0){
				builder.append(", ");
			}
			builder.append(elements[i]);
			
		}
		builder.append("]");
		return builder.toString();
	}

	/*	 
	 * TODO: rendere il set unbounded. Usare il metodo statico
	 * Arrays.copyOf(T[] original, int newLength). Importare Arrays dal package
	 * java.util
	 */	

}
