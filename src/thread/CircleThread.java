package thread;

import javafx.application.Platform;
import model.CircleManager;
import ui.AlgorithmsRaceGUI;

public class CircleThread extends Thread{

	private CircleManager c1;
	private CircleManager c2;
	private AlgorithmsRaceGUI guiOlympics;
	
	private boolean changeRadius;
	
	public CircleThread(CircleManager c1, CircleManager c2, AlgorithmsRaceGUI guiOlympics) {
		this.c1 = c1;
		this.c2 = c2;
		this.guiOlympics = guiOlympics;
		
		changeRadius = true;
	}
	
	public void run() {
		
		while(changeRadius) {
			c1.changeRadius();
			c2.changeRadius();
			
			try {
				CircleThread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			Platform.runLater(new Thread() {
				public void run() {
					guiOlympics.updateCircles();
				}
			});
		}
	}
	
	public void stopRun() {
		changeRadius = false;
	}
}
