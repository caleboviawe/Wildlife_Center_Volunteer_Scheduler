/**
 * @author GYURIN (JANE) MO, CALEB OVIAWE, YANISA SRISA-ARD, EMIKO EMIKO
 * @version 2.1
 * @since 1.1
*/

package edu.ucalgary.oop;

/* This DatabaseAccess class is used to access the sql database.
*  Its methods use queries to retrieve data from the database.
*  The data retrieved includes the animal IDs, the number of each species, 
*  tasks IDs, task descriptions, timing of the tasks, and other helpers that
*  that aid in forming the schedule.
*/

import java.sql.*;
import java.util.*;
import java.io.*;

public class DatabaseAccess{

  /*
   * This variable represents the connection to the database.
   */
  private Connection dbConnect;

  /*
   * This variable represents the results of a query.
   */
  private ResultSet results;

  public DatabaseAccess(){}

  /*
   * Creates a connection to the database.
   */
  public void createConnection(){
    try{
      dbConnect = DriverManager.getConnection(
      "jdbc:mysql://localhost/EWR", "oop", "password");
    } catch (SQLException e){
        e.printStackTrace();
    }
  }

  /**
   * Returns the IDs of all animals from the database.
   * @return An array list of integers representing the IDs of all animals from the database.
   */
  public ArrayList<Integer> getAnimalID() {
    ArrayList<Integer> animalID = new ArrayList<Integer>();
    try {
      Statement myStmt = dbConnect.createStatement();
      results = myStmt.executeQuery("SELECT * FROM animals");

      while(results.next()) {
        animalID.add(results.getInt("AnimalID"));
      }
      myStmt.close();
    } catch (SQLException e) {
    e.printStackTrace();
    }
    return animalID;
  }

  /**
   * Returns the IDs of all non-orphaned animals from the database.
   * @return An array list of integers representing the IDs of all non-orphaned animals from the database.
   */
  public ArrayList<Integer> getNonOrphanedAnimals() {
    ArrayList<Integer> nonOrphaned = new ArrayList<Integer>();
    try {
      Statement myStmt = dbConnect.createStatement();
      String query = "SELECT AnimalID FROM treatments WHERE TaskID != 1";
      results = myStmt.executeQuery(query);

      while(results.next()) {
        nonOrphaned.add(results.getInt("AnimalID"));
      }

      HashSet<Integer> temp = new HashSet<Integer>(nonOrphaned);
      nonOrphaned.clear();
      nonOrphaned.addAll(temp);

      myStmt.close();
    } catch (SQLException e) {
    e.printStackTrace();
    }
    return nonOrphaned;
  }

  /**
   * Counts the number of non-orphaned beavers from the database.
   * @param notOrphaned  An array list of integers representing the IDs of all non-orphaned animals from the database.
   * @return An integer representing the number of non-orphaned beavers from the database.
   */
  public int countNonOrphanedBeavers(ArrayList<Integer> notOrphaned) {
    ArrayList<Integer> beavers = new ArrayList<Integer>();
    ArrayList<Integer> overlap = new ArrayList<Integer>();
    try {
      Statement myStmt = dbConnect.createStatement();
      String query = "SELECT AnimalID FROM animals WHERE AnimalSpecies = 'beavers'";
      results = myStmt.executeQuery(query);

      while(results.next()) {
        beavers.add(results.getInt("AnimalID"));
      }
      myStmt.close();
    } catch (SQLException e) {
    e.printStackTrace();
    }

    for (Integer id : notOrphaned) {
      if (beavers.contains(id)) {
          overlap.add(id);
      }
    }
    int numBeavers = overlap.size();
    return numBeavers;
  }

