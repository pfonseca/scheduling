package com.atech.optimization.scheduling;

import org.optaplanner.core.api.solver.Solver;
import org.optaplanner.core.api.solver.SolverFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.atech.optimization.scheduling.domain.Dock;
import com.atech.optimization.scheduling.domain.DockAssignment;
import com.atech.optimization.scheduling.domain.DockScheduling;
import com.google.common.collect.Lists;

//@SpringBootApplication
public class SchedulingApplication {

	private static final Logger logger = LoggerFactory.getLogger(SchedulingApplication.class);

	public static void main(String[] args) {
		// SpringApplication.run(SchedulingApplication.class, args);

		logger.info("Your application started with option names : {}", args);

		// Build the Solver
		SolverFactory<DockScheduling> solverFactory = SolverFactory.createFromXmlResource("schedulingSolverConfig.xml");
		Solver<DockScheduling> solver = solverFactory.buildSolver();

		// Solve the problem
		DockScheduling unsolvedDockScheduling = new DockSchedulingGenerator().getScheduling();
		
		DockScheduling dockScheduling = solver.solve(unsolvedDockScheduling);

		for (DockAssignment dockAssignment : dockScheduling.getDockAssignments()) {
			System.out.println(dockAssignment.getPeriod());
			System.out.println("\t" + dockAssignment.getDocument().getId());
		}

		System.out.println("Finished");
		System.out.println("Initial Score: " + dockScheduling.getScore().getInitScore());
		System.out.println("Hard Score: " + dockScheduling.getScore().getHardScore());
		System.out.println("Soft Score: " + dockScheduling.getScore().getSoftScore());
		
	}
}
