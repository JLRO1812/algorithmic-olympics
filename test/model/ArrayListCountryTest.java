package model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

public class ArrayListCountryTest {
	ArrayListCountry alc;
	
	void setup1() {
		alc = new ArrayListCountry();
		Long n = (long)1;
		alc.add(n);
		
		n = (long)2;
		alc.add(n);
		
		n = (long)3;
		alc.add(n);
		
		n = (long)4;
		alc.add(n);
		
		n = (long)5;
		alc.add(n);
	}
	
	@Test
	void searchIterativeTest() {
		setup1();
		boolean result;
		result = alc.searchIterative(1);
		assertEquals(true, result);
		
		result = alc.searchIterative(2);
		assertEquals(true, result);
		
		result = alc.searchIterative(3);
		assertEquals(true, result);
		
		result = alc.searchIterative(4);
		assertEquals(true, result);
		
		result = alc.searchIterative(5);
		assertEquals(true, result);
		
		result = alc.searchIterative(0);
		assertEquals(false, result);
	}
	
	@Test
	void searchRecursiveTest() {
		setup1();
		boolean result;
		result = alc.searchRecursive(1);
		assertEquals(true, result);
		
		result = alc.searchRecursive(2);
		assertEquals(true, result);
		
		result = alc.searchRecursive(3);
		assertEquals(true, result);
		
		result = alc.searchRecursive(4);
		assertEquals(true, result);
		
		result = alc.searchRecursive(5);
		assertEquals(true, result);
		
		result = alc.searchRecursive(0);
		assertEquals(false, result);
	}
	
	@Test
	void deleteIterativeTest() {
		setup1();
		boolean result;
		result = alc.deleteIterative(1);
		assertEquals(true, result);
		assertEquals(2, alc.getArrayList().get(0));
		
		result = alc.deleteIterative(5);
		assertEquals(true, result);
		ArrayList<Long> aux = alc.getArrayList();
		assertEquals(4, aux.get(aux.size()-1));
		
		result = alc.deleteIterative(3);
		assertEquals(true, result);
		aux = alc.getArrayList();
		assertEquals(4, aux.get(1));
		
		result = alc.deleteIterative(0);
		assertEquals(false, result);
	}
	
	@Test
	void deleteRecursiveTest() {
		setup1();
		boolean result;
		result = alc.deleteRecursive(1);
		assertEquals(true, result);
		assertEquals(2, alc.getArrayList().get(0));
		
		result = alc.deleteRecursive(5);
		assertEquals(true, result);
		ArrayList<Long> aux = alc.getArrayList();
		assertEquals(4, aux.get(aux.size()-1));
		
		result = alc.deleteRecursive(3);
		assertEquals(true, result);
		aux = alc.getArrayList();
		assertEquals(4, aux.get(1));
		
		result = alc.deleteRecursive(0);
		assertEquals(false, result);
	}
}