  /**
   * Counts the number of non-orphaned coyotes from the database.
   * @param notOrphaned An array list of integers representing the IDs of all non-orphaned animals from the database.
   * @return An integer representing the number of non-orphaned coyotes from the database.
   */
  public int countNonOrphanedCoyotes(ArrayList<Integer> notOrphaned) {
    ArrayList<Integer> coyotes = new ArrayList<Integer>();
    ArrayList<Integer> overlap = new ArrayList<Integer>();
    try {
      Statement myStmt = dbConnect.createStatement();
      String query = "SELECT AnimalID FROM animals WHERE AnimalSpecies = 'coyote'";
      results = myStmt.executeQuery(query);

      while(results.next()) {
        coyotes.add(results.getInt("AnimalID"));
      }
      myStmt.close();
    } catch (SQLException e) {
    e.printStackTrace();
    }

    for (Integer id : notOrphaned) {
      if (coyotes.contains(id)) {
          overlap.add(id);
      }
    }
    int numCoyotes = overlap.size();
    return numCoyotes;
  }

  /**
   * Counts the number of non-orphaned foxes from the database.
   * @param notOrphaned An array list of integers representing the IDs of all non-orphaned animals from the database. 
   * @return An integer representing the number of non-orphaned foxes from the database.
   */
  public int countNonOrphanedFoxes(ArrayList<Integer> notOrphaned) {
    ArrayList<Integer> foxes = new ArrayList<Integer>();
    ArrayList<Integer> overlap = new ArrayList<Integer>();
    try {
      Statement myStmt = dbConnect.createStatement();
      String query = "SELECT AnimalID FROM animals WHERE AnimalSpecies = 'fox'";
      results = myStmt.executeQuery(query);

      while(results.next()) {
        foxes.add(results.getInt("AnimalID"));
      }
      myStmt.close();
    } catch (SQLException e) {
    e.printStackTrace();
    }

    for (Integer id : notOrphaned) {
      if (foxes.contains(id)) {
          overlap.add(id);
      }
    }
    int numFoxes = overlap.size();
    return numFoxes;
  }

  /**
   * Counts the number of non-orphaned porcupines from the database.
   * @param notOrphaned An array list of integers representing the IDs of all non-orphaned animals from the database.
   * @return An integer representing the number of non-orphaned porcupines from the database.
   */
  public int countNonOrphanedPorcupines(ArrayList<Integer> notOrphaned) {
    ArrayList<Integer> porcupines = new ArrayList<Integer>();
    ArrayList<Integer> overlap = new ArrayList<Integer>();
    try {
      Statement myStmt = dbConnect.createStatement();
      String query = "SELECT AnimalID FROM animals WHERE AnimalSpecies = 'porcupine'";
      results = myStmt.executeQuery(query);

      while(results.next()) {
        porcupines.add(results.getInt("AnimalID"));
      }
      myStmt.close();
    } catch (SQLException e) {
    e.printStackTrace();
    }

    for (Integer id : notOrphaned) {
      if (porcupines.contains(id)) {
          overlap.add(id);
      }
    }
    int numPorcupines = overlap.size();
    return numPorcupines;
  }

  /**
   * Counts the number of non-orphaned racoons from the database.
   * @param notOrphaned An array list of integers representing the IDs of all non-orphaned animals from the database.
   * @return An integer representing the number of non-orphaned racoons from the database.
   */
  public int countNonOrphanedRacoons(ArrayList<Integer> notOrphaned) {
    ArrayList<Integer> racoons = new ArrayList<Integer>();
    ArrayList<Integer> overlap = new ArrayList<Integer>();
    try {
      Statement myStmt = dbConnect.createStatement();
      String query = "SELECT AnimalID FROM animals WHERE AnimalSpecies = 'racoon'";
      results = myStmt.executeQuery(query);

      while(results.next()) {
        racoons.add(results.getInt("AnimalID"));
      }
      myStmt.close();
    } catch (SQLException e) {
    e.printStackTrace();
    }

    for (Integer id : notOrphaned) {
      if (racoons.contains(id)) {
          overlap.add(id);
      }
    }
    int numRacoons = overlap.size();
    return numRacoons;
  }

