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
 *  File given for body part selection. No modification.
 *  
 */

/**
 * An interface ask object to response to select control
 * 
 * @author Zezhou Sun <micou@bu.edu>
 * @since Fall 2019
 */

public interface Selection {

	void toggleSelection(int componentNum);

	void changeSelected(Configuration configuration);
}
