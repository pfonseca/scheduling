package com.atech.optimization.scheduling.domain;

public class Capacity {

	public Capacity(VehicleType vehicleType, int size) {
		super();
		this.vehicleType = vehicleType;
		this.size = size;
	}
	
	public Capacity() {
		
	}
	
	private VehicleType vehicleType;
	private int size;
	
	public VehicleType getVehicleType() {
		return vehicleType;
	}
	public void setVehicleType(VehicleType vehicleType) {
		this.vehicleType = vehicleType;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
}
