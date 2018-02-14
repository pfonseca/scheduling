package com.atech.optimization.scheduling.domain;

import java.util.List;

public class Dock {

	public Dock(Long id, String name, List<Capacity> capacities, List<OperationType> operationTypes) {
		this();
		this.id = id;
		this.name = name;
		this.capacities = capacities;
		this.operationTypes = operationTypes;
	}
	
	public Dock() {
		super();
	}

	private Long id;
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public boolean isDocumentSupported(Document document) {
		if(document == null)
			return true;
		
		return this.operationTypes.contains(document.getOperationType()); 
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Dock other = (Dock) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
