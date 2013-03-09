package persistence;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Embeddable
public class MarkPk implements Serializable {

	private int idStud;
	private int idMod;
	private Date idDate;

	public MarkPk() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idDate == null) ? 0 : idDate.hashCode());
		result = prime * result + idMod;
		result = prime * result + idStud;
		return result;
	}

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

	public int getIdStud() {
		return idStud;
	}

	public void setIdStud(int idStud) {
		this.idStud = idStud;
	}

	public int getIdMod() {
		return idMod;
	}

	public void setIdMod(int idMod) {
		this.idMod = idMod;
	}

	@Temporal(TemporalType.TIMESTAMP)
	public Date getIdDate() {
		return idDate;
	}

	public void setIdDate(Date idDate) {
		this.idDate = idDate;
	}

	public MarkPk(int idStud, int idMod, Date dateOfExam) {
		super();
		this.idStud = idStud;
		this.idMod = idMod;
		this.idDate = dateOfExam;

	}

}
