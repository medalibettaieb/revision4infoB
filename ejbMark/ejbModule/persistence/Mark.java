package persistence;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

// TODO: Auto-generated Javadoc
/**
 * Entity implementation class for Entity: Mark.
 */
@Entity
public class Mark implements Serializable {

	/** The mark pk. */
	private MarkPk markPk;

	/** The type. */
	private String type;

	/** The mark. */
	private int mark;

	/** The student. */
	private Student student;

	/** The module. */
	private Module module;

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new mark.
	 */
	public Mark() {
		super();
	}

	/**
	 * Gets the type.
	 * 
	 * @return the type
	 */
	public String getType() {
		return this.type;
	}

	/**
	 * Sets the type.
	 * 
	 * @param type
	 *            the new type
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * Gets the mark.
	 * 
	 * @return the mark
	 */
	public int getMark() {
		return this.mark;
	}

	/**
	 * Sets the mark.
	 * 
	 * @param mark
	 *            the new mark
	 */
	public void setMark(int mark) {
		this.mark = mark;
	}

	/**
	 * Gets the mark pk.
	 * 
	 * @return the mark pk
	 */
	@EmbeddedId
	public MarkPk getMarkPk() {
		return markPk;
	}

	/**
	 * Sets the mark pk.
	 * 
	 * @param markPk
	 *            the new mark pk
	 */
	public void setMarkPk(MarkPk markPk) {
		this.markPk = markPk;
	}

	/**
	 * Gets the student.
	 * 
	 * @return the student
	 */
	@ManyToOne
	@JoinColumn(name = "idStud", referencedColumnName = "idStudent", insertable = false, updatable = false)
	public Student getStudent() {
		return student;
	}

	/**
	 * Sets the student.
	 * 
	 * @param student
	 *            the new student
	 */
	public void setStudent(Student student) {
		this.student = student;
	}

	/**
	 * Gets the module.
	 * 
	 * @return the module
	 */
	@ManyToOne
	@JoinColumn(name = "idMod", referencedColumnName = "idModule", insertable = false, updatable = false)
	public Module getModule() {
		return module;
	}

	/**
	 * Sets the module.
	 * 
	 * @param module
	 *            the new module
	 */
	public void setModule(Module module) {
		this.module = module;
	}

	/**
	 * Gets the serialversionuid.
	 * 
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * Instantiates a new mark.
	 * 
	 * @param type
	 *            the type
	 * @param mark
	 *            the mark
	 * @param student
	 *            the student
	 * @param module
	 *            the module
	 * @param dateOfExam
	 *            the date of exam
	 */
	public Mark(String type, int mark, Student student, Module module,
			Date dateOfExam) {
		super();
		this.type = type;
		this.mark = mark;
		this.student = student;
		this.module = module;
		this.markPk = new MarkPk(student.getIdStudent(), module.getIdModule(),
				dateOfExam);
	}

}
