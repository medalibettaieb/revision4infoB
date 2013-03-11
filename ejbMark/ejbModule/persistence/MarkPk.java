package persistence;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

// TODO: Auto-generated Javadoc
/**
 * The Class MarkPk.
 */
@Embeddable
public class MarkPk implements Serializable {

	/** The id stud. */
	private int idStud;

	/** The id mod. */
	private int idMod;

	/** The id date. */
	private Date idDate;

	/**
	 * Instantiates a new mark pk.
	 */
	public MarkPk() {
		// TODO Auto-generated constructor stub
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
		result = prime * result + ((idDate == null) ? 0 : idDate.hashCode());
		result = prime * result + idMod;
		result = prime * result + idStud;
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
		MarkPk other = (MarkPk) obj;
		if (idDate == null) {
			if (other.idDate != null)
				return false;
		} else if (!idDate.equals(other.idDate))
			return false;
		if (idMod != other.idMod)
			return false;
		if (idStud != other.idStud)
			return false;
		return true;
	}

	/**
	 * Gets the id stud.
	 * 
	 * @return the id stud
	 */
	public int getIdStud() {
		return idStud;
	}

	/**
	 * Sets the id stud.
	 * 
	 * @param idStud
	 *            the new id stud
	 */
	public void setIdStud(int idStud) {
		this.idStud = idStud;
	}

	/**
	 * Gets the id mod.
	 * 
	 * @return the id mod
	 */
	public int getIdMod() {
		return idMod;
	}

	/**
	 * Sets the id mod.
	 * 
	 * @param idMod
	 *            the new id mod
	 */
	public void setIdMod(int idMod) {
		this.idMod = idMod;
	}

	/**
	 * Gets the id date.
	 * 
	 * @return the id date
	 */
	@Temporal(TemporalType.TIMESTAMP)
	public Date getIdDate() {
		return idDate;
	}

	/**
	 * Sets the id date.
	 * 
	 * @param idDate
	 *            the new id date
	 */
	public void setIdDate(Date idDate) {
		this.idDate = idDate;
	}

	/**
	 * Instantiates a new mark pk.
	 * 
	 * @param idStud
	 *            the id stud
	 * @param idMod
	 *            the id mod
	 * @param dateOfExam
	 *            the date of exam
	 */
	public MarkPk(int idStud, int idMod, Date dateOfExam) {
		super();
		this.idStud = idStud;
		this.idMod = idMod;
		this.idDate = dateOfExam;

	}

}
