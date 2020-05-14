package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class ABBCountryTest {
	
	private ABBCountry abbc;
	
	void setup1() {
		abbc = new ABBCountry();
	}
	
	void setup2() {
		abbc = new ABBCountry();
		
		abbc.addIterative(20);
		abbc.addIterative(40);
		abbc.addIterative(60);
		abbc.addIterative(80);
		abbc.addIterative(100);
		abbc.addIterative(120);
	}
	
	@Test
	void addIterativeTest() {
		setup1();
		abbc.addIterative(300);
		assertTrue(abbc.getTop().getAmount() == 300);
		
		abbc.addIterative(30);
		assertTrue(abbc.getTop().getAmount() == 300);
		assertTrue(abbc.getTop().getLeft().getAmount() == 30);
		assertTrue(abbc.getTop().getRigth() == null);
			
		setup1();
		abbc.addIterative(10);
		abbc.addIterative(1250);
		assertTrue(abbc.getTop().getAmount() == 10);
		assertTrue(abbc.getTop().getRigth().getAmount() == 1250);
		assertTrue(abbc.getTop().getLeft() == null);
	}
	
	@Test
	void addRecursiveTest() {
		setup1();
		abbc.addRecursive(300);
		assertTrue(abbc.getTop().getAmount() == 300);
		
		abbc.addRecursive(30);
		assertTrue(abbc.getTop().getAmount() == 300);
		assertTrue(abbc.getTop().getLeft().getAmount() == 30);
		assertTrue(abbc.getTop().getRigth() == null);
			
		setup1();
		abbc.addRecursive(10);
		abbc.addRecursive(1250);
		assertTrue(abbc.getTop().getAmount() == 10);
		assertTrue(abbc.getTop().getRigth().getAmount() == 1250);
		assertTrue(abbc.getTop().getLeft() == null);
	}
	
	@Test
	void searchIterativeTest() {
		setup2();
		boolean result;
		
		result =abbc.searchIterative(20);
		assertEquals(true, result);
		
		result =abbc.searchIterative(40);
		assertEquals(true, result);
		
		result =abbc.searchIterative(60);
		assertEquals(true, result);
		
		result =abbc.searchIterative(80);
		assertEquals(true, result);
		
		result =abbc.searchIterative(100);
		assertEquals(true, result);
		
		result =abbc.searchIterative(10);
		assertEquals(false, result);
	}
	
	@Test
	void searchRecursiveTest() {
		setup2();
		boolean result;
		
		result =abbc.searchRecursive(20);
		assertEquals(true, result);
		
		result =abbc.searchRecursive(40);
		assertEquals(true, result);
		
		result =abbc.searchRecursive(60);
		assertEquals(true, result);
		
		result =abbc.searchRecursive(80);
		assertEquals(true, result);
		
		result =abbc.searchRecursive(100);
		assertEquals(true, result);
		
		result =abbc.searchRecursive(10);
		assertEquals(false, result);
	}
	
	@Test
	void deleteIterativeTest() {
		setup2();
		boolean result;
		NodoABB current;
		
		assertEquals(20, abbc.getTop().getAmount());
		result =abbc.deleteIterative(20);
		assertEquals(true, result);
		assertEquals(40, abbc.getTop().getAmount());
		
		result = abbc.deleteIterative(40);
		current = abbc.getTop();
		while(current.getLeft() != null) {
			current = current.getLeft();
		}
		assertEquals(true, result);
		assertEquals(60, current.getAmount());
		
		result = abbc.deleteIterative(80);
		current = abbc.getTop();
		while(current.getLeft() != null) {
			current = current.getLeft();
		}
		assertEquals(true, result);
		assertEquals(60, current.getAmount());
		
		result = abbc.deleteIterative(10);
		assertEquals(false, result);
	}
	
	@Test
	void deleteRecursiveTest() {
		setup2();
		boolean result;
		NodoABB current;
		
		assertEquals(20, abbc.getTop().getAmount());
		result =abbc.deleteRecursive(20);
		assertEquals(true, result);
		assertEquals(40, abbc.getTop().getAmount());
		
		result = abbc.deleteRecursive(40);
		current = abbc.getTop();
		while(current.getLeft() != null) {
			current = current.getLeft();
		}
		assertEquals(true, result);
		assertEquals(60, current.getAmount());
		
		result = abbc.deleteRecursive(80);
		current = abbc.getTop();
		while(current.getLeft() != null) {
			current = current.getLeft();
		}
		assertEquals(true, result);
		assertEquals(60, current.getAmount());
		
		result = abbc.deleteRecursive(10);
		assertEquals(false, result);
	}
}
