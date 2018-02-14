package com.atech.optimization.scheduling.domain;

public class Period {

	public Period(Dock dock, int dayOfYear, int startingMinuteOfDay, int length) {
		super();
		this.dock = dock;
		this.dayOfYear = dayOfYear;
		this.startingMinuteOfDay = startingMinuteOfDay;
		this.length = length;
	}
	
	public Period() {
		
	}
	
	private Dock dock;
	
	private int dayOfYear;
	private int startingMinuteOfDay;
	private int length; // in minutes
	
	
	public Dock getDock() {
		return dock;
	}
	public void setDock(Dock dock) {
		this.dock = dock;
	}
	public int getDayOfYear() {
		return dayOfYear;
	}
	public void setDayOfYear(int dayOfYear) {
		this.dayOfYear = dayOfYear;
	}
	public int getStartingMinuteOfDay() {
		return startingMinuteOfDay;
	}
	public void setStartingMinuteOfDay(int startingMinuteOfDay) {
		this.startingMinuteOfDay = startingMinuteOfDay;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	
	public String toString() {
		return String.format("Dock: %s\tDay: %s\tStarting: %d", this.dock.getName(), dayOfYear, startingMinuteOfDay);
	}
}
