package model;

public class NodoABB {
	
	private NodoABB rigth;
	private NodoABB left;
	
	private long amount;

	public NodoABB(long amount) {
		this.amount = amount;
		
		rigth = null;
		left = null;
	}

	public NodoABB getRigth() {
		return rigth;
	}

	public void setRigth(NodoABB rigth) {
		this.rigth = rigth;
	}

	public NodoABB getLeft() {
		return left;
	}

	public void setLeft(NodoABB left) {
		this.left = left;
	}

	public long getAmount() {
		return amount;
	}
}
