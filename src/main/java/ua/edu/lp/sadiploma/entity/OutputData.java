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

	public OutputData() {

	}

	public OutputData(String resultNumbers) {
		this.resultNumbers = resultNumbers;
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

}
