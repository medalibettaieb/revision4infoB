package persistence;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

// TODO: Auto-generated Javadoc
/**
 * Entity implementation class for Entity: Student.
 */
@Entity
public class Student implements Serializable {

	/** The id student. */
	private int idStudent;

	/** The name student. */
	private String nameStudent;

	/** The marks. */
	private List<Mark> marks;

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new student.
	 */
	public Student() {
		super();
	}

	/**
	 * Gets the id student.
	 * 
	 * @return the id student
	 */
	@Id
	public int getIdStudent() {
		return this.idStudent;
	}

	/**
	 * Sets the id student.
	 * 
	 * @param idStudent
	 *            the new id student
	 */
	public void setIdStudent(int idStudent) {
		this.idStudent = idStudent;
	}

	/**
	 * Gets the name student.
	 * 
	 * @return the name student
	 */
	public String getNameStudent() {
		return this.nameStudent;
	}

	/**
	 * Sets the name student.
	 * 
	 * @param nameStudent
	 *            the new name student
	 */
	public void setNameStudent(String nameStudent) {
		this.nameStudent = nameStudent;
	}

	/**
	 * Gets the marks.
	 * 
	 * @return the marks
	 */
	@OneToMany(mappedBy = "student")
	public List<Mark> getMarks() {
		return marks;
	}

	/**
	 * Sets the marks.
	 * 
	 * @param marks
	 *            the new marks
	 */
	public void setMarks(List<Mark> marks) {
		this.marks = marks;
	}

}
