package model;

public class NodoLE {

	private NodoLE next;
	private NodoLE previous;
	
	private long amount;
	
	public NodoLE(long amount) {
		this.amount = amount;
		
		next = null;
		previous = null;
	}

	public NodoLE getNext() {
		return next;
	}

	public void setNext(NodoLE next) {
		this.next = next;
	}

	public NodoLE getPrevious() {
		return previous;
	}

	public void setPrevious(NodoLE previous) {
		this.previous = previous;
	}

	public long getAmount() {
		return amount;
	}
}
