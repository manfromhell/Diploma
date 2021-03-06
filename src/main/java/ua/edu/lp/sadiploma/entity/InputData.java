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
	private double initTemp;
	private int iterationsPerTemperature;
	private double alpha;
	private double gapsCoef;
	private double repCoef;
	private boolean done;
	private String treeType;
	private int numberOfNodes;
	private String comment;

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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "InputData [parentCode=" + parentCode + ", initTemp=" + initTemp
				+ ", iterationsPerTemperature=" + iterationsPerTemperature
				+ ", alpha=" + alpha + ", gapsCoef=" + gapsCoef + ", repCoef="
				+ repCoef + ", done=" + done + ", treeType=" + treeType
				+ ", numberOfNodes=" + numberOfNodes + ", comment=" + comment
				+ ", id=" + id + ", created=" + created + ", outputData="
				+ outputData + "]";
	}

	/**
	 * @return the done
	 */
	public boolean getDone() {
		return done;
	}

	/**
	 * @param done
	 *            the done to set
	 */
	public void setDone(boolean done) {
		this.done = done;
	}

	public int getNumberOfNodes() {
		return numberOfNodes;
	}

	public void setNumberOfNodes(int numberOfNodes) {
		this.numberOfNodes = numberOfNodes;
	}

	public String getTreeType() {
		return treeType;
	}

	public void setTreeType(String treeType) {
		this.treeType = treeType;
	}

	/**
	 * @return the comment
	 */
	public String getComment() {
		return comment;
	}

	/**
	 * @param comment the comment to set
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(alpha);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((comment == null) ? 0 : comment.hashCode());
		result = prime * result + ((created == null) ? 0 : created.hashCode());
		result = prime * result + (done ? 1231 : 1237);
		temp = Double.doubleToLongBits(gapsCoef);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		temp = Double.doubleToLongBits(initTemp);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + iterationsPerTemperature;
		result = prime * result + numberOfNodes;
		result = prime * result
				+ ((outputData == null) ? 0 : outputData.hashCode());
		result = prime * result
				+ ((parentCode == null) ? 0 : parentCode.hashCode());
		temp = Double.doubleToLongBits(repCoef);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result
				+ ((treeType == null) ? 0 : treeType.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof InputData)) {
			return false;
		}
		InputData other = (InputData) obj;
		if (Double.doubleToLongBits(alpha) != Double
				.doubleToLongBits(other.alpha)) {
			return false;
		}
		if (comment == null) {
			if (other.comment != null) {
				return false;
			}
		} else if (!comment.equals(other.comment)) {
			return false;
		}
		if (created == null) {
			if (other.created != null) {
				return false;
			}
		} else if (!created.equals(other.created)) {
			return false;
		}
		if (done != other.done) {
			return false;
		}
		if (Double.doubleToLongBits(gapsCoef) != Double
				.doubleToLongBits(other.gapsCoef)) {
			return false;
		}
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		if (Double.doubleToLongBits(initTemp) != Double
				.doubleToLongBits(other.initTemp)) {
			return false;
		}
		if (iterationsPerTemperature != other.iterationsPerTemperature) {
			return false;
		}
		if (numberOfNodes != other.numberOfNodes) {
			return false;
		}
		if (outputData == null) {
			if (other.outputData != null) {
				return false;
			}
		} else if (!outputData.equals(other.outputData)) {
			return false;
		}
		if (parentCode == null) {
			if (other.parentCode != null) {
				return false;
			}
		} else if (!parentCode.equals(other.parentCode)) {
			return false;
		}
		if (Double.doubleToLongBits(repCoef) != Double
				.doubleToLongBits(other.repCoef)) {
			return false;
		}
		if (treeType == null) {
			if (other.treeType != null) {
				return false;
			}
		} else if (!treeType.equals(other.treeType)) {
			return false;
		}
		return true;
	}

}