  /**
   * Counts the total number of beavers from the database.
   * @param animalID An ArrayList of all animal IDs.
   * @return An integer representing the number of beavers from the database.
   */
  public int countTotalBeavers(ArrayList<Integer> animalID) {
    ArrayList<Integer> beavers = new ArrayList<Integer>();
    try {
      Statement myStmt = dbConnect.createStatement();
      String query = "SELECT AnimalID FROM animals WHERE AnimalSpecies = 'beavers'";
      results = myStmt.executeQuery(query);

      while(results.next()) {
        beavers.add(results.getInt("AnimalID"));
      }
      myStmt.close();
    } catch (SQLException e) {
    e.printStackTrace();
    }
    int numBeavers = beavers.size();
    return numBeavers;
  }

  /**
   * Counts the total number of coyotes from the database.
   * @param animalID An ArrayList of all animal IDs.
   * @return An integer representing the total number of coyotes from the database.
   */
  public int countTotalCoyotes(ArrayList<Integer> animalID) {
    ArrayList<Integer> coyotes = new ArrayList<Integer>();
    try {
      Statement myStmt = dbConnect.createStatement();
      String query = "SELECT AnimalID FROM animals WHERE AnimalSpecies = 'coyote'";
      results = myStmt.executeQuery(query);

      while(results.next()) {
        coyotes.add(results.getInt("AnimalID"));
      }
      myStmt.close();
    } catch (SQLException e) {
    e.printStackTrace();
    }
    int numCoyotes = coyotes.size();
    return numCoyotes;
  }

  /**
   * Counts the total number of foxes from the database.
   * @param animalID An ArrayList of all animal IDs.
   * @return An integer representing the total number of foxes from the database.
   */
  public int countTotalFoxes(ArrayList<Integer> animalID) {
    ArrayList<Integer> foxes = new ArrayList<Integer>();
    try {
      Statement myStmt = dbConnect.createStatement();
      String query = "SELECT AnimalID FROM animals WHERE AnimalSpecies = 'fox'";
      results = myStmt.executeQuery(query);

      while(results.next()) {
        foxes.add(results.getInt("AnimalID"));
      }
      myStmt.close();
    } catch (SQLException e) {
    e.printStackTrace();
    }
    int numFoxes = foxes.size();
    return numFoxes;
  }

  /**
   * Counts the total number of porcupines from the database.
   * @param animalID An ArrayList of animal all IDs.
   * @return An integer representing the total number of porcupines from the database.
   */
  public int countTotalPorcupines(ArrayList<Integer> animalID) {
    ArrayList<Integer> porcupines = new ArrayList<Integer>();
    try {
      Statement myStmt = dbConnect.createStatement();
      String query = "SELECT AnimalID FROM animals WHERE AnimalSpecies = 'porcupine'";
      results = myStmt.executeQuery(query);

      while(results.next()) {
        porcupines.add(results.getInt("AnimalID"));
      }
      myStmt.close();
    } catch (SQLException e) {
    e.printStackTrace();
    }
    int numPorcupines = porcupines.size();
    return numPorcupines;
  }

  /**
   * Counts the total number of racoons from the database.
   * @param animalID An ArrayList of all animal IDs.
   * @return An integer representing the total number of racoons from the database.
   */
  public int countTotalRacoons(ArrayList<Integer> animalID) {
    ArrayList<Integer> racoons = new ArrayList<Integer>();
    try {
      Statement myStmt = dbConnect.createStatement();
      String query = "SELECT AnimalID FROM animals WHERE AnimalSpecies = 'racoon'";
      results = myStmt.executeQuery(query);

      while(results.next()) {
        racoons.add(results.getInt("AnimalID"));
      }
      myStmt.close();
    } catch (SQLException e) {
    e.printStackTrace();
    }
    int numRacoons = racoons.size();
    return numRacoons;
  }

