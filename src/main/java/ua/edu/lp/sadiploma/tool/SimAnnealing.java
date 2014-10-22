package ua.edu.lp.sadiploma.tool;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import ua.edu.lp.sadiploma.entity.OutputData;
import ua.edu.lp.sadiploma.service.OutputDataService;

@org.springframework.stereotype.Component
public class SimAnnealing implements Runnable {

	private OutputDataService dataService;
	private SAConfig config;
	private Component component;
	// private static int TYPE;

	// private static BundleType bundleType;

	// private Solution workingSolution;
	private Solution currentSolution;
	private Solution bestSolution;

	
	@Autowired
	public SimAnnealing(OutputDataService dataService) {
		this.dataService = dataService;
	}
	
	
	public SimAnnealing(Component component, OutputDataService dataService, SAConfig config) {
		this.dataService = dataService;
		this.config = config;
		this.component = component;
	}

	@Override
	public void run() {
		System.out.println(dataService.findAll());
		OutputData entity = new OutputData();
		entity.setStartTime(new Date());
		
		currentSolution = new Solution(component, config.getGapsKoef(),
				config.getRepKoef());
		bestSolution = new Solution(component, config.getGapsKoef(),
				config.getRepKoef());
		bestSolution.computeTargetFunction();
		double temperature = config.getInitialTemperature();
		while (temperature > config.getFinalTemperature()) {
			for (int i = 0; i < config.getIterationsAtTemperature(); i++) {
				if (i % 2 == 0) {
					currentSolution.mutation();
				} else {
					currentSolution.randomChange();
				}
			}
			currentSolution.computeTargetFunction();
			if (currentSolution.getSolutionEnergy() < bestSolution
					.getSolutionEnergy()) {
				bestSolution.setSolution(currentSolution);
				bestSolution.computeTargetFunction();
			} else {
				currentSolution.setSolution(bestSolution);
			}
			temperature *= config.getAlpha();
		}
//		System.out.println("final temp: " + temperature);

		entity.setResultNumbers(bestSolution.getBundle().getData().getAllValues().toString());
		entity.setFinishTime(new Date());
		entity.setSolutionEnergy(bestSolution.getSolutionEnergy());
		dataService.create(entity);
	}

	
	
	
	
	
	/**
	 * @return the bestSolution
	 */
	public Solution getBestSolution() {
		return bestSolution;
	}

	/**
	 * @param bestSolution
	 *            the bestSolution to set
	 */
	public void setBestSolution(Solution bestSolution) {
		this.bestSolution = bestSolution;
	}

}