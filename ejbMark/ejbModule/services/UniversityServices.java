package services;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import persistence.Mark;
import persistence.Module;
import persistence.Prof;
import persistence.Student;

/**
 * Session Bean implementation class UniversityServices
 */
@Stateless
public class UniversityServices implements UniversityServicesRemote {

	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public UniversityServices() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void addStudent(Student student) {
		entityManager.persist(student);

	}

	@Override
	public void addModule(Module module) {
		entityManager.persist(module);
	}

	@Override
	public void addProf(Prof prof) {
		entityManager.persist(prof);
	}

	@Override
	public void assignProfsToModule(List<Prof> profs, Module module) {
		module.linkProfsToModule(profs);
		entityManager.merge(module);

	}

	@Override
	public void createMark(Student student, Module module, Date dateOfExam,
			String type, int mark) {
		Mark mark1 = new Mark(type, mark, student, module, dateOfExam);
		entityManager.persist(mark1);

	}

	@Override
	public List<Student> findAllStudentByProf(Prof prof) {
		String jpql = "select stu from Mark mar ,Module mod  join mar.student stu join mar.module mod  where :pro member of mod.profs ";
		Query query = entityManager.createQuery(jpql);
		return query.getResultList();
	}

}