  /**
   * Creates a table for each hour of the day in the database.
   */
  public void createScheduleTable() {
    for (int i=0; i < 24; i++){
      try {
        String query1 = "DROP TABLE IF EXISTS StartTime" + Integer.toString(i);
        PreparedStatement myStmt1 = dbConnect.prepareStatement(query1);
        myStmt1.executeUpdate(query1);
  
        String query2 = "CREATE TABLE StartTime" + Integer.toString(i) + "(" +
                        "RowID          int not null," +
                        "Description    varchar(50)," +
                        "TimeSpent      int not null," +
                        "TimeRemaining  int not null," +
                        "primary key (RowID)" +
                        ")";
        
        PreparedStatement myStmt2 = dbConnect.prepareStatement(query2);
        myStmt2.executeUpdate(query2);
      
        myStmt1.close();
        myStmt2.close();
      } catch (SQLException e) {
      e.printStackTrace();
      }
    }
  }
  
  /**
   * Returns the IDs of the tasks that are scheduled for a given hour.
   * @param startHour An integer representing the hour of the day.
   * @return An ArrayList of integers representing the IDs of the tasks scheduled for a given hour.
   */
  public ArrayList<Integer> getTaskIDFromTreatments(int startHour) {
    ArrayList<Integer> taskID = new ArrayList<>();
    try {
      Statement myStmt = dbConnect.createStatement();
      String query = "SELECT TaskID FROM treatments WHERE StartHour =" + Integer.toString(startHour);
      results = myStmt.executeQuery(query);
  
      while(results.next()) {
        taskID.add(results.getInt("TaskID"));
      }
      myStmt.close();
    } catch (SQLException e) {
    e.printStackTrace();
    }
    return taskID;    
  }

  /**
   * Returns the descriptions of the tasks that are scheduled for a given hour.
   * @param taskID An ArrayList of integers representing the IDs of the tasks scheduled for a given hour.
   * @return An ArrayList of strings representing the descriptions of the tasks scheduled for a given hour.
   */
  public ArrayList<String> getDescriptionFromTasks(ArrayList<Integer> taskID) { 
    ArrayList<String> description = new ArrayList<>();
    for (int id : taskID){
      try {
        Statement myStmt = dbConnect.createStatement();
        String query = "SELECT Description FROM tasks WHERE TaskID = " + id;
        results = myStmt.executeQuery(query);
  
        while(results.next()) {
          description.add(results.getString("Description"));
        }
        myStmt.close();
      } catch (SQLException e) {
      e.printStackTrace();
      }
    }
    return description;
  }

  /**
   * Returns a task description of a chosen row in a chosen hour's schedule table from the database.
   * @param rowID A string representation of a rowID to retreive task description from.
   * @param time A string representation of chosen hour to specify table in the database.
   * @return A string representing the task description of the chosen rowID and time.
   */
  public String getDescriptionFromTable(String rowID, String time) { 
    String description = "";
      try {
        Statement myStmt = dbConnect.createStatement();
        String query = "SELECT Description FROM starttime" + time + " WHERE RowID = " + rowID;
        results = myStmt.executeQuery(query);
  
        while(results.next()) {
          description = results.getString("Description");
        }
        myStmt.close();
      } catch (SQLException e) {
      e.printStackTrace();
      }
    return description;
  }
  
  /**
   * Returns the durations of the tasks that are scheduled for a given hour.
   * @param taskID An ArrayList of integers representing the IDs of the tasks scheduled for a given hour.
   * @return An ArrayList of integers representing the durations of the tasks scheduled for a given hour.
   */
  public ArrayList<Integer> getDurationFromTasks(ArrayList<Integer> taskID) { 
    ArrayList<Integer> duration = new ArrayList<>();
    for (int id : taskID){
      try {
        Statement myStmt = dbConnect.createStatement();
        String query = "SELECT Duration FROM tasks WHERE TaskID = " + id;
        results = myStmt.executeQuery(query);
  
        while(results.next()) {
          duration.add(results.getInt("Duration"));
        }
        myStmt.close();
      } catch (SQLException e) {
      e.printStackTrace();
      }
    }
    return duration;
  }  

