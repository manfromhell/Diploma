package ua.edu.lp.sadiploma.tool;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class Solution {
	private double GAPS_KOEF;
	private double REP_KOEF;
	// private static BundleType bundleType = BundleType.RingBundle;

	private double solutionEnergy = 0.0;
	private Bundle bundle = null;

	public Solution(Component component) {
		/*
		 * switch (BundleType.getType(bundleType)) { case 1: bundle = new
		 * LineBundle(new int[n]); break; default: bundle = new RingBundle(new
		 * int[n]); }
		 */
		bundle = new TreeBundle(component);
		this.solutionEnergy = computeTargetFunction();
		GAPS_KOEF = 1;
		REP_KOEF = 1;
	}

	public Solution(Component component, double gapsKoef, double repKoef) {
		/*
		 * switch (BundleType.getType(bundleType)) { case 1: bundle = new
		 * LineBundle(new int[n]); break; default: bundle = new RingBundle(new
		 * int[n]); }
		 */
		bundle = new TreeBundle(component);
		this.solutionEnergy = Double.MAX_VALUE;
		GAPS_KOEF = gapsKoef;
		REP_KOEF = repKoef;
	}

	@Override
	public String toString() {
		return bundle.toString();
	}

	public void setSolution(Solution that) {
		this.bundle = new TreeBundle(that.bundle.getComponent());
		this.solutionEnergy = that.solutionEnergy;
		return;
	}

	public double getSolutionEnergy() {
		return this.solutionEnergy;
	}

	/**
	 * Get two different random numbers and change them
	 */
	public void randomChange() {

		Bundle tmpBundle = null;
		do {
			int x = new Random().nextInt(this.bundle.getDataLength()) + 1;
			int y = getExclusiveRandomNumber(this.bundle.getDataLength(), x);
			tmpBundle = new TreeBundle(bundle.getComponent());
			int randomValue = new Random().nextInt(tmpBundle.getDataSum() / 2);
			randomValue = (tmpBundle.getData(x).getValue() > tmpBundle.getData(
					y).getValue()) ? randomValue : -randomValue;
			tmpBundle.setData(x, this.bundle.getData(x).getValue()
					- randomValue);
			tmpBundle.setData(y, this.bundle.getData(y).getValue()
					+ randomValue);

		} while ((tmpBundle.hasNegatives()) || (!tmpBundle.hasOnes()));
		this.bundle = (Bundle) tmpBundle.clone();

		return;
	}

	public void mutation() {

		Bundle tmpBundle = null;
		do {
			int x = new Random().nextInt(this.bundle.getDataLength()) + 1;
			tmpBundle = new TreeBundle(bundle.getComponent());
			int randomValue = new Random().nextInt(tmpBundle.getDataSum())
					- (tmpBundle.getDataSum() / 2) + 1;
			tmpBundle.setData(x, this.bundle.getData(x).getValue()
					- randomValue);
		} while ((tmpBundle.hasNegatives()) || (!tmpBundle.hasOnes()));
		this.bundle = tmpBundle.clone();

		return;
	}

	private static int getExclusiveRandomNumber(final int high, final int except) {
		int getRand = 1;
		do {
			getRand = new Random().nextInt(high - 1) + 1;
		} while (getRand == except);
		return getRand;
	}

	public double computeTargetFunction() {
		int gaps = 0;
		int repeats = 0;

		List<Integer> allNumbers = bundle.generateCombinations();

		// System.out.println(allNumbers);
		sortList(allNumbers);
		// System.out.println("Sorted sums: \t"+allNumbers);

		// counting gaps
		int max = allNumbers.get(allNumbers.size() - 1);
		// System.out.println(max);
		for (int i = 1; i < max; i++) {
			if (!(allNumbers.contains(i))) {
				// System.out.println("gap " + i);
				gaps++;
			}
			// counting repeats
			int count = 0;
			for (int j : allNumbers) {
				if (i == j) {
					// System.out.println("repeat " + i);
					count++;
				}
			}
			if (count > 1) {
				repeats += count - 1;
			}
		}

		// System.out.println("gaps " + gaps + " repeats " + repeats
		// + " max number " + allNumbers.get(allNumbers.size() - 1));
		this.solutionEnergy = gaps * GAPS_KOEF + repeats * REP_KOEF; // Complete
		return this.solutionEnergy;
	}

	public int getFitness() {
		return this.REP_KOEF == 1 ? getFitnessL() : getFitnessG();
	}

	private Integer getFitnessG() {
		return Collections.max(bundle.generateCombinations());
	}

	private int getFitnessL() {
		Set<Integer> list = new HashSet<Integer>(bundle.generateCombinations());
		for (int i = 1; i < list.size() ; i++) {
			if (!list.contains(i)) {
				return i-1;
			}
		}
		return list.size();
	}

	private static void sortList(List<Integer> list) {
		int[] tmpArray = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			tmpArray[i] = list.get(i);
		}
		Arrays.sort(tmpArray);
		list.clear();
		for (int i : tmpArray) {
			list.add(i);
		}
	}

	/**
	 * @return the bundle
	 */
	public Bundle getBundle() {
		return bundle;
	}

	/**
	 * @param bundle
	 *            the bundle to set
	 */
	public void setBundle(Bundle bundle) {
		this.bundle = bundle;
	}

	/**
	 * @return the gAPS_KOEF
	 */
	public double getGAPS_KOEF() {
		return GAPS_KOEF;
	}

	/**
	 * @param gAPS_KOEF
	 *            the gAPS_KOEF to set
	 */
	public void setGAPS_KOEF(double gAPS_KOEF) {
		GAPS_KOEF = gAPS_KOEF;
	}

	/**
	 * @return the rEP_KOEF
	 */
	public double getREP_KOEF() {
		return REP_KOEF;
	}

	/**
	 * @param rEP_KOEF
	 *            the rEP_KOEF to set
	 */
	public void setREP_KOEF(double rEP_KOEF) {
		REP_KOEF = rEP_KOEF;
	}

}