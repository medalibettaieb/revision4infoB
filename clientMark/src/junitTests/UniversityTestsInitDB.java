package junitTests;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import persistence.Module;
import persistence.Prof;
import persistence.Student;
import services.UniversityServicesRemote;

public class UniversityTestsInitDB {
	private static Context context;
	private static UniversityServicesRemote proxy;

	/**
	 * The main method.
	 * 
	 * @param args
	 *            the arguments
	 * @throws NamingException
	 *             the naming exception
	 */
	public static void main(String[] args) throws NamingException {
		context = new InitialContext();
		proxy = (UniversityServicesRemote) context
				.lookup("ejb:/ejbMark/UniversityServices!services.UniversityServicesRemote");

		Student student = new Student();
		student.setIdStudent(1);
		student.setNameStudent("aymen");

		proxy.addStudent(student);

		Module module = new Module();
		module.setIdModule(1);
		module.setNameModule("jee");

		proxy.addModule(module);

		Prof prof = new Prof();
		prof.setNameProf("karim");
		Prof prof2 = new Prof();
		prof2.setNameProf("daly");
		Prof prof3 = new Prof();
		prof3.setNameProf("zoubeier");

		List<Prof> profs = new ArrayList<Prof>();
		profs.add(prof);
		profs.add(prof2);
		profs.add(prof3);

		proxy.assignProfsToModule(profs, module);

		proxy.createMark(student, module, new Date(), "ds", 12);
	}
}
