package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LinkedListCountryTest {

	private LinkedListCountry llc;
	
	void setup1() {
		llc = new LinkedListCountry();
	}
	
	void setup2() {
		llc = new LinkedListCountry();
		llc.addIterative(1);
		llc.addIterative(2);
		llc.addIterative(3);
		llc.addIterative(4);
	}
	
	void setup3() {
		llc = new LinkedListCountry();
		llc.addIterative(1);
		llc.addIterative(2);
		llc.addIterative(3);
		llc.addIterative(4);
		llc.addIterative(5);
	}
	
	void setup4() {
		llc = new LinkedListCountry();
		llc.addIterative(1);
	}
	
	@Test
	void addIterativeTest() {
		
		setup1();
		
		NodoLE n = llc.getCabeza();
		assertEquals(null, n);
		
		llc.addIterative(1);
		llc.addIterative(2);
		llc.addIterative(3);
		llc.addIterative(4);
		
		n = llc.getCabeza();
		assertEquals(1, n.getAmount());
		assertEquals(null, n.getPrevious());
		assertEquals(2, n.getNext().getAmount());
		
		n = n.getNext();
		assertEquals(2, n.getAmount());
		assertEquals(1, n.getPrevious().getAmount());
		assertEquals(3, n.getNext().getAmount());
		
		n = n.getNext();
		assertEquals(3, n.getAmount());
		assertEquals(2, n.getPrevious().getAmount());
		assertEquals(4, n.getNext().getAmount());
		
		n = n.getNext();
		assertEquals(4, n.getAmount());
		assertEquals(3, n.getPrevious().getAmount());
		assertEquals(null, n.getNext());
	}
	
	@Test
	void addRecursiveTest() {
		setup1();
		
		NodoLE n = llc.getCabeza();
		assertEquals(null, n);
		
		llc.addRecursive(1);
		llc.addRecursive(2);
		llc.addRecursive(3);
		llc.addRecursive(4);
		
		n = llc.getCabeza();
		assertEquals(1, n.getAmount());
		assertEquals(null, n.getPrevious());
		assertEquals(2, n.getNext().getAmount());
		
		n = n.getNext();
		assertEquals(2, n.getAmount());
		assertEquals(1, n.getPrevious().getAmount());
		assertEquals(3, n.getNext().getAmount());
		
		n = n.getNext();
		assertEquals(3, n.getAmount());
		assertEquals(2, n.getPrevious().getAmount());
		assertEquals(4, n.getNext().getAmount());
		
		n = n.getNext();
		assertEquals(4, n.getAmount());
		assertEquals(3, n.getPrevious().getAmount());
		assertEquals(null, n.getNext());
	}
	
	@Test
	void searchIterativeTest() {
		setup1();
		boolean result;
		result = llc.searchIterative(1);
		assertEquals(false, result);
		
		setup2();
		result = llc.searchIterative(1);
		assertEquals(true, result);
		
		result = llc.searchIterative(2);
		assertEquals(true, result);
		
		result = llc.searchIterative(3);
		assertEquals(true, result);
		
		result = llc.searchIterative(4);
		assertEquals(true, result);
		
		result = llc.searchIterative(5);
		assertEquals(false, result);
		
		result = llc.searchIterative(0);
		assertEquals(false, result);
	}
	
	@Test
	void searchRecursiveTest() {
		setup1();
		boolean result;
		result = llc.searchRecursive(1);
		assertEquals(false, result);
		
		setup2();
		result = llc.searchRecursive(1);
		assertEquals(true, result);
		
		result = llc.searchRecursive(2);
		assertEquals(true, result);
		
		result = llc.searchRecursive(3);
		assertEquals(true, result);
		
		result = llc.searchRecursive(4);
		assertEquals(true, result);
		
		result = llc.searchRecursive(5);
		assertEquals(false, result);
		
		result = llc.searchRecursive(0);
		assertEquals(false, result);
	}
	
	@Test
	void deleteIterativeTest() {
		setup4();
		boolean result;
		result = llc.deleteIterative(1);
		assertEquals(true, result);
		assertEquals(null, llc.getCabeza());
		
		setup3();
		result = llc.deleteIterative(1);
		assertEquals(true, result);
		
		NodoLE aux = llc.getCabeza();
		assertEquals(2, aux.getAmount());
		assertEquals(null, aux.getPrevious());
		assertEquals(3, aux.getNext().getAmount());
		
		aux = aux.getNext();
		assertEquals(3, aux.getAmount());
		assertEquals(2, aux.getPrevious().getAmount());
		assertEquals(4, aux.getNext().getAmount());
		
		aux = aux.getNext();
		assertEquals(4, aux.getAmount());
		assertEquals(3, aux.getPrevious().getAmount());
		assertEquals(5, aux.getNext().getAmount());
		
		aux = aux.getNext();
		assertEquals(5, aux.getAmount());
		assertEquals(4, aux.getPrevious().getAmount());
		assertEquals(null, aux.getNext());
		
		result = llc.deleteIterative(5);
		assertEquals(true, result);
		
		aux = llc.getCabeza();
		assertEquals(2, aux.getAmount());
		assertEquals(null, aux.getPrevious());
		assertEquals(3, aux.getNext().getAmount());
		
		aux = aux.getNext();
		assertEquals(3, aux.getAmount());
		assertEquals(2, aux.getPrevious().getAmount());
		assertEquals(4, aux.getNext().getAmount());
		
		aux = aux.getNext();
		assertEquals(4, aux.getAmount());
		assertEquals(3, aux.getPrevious().getAmount());
		assertEquals(null, aux.getNext());
		
		result = llc.deleteIterative(3);
		assertEquals(true, result);
		aux = llc.getCabeza();
		assertEquals(2, aux.getAmount());
		assertEquals(null, aux.getPrevious());
		assertEquals(4, aux.getNext().getAmount());

		aux = aux.getNext();
		assertEquals(4, aux.getAmount());
		assertEquals(2, aux.getPrevious().getAmount());
		assertEquals(null, aux.getNext());
	}
	
	@Test
	void deleteRecursiveTest() {
		setup4();
		boolean result;
		result = llc.deleteRecursive(1);
		assertEquals(true, result);
		assertEquals(null, llc.getCabeza());
		
		setup3();
		result = llc.deleteRecursive(1);
		assertEquals(true, result);
		
		NodoLE aux = llc.getCabeza();
		assertEquals(2, aux.getAmount());
		assertEquals(null, aux.getPrevious());
		assertEquals(3, aux.getNext().getAmount());
		
		aux = aux.getNext();
		assertEquals(3, aux.getAmount());
		assertEquals(2, aux.getPrevious().getAmount());
		assertEquals(4, aux.getNext().getAmount());
		
		aux = aux.getNext();
		assertEquals(4, aux.getAmount());
		assertEquals(3, aux.getPrevious().getAmount());
		assertEquals(5, aux.getNext().getAmount());
		
		aux = aux.getNext();
		assertEquals(5, aux.getAmount());
		assertEquals(4, aux.getPrevious().getAmount());
		assertEquals(null, aux.getNext());
		
		result = llc.deleteRecursive(5);
		assertEquals(true, result);
		
		aux = llc.getCabeza();
		assertEquals(2, aux.getAmount());
		assertEquals(null, aux.getPrevious());
		assertEquals(3, aux.getNext().getAmount());
		
		aux = aux.getNext();
		assertEquals(3, aux.getAmount());
		assertEquals(2, aux.getPrevious().getAmount());
		assertEquals(4, aux.getNext().getAmount());
		
		aux = aux.getNext();
		assertEquals(4, aux.getAmount());
		assertEquals(3, aux.getPrevious().getAmount());
		assertEquals(null, aux.getNext());
		
		result = llc.deleteRecursive(3);
		assertEquals(true, result);
		aux = llc.getCabeza();
		assertEquals(2, aux.getAmount());
		assertEquals(null, aux.getPrevious());
		assertEquals(4, aux.getNext().getAmount());

		aux = aux.getNext();
		assertEquals(4, aux.getAmount());
		assertEquals(2, aux.getPrevious().getAmount());
		assertEquals(null, aux.getNext());
	}
}
