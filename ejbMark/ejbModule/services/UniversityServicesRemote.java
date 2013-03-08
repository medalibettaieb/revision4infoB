package services;

import java.util.Date;
import java.util.List;

import javax.ejb.Remote;

import persistence.Module;
import persistence.Prof;
import persistence.Student;

@Remote
public interface UniversityServicesRemote {

	void addStudent(Student student);

	void addModule(Module module);

	void addProf(Prof prof);

	void assignProfsToModule(List<Prof> profs, Module module);

	void createMark(Student student, Module module, Date dateOfExam, String type,int mark);

	List<Student> findAllStudentByProf(Prof prof);
}
