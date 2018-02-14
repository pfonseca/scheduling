package com.atech.optimization.scheduling.domain;

import java.util.List;

import com.google.common.collect.Lists;

public class Vehicle {

	private Long id;
	
	private VehicleType vehicleType;
	private List<Document> documents;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public VehicleType getVehicleType() {
		return vehicleType;
	}
	public void setVehicleType(VehicleType vehicleType) {
		this.vehicleType = vehicleType;
	}
	public List<Document> getDocuments() {
		if(documents == null)
			documents = Lists.newArrayList();
		
		return documents;
	}
	public void setDocuments(List<Document> documents) {
		this.documents = documents;
	}
	
}
