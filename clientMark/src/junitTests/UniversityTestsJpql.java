package junitTests;

import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import persistence.Prof;
import persistence.Student;
import services.UniversityServicesRemote;

public class UniversityTestsJpql {
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

		Student student = proxy.findstudentById(1);
		List<Prof> profs = proxy.findAllProfByStudent(student);
		System.out.println(profs.size());
		for (Prof p : profs) {
			System.out.println(p);
		}

	}
}
