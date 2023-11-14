/**
 * @author GYURIN (JANE) MO, CALEB OVIAWE, YANISA SRISA-ARD, EMIKO EMIKO
 * @version 1.7
 * @since 1.2
*/

package edu.ucalgary.oop;

import javax.swing.*;
import java.awt.*;

/**
 * MainGUI class represents a Graphical User Interface (GUI) for the EWR schedule.
 * This class provides three options for the users to choose from which allows the 
 * users to modify or generate schedule and to contact back up volunteer if needed.
*/
public class MainGUI {

    /**
     * defining the frame and buttons for the schedule builder window
     */
    private static JFrame frame = new JFrame("EWR Schedule Builder");
    private static JButton modifyBtn = new JButton("Modify Schedule");
    private static JButton volunteerBtn = new JButton("Contact Volunteer");
    private static JButton scheduleBtn = new JButton("Generate Final Schedule");
    private static JLabel label = new JLabel("Please select:");

    /**
     * MainGUI default constructor which creates the frame layout and buttons
     */
    public MainGUI() {
    	final GridLayout gl = new GridLayout();
        gl.setColumns(1);
        gl.setRows(4);
        
        frame.setLayout(gl);
        frame.add(label);
        frame.add(modifyBtn);
        frame.add(volunteerBtn);
        frame.add(scheduleBtn);

        frame.setSize(400, 400);
        
        // when the close button is pressed, the JFrame will exit
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    /**
     * Sets MainGUI frame to be visible if passed argument is true or not visible if the passed arguemnt is false.
     * @param visible A boolean representation which sets MainGUI to be visible or not visible.
     */
    public static void setVisibility(boolean visible) {
    	frame.setVisible(visible);
    }
    
    /**
     * Returns true if the modify schedule button has been pressed, false if not pressed.
     * @return boolean which indicates whether the modify schedule button has been pressed or not.
     */  
    public static boolean pressedModifyBtn() {
    	return modifyBtn.getModel().isPressed();
    }
    
    /**
     * Returns true if the generate schedule button has been pressed, false if not pressed.
     * @return boolean which indicates whether the generate schedule button has been pressed or not.
     */   
    public static boolean pressedScheduleBtn() {
    	return scheduleBtn.getModel().isPressed();
    }

    /**
     * Returns true if the contact volunteer button has been pressed, false if not pressed.
     * @return boolean which indicates whether the contact volunteer button has been pressed or not.
     */    
    public static boolean pressedVolunteerBtn() {
    	return volunteerBtn.getModel().isPressed();
    }
    
} // End of class MainGUI


