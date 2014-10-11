package ua.edu.lp.sadiploma.tool;

public class SAConfig {
	private double INITIAL_TEMPERATURE;
	private double FINAL_TEMPERATURE;
	private double ALPHA;
	private int ITERATIONS_PER_TEMPERATURE;
	private double GAPS_KOEF;
	private double REP_KOEF;

	public SAConfig(double initialTemperature, double finalTemperature,
			double alpha, int iterationsAtTemperature, double gapsKoef,
			double repKoef) {
		super();
		INITIAL_TEMPERATURE = initialTemperature;
		FINAL_TEMPERATURE = finalTemperature;
		ALPHA = alpha;
		ITERATIONS_PER_TEMPERATURE = iterationsAtTemperature;
		GAPS_KOEF = gapsKoef;
		REP_KOEF = repKoef;
	}

	/**
	 * @return the iNITIAL_TEMPERATURE
	 */
	public double getInitialTemperature() {
		return INITIAL_TEMPERATURE;
	}

	/**
	 * @param initialTemperature
	 *            the iNITIAL_TEMPERATURE to set
	 */
	public void setInitialTemperature(double initialTemperature) {
		INITIAL_TEMPERATURE = initialTemperature;
	}

	/**
	 * @return the fINAL_TEMPERATURE
	 */
	public double getFinalTemperature() {
		return FINAL_TEMPERATURE;
	}

	/**
	 * @param finalTemperature
	 *            the fINAL_TEMPERATURE to set
	 */
	public void setFinalTemperature(double finalTemperature) {
		FINAL_TEMPERATURE = finalTemperature;
	}

	/**
	 * @return the aLPHA
	 */
	public double getAlpha() {
		return ALPHA;
	}

	/**
	 * @param alpha
	 *            the aLPHA to set
	 */
	public void setAlpha(double alpha) {
		ALPHA = alpha;
	}

	/**
	 * @return the iTERATIONS_AT_TEMPERATURE
	 */
	public int getIterationsAtTemperature() {
		return ITERATIONS_PER_TEMPERATURE;
	}

	/**
	 * @param iterationsAtTemperature
	 *            the iTERATIONS_AT_TEMPERATURE to set
	 */
	public void setIterationsAtTemperature(int iterationsAtTemperature) {
		ITERATIONS_PER_TEMPERATURE = iterationsAtTemperature;
	}

	/**
	 * @return the gAPS_KOEF
	 */
	public double getGapsKoef() {
		return GAPS_KOEF;
	}

	/**
	 * @param gapsKoef
	 *            the gAPS_KOEF to set
	 */
	public void setGapsKoef(double gapsKoef) {
		GAPS_KOEF = gapsKoef;
	}

	/**
	 * @return the rEP_KOEF
	 */
	public double getRepKoef() {
		return REP_KOEF;
	}

	/**
	 * @param repKoef
	 *            the rEP_KOEF to set
	 */
	public void setRepKoef(double repKoef) {
		REP_KOEF = repKoef;
	}

}