  /**
   * Returns a task duration associated with the chosen task description.
   * @param desc A string representing a task description.
   * @return An integer representing task duration associated with the chosen task description.
   */
  public int getDurationFromTasks(String desc) { 
    int duration = 0;
    try {
      Statement myStmt = dbConnect.createStatement();
      String query = "SELECT Duration FROM tasks WHERE Description = '" + desc + "'";
      results = myStmt.executeQuery(query);
  
      while(results.next()) {
        duration = results.getInt("Duration");
      }
      myStmt.close();
      } catch (SQLException e) {
      e.printStackTrace();
      }
    return duration;
  }  

  /**
   * Calculates the time remaining for each task scheduled for a given hour.
   * @param duration An ArrayList of integers representing the durations of the tasks scheduled for a given hour.
   * @return An ArrayList of integers representing the time remaining for each task scheduled for a given hour.
   */
  public ArrayList<Integer> calculateTimeRemaining(ArrayList<Integer> duration) {
    ArrayList<Integer> timeRemaining = new ArrayList<>();
    int temp = 60;
    for (int i=0; i < duration.size(); i++) {
      temp -= duration.get(i);
      timeRemaining.add(temp);
    }
    return timeRemaining;
  }

  /**
   * Inserts the tasks scheduled for a given hour into the database.
   */
  public void initialScheduleTable() {
    for(int i=0; i < 24; i++) {   
      ArrayList<Integer> taskID = getTaskIDFromTreatments(i);
      ArrayList<String> description = getDescriptionFromTasks(taskID);
      ArrayList<Integer> duration = getDurationFromTasks(taskID);
      ArrayList<Integer> timeRemaining = calculateTimeRemaining(duration);
      try{
        String query = "INSERT INTO StartTime" + Integer.toString(i) + 
                       "(RowID, Description, TimeSpent, TimeRemaining) VALUES (?,?,?,?)";
        PreparedStatement myStmt = dbConnect.prepareStatement(query);
        
        for (int j=0; j < taskID.size(); j++) {
          
          myStmt.setInt(1, j+1);
          myStmt.setString(2, description.get(j));
          myStmt.setInt(3, duration.get(j));
          myStmt.setInt(4, timeRemaining.get(j));
          myStmt.executeUpdate();
        }
        myStmt.close();   
      } catch (SQLException e) {
      e.printStackTrace();
      }
    }
  }

  /**
   * Inserts the feeding schedule into the database for a given species.
   * @param species An ArrayList of strings representing the species to be fed.
   * @param feedingSchedule An ArrayList of integers representing the feeding schedule for a given species.
   */
  public void insertFeedingSchedule(ArrayList<String> species, ArrayList<Integer> feedingSchedule) {
    for (int i=0; i < feedingSchedule.size(); i++) {
      if (feedingSchedule.get(i) != 0) {
        int[] feedWindow = getFeedWindow(species.get(i));
        
        ArrayList<Integer> availableTime = getAvailableTime(feedWindow);

        for(int j=0; j < availableTime.size(); j++) {        
          if (availableTime.get(j) > feedingSchedule.get(i)) {
            try{
              String query = "INSERT INTO StartTime" + Integer.toString(feedWindow[j]) + 
                             "(RowID, Description, TimeSpent, TimeRemaining) VALUES (?,?,?,?)";
              PreparedStatement myStmt = dbConnect.prepareStatement(query);
              
              int rowID = getRowNum(Integer.toString(feedWindow[j]));
              myStmt.setInt(1, rowID + 1);
              myStmt.setString(2,"Feed " + species.get(i));
              myStmt.setInt(3, feedingSchedule.get(i));
              myStmt.setInt(4, availableTime.get(j) - feedingSchedule.get(i));
              myStmt.executeUpdate();

              myStmt.close();   
            } catch (SQLException e) {
            e.printStackTrace();
            }
            break;
          }        
        }
      }
    }  
  }

