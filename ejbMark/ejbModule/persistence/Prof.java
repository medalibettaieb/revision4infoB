package persistence;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Entity implementation class for Entity: Prof
 * 
 */
@Entity
public class Prof implements Serializable {

	private int idProf;
	private String nameProf;

	private Module module;
	private static final long serialVersionUID = 1L;

	public Prof() {
		super();
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getIdProf() {
		return this.idProf;
	}

	public void setIdProf(int idProf) {
		this.idProf = idProf;
	}

	public String getNameProf() {
		return this.nameProf;
	}

	public void setNameProf(String nameProf) {
		this.nameProf = nameProf;
	}

	@ManyToOne
	public Module getModule() {
		return module;
	}

	public void setModule(Module module) {
		this.module = module;
	}

}
