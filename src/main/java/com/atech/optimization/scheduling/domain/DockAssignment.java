package com.atech.optimization.scheduling.domain;

//@PlanningEntity
public class DockAssignment {

	private Dock dock;
	private Vehicle vehicle;
	
	// Planning variables: changes during planning, between score calculations.
	private Period period;
	
	public Dock getDock() {
		return dock;
	}
	public void setDock(Dock dock) {
		this.dock = dock;
	}
	public Vehicle getVehicle() {
		return vehicle;
	}
	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
	public Period getPeriod() {
		return period;
	}
	public void setPeriod(Period period) {
		this.period = period;
	}
	
}
