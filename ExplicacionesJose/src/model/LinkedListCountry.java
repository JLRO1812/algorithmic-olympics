package model;

public class LinkedListCountry {

	private NodoLE cabeza;
	
	public LinkedListCountry() {
		cabeza = null;
	}
	
	public void addIterative(long n) {
		NodoLE newNodo = new NodoLE(n);
		if(cabeza == null) {
			cabeza = newNodo;
		}else {
			NodoLE aux = cabeza;
			while(aux.getNext()!=null) {
				aux = aux.getNext();
			}
			aux.setNext(newNodo);
			newNodo.setPrevious(aux);
		}
	}
	
	public void addRecursive(long n) {
		NodoLE newNodo = new NodoLE(n);
		if(cabeza == null) {
			cabeza = newNodo;
		}else {
			NodoLE aux = cabeza;
			aux = getEndRecursive(aux);
			aux.setNext(newNodo);
			newNodo.setPrevious(aux);
		}
	}
	
	private NodoLE getEndRecursive(NodoLE aux) {
		if(aux.getNext()!=null) {
			aux = aux.getNext();
			return getEndRecursive(aux);
		}else {
			return aux;
		}
	}
	
	
	public boolean searchIterative(long n) {
		if(cabeza!=null){
			NodoLE aux = cabeza;
			
			while(aux!=null && aux.getAmount()!=n) {
				aux = aux.getNext();
			}
			
			if(aux == null) {
				return false;
			}else {
				return true;
			}
			
		}else {
			return false;
		}
	}
	
	public boolean searchRecursive(long n) {
		if(cabeza!=null) {
			NodoLE aux = cabeza;
			aux = searchRecursive(aux, n);
			
			if(aux == null) {
				return false;
			}else {
				return true;
			}
			
		}else {
			return false;
		}
	}
	
	private NodoLE searchRecursive(NodoLE aux, long n) {
		if(aux != null && aux.getAmount() != n) {
			aux = aux.getNext();
			return searchRecursive(aux, n);
		}else {
			return aux;
		}
	}
	
	public boolean deleteIterative(long n) {
		if(cabeza!=null) {
			NodoLE aux = cabeza;
			
			while(aux!=null && aux.getAmount()!=n) {
				aux = aux.getNext();
			}
			
			if(aux == null) {
				return false;
			}else {
				if(aux.getNext()==null && aux.getPrevious()==null) {
					cabeza = null;
				}else if(aux.getPrevious()==null) {
					aux.getNext().setPrevious(null);
					cabeza = aux.getNext();
				}else if(aux.getNext()==null) {
					aux.getPrevious().setNext(null);
				}else {
					aux.getPrevious().setNext(aux.getNext());
					aux.getNext().setPrevious(aux.getPrevious());
				}
				
				return true;
			}
			
		}else {
			return false;
		}
	}
	
	public boolean deleteRecursive(long n) {
		if(cabeza!=null) {
			NodoLE aux = cabeza;
			
			aux = searchRecursive(aux, n);
			
			if(aux == null) {
				return false;
			}else {
				if(aux.getNext()==null && aux.getPrevious()==null) {
					cabeza = null;
				}else if(aux.getPrevious()==null) {
					aux.getNext().setPrevious(null);
					cabeza = aux.getNext();
				}else if(aux.getNext()==null) {
					aux.getPrevious().setNext(null);
				}else {
					aux.getPrevious().setNext(aux.getNext());
					aux.getNext().setPrevious(aux.getPrevious());
				}
				
				return true;
			}
			
		}else {
			return false;
		}
	}

	public NodoLE getCabeza() {
		return cabeza;
	}
}
