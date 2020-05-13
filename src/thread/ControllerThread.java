package thread;

import java.io.IOException;

import javafx.application.Platform;
import model.CircleManager;
import model.ProgressManager;
import model.TimeKeeperManager;
import ui.AlgorithmsRaceGUI;

public class ControllerThread extends Thread{

	public static final String METHOD_ADD = "ADD";
	public static final String METHOD_SEARCH = "SEARCH";
	public static final String METHOD_DELETE = "DELETE";
	
	public static final int ADD_SEED = 50;
	
	private AlgorithmsRaceGUI guiOlympics;
	private ProgressManager progressBarArrayList;
    private ProgressManager progressBarLinkedList;
    private ProgressManager progressBarAbb;
    private ProgressManager progressIndiArrayList;
    private ProgressManager progressIndiLinkedList;
    private ProgressManager progressIndiAbb;
    private CircleManager c1;
	private CircleManager c2;
	private TimeKeeperManager timeKeeperManager;
	
	private String method;
	private boolean iterative;
	private long n;
	
	

	public ControllerThread(AlgorithmsRaceGUI guiOlympics, ProgressManager progressBarArrayList,
			ProgressManager progressBarLinkedList, ProgressManager progressBarAbb,
			ProgressManager progressIndiArrayList, ProgressManager progressIndiLinkedList,
			ProgressManager progressIndiAbb, CircleManager c1, CircleManager c2,TimeKeeperManager timeKeeperManager,
			String method, boolean iterative, long n) {
		
		this.guiOlympics = guiOlympics;
		this.progressBarArrayList = progressBarArrayList;
		this.progressBarLinkedList = progressBarLinkedList;
		this.progressBarAbb = progressBarAbb;
		this.progressIndiArrayList = progressIndiArrayList;
		this.progressIndiLinkedList = progressIndiLinkedList;
		this.progressIndiAbb = progressIndiAbb;
		this.c1 = c1;
		this.c2 = c2;
		this.timeKeeperManager = timeKeeperManager;
		this.method = method;
		this.iterative = iterative;
		this.n = n;
	}



	public void run() {
		ArrayListThread arrayListThread = new ArrayListThread(method, iterative, n, guiOlympics, progressBarArrayList, progressIndiArrayList);
		LinkedListThread linkedListThread = new LinkedListThread(method, iterative, n, guiOlympics, progressBarLinkedList, progressIndiLinkedList);
		ABBThread abbThread = new ABBThread();
		
		if(method.equals(METHOD_SEARCH) || method.equals(METHOD_DELETE)) {
			AddCasesThread addCasses = new AddCasesThread(arrayListThread, linkedListThread, abbThread);
			Platform.runLater(new Thread() {
				public void run() {
					try {
						guiOlympics.openWaitStage();
					} catch (IOException e) {
						e.printStackTrace();
					} 
				}
			});
			
			addCasses.start();
			try {
				addCasses.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			Platform.runLater(new Thread() {
				public void run() {
					guiOlympics.closeWaitStage();
				}
			});
		}
		
		CircleThread circleThread = new CircleThread(c1, c2, guiOlympics);
		TimeKeeperThread timeKeeperThread = new TimeKeeperThread(guiOlympics, timeKeeperManager);
		
		arrayListThread.start();
		linkedListThread.start();
		//abbThread.start();
		timeKeeperThread.start();
		circleThread.start();
		
		try {
			arrayListThread.join();
			linkedListThread.join();
			//abbThread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		circleThread.stopRun();
		timeKeeperThread.stopRun();
	}
}