  /**
   * Returns the available time in the selected feed window for a given species.
   * @param species A string representing the species
   * @return An array of integers representing the available time in the selected feed window for a given species.
   */
  public int[] getFeedWindow(String species) {
    int[] feedWindow = {};
    if (species == "Beaver") {
      Beaver beaver = new Beaver();
      feedWindow = beaver.getFeedWindow();
    }
    if (species == "Coyote") {
      Coyote coyote = new Coyote();
      feedWindow = coyote.getFeedWindow();
    }
    if (species == "Fox") {
      Fox fox = new Fox();
      feedWindow = fox.getFeedWindow();
    }
    if (species == "Porcupine") {
      Porcupine porcupine = new Porcupine();
      feedWindow = porcupine.getFeedWindow();
    }
    if (species == "Racoon") {
      Racoon racoon = new Racoon();
      feedWindow = racoon.getFeedWindow();
    }
    return feedWindow;
  }

  /**
   * Returns the available time in the selected feed window.
   * @param feedWindow An array of integers representing the selected feed window.
   * @return An ArrayList of integers representing the available time in the selected feed window.
   */
  public ArrayList<Integer> getAvailableTime(int[] feedWindow) {
    ArrayList<Integer> availableTime = new ArrayList<Integer>();
    for (int i=0; i < feedWindow.length; i++) {    
      try {
        Statement myStmt = dbConnect.createStatement();
        String query = "SELECT TimeRemaining FROM StartTime" + Integer.toString(feedWindow[i]) + 
                       " ORDER BY TimeRemaining LIMIT 1";
        results = myStmt.executeQuery(query);
        
        if (results.next()){
          availableTime.add(results.getInt("TimeRemaining"));
        } else {
          availableTime.add(60);
        }
        myStmt.close();
      } catch (SQLException e) {
      e.printStackTrace();
      }
    }
    return availableTime;
  }
  
  /**
   * Inserts the cage cleaning schedule into the database for a given species.
   * @param species An ArrayList of strings representing the species.
   * @param cageCleaningSchedule An ArrayList of integers representing the cage cleaning schedule.
   */
  public void insertCageCleaningSchedule(ArrayList<String> species, ArrayList<Integer> cageCleaningSchedule) {
    for (int i=0; i < cageCleaningSchedule.size(); i++) {        
      if (cageCleaningSchedule.get(i) != 0) {     
        ArrayList<Integer> availableTime = getAvailableTime();
        for (int j=0; j < 24; j++) {    
          if (availableTime.get(j) > cageCleaningSchedule.get(i)) {
            try{
              String query = "INSERT INTO StartTime" + Integer.toString(j) + 
                             "(RowID, Description, TimeSpent, TimeRemaining) VALUES (?,?,?,?)";
              PreparedStatement myStmt = dbConnect.prepareStatement(query);
              
              int rowID = getRowNum(Integer.toString(j));
              myStmt.setInt(1, rowID + 1);
              myStmt.setString(2,"Clean " + species.get(i) + " cage");
              myStmt.setInt(3, cageCleaningSchedule.get(i));
              myStmt.setInt(4, availableTime.get(j) - cageCleaningSchedule.get(i));
              myStmt.executeUpdate();
   
            } catch (SQLException e) {
            e.printStackTrace();
            }
            break;
          }        
        }
      }
    }  
  }

  /**
   * Returns the available time in all time slots (from hour 0 to 23).
   * @return An ArrayList of integers representing the available time from all time slots.
   */
  public ArrayList<Integer> getAvailableTime() {
    ArrayList<Integer> availableTime = new ArrayList<Integer>();
    for (int j=0; j < 24; j++) {    
      try {
        Statement myStmt = dbConnect.createStatement();
        String query = "SELECT TimeRemaining FROM StartTime" + Integer.toString(j) + 
                       " ORDER BY TimeRemaining LIMIT 1";
        results = myStmt.executeQuery(query);
            
        if (results.next()){
          availableTime.add(results.getInt("TimeRemaining"));
        } else {
           availableTime.add(60);
        }
        myStmt.close();
      } catch (SQLException e) {
      e.printStackTrace();
      }
    }
    return availableTime;  
  }

