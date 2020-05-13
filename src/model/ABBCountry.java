package model;

public class ABBCountry {
	
	private NodoABB top;
	
	public ABBCountry() {
		top = null;
	}
	
	//Add ITERATIVE	
	public void addIterative(long n) {
		NodoABB nodo = new NodoABB(n);
		NodoABB current = top;
		
		boolean available = false;
		
		while(current!=null&&!available) {
			if(current.getAmount()>n) {
				current = current.getLeft();
			}else if(current.getAmount()<n) {
				current = current.getRigth();
			}else {
				available = true;
			}	
		}if(available)
			current = nodo;
	}
	
	//Add RECURSIVE
	public void addRecursive(long n) {
		
	}
	
	public void addRecursive() {
		
	}
	
	//Search ITERATIVE
	public boolean searchIterative(long n) {
		NodoABB current = top;
		
		while(current != null) {
			if(current.getAmount()>n) {
				current = current.getLeft();
			}else if(current.getAmount()<n) {
				current = current.getRigth();
			}else {
				return true;
			}
		}return false;
		
	}
	
	//Search RECURSIVE
	public boolean searchRecursive(long n) {
		return false;
		
	}
	
	public boolean searchRecursive(NodoABB aux, long n) {
		return false;
		
	}
	
	//Delete ITERATIVE
	public boolean deleteIterative(long n) {
		return false;
		
	}
	
	//Delete RECURSIVE
	public boolean deleteRecursive(long n) {
		return false;
		
	}
	
	public boolean deleteRecursive() {
		return false;
		
	}
}