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
 *  1. Modified Arm.java to create class for ant object.
 *  
 *  2. Assigned appropriate size to each body part and added hierarchy.
 *  
 *  3. Adjusted the rotation limits for each body part.
 *  
 */

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import com.jogamp.opengl.util.gl2.GLUT;

import javax.media.opengl.GL2;



public class Ant extends Component implements Animate, Selection {	

	private final GLUT glut = new GLUT();
	
	private final Component head;
	private final Component body;
	private final Leg[] legs;
	private final Leg[] antennas;
	private final List<Component> components;
	private final Set<Component> selectedComponents = new HashSet<Component>(26);
	
	// Set color of ant
	public static final FloatColor ACTIVE_COLOR = FloatColor.BLUE;
	public static final FloatColor INACTIVE_COLOR = FloatColor.WHITE;
	
	// Set size of ant
	public static final double HEAD_HEIGHT = 1.3;
	public static final double HEAD_RADIUS = 0.3;	
	public static final double BODY_HEIGHT = 0.57;
	public static final double BODY_RADIUS = 0.4;	
	public static final double DISTAL_JOINT_HEIGHT = 0.6;
	public static final double DISTAL_LEG_RADIUS = 0.03;
	public static final double MIDDLE_JOINT_HEIGHT = 0.1;
	public static final double MIDDLE_LEG_RADIUS = 0.03;
    public static final double BODY_JOINT_HEIGHT = 0.3;
    public static final double BODY_LEG_RADIUS = 0.03;
    public static final double ANTENNA_DISTAL_HEIGHT = 0.4;
    public static final double ANTENNA_DISTAL_RADIUS = 0.02;
	public static final double ANTENNA_MIDDLE_HEIGHT = 0.1;
	public static final double ANTENNA_MIDDLE_RADIUS = 0.02;
    public static final double ANTENNA_HEAD_HEIGHT = 0.5;
    public static final double ANTENNA_HEAD_RADIUS = 0.02;

    // Set names for different parts of ant
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
	
	// Match component case number to body parts for ant
	private Component mapNum2Component(int componentNum) {
		switch (componentNum) {
		case 0:
			return this.head;
		case 1:
			return this.body;
		case 2:
			return this.legs[0].bodyJoint();
		case 3:
			return this.legs[0].middleJoint();
		case 4:
			return this.legs[0].distalJoint();
		case 5:
			return this.legs[1].bodyJoint();
		case 6:
			return this.legs[1].middleJoint();
		case 7:
			return this.legs[1].distalJoint();
		case 8:
			return this.legs[2].bodyJoint();
		case 9:
			return this.legs[2].middleJoint();
		case 10:
			return this.legs[2].distalJoint();
		case 11:
			return this.legs[3].bodyJoint();
		case 12:
			return this.legs[3].middleJoint();
		case 13:
			return this.legs[3].distalJoint();
		case 14:
			return this.legs[4].bodyJoint();
		case 15:
			return this.legs[4].middleJoint();
		case 16:
			return this.legs[4].distalJoint();
		case 17:
			return this.legs[5].bodyJoint();
		case 18:
			return this.legs[5].middleJoint();
		case 19:
			return this.legs[5].distalJoint();
		case 20:
			return this.antennas[0].bodyJoint();
		case 21:
			return this.antennas[0].middleJoint();
		case 22:
			return this.antennas[0].distalJoint();
		case 23:
			return this.antennas[1].bodyJoint();
		case 24:
			return this.antennas[1].middleJoint();
		case 25:
			return this.antennas[1].distalJoint();
		default:
			throw new IllegalArgumentException("componentNum out index");
		}
	}

