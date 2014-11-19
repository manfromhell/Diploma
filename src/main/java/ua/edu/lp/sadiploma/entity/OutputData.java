package ua.edu.lp.sadiploma.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@NamedQueries({
	@NamedQuery(name="OutputData.filter", 
			query="SELECT o FROM OutputData o JOIN o.inputData i "
					+ "WHERE ((i.numberOfNodes BETWEEN :numberOfNodesFrom AND :numberOfNodesTo) "
					+ "AND (o.startTime BETWEEN :startTimeFrom AND :startTimeTo)AND i.comment LIKE :comment "
					+ "AND (o.finishTime BETWEEN :finishTimeFrom AND :finishTimeTo))")
})
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "OutputData [startTime=" + startTime + ", finishTime="
				+ finishTime + ", resultNumbers=" + resultNumbers
				+ ", solutionEnergy=" + solutionEnergy + ", iterationsCount="
				+ iterationsCount + ", combinationsCount=" + combinationsCount
				+ ", fitness=" + fitness + ", id=" + id + ", created="
				+ created + "]";
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((combinationsCount == null) ? 0 : combinationsCount
						.hashCode());
		result = prime * result + ((created == null) ? 0 : created.hashCode());
		result = prime * result
				+ ((finishTime == null) ? 0 : finishTime.hashCode());
		result = prime * result + ((fitness == null) ? 0 : fitness.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((inputData == null) ? 0 : inputData.hashCode());
		result = prime * result
				+ ((iterationsCount == null) ? 0 : iterationsCount.hashCode());
		result = prime * result
				+ ((resultNumbers == null) ? 0 : resultNumbers.hashCode());
		result = prime * result
				+ ((solutionEnergy == null) ? 0 : solutionEnergy.hashCode());
		result = prime * result
				+ ((startTime == null) ? 0 : startTime.hashCode());
		return result;
	}

	/* (non-Javadoc)
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
		OutputData other = (OutputData) obj;
		if (combinationsCount == null) {
			if (other.combinationsCount != null)
				return false;
		} else if (!combinationsCount.equals(other.combinationsCount))
			return false;
		if (created == null) {
			if (other.created != null)
				return false;
		} else if (!created.equals(other.created))
			return false;
		if (finishTime == null) {
			if (other.finishTime != null)
				return false;
		} else if (!finishTime.equals(other.finishTime))
			return false;
		if (fitness == null) {
			if (other.fitness != null)
				return false;
		} else if (!fitness.equals(other.fitness))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (inputData == null) {
			if (other.inputData != null)
				return false;
		} else if (!inputData.equals(other.inputData))
			return false;
		if (iterationsCount == null) {
			if (other.iterationsCount != null)
				return false;
		} else if (!iterationsCount.equals(other.iterationsCount))
			return false;
		if (resultNumbers == null) {
			if (other.resultNumbers != null)
				return false;
		} else if (!resultNumbers.equals(other.resultNumbers))
			return false;
		if (solutionEnergy == null) {
			if (other.solutionEnergy != null)
				return false;
		} else if (!solutionEnergy.equals(other.solutionEnergy))
			return false;
		if (startTime == null) {
			if (other.startTime != null)
				return false;
		} else if (!startTime.equals(other.startTime))
			return false;
		return true;
	}
	
}
