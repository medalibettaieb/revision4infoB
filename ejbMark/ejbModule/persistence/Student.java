package persistence;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * Entity implementation class for Entity: Student
 * 
 */
@Entity
public class Student implements Serializable {

	private int idStudent;
	private String nameStudent;

	private List<Mark> marks;
	private static final long serialVersionUID = 1L;

	public Student() {
		super();
	}

	@Id
	public int getIdStudent() {
		return this.idStudent;
	}

	public void setIdStudent(int idStudent) {
		this.idStudent = idStudent;
	}

	public String getNameStudent() {
		return this.nameStudent;
	}

	public void setNameStudent(String nameStudent) {
		this.nameStudent = nameStudent;
	}

	@OneToMany(mappedBy = "student")
	public List<Mark> getMarks() {
		return marks;
	}

	public void setMarks(List<Mark> marks) {
		this.marks = marks;
	}

}
