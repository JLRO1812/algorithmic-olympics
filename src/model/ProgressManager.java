package model;

public class ProgressManager {

	public final double MAX = 1;
	
	private double progress;
	
	public ProgressManager() {
		progress = 0;
	}
	
	public void increase() {
		if(progress<MAX)
			progress += 0.01;
	}

	public double getProgress() {
		return progress;
	}

	public void reset() {
		progress = 0;
	}
}
