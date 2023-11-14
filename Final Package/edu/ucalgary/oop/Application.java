/**
 * @author GYURIN (JANE) MO, CALEB OVIAWE, YANISA SRISA-ARD, EMIKO EMIKO
 * @version 2.1
 * @since 1.1
*/

package edu.ucalgary.oop;

import java.io.IOException;
import java.util.*;
import javax.swing.JOptionPane;

/**
* The Application class contains the main method and is responsible for performing
* the necessary computations for animal feeding and cage cleaning times. It accesses
* the DatabaseAccess class to retrieve information about the animals and calculates
* the total feeding and cage cleaning times for each species. It also creates instances
* of each animal type (Beaver, Coyote, Fox, Porcupine, Racoon) and calls their respective
* methods to calculate the feeding and cleaning times for each species. The main method
* provide a user interactive GUI and allows the user to view, modify and generate schedule.
*/

public class Application {
    /**
    * The main method of the Application class creates an instance of the DatabaseAccess class
    * and calls its methods to retrieve animal information. It then creates instances of each
    * animal type and calls their respective methods to calculate the total feeding and cage cleaning
    * times for each species. The main method also access MainGUI, ModifyScheduleGUI and Schedule
    * classes and provides user interactive GUI and termial to view, modify and generate schedule.
    * @param args the command-line arguments
    * @throws IOException
    * @throws InterruptedException
    */
    public static void main(String[] args) throws IOException, InterruptedException {
        // inform the user the application began
        System.out.println();
        System.out.println("Welcome to EWR Schedule Application");
        System.out.println();
        System.out.println("Creating Schedule.....");
        System.out.println();

        // create connection to SQL database
        DatabaseAccess dbAccess = new DatabaseAccess();
        dbAccess.createConnection();
        
        // get animalID of all animals
        ArrayList<Integer> animalID = dbAccess.getAnimalID();

        // get animalID of non-orphaned animals
        ArrayList<Integer> notOrphaned = dbAccess.getNonOrphanedAnimals();

        // get total feeding time for non-orphaned beavers
        int numNonOrphanedBeavers = dbAccess.countNonOrphanedBeavers(notOrphaned);
        Beaver beaver = new Beaver();
        int beaverTotalFeedTime = beaver.getTotalFeedTime(numNonOrphanedBeavers); 

        // get total feeding time for non-orphaned coyotes
        int numNonOrphanedCoyotes = dbAccess.countNonOrphanedCoyotes(notOrphaned);
        Coyote coyote = new Coyote();
        int coyoteTotalFeedTime = coyote.getTotalFeedTime(numNonOrphanedCoyotes);

        // get total feeding time for non-orphaned foxes
        int numNonOrphanedFoxes = dbAccess.countNonOrphanedFoxes(notOrphaned);
        Fox fox = new Fox();
        int foxTotalFeedTime = fox.getTotalFeedTime(numNonOrphanedFoxes);

        // get total feeding time for non-orphaned porcupines
        int numNonOrphanedPorcupines = dbAccess.countNonOrphanedPorcupines(notOrphaned);
        Porcupine porcupine = new Porcupine();
        int porcupineTotalFeedTime = porcupine.getTotalFeedTime(numNonOrphanedPorcupines);

        // get total feeding time for non-orphaned racoons
        int numNonOrphanedRacoons = dbAccess.countNonOrphanedRacoons(notOrphaned);
        Racoon racoon = new Racoon();
        int racoonTotalFeedTime = racoon.getTotalFeedTime(numNonOrphanedRacoons);
        
        // get total cage cleaning time for beavers
        int numTotalBeavers = dbAccess.countTotalBeavers(animalID);
        int beaverTotalCageCleanTime = beaver.getTotalCageCleanTime(numTotalBeavers);

        // get total cage cleaning time for coyotes
        int numTotalCoyotes = dbAccess.countTotalCoyotes(animalID);
        int coyoteTotalCageCleanTime = coyote.getTotalCageCleanTime(numTotalCoyotes);

        // get total cage cleaning time for foxes
        int numTotalFoxes = dbAccess.countTotalFoxes(animalID);
        int foxTotalCageCleanTime = fox.getTotalCageCleanTime(numTotalFoxes);

        // get total cage cleaning time for porcupines
        int numTotalPorcupines = dbAccess.countTotalPorcupines(animalID);
        int porcupineTotalCageCleanTime = porcupine.getTotalCageCleanTime(numTotalPorcupines);

        // get total cage cleaning time for racoons
        int numTotalRacoons = dbAccess.countTotalRacoons(animalID);
        int racoonTotalCageCleanTime = racoon.getTotalCageCleanTime(numTotalRacoons);

        // create 'Schedule' table in database
        dbAccess.createScheduleTable();

        // insert data from 'Treatments' table into 'Schedule' table in database
        dbAccess.initialScheduleTable();

        // create an ArrayList of all species' names
        ArrayList<String> species = new ArrayList<String>();
        species.add("Beaver");
        species.add("Coyote");
        species.add("Fox");
        species.add("Porcupine");
        species.add("Racoon");

        // create an ArrayList of total feeding time requried for all species
        ArrayList<Integer> feedingSchedule = new ArrayList<Integer>();
        feedingSchedule.add(beaverTotalFeedTime); 
        feedingSchedule.add(coyoteTotalFeedTime);
        feedingSchedule.add(foxTotalFeedTime);
        feedingSchedule.add(porcupineTotalFeedTime); 
        feedingSchedule.add(racoonTotalFeedTime);

        // insert feeding schedule of all species to available time slots
        dbAccess.insertFeedingSchedule(species, feedingSchedule);

        // create an ArrayList of total cage cleaning time required for all species
        ArrayList<Integer> cageCleaningSchedule = new ArrayList<Integer>();
        cageCleaningSchedule.add(beaverTotalCageCleanTime); 
        cageCleaningSchedule.add(coyoteTotalCageCleanTime);
        cageCleaningSchedule.add(foxTotalCageCleanTime);
        cageCleaningSchedule.add(porcupineTotalCageCleanTime); 
        cageCleaningSchedule.add(racoonTotalCageCleanTime);

        // insert cage cleaning schedule of all species to available time slots
        dbAccess.insertCageCleaningSchedule(species, cageCleaningSchedule);

        // check if overflow has occurred in any time slot
        ArrayList<String> overflowTime = dbAccess.checkOverflow();
        
        // if overflow occurred, inform the user in which time slot 
        // the overflow occurred and display the entire schedule 
        Schedule schedule = new Schedule();
        if (overflowTime.size() != 0) {
            schedule.overflow(overflowTime);
            dbAccess.showSchedule();
            System.out.println();
            
            // prompt the user to options to modify schedule, contact backup volunteer or to generate final schedule
            boolean continueLoop = true;

            // Creating a new GUI and making it visible
            new MainGUI();
            new ModifyScheduleGUI();

            while (continueLoop) {
                MainGUI.setVisibility(true);

                // if the Modify Schedule button is pressed, the jframe is made not visible and
                // the modifySchedule method is called from the Schedule class
                if (MainGUI.pressedModifyBtn()) {
                	MainGUI.setVisibility(false); 
                    ModifyScheduleGUI.setVisibility(true);

                    while (!ModifyScheduleGUI.isSubmitPressed()) {
                        // Wait for user to submit input
                        Thread.sleep(100);
                    } 
                
                    // Get queryInfo from ModifyScheduleGUI and edit database
                    ArrayList<String> queryInfo = new ArrayList<String>();
                    queryInfo = schedule.modifySchedule();                
                    dbAccess.editDatabase(queryInfo);
                                    
                    ModifyScheduleGUI.setVisibility(false);
                    ModifyScheduleGUI.setNotSubmitPressed();

                    System.out.println();
                    dbAccess.showSchedule();
                    System.out.println();
                
                // if the Generate Schedule button is pressed, the jframe is made not visible and
                // the schedule will be made and exported to the user's device as a .csv file (excel file)
                } else if (MainGUI.pressedScheduleBtn()) {
                	MainGUI.setVisibility(false);
                    dbAccess.exportSchedule();
                    continueLoop = false;

                // if the Volunteer button is pressed, the jframe is made not visible and
                // there will be a message window informing the user that the volunteer has been contacted
                // when the message window closes, the user is prompt to enter file output path in terminal
                // and the final schedule is exported to the user's devie as a .csv file (excel file)
                } else if (MainGUI.pressedVolunteerBtn()) {
                	MainGUI.setVisibility(false);
                    JOptionPane.showMessageDialog(null, "A backup volunteer has been contacted.");

                    continueLoop = false;
                    dbAccess.exportSchedule();
                }
            }           
        } else {
            dbAccess.exportSchedule();            
        }

        // close connection
        dbAccess.close();
    }
} //End of class
    