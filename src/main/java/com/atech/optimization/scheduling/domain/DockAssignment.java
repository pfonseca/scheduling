package com.atech.optimization.scheduling.domain;

import org.optaplanner.core.api.domain.entity.PlanningEntity;
import org.optaplanner.core.api.domain.variable.PlanningVariable;

@PlanningEntity
public class DockAssignment {

	public DockAssignment(Long id) {
		this();
		this.id = id;
	}
	
	public DockAssignment() {
		super();
	}

	private Long id;
	private Dock dock;
	private Document document;

	private Period period;

	@PlanningVariable(valueRangeProviderRefs = { "dockRange" })
	public Dock getDock() {
		return dock;
	}

	public void setDock(Dock dock) {
		this.dock = dock;
	}

	@PlanningVariable(valueRangeProviderRefs = { "periodRange" })
	public Period getPeriod() {
		return period;
	}

	public void setPeriod(Period period) {
		this.period = period;
	}

	// ************************************************************************
	// Complex methods
	// ************************************************************************

	public int calculateOverlap(DockAssignment other) {

		if (period == null && other.getPeriod() != null) {
			return 0;
		}

		if(other.getDocument().getOperationType() != this.getDocument().getOperationType()) {
			
			int start = period.getStartingMinuteOfDay();
			int end = start + period.getLength();
			int otherStart = other.getPeriod().getStartingMinuteOfDay();
			int otherEnd = otherStart + other.getPeriod().getLength();
			
			if (end < otherStart) {
				return 0;
			} else if (otherEnd < start) {
				return 0;
			}
			return Math.min(end, otherEnd) - Math.max(start, otherStart);
			
		}
		
		return 0;
	}

	@PlanningVariable(valueRangeProviderRefs = { "documentRange" })
	public Document getDocument() {
		return document;
	}

	public void setDocument(Document document) {
		this.document = document;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

}
