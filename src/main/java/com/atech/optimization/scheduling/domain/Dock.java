package com.atech.optimization.scheduling.domain;

import java.util.List;

public class Dock {

	private String name;
	private List<Capacity> capacities;
	
	private List<OperationType> operationTypes;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Capacity> getCapacities() {
		return capacities;
	}

	public void setCapacities(List<Capacity> capacities) {
		this.capacities = capacities;
	}

	public List<OperationType> getOperationTypes() {
		return operationTypes;
	}

	public void setOperationTypes(List<OperationType> operationTypes) {
		this.operationTypes = operationTypes;
	}

}
