package junitTests;

import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import persistence.Module;
import persistence.Prof;
import persistence.Student;
import services.UniversityServicesRemote;

public class UniversityJunitTests {
	private static Context context;
	private static UniversityServicesRemote proxy;

	@BeforeClass
	public static void setUp() throws NamingException {
		context = new InitialContext();
		proxy = (UniversityServicesRemote) context
				.lookup("ejb:/ejbMark/UniversityServices!services.UniversityServicesRemote");
	}

	@Test
	@Ignore
	public void testAddStudent() {
		Student student = new Student();
		student.setNameStudent("aymen");

		proxy.addStudent(student);

	}

	@Test
	@Ignore
	public void testAddModule() {
		Module module = new Module();
		module.setNameModule("jee");

		proxy.addModule(module);

	}

	@Test
	@Ignore
	public void testAddProf() {
		Prof prof = new Prof();
		prof.setNameProf("karim");

		proxy.addProf(prof);

	}

	@Test
	public void testAssignProfsToModule() {
		List<Prof> profs = new ArrayList<Prof>();
		
		Prof prof = new Prof();
		prof.setNameProf("karim");
		Prof prof2 = new Prof();
		prof2.setNameProf("daly");
		Prof prof3 = new Prof();
		prof3.setNameProf("zoubeier");

		profs.add(prof);
		profs.add(prof2);
		profs.add(prof3);

		Module module = new Module();
		module.setNameModule("jee");

		proxy.assignProfsToModule(profs, module);

	}

}
