package ua.edu.lp.sadiploma.tool;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import ua.edu.lp.sadiploma.entity.InputData;
import ua.edu.lp.sadiploma.entity.OutputData;
import ua.edu.lp.sadiploma.service.InputDataService;
import ua.edu.lp.sadiploma.service.OutputDataService;

@org.springframework.stereotype.Component
public class SimAnnealing implements Runnable {

	private static final Logger log = LoggerFactory
			.getLogger(SimAnnealing.class);

	private OutputDataService dataService;
	private SAConfig config;
	private Component component;
	// private static int TYPE;

	// private static BundleType bundleType;

	// private Solution workingSolution;
	private Solution currentSolution;
	private Solution bestSolution;
	private InputData inputData;

	private InputDataService inputDataService;

	@Autowired
	public SimAnnealing(OutputDataService dataService) {
		this.dataService = dataService;
	}

	public SimAnnealing(Component component, InputData inputData,
			InputDataService inputDataService, OutputDataService dataService,
			SAConfig config) {
		this.dataService = dataService;
		this.config = config;
		this.component = component;
		this.inputData = inputData;
		this.inputDataService = inputDataService;
	}

	@Override
	public void run() {
		log.info(dataService.findAll().toString());
		OutputData entity = new OutputData();
		entity.setInputData(inputData);
		entity.setStartTime(new Date(System.currentTimeMillis()));

		currentSolution = new Solution(component, config.getGapsKoef(),
				config.getRepKoef());
		bestSolution = new Solution(component, config.getGapsKoef(),
				config.getRepKoef());
		long iterations = 0;
		bestSolution.computeTargetFunction();
		double temperature = config.getInitialTemperature();
		while (temperature > config.getFinalTemperature()) {
			for (int i = 0; i < config.getIterationsAtTemperature(); i++) {
				iterations++;
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
				log.info("comb: "
						+ bestSolution.getBundle()
						+ " size "
						+ bestSolution.getBundle().generateCombinations()
								.size() + "new energy: "
						+ bestSolution.getSolutionEnergy());
			} else {
				currentSolution.setSolution(bestSolution);
			}
			temperature *= config.getAlpha();
		}
		// System.out.println("final temp: " + temperature);

		entity.setIterationsCount(iterations);
		entity.setFitness(bestSolution.getFitness());
		entity.setResultNumbers(bestSolution.getBundle().getData()
				.getAllValues().toString());
		entity.setFinishTime(new Date(System.currentTimeMillis()));
		entity.setCombinationsCount(bestSolution.getBundle()
				.generateCombinations().size());
		log.info("comb: " + bestSolution.getBundle().generateCombinations()
				+ " size "
				+ bestSolution.getBundle().generateCombinations().size());
		entity.setSolutionEnergy(bestSolution.getSolutionEnergy());
		dataService.create(entity);
		inputData.setDone(true);
		inputDataService.update(inputData);
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