package thread;

import javafx.application.Platform;
import model.TimeKeeperManager;
import ui.AlgorithmsRaceGUI;

public class TimeKeeperThread extends Thread{

	private AlgorithmsRaceGUI guiOlympics;
	private TimeKeeperManager timeKeeper;
	
	private boolean available;

	public TimeKeeperThread(AlgorithmsRaceGUI guiOlympics, TimeKeeperManager timeKeeper) {
		this.guiOlympics = guiOlympics;
		this.timeKeeper = timeKeeper;
		
		available = true;
	}
	
	public void run() {
		while(available) {
			try {
				TimeKeeperThread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			timeKeeper.increase();
			
			Platform.runLater(new Thread() {
				public void run() {
					guiOlympics.updateTimeKeeper();
				}
			});
		}
	}
	
	public void stopRun() {
		available = false;
	}
	
}
