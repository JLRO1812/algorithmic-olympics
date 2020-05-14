package model;

public class ABBCountry {
	
	private NodoABB top;
	
	public ABBCountry() {
		top = null;
	}
	
	//Add ITERATIVE	
	public void addIterative(long n) {
		
		NodoABB nodo = new NodoABB(n);
		NodoABB father;
		
		boolean available;
		
		if(top == null) {
			top = nodo;
		}else {
			NodoABB current = top;
			available = true;
			while(available) {
				father = current;
				if(nodo.getAmount()<current.getAmount()) {
					current = current.getLeft();
					if(current == null) {
						father.setLeft(nodo);
						available = false;
					}
				}else if(nodo.getAmount()>current.getAmount()) {
					current = current.getRigth();
					if(current == null) {
						father.setRigth(nodo);
						available = false;
					}
				}
			}
		}
	}
	
	//Add RECURSIVE
	public void addRecursive(long n) {
		NodoABB nodo = new NodoABB(n);
		
		if(top == null) {
			top = nodo;
		}else {
			NodoABB current = top;
			addRecursive(nodo,current);
		}
	}
	
	public void addRecursive(NodoABB nodo, NodoABB current) {
		NodoABB father = current;
		if(nodo.getAmount()<current.getAmount()) {
			current = current.getLeft();
			if(current == null) {
				father.setLeft(nodo);
			}else {
				addRecursive(nodo, current);
			}
		}else if(nodo.getAmount()>current.getAmount()) {
			current = current.getRigth();
			if(current == null) {
				father.setRigth(nodo);
			}else {
				addRecursive(nodo, current);
			}
		}
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
		NodoABB current = top;
		if(current.getAmount() != n) {
			return searchRecursive(current, n);
		}else {
			return true;
		}
		
	}
	
	public boolean searchRecursive(NodoABB current, long n) {
		if(current.getAmount()>n) {
			current = current.getLeft();
		}else if(current.getAmount()<n) {
			current = current.getRigth();
		}if(current != null) {
			if(current.getAmount() == n) {
				return true;
			}else {
				return searchRecursive(current, n);
			}
		}else 
			return false;			
	}
	
	//Delete ITERATIVE
	public boolean deleteIterative(long n) {
		NodoABB current = top;
		NodoABB father = top;
		
		boolean turnLeft = true;
		
		while(current.getAmount()!=n) {
			 father = current;
			 
			 if(current.getAmount()>n) {
				 turnLeft = true;
				 current =current.getLeft();
			 }else if(current.getAmount()<n) {
				 turnLeft = false;
				 current =current.getRigth();
			 }if(current == null) {
				 return false;
			 }
		}
		
		if(current.getLeft() == null && current.getRigth() == null) {
			
			if(current == top) {
				top = null;
			}else {
				if(turnLeft) {
					father.setLeft(null);
				}else {
					father.setRigth(null);
				}
			}
		}else {
			
			if(current.getRigth() == null) {
				
				if(current == top) {
					top = current.getLeft();
				}else {
					if(turnLeft) {
						father.setLeft(current.getLeft());
					}else {
						father.setRigth(current.getLeft());
					}
				}
			}else {
				if(current.getLeft()==null) {
					if(current == top) {
						top = current.getRigth();
					}else {
						if(turnLeft) {
							father.setLeft(current.getRigth());
						}else {
							father.setRigth(current.getRigth());
						}
					}
				}else {
					NodoABB change = getChangeIterative(current);
					if(current == top) {
						top = change;
					}else {
						if(turnLeft) {
							father.setLeft(change);
						}else {
							father.setRigth(change);
						}
					}change.setLeft(current.getLeft());
				}
			}
		}return true;
	}
	
	private NodoABB getChangeIterative(NodoABB obtain) {
		NodoABB changeFather = obtain;
		NodoABB change = obtain;
		NodoABB current = obtain.getRigth();
		
		while(current != null) {
			changeFather = change;
			change = current;
			current = current.getLeft();
		}
		
		if(change != obtain.getRigth()) {
			changeFather.setLeft(change.getRigth());
			change.setRigth(obtain.getRigth());
		}return change;
	}
	
	//Delete RECURSIVE
	public boolean deleteRecursive(long n) {
		NodoABB[] nodos = {top, top};
		if(top.getAmount() != n) {
			nodos = deleteRecursive(nodos, n); 
		}
		
		if(nodos == null) {
			return false;
		}
		
		NodoABB father = nodos[0];
		NodoABB current = nodos[1];
		
		boolean turnLeft;
		
		if(father.getLeft() != null) {
			if(father.getLeft().getAmount() == current.getAmount()) 
				turnLeft = true;
			else 
				turnLeft = false;
		}else
			turnLeft = false;
		
		if(current.getLeft() == null && current.getRigth() == null) {
			
			if(current == top) {
				top = null;
			}else {
				if(turnLeft) {
					father.setLeft(null);
				}else {
					father.setRigth(null);
				}
			}
		}else {
			
			if(current.getRigth() == null) {
				
				if(current == top) {
					top = current.getLeft();
				}else {
					if(turnLeft) {
						father.setLeft(current.getLeft());
					}else {
						father.setRigth(current.getLeft());
					}
				}
			}else {
				if(current.getLeft()==null) {
					if(current == top) {
						top = current.getRigth();
					}else {
						if(turnLeft) {
							father.setLeft(current.getRigth());
						}else {
							father.setRigth(current.getRigth());
						}
					}
				}else {
					NodoABB change = getChangeRecursive(current, current, current.getRigth(), current);
					if(current == top) {
						top = change;
					}else {
						if(turnLeft) {
							father.setLeft(change);
						}else {
							father.setRigth(change);
						}
					}change.setLeft(current.getLeft());
				}
			}
		}return true;
	}
	
	private NodoABB getChangeRecursive(NodoABB changeFather, NodoABB change, NodoABB current, NodoABB replace) {
		changeFather = change;
		change = current;
		current = current.getLeft();
		
		if(current == null) {
			if(change!=replace.getRigth()) {
				changeFather.setLeft(change.getRigth());
				change.setRigth(replace.getRigth());
			}return replace;	
		}else {
			return getChangeRecursive(changeFather, change, current, replace);
		}
	}
	
	public NodoABB[] deleteRecursive(NodoABB[] nodos, long n) {
		NodoABB father = nodos[0];
		NodoABB current = nodos[1];
		
		father = current;
		if(n<current.getAmount()) {
			current = current.getLeft();
		}else {
			current = current.getRigth();
		}
		
		NodoABB [] rNodos = {father, current};
		
		if(current == null) {
			return null;
		}else {
			
			if(current.getAmount() == n) 
				return rNodos;
			else 
				return deleteRecursive(rNodos, n);
		}
	}
	
	public NodoABB getTop() {
		return top;
	}
}