	// Match component name to body parts for ant
	private Component mapName2Component(String componentName) {
		switch (componentName) {
		case HEAD_NAME:
			return this.head;
		case BODY_NAME:
			return this.body;
		case LEG1_BODY_NAME:
			return this.legs[0].bodyJoint();
		case LEG1_MIDDLE_NAME:
			return this.legs[0].middleJoint();
		case LEG1_DISTAL_NAME:
			return this.legs[0].distalJoint();
		case LEG2_BODY_NAME:
			return this.legs[1].bodyJoint();
		case LEG2_MIDDLE_NAME:
			return this.legs[1].middleJoint();
		case LEG2_DISTAL_NAME:
			return this.legs[1].distalJoint();
		case LEG3_BODY_NAME:
			return this.legs[2].bodyJoint();
		case LEG3_MIDDLE_NAME:
			return this.legs[2].middleJoint();
		case LEG3_DISTAL_NAME:
			return this.legs[2].distalJoint();
		case LEG4_BODY_NAME:
			return this.legs[3].bodyJoint();
		case LEG4_MIDDLE_NAME:
			return this.legs[3].middleJoint();
		case LEG4_DISTAL_NAME:
			return this.legs[3].distalJoint();
		case LEG5_BODY_NAME:
			return this.legs[4].bodyJoint();
		case LEG5_MIDDLE_NAME:
			return this.legs[4].middleJoint();
		case LEG5_DISTAL_NAME:
			return this.legs[4].distalJoint();
		case LEG6_BODY_NAME:
			return this.legs[5].bodyJoint();
		case LEG6_MIDDLE_NAME:
			return this.legs[5].middleJoint();
		case LEG6_DISTAL_NAME:
			return this.legs[5].distalJoint();
		case ANTENNA1_BODY_NAME:
			return this.antennas[0].bodyJoint();
		case ANTENNA1_MIDDLE_NAME:
			return this.antennas[0].middleJoint();
		case ANTENNA1_DISTAL_NAME:
			return this.antennas[0].distalJoint();
		case ANTENNA2_BODY_NAME:
			return this.antennas[1].bodyJoint();
		case ANTENNA2_MIDDLE_NAME:
			return this.antennas[1].middleJoint();
		case ANTENNA2_DISTAL_NAME:
			return this.antennas[1].distalJoint();
		default:
			throw new IllegalArgumentException("componentName doesn't exist");
		}
	}

	public void setModelStates(final ArrayList<Configuration> config_list) {
		for (int i = 0; i < config_list.size(); i++) {
			if (0 <= i && i <= 25) {
				mapNum2Component(i).setAngles(config_list.get(i));
			}
		}
	}

	public void setModelStates(final Map<String, Configuration> state) {
		for (Map.Entry<String, Configuration> entry : state.entrySet()) {
			this.mapName2Component(entry.getKey()).setAngles(entry.getValue());
		}
	}

	/**
	 * Prints the joints on the specified PrintStream.
	 * 
	 * @param printStream The stream on which to print each of the components.
	 */
	public void printJoints(final PrintStream printStream) {
		for (final Component component : this.components) {
			printStream.println(component);
		}
	}

	public void toggleSelection(int selectionNum) {
		if (0 <= selectionNum && selectionNum <= 25) {
			Component component = mapNum2Component(selectionNum);
			if (this.selectedComponents.contains(component)) {
				this.selectedComponents.remove(component);
				component.setColor(INACTIVE_COLOR);
			} else {
				this.selectedComponents.add(component);
				component.setColor(ACTIVE_COLOR);
			}
		}
	}

	public void changeSelected(Configuration config) {
		for (Component c : this.selectedComponents) {
			c.changeConfiguration(config);
		}
	}
		
