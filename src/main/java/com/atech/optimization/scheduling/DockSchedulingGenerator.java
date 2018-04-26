
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

		dockScheduling.getDocuments().addAll(getDocuments(dockScheduling.getVehicle()));

		for(int i = 0; i < dockScheduling.getDocuments().size() ; i++) {
			dockScheduling.getDockAssignments().add(new DockAssignment(i + 1L));
		}
		
		// Adding periods
		addPeriods(dockScheduling);

		return dockScheduling;
	}

	private List<Document> getDocuments(Vehicle vehicle) {
		List<Document> documents = new ArrayList<>();
		
		documents.add(new Document("DOCUMENT-1", OperationType.DELIVERY, vehicle));
		documents.add(new Document("DOCUMENT-2", OperationType.PICKUP, vehicle));
		documents.add(new Document("DOCUMENT-3", OperationType.DELIVERY, vehicle));
		documents.add(new Document("DOCUMENT-4", OperationType.PICKUP, vehicle));
		documents.add(new Document("DOCUMENT-5", OperationType.PICKUP, vehicle));
		documents.add(new Document("DOCUMENT-6", OperationType.DELIVERY, vehicle));
		documents.add(new Document("DOCUMENT-7", OperationType.DELIVERY, vehicle));
		documents.add(new Document("DOCUMENT-8", OperationType.DELIVERY, vehicle));
		documents.add(new Document("DOCUMENT-9", OperationType.DELIVERY, vehicle));
		documents.add(new Document("DOCUMENT-10", OperationType.DELIVERY, vehicle));
		documents.add(new Document("DOCUMENT-11", OperationType.DELIVERY, vehicle));
		documents.add(new Document("DOCUMENT-12", OperationType.DELIVERY, vehicle));
		documents.add(new Document("DOCUMENT-13", OperationType.DELIVERY, vehicle));
		documents.add(new Document("DOCUMENT-14", OperationType.DELIVERY, vehicle));
		documents.add(new Document("DOCUMENT-15", OperationType.PICKUP, vehicle));
		documents.add(new Document("DOCUMENT-16", OperationType.PICKUP, vehicle));
		
		return documents;
	}

	private void addPeriods(DockScheduling dockScheduling) {

		for (Dock dock : dockScheduling.getDocks()) {
			for (int i = 0; i < 8; i++) {
				dockScheduling.getPeriods().add(new Period(dock, 10, 700 - i * 30, 30));
			}
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
				Lists.newArrayList(new Capacity(VehicleType.CAR, 5), new Capacity(VehicleType.TRUCK, 0)),
				Lists.newArrayList(OperationType.DELIVERY, OperationType.PICKUP));

		Dock dockB = new Dock(2L, "Dock B",
				Lists.newArrayList(new Capacity(VehicleType.CAR, 2), new Capacity(VehicleType.TRUCK, 1)),
				Lists.newArrayList(OperationType.PICKUP));
		
		Dock dockC = new Dock(3L, "Dock C",
				Lists.newArrayList(new Capacity(VehicleType.CAR, 2), new Capacity(VehicleType.TRUCK, 4)),
				Lists.newArrayList(OperationType.DELIVERY));
		
		dockScheduling.getDocks().add(dockA);
		dockScheduling.getDocks().add(dockB);
		dockScheduling.getDocks().add(dockC);
		
	}

}
