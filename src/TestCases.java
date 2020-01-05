/*
 * 
 * Name: Xinyuan Zhang
 * Class: CS480
 * 
 * Assignment 2
 * Due: 2019/10/15
 * Problem Number: 1, 2
 * 
 * Description: 
 * 	Implemented five poses
 */

/**
 * @author Jeffrey Finkelstein <jeffrey.finkelstein@gmail.com>
 * @author Zezhou Sun <micou@bu.edu>
 * @since Spring 2011
 */

import java.util.HashMap;
import java.util.Map;

public class TestCases extends CyclicIterator<Map<String, Configuration>> {

	public static final String LEG1_BODY_NAME = "leg1 body";
	public static final String LEG1_MIDDLE_NAME = "leg1 middle";
	public static final String LEG1_DISTAL_NAME = "leg1 distal";
	public static final String LEG2_BODY_NAME = "leg2 body";
	public static final String LEG2_MIDDLE_NAME = "leg2 middle";
	public static final String LEG2_DISTAL_NAME = "leg2 distal";
	public static final String LEG3_BODY_NAME = "leg3 body";
	public static final String LEG3_MIDDLE_NAME = "leg3 middle";
	public static final String LEG3_DISTAL_NAME = "leg3 distal";
	public static final String LEG4_BODY_NAME = "leg4 body";
	public static final String LEG4_MIDDLE_NAME = "leg4 middle";
	public static final String LEG4_DISTAL_NAME = "leg4 distal";
	public static final String LEG5_BODY_NAME = "leg5 body";
	public static final String LEG5_MIDDLE_NAME = "leg5 middle";
	public static final String LEG5_DISTAL_NAME = "leg5 distal";
	public static final String LEG6_BODY_NAME = "leg6 body";
	public static final String LEG6_MIDDLE_NAME = "leg6 middle";
	public static final String LEG6_DISTAL_NAME = "leg6 distal";
	public static final String ANTENNA1_BODY_NAME = "antenna1 body";
	public static final String ANTENNA1_MIDDLE_NAME = "antenna1 middle";
	public static final String ANTENNA1_DISTAL_NAME = "antenna1 distal";
	public static final String ANTENNA2_BODY_NAME = "antenna2 body";
	public static final String ANTENNA2_MIDDLE_NAME = "antenna2 middle";
	public static final String ANTENNA2_DISTAL_NAME = "antenna2 distal";
	public static final String HEAD_NAME = "head";
	public static final String BODY_NAME = "body";
	

	Map<String, Configuration> stop() {
		return this.stop;
	}

	private final Map<String, Configuration> stop;

