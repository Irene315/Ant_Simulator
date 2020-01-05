/*
 * 
 * Name: Xinyuan Zhang
 * Class: CS480
 * 
 * Assignment 2
 * Due: 2019/10/15
 * Problem Number: /
 * 
 * Description: 
 *  File given for animate interface. No modification.
 *  
 */

/**
 * Animate.java - an object which can be changed by configuration list
 * 
 * @author Zezhou Sun <micou@bu.edu>
 * @since  Sep 2019
 */

import java.util.ArrayList;

public interface Animate {
	/**
	 * Set Current Component and its children to States
	 * 
	 * @param an ArrayList of configurations, define mapping from ArrayList to
	 *           Component configurations in function
	 */
	void setModelStates(final ArrayList<Configuration> config_list);
}
