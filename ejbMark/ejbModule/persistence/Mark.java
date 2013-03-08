package persistence;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Entity implementation class for Entity: Mark
 * 
 */
@Entity
public class Mark implements Serializable {

	private MarkPk markPk;
	private String type;
	private int mark;

	private Student student;
	private Module module;

	private static final long serialVersionUID = 1L;

	public Mark() {
		super();
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getMark() {
		return this.mark;
	}

	public void setMark(int mark) {
		this.mark = mark;
	}

	@EmbeddedId
	public MarkPk getMarkPk() {
		return markPk;
	}

	public void setMarkPk(MarkPk markPk) {
		this.markPk = markPk;
	}

	@ManyToOne
	@JoinColumn(name = "idStud", referencedColumnName = "idStudent", insertable = false, updatable = false)
	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	@ManyToOne
	@JoinColumn(name = "idMod", referencedColumnName = "idModule", insertable = false, updatable = false)
	public Module getModule() {
		return module;
	}

	public void setModule(Module module) {
		this.module = module;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Mark(String type, int mark, Student student, Module module,
			Date dateOfExam) {
		super();
		this.type = type;
		this.mark = mark;
		this.student = student;
		this.module = module;
		this.markPk = new MarkPk(student.getIdStudent(), module.getIdModule(),dateOfExam);
	}

}
