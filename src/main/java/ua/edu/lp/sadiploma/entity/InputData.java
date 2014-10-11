package ua.edu.lp.sadiploma.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "INPUT_DATA")
public class InputData {

	private String parentCode;
	private String marks;
	private int numberOfMarks;
	private double initTemp;
	private double finalTemp;
	private int iterationsPerTemperature;
	private double alpha;
	private double gapsCoef;
	private double repCoef;
	private long timeForComputing;
	private long timeForOutputCurrentRes;

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "ID")
	private Long id;

	@Column(name = "CREATED", insertable = false, nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	@DateTimeFormat(pattern = "dddd, dd MMMM yyyy	hh:mm tt")
	private Date created;

	/**
	 * @return the iterationsPerTemperature
	 */
	public int getIterationsPerTemperature() {
		return iterationsPerTemperature;
	}

	/**
	 * @param iterationsPerTemperature
	 *            the iterationsPerTemperature to set
	 */
	public void setIterationsPerTemperature(int iterationsPerTemperature) {
		this.iterationsPerTemperature = iterationsPerTemperature;
	}

	public InputData() {

	}

	@OneToMany(mappedBy = "inputData", orphanRemoval = true)
	private List<OutputData> outputData = new ArrayList<OutputData>();

	/**
	 * @return the parentCode
	 */
	public String getParentCode() {
		return parentCode;
	}

	/**
	 * @param parentCode
	 *            the parentCode to set
	 */
	public void setParentCode(String parentCode) {
		this.parentCode = parentCode;
	}

	/**
	 * @return the numbers
	 */
	public String getNumbers() {
		return marks;
	}

	/**
	 * @param numbers
	 *            the numbers to set
	 */
	public void setNumbers(String numbers) {
		this.marks = numbers;
	}

	/**
	 * @return the initTemp
	 */
	public double getInitTemp() {
		return initTemp;
	}

	/**
	 * @param initTemp
	 *            the initTemp to set
	 */
	public void setInitTemp(double initTemp) {
		this.initTemp = initTemp;
	}

	/**
	 * @return the finalTemp
	 */
	public double getFinalTemp() {
		return finalTemp;
	}

	/**
	 * @param finalTemp
	 *            the finalTemp to set
	 */
	public void setFinalTemp(double finalTemp) {
		this.finalTemp = finalTemp;
	}

	/**
	 * @return the tempIter
	 */
	public int getTempIter() {
		return iterationsPerTemperature;
	}

	/**
	 * @param tempIter
	 *            the tempIter to set
	 */
	public void setTempIter(int tempIter) {
		this.iterationsPerTemperature = tempIter;
	}

	/**
	 * @return the timeForComputing
	 */
	public long getTimeForComputing() {
		return timeForComputing;
	}

	/**
	 * @param timeForComputing
	 *            the timeForComputing to set
	 */
	public void setTimeForComputing(long timeForComputing) {
		this.timeForComputing = timeForComputing;
	}

	/**
	 * @return the timeForOutputCurrentRes
	 */
	public long getTimeForOutputCurrentRes() {
		return timeForOutputCurrentRes;
	}

	/**
	 * @param timeForOutputCurrentRes
	 *            the timeForOutputCurrentRes to set
	 */
	public void setTimeForOutputCurrentRes(long timeForOutputCurrentRes) {
		this.timeForOutputCurrentRes = timeForOutputCurrentRes;
	}

	public double getAlpha() {
		return alpha;
	}

	public void setAlpha(double alpha) {
		this.alpha = alpha;
	}

	public double getGapsCoef() {
		return gapsCoef;
	}

	public void setGapsCoef(double gapsCoef) {
		this.gapsCoef = gapsCoef;
	}

	public double getRepCoef() {
		return repCoef;
	}

	public void setRepCoef(double repCoef) {
		this.repCoef = repCoef;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "InputData [parentCode=" + parentCode + ", numbers=" + marks
				+ ", initTemp=" + initTemp + ", finalTemp=" + finalTemp
				+ ", iterationsPerTemperature=" + iterationsPerTemperature
				+ ", alpha=" + alpha + ", gapsCoef=" + gapsCoef + ", repCoef="
				+ repCoef + ", timeForComputing=" + timeForComputing
				+ ", timeForOutputCurrentRes=" + timeForOutputCurrentRes
				+ ", id=" + id + ", created=" + created + ", outputData="
				+ outputData + "]";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(alpha);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((created == null) ? 0 : created.hashCode());
		temp = Double.doubleToLongBits(finalTemp);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(gapsCoef);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		temp = Double.doubleToLongBits(initTemp);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + iterationsPerTemperature;
		result = prime * result + ((marks == null) ? 0 : marks.hashCode());
		result = prime * result
				+ ((outputData == null) ? 0 : outputData.hashCode());
		result = prime * result
				+ ((parentCode == null) ? 0 : parentCode.hashCode());
		temp = Double.doubleToLongBits(repCoef);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result
				+ (int) (timeForComputing ^ (timeForComputing >>> 32));
		result = prime
				* result
				+ (int) (timeForOutputCurrentRes ^ (timeForOutputCurrentRes >>> 32));
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		InputData other = (InputData) obj;
		if (Double.doubleToLongBits(alpha) != Double
				.doubleToLongBits(other.alpha))
			return false;
		if (created == null) {
			if (other.created != null)
				return false;
		} else if (!created.equals(other.created))
			return false;
		if (Double.doubleToLongBits(finalTemp) != Double
				.doubleToLongBits(other.finalTemp))
			return false;
		if (Double.doubleToLongBits(gapsCoef) != Double
				.doubleToLongBits(other.gapsCoef))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (Double.doubleToLongBits(initTemp) != Double
				.doubleToLongBits(other.initTemp))
			return false;
		if (iterationsPerTemperature != other.iterationsPerTemperature)
			return false;
		if (marks == null) {
			if (other.marks != null)
				return false;
		} else if (!marks.equals(other.marks))
			return false;
		if (outputData == null) {
			if (other.outputData != null)
				return false;
		} else if (!outputData.equals(other.outputData))
			return false;
		if (parentCode == null) {
			if (other.parentCode != null)
				return false;
		} else if (!parentCode.equals(other.parentCode))
			return false;
		if (Double.doubleToLongBits(repCoef) != Double
				.doubleToLongBits(other.repCoef))
			return false;
		if (timeForComputing != other.timeForComputing)
			return false;
		if (timeForOutputCurrentRes != other.timeForOutputCurrentRes)
			return false;
		return true;
	}

	public int getNumberOfMarks() {
		return numberOfMarks;
	}

	public void setNumberOfMarks(int numberOfMarks) {
		this.numberOfMarks = numberOfMarks;
	}

	/**
	 * @return the marks
	 */
	public String getMarks() {
		return marks;
	}

	/**
	 * @param marks
	 *            the marks to set
	 */
	public void setMarks(String marks) {
		this.marks = marks;
	}

}
