/**
 * @author GYURIN (JANE) MO, CALEB OVIAWE, YANISA SRISA-ARD, EMIKO EMIKO
 * @version 1.7
 * @since 1.2
*/

package edu.ucalgary.oop;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * ModifyScheduleGUI class represents a Graphical User Interface (GUI) for the EWR schedule.
 * This class promps the users to input rowID, removeTime and addTime to modify schedule.
 * This class implements ActionListner class as it receives user input data. 
*/
public class ModifyScheduleGUI implements ActionListener {
    /**
     * defining the frame and text inputs for the modify schedule window.
     */
    private static JFrame frame = new JFrame("Modify Schedule"); 
    private static JTextField rowIDTextField = new JTextField();
    private static JTextField removeTimeTextField = new JTextField();
    private static JTextField addTimeTextField = new JTextField();
    private static JLabel rowIDLabel = new JLabel("Please enter RowID to modify:");
    private static JLabel removeTimeLabel = new JLabel("Please enter the time to remove the task from in 24 hour form (ex. enter 22 for 10PM):");
    private static JLabel addTimeLabel = new JLabel("Please enter the time to add the task to in 24 hour form (ex. enter 22 for 10PM):");
    private static JLabel empty = new JLabel();
    private static JButton submit = new JButton("Submit");
    private static boolean submitPressed = false;
    private static String rowID;
    private static String removeTime;
    private static String addTime;
    
    /**
     * ModifyScheduleGUI default constructor which 
     * creates the frame layout, text fields and buttons.
     */
    public ModifyScheduleGUI() {
    	final GridLayout gl = new GridLayout();
        gl.setColumns(2);
        gl.setRows(3);
        
        frame.setLayout(gl);
        frame.add(rowIDLabel);
        frame.add(rowIDTextField);
        frame.add(removeTimeLabel);
        frame.add(removeTimeTextField);
        frame.add(addTimeLabel);
        frame.add(addTimeTextField);
        frame.add(empty);
        frame.add(submit);

        frame.setSize(400, 400);
        // when the close button is pressed, the JFrame will exit
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
    
        submit.addActionListener(new ActionListener() {
 	        public void actionPerformed(ActionEvent ae) {
                submitPressed = true;
                rowID = rowIDTextField.getText();
                removeTime = removeTimeTextField.getText();
                addTime = addTimeTextField.getText();
            }
 	    });
    }    

    /**
     * Returns the status of Submit button whether it is pressed or not.
     * @return stored boolean value of submitPressed variable.
     */
    public static boolean isSubmitPressed() {
        return submitPressed;
    }

    /**
     * Sets submitPressed variable to false.
     */
    public static void setNotSubmitPressed() {
        submitPressed = false;
    }
    
    /**
     * Sets ModifyScheduleGUI frame to be visible if passed argument 
     * is true or not visible if the passed arguemnt is false.
     * @param visible A boolean representation which sets MainGUI to be visible or not visible.
     */
    public static void setVisibility(boolean visible) {
    	frame.setVisible(visible);
    }
    
    /**
     * getRowID returns ModifyScheduleGUI object's rowID
     * @return A string rowID representing user input rowID that the user wants to modify.
     */
    public static String getRowID() { return rowID; }

    /**
     * getRemoveTime returns ModifyScheduleGUI object's removeTime.
     * @return A string removeTime representing user input hour where the user wants to remove the rowID from.
     */
    public static String getRemoveTime() { return removeTime; }

    /**
     * getAddTime returns ModifyScheduleGUI object's addTime.
     * @return A string addTime representing user input hour where the user wants to add the rowID to.
     */
    public static String getAddTime() { return addTime; }

    /**
     * Overriden method from ActionListener class which throws UnsupportedOperationException.
     * @throws UnsupportedOperationException
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }
 
}