package ua.edu.lp.sadiploma.tool;

import java.util.Random;

public class SimAnnealing extends Thread {
	private SAConfig config;
	private Component component;
	// private static int TYPE;

	// private static BundleType bundleType;

	private Solution currentSolution;
	private Solution workingSolution;
	private Solution bestSolution;

	public SimAnnealing(Component component, SAConfig config) {
		this.config = config;
		this.component = component;
	}

	@Override
	public void run() {
		boolean useNew = false;
		currentSolution = new Solution(component, config
				.getGapsKoef(), config.getRepKoef());

		workingSolution = new Solution(component, config
				.getGapsKoef(), config.getRepKoef());

		bestSolution = new Solution(component, config.getGapsKoef(),
				config.getRepKoef());

		currentSolution.computeTargetFunction();

		bestSolution.setSolution(currentSolution);
		workingSolution.setSolution(currentSolution);

		double temperature = config.getInitialTemperature();
		while (temperature > config.getFinalTemperature()) {
			for (int i = 0; i < config.getIterationsAtTemperature(); i++) {
				useNew = false;
				workingSolution.randomChange();
				workingSolution.computeTargetFunction();

				if (workingSolution.getSolutionEnergy() <= currentSolution
						.getSolutionEnergy()) {
					useNew = true;
				} else {
					double test = new Random().nextDouble(); // Get random value
																// between 0.0
																// and 1.0
					double delta = workingSolution.getSolutionEnergy()
							- currentSolution.getSolutionEnergy();
					double calc = Math.exp(-delta / temperature);
					if (calc > test) {
						useNew = true;
					}
				}

				if (useNew) {
					useNew = false;
					currentSolution.setSolution(workingSolution);
					if (currentSolution.getSolutionEnergy() < bestSolution
							.getSolutionEnergy()) {
						bestSolution.setSolution(currentSolution);
						// System.out.println(bestSolution + "\t\t" +
						// bestSolution.getSolutionEnergy() +"\t\t"+
						// temperature);

					}
				} else {
					workingSolution.setSolution(currentSolution);
				}

				if (bestSolution.getSolutionEnergy() == 0) {
					System.out.print(bestSolution + "\t energy: "
							+ bestSolution.getSolutionEnergy());
				}
			}
			temperature *= config.getAlpha();
		}

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