  /**
   * Returns available time of a chosen hour.
   * @param time A string representing chosen hour to retrieve available time from.
   * @return An integer representing the available time in the chosen hour.
   */
  public int getAvailableTime(String time) {
    int remainingTime = 0;  
    try {
        Statement myStmt = dbConnect.createStatement();
        String query = "SELECT TimeRemaining FROM StartTime" + time + 
                       " ORDER BY TimeRemaining LIMIT 1";
        results = myStmt.executeQuery(query);
            
        if (results.next()){
          remainingTime = results.getInt("TimeRemaining");
        } else {
           remainingTime = 60;
        }
        myStmt.close();
      } catch (SQLException e) {
      e.printStackTrace();
      }
    
    return remainingTime;  
  }

  /**
   * Returns a number of rows being used in a time table of a chosen hour.
   * @param time A string representing chosen hour to retrieve information from.
   * @return An integer representing the number of rows occupied by data in the given hour's table.
   */
  public int getRowNum(String time) {
    int rowNum = 0;  
    try {
        Statement myStmt = dbConnect.createStatement();
        String query = "SELECT COUNT(*) FROM StartTime" + time;
        results = myStmt.executeQuery(query);
            
        if (results.next()){
          rowNum = results.getInt("COUNT(*)");
        } else {
           rowNum = 0;
        }
        myStmt.close();
      } catch (SQLException e) {
      e.printStackTrace();
      }
    return rowNum;  
  }

  /**
   * Checks if there is overflow in the schedule.
   * @return An ArrayList of integers representing the overflow in the schedule.
   */
  public ArrayList<String> checkOverflow() {
    ArrayList<Integer> overflow = new ArrayList<Integer>();
    for (int i=0; i < 24; i++) {
      try {
        Statement myStmt = dbConnect.createStatement();
        String query = "SELECT * FROM StartTime" + Integer.toString(i) + " WHERE TimeRemaining < 0";
        results = myStmt.executeQuery(query);
  
        while(results.next()) {
          overflow.add(i);
        }
        myStmt.close();
      } catch (SQLException e) {
      e.printStackTrace();
      }
    }
    HashSet<Integer> set = new HashSet<>(overflow);
    overflow.clear();
    overflow.addAll(set);

    ArrayList<String> overflowTime = new ArrayList<String>();
    for (int j=0; j < overflow.size(); j++){
      overflowTime.add(getTime(overflow.get(j)));
    }
    return overflowTime;
  }

  /**
   * Retrieve RowID, Description, TimeSpent and TimeRemaining from the database 
   * and insert the data in an excel file (.csv). Prompt the user to input a 
   * file output path to where the user wants to save the schedule.csv file.'
   * @throws IOException
   */
  public void exportSchedule() throws IOException {
    System.out.println("Schedule is created");
    System.out.println();
    System.out.print(
      "Please enter file output path to save schedule.csv file [ex) C:\\Users\\janem\\Desktop]: ");
    System.out.println();

    Scanner scanner2 = new Scanner(System.in);
    String fileOutputPath = scanner2.nextLine();

    PrintWriter writer = new PrintWriter(new FileWriter(fileOutputPath + "/schedule.csv"));
    
    try {
      Statement myStmt = dbConnect.createStatement();
      String query = "SELECT * FROM starttime0";
      results = myStmt.executeQuery(query);  
      
      int numColumns = results.getMetaData().getColumnCount();
      writer.print("Time");
      for (int j = 1; j <= numColumns; j++) {
        String header = results.getMetaData().getColumnName(j);
        writer.print(",");
        writer.print(header);
      }
      writer.println();

      for (int i=0; i < 24; i++) {
        writer.println();
        Statement myStmt2 = dbConnect.createStatement();
        String query2 = "SELECT * FROM starttime" + i;
        results = myStmt.executeQuery(query2);

        String time = getTime(i);
        writer.print(time);
        while (results.next()) {
          for (int k = 1; k <= numColumns; k++) {
            String value = results.getString(k);
            writer.print(",");            
            writer.print(value);
          }
          writer.println();
        }
        results.close();
        myStmt2.close();
      }
      writer.close();
    } catch (SQLException e) {
    e.printStackTrace();
    }
    System.out.println();
    System.out.println("schedule.cvs saved to your computer");
    System.out.println();
    System.out.println("Thank you for using EWR Schedule Application");

    scanner2.close();        
  }

