package thread;

import java.util.Random;

import javafx.application.Platform;
import model.LinkedListCountry;
import model.ProgressManager;
import ui.AlgorithmsRaceGUI;

public class LinkedListThread extends Thread{
	private String method;
	private boolean iterative;
	private long n;
	private double index;

	private LinkedListCountry linkedListCountry;
	private ProgressManager progressBar;
	private ProgressManager progressIndi;
	private AlgorithmsRaceGUI guiOlympics;
	
	
	public LinkedListThread(String method, boolean iterative, long n,AlgorithmsRaceGUI guiOlympics, ProgressManager progressBar, ProgressManager progressIndi) {
		this.method = method;
		this.iterative = iterative;
		this.n = n;
		this.progressBar = progressBar;
		this.progressIndi = progressIndi;
		this.guiOlympics = guiOlympics;
		
		linkedListCountry = new LinkedListCountry();
		index = n/100;
	}

	public void run() {
		if(method.equals(ControllerThread.METHOD_ADD)) {
			if(iterative) {
				addIterative();
				updateTime();
			}else {
				addRecursive();
				updateTime();
			}
		}else if(method.equals(ControllerThread.METHOD_DELETE)) {
			if(iterative) {
				deleteIterative();
				updateTime();
			}else {
				deleteRecursive();
				updateTime();
			}
		}else if(method.equals(ControllerThread.METHOD_SEARCH)) {
			if(iterative) {
				searchIterative();
				updateTime();
			}else {
				searchRecursive();
				updateTime();
			}
		}
	}
	
	public void add() {
		Random r = new Random(ControllerThread.ADD_SEED);
		
		for(int i = 0; i<n; i++) {
			linkedListCountry.addIterative(r.nextLong());
		}
	}
	
	public void addIterative() {
		Random r = new Random(ControllerThread.ADD_SEED);
		int j = 0;
		for(int i = 0; i<n; i++) {
			linkedListCountry.addIterative(r.nextLong());
			if(j==index) {
				j=0;
				updateProgress(i);
			}
			j++;
		}
		updateProgress((int)n);
	}
	
	public void addRecursive() {
		Random r = new Random(ControllerThread.ADD_SEED);
		int j = 0;
		for(int i = 0; i<n; i++) {
			linkedListCountry.addRecursive(r.nextLong());
			if(j==index) {
				j=0;
				updateProgress(i);
			}
			j++;
		}
		updateProgress((int)n);
	}
	
	public void deleteIterative() {
		Random r = new Random(ControllerThread.ADD_SEED);
		int j = 0;
		for(int i = 0; i<n; i++) {
			linkedListCountry.deleteIterative(r.nextLong());
			if(j==index) {
				j=0;
				updateProgress(i);
			}
			j++;
		}
		updateProgress((int)n);
	}
	
	public void deleteRecursive() {
		Random r = new Random(ControllerThread.ADD_SEED);
		int j = 0;
		for(int i = 0; i<n; i++) {
			linkedListCountry.deleteRecursive(r.nextLong());
			if(j==index) {
				j=0;
				updateProgress(i);
			}
			j++;
		}
		updateProgress((int)n);
	}
	
	public void searchIterative() {
		Random r = new Random(ControllerThread.ADD_SEED);
		int j = 0;
		for(int i = 0; i<n; i++) {
			linkedListCountry.searchIterative(r.nextLong());
			if(j==index) {
				j=0;
				updateProgress(i);
			}
			j++;
		}
		updateProgress((int)n);
	}
	
	public void searchRecursive() {
		Random r = new Random(ControllerThread.ADD_SEED);
		int j = 0;
		for(int i = 0; i<n; i++) {
			linkedListCountry.searchRecursive(r.nextLong());
			if(j==index) {
				j=0;
				updateProgress(i);
			}
			j++;
		}
		updateProgress((int)n);
	}
	
	private void updateProgress(int i) {
		progressBar.increase();
		progressIndi.increase();
		
		Platform.runLater(new Thread() {
			public void run() {
				guiOlympics.updateProgressBar();
				guiOlympics.updateProgressIndi();
				guiOlympics.updateOperationsLabelLinkedList("" + i);
			}
		});
	}
	
	private void updateTime() {
		Platform.runLater(new Thread() {
			public void run() {
				guiOlympics.updateTimeLinkedListLabel();
			}
		});
	}
}
