package model;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class TimeKeeperManager {

	private final long PLUS = 2;
	
	private LocalTime time;
	
	public TimeKeeperManager() {
		time = LocalTime.of(0, 0, 0, 0);
	}
	
	public void increase() {
		time = time.plus(PLUS, ChronoUnit.MILLIS);
	}
	
	public String getTime() {
		int minute = time.getMinute();
		int second = time.getSecond();
		int millis = time.getNano()/1000000;
		
		String minuteReturn;
		String secondReturn;
		String millisReturn;
		
		if(minute<10) {
			minuteReturn = "0" + minute;
		}else {
			minuteReturn = "" + minute;
		}
		
		if(second<10) {
			secondReturn = "0" + second;
		}else {
			secondReturn = "" + second;
		}
		
		if(millis<100) {
			if(millis<10) 
				millisReturn = "00" + millis;
			else 
				millisReturn = "0" + millis;
		}else {
			millisReturn = "" + millis;
		}
		
		return minuteReturn + ":" + secondReturn + ":" + millisReturn;
	}
	
	public void reset() {
		time = LocalTime.of(0, 0, 0, 0);
	}
}