  /**
   * Convert a time from 24 hour format to 12 hour format.
   * @param hour An integer representing the chosen hour in 24 hour format.
   * @return A string of the given hour in 12 hour format.
   */
  public String getTime(int hour) {
    String period = (hour >= 12) ? "PM" : "AM"; 
    int hour12 = (hour == 0 || hour == 12) ? 12 : hour % 12; 
    
    return hour12 + period;  
}

/**
   * Retrieve RowID, Description, TimeSpent and TimeRemaining from the 
   * database and display the entire schedule from 12AM to 11PM in terminal.
   */
  public void showSchedule() {
    try {     
      String output = String.format(
        "%-10s %-10s %-25s %-15s %-15s", 
        "Time", "RowID", "Description", "TimeSpent", "TimeRemaining");
      System.out.println(output);

      for (int i=0; i < 24; i++) {
        System.out.println(
        "---------------------------------------------------------------------------------");
        String time = getTime(i);
        System.out.println(time);

        Statement myStmt = dbConnect.createStatement();
        String query = "SELECT * FROM starttime" + i;
        results = myStmt.executeQuery(query);

        int numColumns = results.getMetaData().getColumnCount();
        while (results.next()) {
          ArrayList<String> rowData = new ArrayList<String>();
          for (int k = 1; k <= numColumns; k++) {
            String value = results.getString(k); 
            rowData.add(value);
          }
       
          String space = "";
          String rowID = rowData.get(0);
          String description = rowData.get(1);
          String timeSpent = rowData.get(2);
          String timeRemaining = rowData.get(3);

          output = String.format(
            "%-10s %-10s %-25s %-15s %-15s", 
            space, rowID, description, timeSpent, timeRemaining);
          System.out.println(output);
          
        }
        results.close();
        myStmt.close();
      }
    } catch (SQLException e) {
    e.printStackTrace();
    }
  }

  /**
   * Edits tasks in the database by deleting user chosen row from user chosen 
   * hour table and adding user chosen row to user chosen hour table.
   * @param queryInfo A String ArrayList consists of rowID, initialTime and newTime from user inputs.
   */
  public void editDatabase(ArrayList<String> queryInfo) {
    
    String rowID = queryInfo.get(0);
    String initialTime = queryInfo.get(1);
    String newTime = queryInfo.get(2);

    String description = getDescriptionFromTable(rowID, initialTime);
    
    try{
      String query = "DELETE FROM starttime" + initialTime + " WHERE RowID = " + rowID;
      PreparedStatement myStmt = dbConnect.prepareStatement(query);
      myStmt.executeUpdate();

      int rowNum = getRowNum(newTime) + 1;
      System.out.println(rowNum);

      int duration = getDurationFromTasks(description);
      int availableTime = getAvailableTime(newTime);

      String query2 = "INSERT INTO StartTime" + newTime + 
                     "(RowID, Description, TimeSpent, TimeRemaining) VALUES (?,?,?,?)";
      PreparedStatement myStmt2 = dbConnect.prepareStatement(query2);

      myStmt2.setInt(1, rowNum);
      myStmt2.setString(2, description);
      myStmt2.setInt(3, duration);
      myStmt2.setInt(4, availableTime - duration);
      myStmt2.executeUpdate();      

      myStmt2.close();
      myStmt.close();   
    } catch (SQLException e) {
    e.printStackTrace();
    }
  }      

  /**
   * Closes the database connection.
   */
  public void close() {
    try {
        results.close();
        dbConnect.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
  }
}//End of class  
  