	public Ant(Point3D position, String name) {
		super(position, name);
		
		// Set initial position of ant
		// Set initial positions for all distal joints
		final Component distal1 = new Component(new Point3D(0, 0, MIDDLE_JOINT_HEIGHT),
				new RoundedCylinder(DISTAL_LEG_RADIUS, DISTAL_JOINT_HEIGHT, this.glut), LEG1_DISTAL_NAME);
		final Component distal2 = new Component(new Point3D(0, 0, MIDDLE_JOINT_HEIGHT),
				new RoundedCylinder(DISTAL_LEG_RADIUS, DISTAL_JOINT_HEIGHT, this.glut), LEG2_DISTAL_NAME);
		final Component distal3 = new Component(new Point3D(0, 0, MIDDLE_JOINT_HEIGHT),
				new RoundedCylinder(DISTAL_LEG_RADIUS, DISTAL_JOINT_HEIGHT, this.glut), LEG3_DISTAL_NAME);
		final Component distal4 = new Component(new Point3D(0, 0, MIDDLE_JOINT_HEIGHT),
				new RoundedCylinder(DISTAL_LEG_RADIUS, DISTAL_JOINT_HEIGHT, this.glut), LEG4_DISTAL_NAME);
		final Component distal5 = new Component(new Point3D(0, 0, MIDDLE_JOINT_HEIGHT),
				new RoundedCylinder(DISTAL_LEG_RADIUS, DISTAL_JOINT_HEIGHT, this.glut), LEG5_DISTAL_NAME);
		final Component distal6 = new Component(new Point3D(0, 0, MIDDLE_JOINT_HEIGHT),
				new RoundedCylinder(DISTAL_LEG_RADIUS, DISTAL_JOINT_HEIGHT, this.glut), LEG6_DISTAL_NAME);
		final Component antenna_distal1 = new Component(new Point3D(0, 0, ANTENNA_MIDDLE_HEIGHT),
				new RoundedCylinder(ANTENNA_DISTAL_RADIUS, ANTENNA_DISTAL_HEIGHT, this.glut), ANTENNA1_DISTAL_NAME);
		final Component antenna_distal2 = new Component(new Point3D(0, 0, ANTENNA_MIDDLE_HEIGHT),
				new RoundedCylinder(ANTENNA_DISTAL_RADIUS, ANTENNA_DISTAL_HEIGHT, this.glut), ANTENNA2_DISTAL_NAME);
		
		// Set initial positions for all middle joints
		final Component middle1 = new Component(new Point3D(0, 0, BODY_JOINT_HEIGHT),
				new RoundedCylinder(MIDDLE_LEG_RADIUS, MIDDLE_JOINT_HEIGHT, this.glut), LEG1_MIDDLE_NAME);
		final Component middle2 = new Component(new Point3D(0, 0, BODY_JOINT_HEIGHT),
				new RoundedCylinder(MIDDLE_LEG_RADIUS, MIDDLE_JOINT_HEIGHT, this.glut), LEG2_MIDDLE_NAME);
		final Component middle3 = new Component(new Point3D(0, 0, BODY_JOINT_HEIGHT),
				new RoundedCylinder(MIDDLE_LEG_RADIUS, MIDDLE_JOINT_HEIGHT, this.glut), LEG3_MIDDLE_NAME);
		final Component middle4 = new Component(new Point3D(0, 0, BODY_JOINT_HEIGHT),
				new RoundedCylinder(MIDDLE_LEG_RADIUS, MIDDLE_JOINT_HEIGHT, this.glut), LEG4_MIDDLE_NAME);
		final Component middle5 = new Component(new Point3D(0, 0, BODY_JOINT_HEIGHT),
				new RoundedCylinder(MIDDLE_LEG_RADIUS, MIDDLE_JOINT_HEIGHT, this.glut), LEG5_MIDDLE_NAME);
		final Component middle6 = new Component(new Point3D(0, 0, BODY_JOINT_HEIGHT),
				new RoundedCylinder(MIDDLE_LEG_RADIUS, MIDDLE_JOINT_HEIGHT, this.glut), LEG6_MIDDLE_NAME);
		final Component antenna_middle1 = new Component(new Point3D(0, 0, ANTENNA_HEAD_HEIGHT),
				new RoundedCylinder(ANTENNA_MIDDLE_RADIUS, ANTENNA_MIDDLE_HEIGHT, this.glut), ANTENNA1_MIDDLE_NAME);
		final Component antenna_middle2 = new Component(new Point3D(0, 0, ANTENNA_HEAD_HEIGHT),
				new RoundedCylinder(ANTENNA_MIDDLE_RADIUS, ANTENNA_MIDDLE_HEIGHT, this.glut), ANTENNA2_MIDDLE_NAME);

		// Set initial positions for all body joints
		final Component body1 = new Component(new Point3D(0.3, 0, 0.25),
				new RoundedCylinder(BODY_LEG_RADIUS, BODY_JOINT_HEIGHT, this.glut), LEG1_BODY_NAME);
		final Component body2 = new Component(new Point3D(-0.3, 0, 0.25),
				new RoundedCylinder(BODY_LEG_RADIUS, BODY_JOINT_HEIGHT, this.glut), LEG2_BODY_NAME);
		final Component body3 = new Component(new Point3D(0.3, 0, 0.4),
				new RoundedCylinder(BODY_LEG_RADIUS, BODY_JOINT_HEIGHT, this.glut), LEG3_BODY_NAME);
		final Component body4 = new Component(new Point3D(-0.3, 0, 0.4),
				new RoundedCylinder(BODY_LEG_RADIUS, BODY_JOINT_HEIGHT, this.glut), LEG4_BODY_NAME);
		final Component body5 = new Component(new Point3D(0.3, 0, 0.55),
				new RoundedCylinder(BODY_LEG_RADIUS, BODY_JOINT_HEIGHT, this.glut), LEG5_BODY_NAME);
		final Component body6 = new Component(new Point3D(-0.3, 0, 0.55),
				new RoundedCylinder(BODY_LEG_RADIUS, BODY_JOINT_HEIGHT, this.glut), LEG6_BODY_NAME);
		final Component antenna_head1 = new Component(new Point3D(0.15, -0.08, 0.45),
				new RoundedCylinder(ANTENNA_HEAD_RADIUS, ANTENNA_HEAD_HEIGHT, this.glut), ANTENNA1_BODY_NAME);
		final Component antenna_head2 = new Component(new Point3D(-0.15, -0.08, 0.45),
				new RoundedCylinder(ANTENNA_HEAD_RADIUS, ANTENNA_HEAD_HEIGHT, this.glut), ANTENNA2_BODY_NAME);
		    
		this.legs = new Leg[] { new Leg(body1, middle1, distal1), new Leg(body2, middle2, distal2),
								new Leg(body3, middle3, distal3), new Leg(body4, middle4, distal4),
								new Leg(body5, middle5, distal5), new Leg(body6, middle6, distal6)};

		this.antennas = new Leg[] {new Leg(antenna_head1, antenna_middle1, antenna_distal1), new Leg(antenna_head2, antenna_middle2, antenna_distal2)};

		// Set initial positions for head and body
		this.head = new Component(new Point3D(0, 0, HEAD_HEIGHT), new Head(HEAD_RADIUS, this.glut), HEAD_NAME);
		this.body = new Component(new Point3D(0, 0, BODY_HEIGHT), new Body(BODY_RADIUS, this.glut), BODY_NAME);
		
		// Set hierarchy of each part of ant
		this.addChild(this.head);
		// Add body and antenna as children of head
		this.head.addChild(this.body);
		this.head.addChildren(antenna_head1, antenna_head2);
		// Add body joints as children of body
		this.body.addChildren(body1, body2, body3, body4, body5, body6);
		   
		// Add middle joints as children of body joints
		body1.addChild(middle1);
		body2.addChild(middle2);
		body3.addChild(middle3);
		body4.addChild(middle4);
		body5.addChild(middle5);
		body6.addChild(middle6);
		// Add antenna middle joints as children of antenna body joints
		antenna_head1.addChild(antenna_middle1);
		antenna_head2.addChild(antenna_middle2);
		    
		// Add distal joints as children of middle joints
		middle1.addChild(distal1);
		middle2.addChild(distal2);
		middle3.addChild(distal3);
		middle4.addChild(distal4);
		middle5.addChild(distal5);
		middle6.addChild(distal6);
		// Add antenna distal joints as children of antenna middle joints
		antenna_middle1.addChild(antenna_distal1);
		antenna_middle2.addChild(antenna_distal2);

		// Set initial pose of ant
		this.rotate(Axis.Y, 75);
		this.rotate(Axis.X, -130);
		
		body1.rotate(Axis.Y, 130);
		body2.rotate(Axis.Y, -130);
		body3.rotate(Axis.Y, 105);
		body4.rotate(Axis.Y, -105);
		body5.rotate(Axis.Y, 85);
		body6.rotate(Axis.Y, -85);
		
		body1.rotate(Axis.Z, -50);
	    body2.rotate(Axis.Z, 50);
	    body3.rotate(Axis.Z, -10);
	    body4.rotate(Axis.Z, 10);
	    body5.rotate(Axis.Z, 10);
	    body6.rotate(Axis.Z, -10);
		
		distal1.rotate(Axis.X, -70);
		distal2.rotate(Axis.X, -70);
		distal3.rotate(Axis.X, -70);
		distal4.rotate(Axis.X, -70);
		distal5.rotate(Axis.X, -70);
		distal6.rotate(Axis.X, -70);
		
		antenna_head1.rotate(Axis.X, 120);
	    antenna_head2.rotate(Axis.X, 120);
	    antenna_distal1.rotate(Axis.X, 20);
	    antenna_distal2.rotate(Axis.X, 20);
	    
		// Set rotation limits for ant head and body   
	    this.head.setXPositiveExtent(40);
	    this.head.setXNegativeExtent(-40);
	    this.head.setYPositiveExtent(20);
	    this.head.setYNegativeExtent(-20);
	    this.head.setZPositiveExtent(0);
	    this.head.setZNegativeExtent(-60);
	    
	    this.body.setXPositiveExtent(20);
	    this.body.setXNegativeExtent(-20);
	    this.body.setYPositiveExtent(20);
	    this.body.setYNegativeExtent(-25);
	    this.body.setZPositiveExtent(10);
	    this.body.setZNegativeExtent(-10);
	    	
	    // Set rotation limits each leg
	    body1.setXPositiveExtent(10);
	    body1.setXNegativeExtent(-10);
	    body1.setYPositiveExtent(140);
	    body1.setYNegativeExtent(120);
	    body1.setZPositiveExtent(20);
	    body1.setZNegativeExtent(-130);
	 	    
	    body2.setXPositiveExtent(10);
	    body2.setXNegativeExtent(-10);
	    body2.setYPositiveExtent(-120);
	    body2.setYNegativeExtent(-140);
	    body2.setZPositiveExtent(130);
	    body2.setZNegativeExtent(-20);
	    
	    body3.setXPositiveExtent(10);
	    body3.setXNegativeExtent(-10);
	    body3.setYPositiveExtent(125);
	    body3.setYNegativeExtent(95);
	    body3.setZPositiveExtent(20);
	    body3.setZNegativeExtent(-30);
	    
	    body4.setXPositiveExtent(10);
	    body4.setXNegativeExtent(-10);
	    body4.setYPositiveExtent(-95);
	    body4.setYNegativeExtent(-125);
	    body4.setZPositiveExtent(30);
	    body4.setZNegativeExtent(-20);
	    
	    body5.setXPositiveExtent(10);
	    body5.setXNegativeExtent(-10);
	    body5.setYPositiveExtent(95);
	    body5.setYNegativeExtent(75);
	    body5.setZPositiveExtent(70);
	    body5.setZNegativeExtent(-30);
	    
	    body6.setXPositiveExtent(10);
	    body6.setXNegativeExtent(-10);
	    body6.setYPositiveExtent(-75);
	    body6.setYNegativeExtent(-95);
	    body6.setZPositiveExtent(30);
	    body6.setZNegativeExtent(-70);
	    	    
	    for (final Component middleJoint: Arrays.asList(middle1, middle2, middle3, 
	    		middle4, middle5, middle6)) {
	    	middleJoint.setXPositiveExtent(5);
	        middleJoint.setXNegativeExtent(-5);
	        middleJoint.setYPositiveExtent(5);
	        middleJoint.setYNegativeExtent(-5);
	        middleJoint.setZPositiveExtent(5);
	        middleJoint.setZNegativeExtent(-5);
	    }
	    
	    
	    for (final Component distalJoint: Arrays.asList(distal1, distal2, distal3, 
	    		distal4, distal5, distal6)) {
	    	distalJoint.setXPositiveExtent(-10);
		    distalJoint.setXNegativeExtent(-80);
		    distalJoint.setYPositiveExtent(10);
		    distalJoint.setYNegativeExtent(-10);
		    distalJoint.setZPositiveExtent(10);
		    distalJoint.setZNegativeExtent(-10);
	    }
	    
	    // Set rotation limits each antenna
	    for (final Component antennaHead: Arrays.asList(antenna_head1, antenna_head2)) {
	    	antennaHead.setXPositiveExtent(130);
	    	antennaHead.setXNegativeExtent(50);
	    	antennaHead.setYPositiveExtent(0);
	    	antennaHead.setYNegativeExtent(0);
		    antennaHead.setZPositiveExtent(10);
		    antennaHead.setZNegativeExtent(-10);
	    }
	    
	    for (final Component antennaMiddle: Arrays.asList(antenna_middle1, antenna_middle2)) {
	    	antennaMiddle.setXPositiveExtent(0);
	    	antennaMiddle.setXNegativeExtent(0);
	    	antennaMiddle.setYPositiveExtent(0);
	    	antennaMiddle.setYNegativeExtent(0);
		    antennaMiddle.setZPositiveExtent(0);
		    antennaMiddle.setZNegativeExtent(0);
	    }
	    
	    for (final Component antennaDistal: Arrays.asList(antenna_distal1, antenna_distal2)) {
	    	antennaDistal.setXPositiveExtent(30);
	    	antennaDistal.setXNegativeExtent(-30);
	    	antennaDistal.setYPositiveExtent(30);
	    	antennaDistal.setYNegativeExtent(-30);
		    antennaDistal.setZPositiveExtent(10);
		    antennaDistal.setZNegativeExtent(-10);
	    }
	    
	    this.components = Arrays.asList(body1, middle1, distal1, body2, middle2, distal2, 
	    	body3, middle3, distal3, body4, middle4, distal4, body5, middle5, distal5, 
	    	body6, middle6, distal6, antenna_head1, antenna_head2, antenna_middle1, 
	    	antenna_middle2, antenna_distal1, antenna_distal2, this.head, this.body);
		        
	}

	// Create class for leg and antenna
	private class Leg {
		private final List<Component> joints;
		private final Component distalJoint;
		private final Component middleJoint;
		private final Component bodyJoint;

		public Leg(final Component bodyJoint, final Component middleJoint, final Component distalJoint) {
			this.bodyJoint = bodyJoint;
			this.middleJoint = middleJoint;
			this.distalJoint = distalJoint;

			this.joints = Collections
				.unmodifiableList(Arrays.asList(this.bodyJoint, this.middleJoint, this.distalJoint));
		}
		
		List<Component> joints() {
			return this.joints;
		}
		
		// Get distal joint value
		Component distalJoint() {
			return this.distalJoint;
		}

		// Get middle joint value
		Component middleJoint() {
			return this.middleJoint;
		}

		// Get body joint value
		Component bodyJoint() {
			return this.bodyJoint;
		}

	}




}
