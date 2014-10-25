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
@Table(name = "CURRENT_RESULT")
public class CurrentResult {

	public CurrentResult() {
	}

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

	private Date startTime;
	private String resultNumbers;
	private Double solutionEnergy;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public InputData getInputData() {
		return inputData;
	}

	public void setInputData(InputData inputData) {
		this.inputData = inputData;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public String getResultNumbers() {
		return resultNumbers;
	}

	public void setResultNumbers(String resultNumbers) {
		this.resultNumbers = resultNumbers;
	}

	public Double getSolutionEnergy() {
		return solutionEnergy;
	}

	public void setSolutionEnergy(Double solutionEnergy) {
		this.solutionEnergy = solutionEnergy;
	}

}