	@SuppressWarnings("unchecked")
	TestCases() {
		this.stop = new HashMap<String, Configuration>();
		final Map<String, Configuration> hello = new HashMap<String, Configuration>();
		final Map<String, Configuration> fly = new HashMap<String, Configuration>();
		final Map<String, Configuration> hurray = new HashMap<String, Configuration>();
		final Map<String, Configuration> tired = new HashMap<String, Configuration>();
		final Map<String, Configuration> dab = new HashMap<String, Configuration>();

		super.add(stop, hello, fly, hurray, tired, dab);

		// the head and body angles through the test cases
		stop.put(HEAD_NAME, new BaseConfiguration(0, 0, 0));
		hello.put(HEAD_NAME, new BaseConfiguration(0, 0, 0));
		fly.put(HEAD_NAME, new BaseConfiguration(0, 0, 0));
		hurray.put(HEAD_NAME, new BaseConfiguration(0, 40, 0));
		tired.put(HEAD_NAME, new BaseConfiguration(180, 180, 20));
		dab.put(HEAD_NAME, new BaseConfiguration(0, -40, 0));

		stop.put(BODY_NAME, new BaseConfiguration(0, 0, 0));
		hello.put(BODY_NAME, new BaseConfiguration(0, 0, 0));
		fly.put(BODY_NAME, new BaseConfiguration(0, 0, 0));
		hurray.put(BODY_NAME, new BaseConfiguration(50, 0, 0));
		tired.put(BODY_NAME, new BaseConfiguration(0, 0, 0));
		dab.put(BODY_NAME, new BaseConfiguration(0, 50, 0));
		
		// the stop test case
		stop.put(LEG1_BODY_NAME, new BaseConfiguration(0, 130, -50));
		stop.put(LEG1_MIDDLE_NAME, new BaseConfiguration(0, 0, 0));
		stop.put(LEG1_DISTAL_NAME, new BaseConfiguration(-70, 0, 0));
		stop.put(LEG2_BODY_NAME, new BaseConfiguration(0, -130, 50));
		stop.put(LEG2_MIDDLE_NAME, new BaseConfiguration(0, 0, 0));
		stop.put(LEG2_DISTAL_NAME, new BaseConfiguration(-70, 0, 0));
		stop.put(LEG3_BODY_NAME, new BaseConfiguration(0, 105, -10));
		stop.put(LEG3_MIDDLE_NAME, new BaseConfiguration(0, 0, 0));
		stop.put(LEG3_DISTAL_NAME, new BaseConfiguration(-70, 0, 0));
		stop.put(LEG4_BODY_NAME, new BaseConfiguration(0, -105, 10));
		stop.put(LEG4_MIDDLE_NAME, new BaseConfiguration(0, 0, 0));
		stop.put(LEG4_DISTAL_NAME, new BaseConfiguration(-70, 0, 0));
		stop.put(LEG5_BODY_NAME, new BaseConfiguration(0, 85, -350));
		stop.put(LEG5_MIDDLE_NAME, new BaseConfiguration(0, 0, 0));
		stop.put(LEG5_DISTAL_NAME, new BaseConfiguration(-70, 0, 0));
		stop.put(LEG6_BODY_NAME, new BaseConfiguration(0, -85, 350));
		stop.put(LEG6_MIDDLE_NAME, new BaseConfiguration(0, 0, 0));
		stop.put(LEG6_DISTAL_NAME, new BaseConfiguration(-70, 0, 0));
		stop.put(ANTENNA1_BODY_NAME, new BaseConfiguration(120, 0, 0));
		stop.put(ANTENNA1_MIDDLE_NAME, new BaseConfiguration(0, 0, 0));
		stop.put(ANTENNA1_DISTAL_NAME, new BaseConfiguration(20, 0, 0));
		stop.put(ANTENNA2_BODY_NAME, new BaseConfiguration(120, 0, 0));
		stop.put(ANTENNA2_MIDDLE_NAME, new BaseConfiguration(0, 0, 0));
		stop.put(ANTENNA2_DISTAL_NAME, new BaseConfiguration(20, 0, 0));
		
		// the hello test case
		hello.put(LEG1_BODY_NAME, new BaseConfiguration(0, 130, -50));
		hello.put(LEG1_MIDDLE_NAME, new BaseConfiguration(0, 0, 0));
		hello.put(LEG1_DISTAL_NAME, new BaseConfiguration(-120, 80, 0));
		hello.put(LEG2_BODY_NAME, new BaseConfiguration(0, -130, 50));
		hello.put(LEG2_MIDDLE_NAME, new BaseConfiguration(0, 0, 0));
		hello.put(LEG2_DISTAL_NAME, new BaseConfiguration(-70, 0, 0));
		hello.put(LEG3_BODY_NAME, new BaseConfiguration(0, 105, -10));
		hello.put(LEG3_MIDDLE_NAME, new BaseConfiguration(0, 0, 0));
		hello.put(LEG3_DISTAL_NAME, new BaseConfiguration(-70, 0, 0));
		hello.put(LEG4_BODY_NAME, new BaseConfiguration(0, -105, 10));
		hello.put(LEG4_MIDDLE_NAME, new BaseConfiguration(0, 0, 0));
		hello.put(LEG4_DISTAL_NAME, new BaseConfiguration(-70, 0, 0));
		hello.put(LEG5_BODY_NAME, new BaseConfiguration(0, 85, -350));
		hello.put(LEG5_MIDDLE_NAME, new BaseConfiguration(0, 0, 0));
		hello.put(LEG5_DISTAL_NAME, new BaseConfiguration(-70, 0, 0));
		hello.put(LEG6_BODY_NAME, new BaseConfiguration(0, -85, 350));
		hello.put(LEG6_MIDDLE_NAME, new BaseConfiguration(0, 0, 0));
		hello.put(LEG6_DISTAL_NAME, new BaseConfiguration(-70, 0, 0));
		hello.put(ANTENNA1_BODY_NAME, new BaseConfiguration(120, 0, 0));
		hello.put(ANTENNA1_MIDDLE_NAME, new BaseConfiguration(0, 0, 0));
		hello.put(ANTENNA1_DISTAL_NAME, new BaseConfiguration(20, 20, 0));
		hello.put(ANTENNA2_BODY_NAME, new BaseConfiguration(120, 0, 0));
		hello.put(ANTENNA2_MIDDLE_NAME, new BaseConfiguration(0, 0, 0));
		hello.put(ANTENNA2_DISTAL_NAME, new BaseConfiguration(20, -20, 0));

		// the fly test case
		fly.put(LEG1_BODY_NAME, new BaseConfiguration(0, 130, -70));
		fly.put(LEG1_MIDDLE_NAME, new BaseConfiguration(0, 0, 0));
		fly.put(LEG1_DISTAL_NAME, new BaseConfiguration(-30, 0, 0));
		fly.put(LEG2_BODY_NAME, new BaseConfiguration(0, -130, 70));
		fly.put(LEG2_MIDDLE_NAME, new BaseConfiguration(0, 0, 0));
		fly.put(LEG2_DISTAL_NAME, new BaseConfiguration(-30, 0, 0));
		fly.put(LEG3_BODY_NAME, new BaseConfiguration(0, 105, -10));
		fly.put(LEG3_MIDDLE_NAME, new BaseConfiguration(0, 0, 0));
		fly.put(LEG3_DISTAL_NAME, new BaseConfiguration(-30, 0, 0));
		fly.put(LEG4_BODY_NAME, new BaseConfiguration(0, -105, 10));
		fly.put(LEG4_MIDDLE_NAME, new BaseConfiguration(0, 0, 0));
		fly.put(LEG4_DISTAL_NAME, new BaseConfiguration(-30, 0, 0));
		fly.put(LEG5_BODY_NAME, new BaseConfiguration(0, 85, -350));
		fly.put(LEG5_MIDDLE_NAME, new BaseConfiguration(0, 0, 0));
		fly.put(LEG5_DISTAL_NAME, new BaseConfiguration(-30, 0, 0));
		fly.put(LEG6_BODY_NAME, new BaseConfiguration(0, -85, 350));
		fly.put(LEG6_MIDDLE_NAME, new BaseConfiguration(0, 0, 0));
		fly.put(LEG6_DISTAL_NAME, new BaseConfiguration(-30, 0, 0));
		fly.put(ANTENNA1_BODY_NAME, new BaseConfiguration(120, 0, 0));
		fly.put(ANTENNA1_MIDDLE_NAME, new BaseConfiguration(0, 0, 0));
		fly.put(ANTENNA1_DISTAL_NAME, new BaseConfiguration(80, 0, 0));
		fly.put(ANTENNA2_BODY_NAME, new BaseConfiguration(120, 0, 0));
		fly.put(ANTENNA2_MIDDLE_NAME, new BaseConfiguration(0, 0, 0));
		fly.put(ANTENNA2_DISTAL_NAME, new BaseConfiguration(80, 0, 0));

		// the hurray test case
		hurray.put(LEG1_BODY_NAME, new BaseConfiguration(0, 130, -50));
		hurray.put(LEG1_MIDDLE_NAME, new BaseConfiguration(0, 0, 0));
		hurray.put(LEG1_DISTAL_NAME, new BaseConfiguration(-50, 80, 20));
		hurray.put(LEG2_BODY_NAME, new BaseConfiguration(0, -130, 50));
		hurray.put(LEG2_MIDDLE_NAME, new BaseConfiguration(0, 0, 0));
		hurray.put(LEG2_DISTAL_NAME, new BaseConfiguration(-50, -80, 20));
		hurray.put(LEG3_BODY_NAME, new BaseConfiguration(0, 105, -10));
		hurray.put(LEG3_MIDDLE_NAME, new BaseConfiguration(0, 0, 0));
		hurray.put(LEG3_DISTAL_NAME, new BaseConfiguration(-70, 0, 0));
		hurray.put(LEG4_BODY_NAME, new BaseConfiguration(0, -105, 10));
		hurray.put(LEG4_MIDDLE_NAME, new BaseConfiguration(0, 0, 0));
		hurray.put(LEG4_DISTAL_NAME, new BaseConfiguration(-70, 0, 0));
		hurray.put(LEG5_BODY_NAME, new BaseConfiguration(0, 85, 10));
		hurray.put(LEG5_MIDDLE_NAME, new BaseConfiguration(0, 0, 0));
		hurray.put(LEG5_DISTAL_NAME, new BaseConfiguration(-70, 0, 0));
		hurray.put(LEG6_BODY_NAME, new BaseConfiguration(0, -85, -10));
		hurray.put(LEG6_MIDDLE_NAME, new BaseConfiguration(0, 0, 0));
		hurray.put(LEG6_DISTAL_NAME, new BaseConfiguration(-70, 0, 0));
		hurray.put(ANTENNA1_BODY_NAME, new BaseConfiguration(120, 0, 0));
		hurray.put(ANTENNA1_MIDDLE_NAME, new BaseConfiguration(0, 0, 0));
		hurray.put(ANTENNA1_DISTAL_NAME, new BaseConfiguration(50, 20, 0));
		hurray.put(ANTENNA2_BODY_NAME, new BaseConfiguration(120, 0, 0));
		hurray.put(ANTENNA2_MIDDLE_NAME, new BaseConfiguration(0, 0, 0));
		hurray.put(ANTENNA2_DISTAL_NAME, new BaseConfiguration(50, -20, 0));

		// the tired test case
		tired.put(LEG1_BODY_NAME, new BaseConfiguration(0, 130, -70));
		tired.put(LEG1_MIDDLE_NAME, new BaseConfiguration(0, 0, 0));
		tired.put(LEG1_DISTAL_NAME, new BaseConfiguration(-30, 0, 0));
		tired.put(LEG2_BODY_NAME, new BaseConfiguration(0, -130, 70));
		tired.put(LEG2_MIDDLE_NAME, new BaseConfiguration(0, 0, 0));
		tired.put(LEG2_DISTAL_NAME, new BaseConfiguration(-30, 0, 0));
		tired.put(LEG3_BODY_NAME, new BaseConfiguration(0, 105, -10));
		tired.put(LEG3_MIDDLE_NAME, new BaseConfiguration(0, 0, 0));
		tired.put(LEG3_DISTAL_NAME, new BaseConfiguration(-30, 0, 0));
		tired.put(LEG4_BODY_NAME, new BaseConfiguration(0, -105, 10));
		tired.put(LEG4_MIDDLE_NAME, new BaseConfiguration(0, 0, 0));
		tired.put(LEG4_DISTAL_NAME, new BaseConfiguration(-30, 0, 0));
		tired.put(LEG5_BODY_NAME, new BaseConfiguration(0, 85, -350));
		tired.put(LEG5_MIDDLE_NAME, new BaseConfiguration(0, 0, 0));
		tired.put(LEG5_DISTAL_NAME, new BaseConfiguration(-30, 0, 0));
		tired.put(LEG6_BODY_NAME, new BaseConfiguration(0, -85, 350));
		tired.put(LEG6_MIDDLE_NAME, new BaseConfiguration(0, 0, 0));
		tired.put(LEG6_DISTAL_NAME, new BaseConfiguration(-30, 0, 0));
		tired.put(ANTENNA1_BODY_NAME, new BaseConfiguration(180, 0, 0));
		tired.put(ANTENNA1_MIDDLE_NAME, new BaseConfiguration(0, 0, 0));
		tired.put(ANTENNA1_DISTAL_NAME, new BaseConfiguration(20, 0, 0));
		tired.put(ANTENNA2_BODY_NAME, new BaseConfiguration(180, 0, 0));
		tired.put(ANTENNA2_MIDDLE_NAME, new BaseConfiguration(0, 0, 0));
		tired.put(ANTENNA2_DISTAL_NAME, new BaseConfiguration(20, 0, 0));

		// the dab test case
		dab.put(LEG1_BODY_NAME, new BaseConfiguration(0, 130, -50));
		dab.put(LEG1_MIDDLE_NAME, new BaseConfiguration(0, 0, 0));
		dab.put(LEG1_DISTAL_NAME, new BaseConfiguration(-50, 80, 20));
		dab.put(LEG2_BODY_NAME, new BaseConfiguration(0, -130, 50));
		dab.put(LEG2_MIDDLE_NAME, new BaseConfiguration(0, 0, 0));
		dab.put(LEG2_DISTAL_NAME, new BaseConfiguration(-50, -80, 20));
		dab.put(LEG3_BODY_NAME, new BaseConfiguration(0, 105, -10));
		dab.put(LEG3_MIDDLE_NAME, new BaseConfiguration(0, 0, 0));
		dab.put(LEG3_DISTAL_NAME, new BaseConfiguration(-70, 0, 0));
		dab.put(LEG4_BODY_NAME, new BaseConfiguration(0, -105, 10));
		dab.put(LEG4_MIDDLE_NAME, new BaseConfiguration(0, 0, 0));
		dab.put(LEG4_DISTAL_NAME, new BaseConfiguration(-70, 0, 0));
		dab.put(LEG5_BODY_NAME, new BaseConfiguration(0, 85, 10));
		dab.put(LEG5_MIDDLE_NAME, new BaseConfiguration(0, 0, 0));
		dab.put(LEG5_DISTAL_NAME, new BaseConfiguration(-70, 0, 0));
		dab.put(LEG6_BODY_NAME, new BaseConfiguration(0, -85, -10));
		dab.put(LEG6_MIDDLE_NAME, new BaseConfiguration(0, 0, 0));
		dab.put(LEG6_DISTAL_NAME, new BaseConfiguration(-70, 0, 0));
		dab.put(ANTENNA1_BODY_NAME, new BaseConfiguration(120, 0, 0));
		dab.put(ANTENNA1_MIDDLE_NAME, new BaseConfiguration(0, 0, 0));
		dab.put(ANTENNA1_DISTAL_NAME, new BaseConfiguration(50, 20, 0));
		dab.put(ANTENNA2_BODY_NAME, new BaseConfiguration(120, 0, 0));
		dab.put(ANTENNA2_MIDDLE_NAME, new BaseConfiguration(0, 0, 0));
		dab.put(ANTENNA2_DISTAL_NAME, new BaseConfiguration(50, -20, 0));
	}
}
