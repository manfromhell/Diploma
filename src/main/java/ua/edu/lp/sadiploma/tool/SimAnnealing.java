package ua.edu.lp.sadiploma.tool;

public class SimAnnealing implements Runnable {
	private SAConfig config;
	private Component component;
	// private static int TYPE;

	// private static BundleType bundleType;

	// private Solution workingSolution;
	private Solution currentSolution;
	private Solution bestSolution;

	public SimAnnealing(Component component, SAConfig config) {
		this.config = config;
		this.component = component;
	}

	@Override
	public void run() {
		currentSolution = new Solution(component, config.getGapsKoef(),
				config.getRepKoef());
		bestSolution = new Solution(component, config.getGapsKoef(),
				config.getRepKoef());
		bestSolution.computeTargetFunction();
		double temperature = config.getInitialTemperature();
		while (temperature > config.getFinalTemperature()) {
			for (int i = 0; i < config.getIterationsAtTemperature(); i++) {
				currentSolution.randomChange();
			}
			currentSolution.computeTargetFunction();
			if (currentSolution.getSolutionEnergy() < bestSolution
					.getSolutionEnergy()) {
				bestSolution.setSolution(currentSolution);
				bestSolution.computeTargetFunction();
				System.out.println("new best energy: "
						+ currentSolution.getSolutionEnergy());
			} else {
				currentSolution.setSolution(bestSolution);
			}
			temperature *= config.getAlpha();
		}
		System.out.println("final temp: "+temperature);
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