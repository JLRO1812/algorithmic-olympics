package model;

import java.util.ArrayList;

public class ArrayListCountry {

	private ArrayList<Long> arrayList;
	
	public ArrayListCountry() {
		arrayList = new ArrayList<Long>();
	}
	
	public void add(Long n) {
		arrayList.add(n);
	}
	
	//Search ITERATIVE
	public boolean searchIterative(long n) {
		
		for(int i = 0; i<arrayList.size(); i++) {
			if(arrayList.get(i).longValue() == n) {
				return true;
			}
		}
		
		return false;
	}
	
	//Search RECURSIVE
	public boolean searchRecursive(long n) {
		return searchRecursive(0, n);
	}
	
	private boolean searchRecursive(int i, long n) {
		if(i<arrayList.size()) {
			if(arrayList.get(i).longValue() == n) {
				return true;
			}else {
				i++;
				return searchRecursive(i, n);
			}
		}else {
			return false;
		}
	}
	
	//Delete ITERATIVE
	public boolean deleteIterative(long n) {
		
		for (int i = 0; i < arrayList.size(); i++) {
			if(arrayList.get(i).longValue() == n) {
				arrayList.remove(i);
				return true;
			}
		}
		
		return false;
	}
	
	//Delete RECURSIVE
	public boolean deleteRecursive(long n) {
		return deleteRecursive(0, n);
	}

	private boolean deleteRecursive(int i, long n) {
		if(i<arrayList.size()) {
			if(arrayList.get(i).longValue() == n) {
				arrayList.remove(i);
				return true;
			}else {
				i++;
				return deleteRecursive(i, n);
			}
		}else {
			return false;
		}
	}
	
	public ArrayList<Long> getArrayList(){
		return arrayList;
	}
}
