package com.atech.optimization.scheduling;

import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;
import org.optaplanner.core.api.solver.Solver;
import org.optaplanner.core.api.solver.SolverFactory;
import org.optaplanner.core.api.solver.event.BestSolutionChangedEvent;
import org.optaplanner.core.api.solver.event.SolverEventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.atech.optimization.scheduling.domain.DockAssignment;
import com.atech.optimization.scheduling.domain.DockScheduling;

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
		
		
		solver.addEventListener(new SolverEventListener<DockScheduling>() {
			@Override
			public void bestSolutionChanged(BestSolutionChangedEvent<DockScheduling> event) {
				HardSoftScore newBestScore = (HardSoftScore) event.getNewBestScore();
				System.out.println("Hard Score: " + newBestScore.getHardScore());
				System.out.println("Soft Score: " + newBestScore.getSoftScore());
			}
		});
		
		DockScheduling dockScheduling = solver.solve(unsolvedDockScheduling);

		dockScheduling.getDockAssignments().stream().sorted((dockScheduling1, dockScheduling2) -> {
			return (dockScheduling1.getPeriod().getStartingMinuteOfDay() > dockScheduling2.getPeriod().getStartingMinuteOfDay()? 1: -1);
		}).forEach(dockAssignment -> {
			System.out.println(dockAssignment.getPeriod());
			System.out.println("\t" + dockAssignment.getDocument().getId()+ " "+dockAssignment.getDocument().getOperationType());
		});

		System.out.println("Finished");
		System.out.println("Initial Score: " + dockScheduling.getScore().getInitScore());
		System.out.println("Hard Score: " + dockScheduling.getScore().getHardScore());
		System.out.println("Soft Score: " + dockScheduling.getScore().getSoftScore());
		
	}
}
