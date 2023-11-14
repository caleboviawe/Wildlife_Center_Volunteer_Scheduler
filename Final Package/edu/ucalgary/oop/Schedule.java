/**
 * @author GYURIN (JANE) MO, CALEB OVIAWE, YANISA SRISA-ARD, EMIKO EMIKO
 * @version 1.7
 * @since 1.2
*/

package edu.ucalgary.oop;

import java.util.*;

/**
 * Schedule class informs the users in which time slots schedule overflow has occurred
 * and receives user input data by accessing ModifyScheduleGUI class in order to pass
 * the data to modify existing schedules.
 */
public class Schedule {

    /**
     * Informs the users in which time windows schedule overflow has occurred. 
     * @param overflowTime A string ArrayList consists of hours where schedule overflow has occurred.
     */
    public void overflow(ArrayList<String> overflowTime) throws IllegalArgumentException {
        if (overflowTime == null) {
            throw new IllegalArgumentException("overflowTime cannot be null");
        }
        System.out.print("Schedule overflow occurred in: ");
        for(int i=0; i < overflowTime.size(); i++){
            if (i == overflowTime.size() - 1) {
                System.out.print(overflowTime.get(i));
            } else {
                System.out.print(overflowTime.get(i) + ", ");
            }
        }
        System.out.println();
        System.out.println();
    }

    /**
     * Accesses ModifyScheduleGUI class to retrieve user input data (RowID, 
     * RemoveTime and AddTime) which will be used to modify task schedules.
     * @returns A string ArrayList consists of RowID, RemoveTime and AddTime 
     * which will be used for queries to modify schedule.
     */
    public ArrayList<String> modifySchedule(){
        ArrayList<String> queryInfo = new ArrayList<String>();
        
        // Creating a new GUI and making it visible
        new ModifyScheduleGUI();
        ModifyScheduleGUI.setVisibility(true);
        
        queryInfo.add(ModifyScheduleGUI.getRowID());
        queryInfo.add(ModifyScheduleGUI.getRemoveTime());
        queryInfo.add(ModifyScheduleGUI.getAddTime());

        return queryInfo;
    }

}
