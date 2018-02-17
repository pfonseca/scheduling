
package com.atech.optimization.scheduling;

import java.util.ArrayList;
import java.util.List;

import com.atech.optimization.scheduling.domain.Capacity;
import com.atech.optimization.scheduling.domain.Dock;
import com.atech.optimization.scheduling.domain.DockAssignment;
import com.atech.optimization.scheduling.domain.DockScheduling;
import com.atech.optimization.scheduling.domain.Document;
import com.atech.optimization.scheduling.domain.OperationType;
import com.atech.optimization.scheduling.domain.Period;
import com.atech.optimization.scheduling.domain.Vehicle;
import com.atech.optimization.scheduling.domain.VehicleType;
import com.google.common.collect.Lists;

public class DockSchedulingGenerator {

	public DockScheduling getScheduling() {

		DockScheduling dockScheduling = new DockScheduling();

		// Add docks
		addDocks(dockScheduling);

		// Setting vehicles
		setVehicle(dockScheduling);

		dockScheduling.getDockAssignments().add(new DockAssignment(1L));
		dockScheduling.getDockAssignments().add(new DockAssignment(2L));
		dockScheduling.getDockAssignments().add(new DockAssignment(3L));

		dockScheduling.getDocuments().addAll(getDocuments(dockScheduling.getVehicle()));

		// Adding periods
		addPeriods(dockScheduling);

		return dockScheduling;
	}

	private List<Document> getDocuments(Vehicle vehicle) {
		List<Document> documents = new ArrayList<>();
		
		documents.add(new Document("DOCUMENT-1", OperationType.DELIVERY, vehicle));
		documents.add(new Document("DOCUMENT-2", OperationType.PICKUP, vehicle));
		documents.add(new Document("DOCUMENT-3", OperationType.DELIVERY, vehicle));
		
		return documents;
	}

	private void addPeriods(DockScheduling dockScheduling) {

		Dock dockA = dockScheduling.getDocks().get(0);
		Dock dockB = dockScheduling.getDocks().get(1);

		for (int i = 0; i < 8; i++) {
			dockScheduling.getPeriods().add(new Period(dockA, 10, 700 - i * 30, 30));
		}
		
		for (int i = 0; i < 8; i++) {
			dockScheduling.getPeriods().add(new Period(dockB, 10, 700 - i * 30, 30));
		}

	}

	private void setVehicle(DockScheduling dockScheduling) {
		Vehicle vehicle = new Vehicle();
		vehicle.setId(1L);
		vehicle.setVehicleType(VehicleType.TRUCK);

		dockScheduling.setVehicle(vehicle);
	}

	private void addDocks(DockScheduling dockScheduling) {

		Dock dockA = new Dock(1L, "Dock A",
				Lists.newArrayList(new Capacity(VehicleType.CAR, 5), new Capacity(VehicleType.TRUCK, 2)),
				Lists.newArrayList(OperationType.DELIVERY));

		Dock dockB = new Dock(2L, "Dock B",
				Lists.newArrayList(new Capacity(VehicleType.CAR, 2), new Capacity(VehicleType.TRUCK, 2)),
				Lists.newArrayList(OperationType.PICKUP, OperationType.DELIVERY));

		dockScheduling.getDocks().add(dockA);
		dockScheduling.getDocks().add(dockB);

	}

}
