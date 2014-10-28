package ua.edu.lp.sadiploma.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "OUTPUT_DATA")
public class OutputData {
	private Date startTime;
	private Date finishTime;
	private String resultNumbers;
	private Double solutionEnergy;
	private Long iterationsCount;
	private Integer combinationsCount;
	private Integer fitness;

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "ID")
	private Long id;

	@Column(name = "CREATED", insertable = false, nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	@DateTimeFormat(pattern = "dddd, dd MMMM yyyy	hh:mm tt")
	private Date created;

	@ManyToOne
	@JoinColumn(name = "INPUT_DATA_ID")
	private InputData inputData;

	public OutputData() {
	}

	public OutputData(InputData inputData) {
		this.inputData = inputData;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getFinishTime() {
		return finishTime;
	}

	public void setFinishTime(Date finishTime) {
		this.finishTime = finishTime;
	}

	public String getResultNumbers() {
		return resultNumbers;
	}

	public void setResultNumbers(String resultNumbers) {
		this.resultNumbers = resultNumbers;
	}

	/**
	 * @return the solutionEnergy
	 */
	public Double getSolutionEnergy() {
		return solutionEnergy;
	}

	/**
	 * @param solutionEnergy
	 *            the solutionEnergy to set
	 */
	public void setSolutionEnergy(Double solutionEnergy) {
		this.solutionEnergy = solutionEnergy;
	}

	public InputData getInputData() {
		return inputData;
	}

	public void setInputData(InputData inputData) {
		this.inputData = inputData;
	}

	/**
	 * @return the iterationsCount
	 */
	public Long getIterationsCount() {
		return iterationsCount;
	}

	/**
	 * @param iterations
	 *            the iterationsCount to set
	 */
	public void setIterationsCount(Long iterations) {
		this.iterationsCount = iterations;
	}

	/**
	 * @return the maxNumber
	 */
	public Integer getCombinationsCount() {
		return combinationsCount;
	}

	/**
	 * @param maxNumber the maxNumber to set
	 */
	public void setCombinationsCount(Integer maxNumber) {
		this.combinationsCount = maxNumber;
	}

	/**
	 * @return the fitness
	 */
	public Integer getFitness() {
		return fitness;
	}

	/**
	 * @param fitness the fitness to set
	 */
	public void setFitness(Integer fitness) {
		this.fitness = fitness;
	}
}
