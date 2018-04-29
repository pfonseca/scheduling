package com.atech.optimization.scheduling.domain;

import java.util.List;

import org.optaplanner.core.api.domain.solution.PlanningEntityCollectionProperty;
import org.optaplanner.core.api.domain.solution.PlanningScore;
import org.optaplanner.core.api.domain.solution.PlanningSolution;
import org.optaplanner.core.api.domain.solution.drools.ProblemFactCollectionProperty;
import org.optaplanner.core.api.domain.solution.drools.ProblemFactProperty;
import org.optaplanner.core.api.domain.valuerange.ValueRangeProvider;
import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;

import com.google.common.collect.Lists;

@PlanningSolution
public class DockScheduling {

	private Vehicle vehicle;
	private List<Dock> docks;
	private List<Document> documents;
	
	private List<Period> periods;
	
	private List<DockAssignment> dockAssignments;
	
	private HardSoftScore score;
	
	@ValueRangeProvider(id = "dockRange")
	@ProblemFactCollectionProperty
	public List<Dock> getDocks() {
		if(docks == null)
			docks = Lists.newArrayList();
		return docks;
	}
	
	public void sortDocks() {
		
		docks.sort((dock1, dock2) -> {
			
			boolean dock1HasDelivery = dock1.getOperationTypes().contains(OperationType.DELIVERY);
			boolean dock2HasDelivery = dock2.getOperationTypes().contains(OperationType.DELIVERY);
			
			if(dock1HasDelivery && dock2HasDelivery) {
				boolean dock1HasPickup = dock1.getOperationTypes().contains(OperationType.PICKUP);
				boolean dock2HasPickup = dock2.getOperationTypes().contains(OperationType.PICKUP);
				
				if(dock1HasPickup)
					return -1;
				
				if(dock2HasPickup)
					return 1;
				
				return 0;
			}
			
			if(dock1HasDelivery) {
				return -1;
			}
			
			if(dock2HasDelivery)
				return 1;
			
			return 0;
		});
		
	}

	public void setDocks(List<Dock> docks) {
		this.docks = docks;
	}

	@ProblemFactCollectionProperty
	@ValueRangeProvider(id = "documentRange")
	public List<Document> getDocuments() {
		if(documents == null)
			documents = Lists.newArrayList();
		
		return documents;
	}

	public void setDocuments(List<Document> documents) {
		this.documents = documents;
	}

	@PlanningEntityCollectionProperty
	public List<DockAssignment> getDockAssignments() {
		if(dockAssignments == null)
			dockAssignments = Lists.newArrayList();
		return dockAssignments;
	}

	public void setDockAssignments(List<DockAssignment> dockAssignments) {
		this.dockAssignments = dockAssignments;
	}

	@ValueRangeProvider(id = "periodRange")
	@ProblemFactCollectionProperty
	public List<Period> getPeriods() {
		if(periods == null)
			periods = Lists.newArrayList();
		return periods;
	}

	public void setPeriods(List<Period> periods) {
		this.periods = periods;
	}
	
	@PlanningScore
	public HardSoftScore getScore() {
		return score;
	}
	
	public void setScore(HardSoftScore score) {
		this.score = score;
	}

	@ProblemFactProperty
	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

}
