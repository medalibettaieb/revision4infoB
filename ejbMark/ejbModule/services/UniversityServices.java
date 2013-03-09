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

	@Override
	public void deleteStudent(int idStudent) {
		entityManager.remove(entityManager.find(Student.class, idStudent));

	}

	@Override
	public void deleteProf(int idProf) {
		entityManager.remove(entityManager.find(Prof.class, idProf));

	}

	@Override
	public void deleteModule(int idModule) {
		entityManager.remove(entityManager.find(Module.class, idModule));

	}

	@Override
	public List<Prof> findAllProfByStudent(Student student) {
		String jpql = "select p from Prof p join p.module mod join mod.marks mark where mark.student =:s";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("s", student);
		return query.getResultList();
	}

	/* (non-Javadoc)
	 * @see services.UniversityServicesRemote#findstudentById(int)
	 */
	@Override
	public Student findstudentById(int idStudent) {

		return entityManager.find(Student.class, idStudent);
	}

}
