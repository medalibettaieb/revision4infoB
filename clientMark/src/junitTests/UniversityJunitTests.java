package junitTests;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import junit.framework.Assert;

import org.junit.Before;
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

	@Before
	public void initDB() {
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

		
	}

	@Test
	@Ignore
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
		module.setIdModule(1);
		module.setNameModule("jee");

		proxy.assignProfsToModule(profs, module);

	}

	@Test
	@Ignore
	public void tesCcreateMark() {
		Module module = new Module();
		module.setIdModule(1);
		module.setNameModule("jee");

		Student student = new Student();
		student.setIdStudent(1);
		student.setNameStudent("aymen");

		proxy.createMark(student, module, new Date(), "ds", 12);

	}

}
