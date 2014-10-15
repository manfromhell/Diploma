package ua.edu.lp.sadiploma.tool;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

	public static void main(String[] args) {
		Component component = Node.generateTree("0,1,2,3,4,5,6");
		System.out.println(component);
		Solution solution = new Solution(component, 1.0, 100.0);
		solution.computeTargetFunction();
		System.out.println(solution.getSolutionEnergy());

		Bundle bundle = new TreeBundle(component);
		List<Integer> allCombinations = bundle.generateCombinations();
		System.out.println(allCombinations);

		SimAnnealing simAnnealing = new SimAnnealing(component, new SAConfig(
				100, 5, 0.99, 10, 1.0, 100.0));
		ExecutorService executor = Executors.newFixedThreadPool(2);
		executor.execute(simAnnealing);
		executor.shutdown();
		try {
			executor.awaitTermination(10, TimeUnit.SECONDS);
			System.out.println("best:" + simAnnealing.getBestSolution()
					+ "\nwith energy "
					+ simAnnealing.getBestSolution().getSolutionEnergy());
			allCombinations = simAnnealing.getBestSolution().getBundle()
					.generateCombinations();
			System.out.println(allCombinations);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}