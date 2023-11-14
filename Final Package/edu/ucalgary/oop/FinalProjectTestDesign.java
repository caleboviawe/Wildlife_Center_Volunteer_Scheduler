/**
 * @author GYURIN (JANE) MO, CALEB OVIAWE, YANISA SRISA-ARD, EMIKO EMIKO
 * @version 1.12
 * @since 1.0
 */

package edu.ucalgary.oop;

/**
 * This class is where the testing of our classes takes place.
 * The files that include the GUI and the access to the database are not tested. 
 */

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.Arrays;

public class FinalProjectTestDesign{

    /**
     * This is a new Coyote object for testing.
     */
    public Coyote coyoteTestObject = new Coyote();
    
    /**
     * This is a new Porcupine object for testing.
     */
    public Porcupine porcupineTestObject = new Porcupine();
    
    /**
     * This is a new Fox object for testing.
     */
    public Fox foxTestObject = new Fox();
    
    /**
     * This is a new Raccoon object for testing.
     */
    public Racoon racoonTestObject = new Racoon();
    
    /**
     * This is a new Beaver object for testing.
     */
    public Beaver beaverTestObject = new Beaver();

    /**
     * The default constructor for the FinalProjectTestDesign class.
     */
    public FinalProjectTestDesign() {}

    /**
     * Below are the tests for the Coyote class.
     */

    /**
     * This test checks if the method getFeedWindow returns the expected result for the Coyote class.
     */
    @Test
    public void testCoyoteGetFeedWindow(){
        int[] determinedFeedWindow = coyoteTestObject.getFeedWindow();
        int[] expectedFeedWindow = {19,20,21};
        assertEquals("Method getFeedWindow did not return the expected result:", 
        Arrays.toString(expectedFeedWindow), Arrays.toString(determinedFeedWindow));
        if (determinedFeedWindow.length < 0 || determinedFeedWindow.length > 3){
            throw new IllegalArgumentException("The determined feed window is the wrong size.");
        }
    }
    
    /**
     * This test checks if the method getPrepTime returns the expected result for the Coyote class.
     */
    @Test
    public void testCoyoteGetPrepTime(){
        int determinedPrepTime = coyoteTestObject.getPrepTime();
        int expectedPrepTime = 10;
        assertEquals("Method getPrepTime did not return the expected result:", 
        expectedPrepTime, determinedPrepTime);
    }

    /**
     * This test checks if the method getFeedTime returns the expected result for the Coyote class.
     */
    @Test
    public void testCoyoteGetFeedTime(){
        int determinedFeedTime = coyoteTestObject.getFeedTime();
        int expectedFeedTime = 5;
        assertEquals("Method getFeedTime did not return the expected result:", 
        expectedFeedTime, determinedFeedTime);
    }

    /**
     * This test checks if the method getCleanTime returns the expected result for the Coyote class.
     */
    @Test
    public void testCoyoteGetCleanTime(){
        int determinedCleanTime = coyoteTestObject.getCleanTime();
        int expectedCleanTime = 5;
        assertEquals("Method getCleanTime did not return the expected result:", 
        expectedCleanTime, determinedCleanTime);
    }

    /**
     * This test checks if the method getTotalFeedTime in the Coyote class throws an IllegalArgumentException when the argument is not an integer.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testCoyoteGetTotalFeedTimeWrongArgType() throws IllegalArgumentException {
        coyoteTestObject.getTotalFeedTime(-1); // should throw an IllegalArgumentException
    }
    
    
    /**
     * This test checks if the method getTotalFeedTime returns the expected result for the Coyote class.
     */
    @Test
    public void testCoyoteGetTotalFeedTime() {
        int numNonOrphanedCoyotes = 4;
        int expectedTotalFeedTime = 30;
        int determinedTotalFeedTime = coyoteTestObject.getTotalFeedTime(numNonOrphanedCoyotes);
        assertEquals("Method getTotalFeedTime did not return the expected result:", expectedTotalFeedTime, determinedTotalFeedTime);
    }

    /**
     * This test checks if the method getTotalCageTime in the Coyote class throws an IllegalArgumentException when the argument is not an integer.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testCoyoteGetTotalCageCleanTimeWrongArgType() throws IllegalArgumentException {
        coyoteTestObject.getTotalCageCleanTime(-1); // should throw an IllegalArgumentException
    }
    
    /**
     * This test checks if the method getTotalCageCleanTime returns the expected result for the Coyote class.
     */
    @Test
    public void testCoyoteGetTotalCageCleanTime() {
        int numNonOrphanedCoyotes = 4;
        int expectedTotalCageCleanTime = 20;
        int determinedTotalCageCleanTime = coyoteTestObject.getTotalCageCleanTime(numNonOrphanedCoyotes);
        assertEquals("Method getTotalCageCleanTime did not return the expected result:", expectedTotalCageCleanTime, determinedTotalCageCleanTime);
    }


    /**
     * Below are the tests for the Porcupine class.
     */

    /**
     * This test checks if the method getFeedWindow returns the expected result for the Porcupine class.
     */
    @Test
    public void testPorcupineGetFeedWindow(){
        int[] determinedFeedWindow = porcupineTestObject.getFeedWindow();
        int[] expectedFeedWindow = {19, 20, 21};
        assertEquals("Method getFeedWindow did not return the expected result:", 
        Arrays.toString(expectedFeedWindow), Arrays.toString(determinedFeedWindow));
        if (determinedFeedWindow.length < 0 || determinedFeedWindow.length > 3){
            throw new IllegalArgumentException("The determined feed window is the wrong size.");
        }
    }
      
    /**
     * This test checks if the method getPrepTime returns the expected result for the Porcupine class.
     */
    @Test
    public void testPorcupineGetPrepTime(){
        int determinedPrepTime = porcupineTestObject.getPrepTime();
        int expectedPrepTime = 0;
        assertEquals("Method getPrepTime did not return the expected result:", 
        expectedPrepTime, determinedPrepTime);
    }
    
    /**
     * This test checks if the method getFeedTime returns the expected result for the Porcupine class.
     */
    @Test
    public void testPorcupineGetFeedTime(){
        int determinedFeedTime = porcupineTestObject.getFeedTime();
        int expectedFeedTime = 5;
        assertEquals("Method getFeedTime did not return the expected result:", 
        expectedFeedTime, determinedFeedTime);
    }
    
    /**
     * This test checks if the method getCleanTime returns the expected result for the Porcupine class.
     */
    @Test
    public void testPorcupineGetCleanTime(){
        int determinedCleanTime = porcupineTestObject.getCleanTime();
        int expectedCleanTime = 10;
        assertEquals("Method getCleanTime did not return the expected result:", 
        expectedCleanTime, determinedCleanTime);
    }

    /**
     * This test checks if the method getTotalFeedTime in the Porcupine class throws an IllegalArgumentException when the argument is not an integer.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testPorcupineGetTotalFeedTimeWrongArgType() throws IllegalArgumentException {
    porcupineTestObject.getTotalFeedTime(-1); // should throw an IllegalArgumentException
    }
    
    /**
     * This test checks if the method getTotalFeedTime returns the expected result for the Porcupine class.
     */
    @Test
    public void testPorcupineGetTotalFeedTime() {
        int numNonOrphanedPorcupines = 4;
        int expectedTotalFeedTime = 20;
        int determinedTotalFeedTime = porcupineTestObject.getTotalFeedTime(numNonOrphanedPorcupines);
        assertEquals("Method getTotalFeedTime did not return the expected result:", expectedTotalFeedTime, determinedTotalFeedTime);
    }

    /**
     * This test checks if the method getTotalCageTime in the Porcupine class throws an IllegalArgumentException when the argument is not an integer.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testPorcupineGetTotalCageCleanTimeWrongArgType() throws IllegalArgumentException {
    porcupineTestObject.getTotalCageCleanTime(-1); // should throw an IllegalArgumentException
    }
    
    /**
     * This test checks if the method getTotalCageCleanTime returns the expected result for the Porcupine class.
     */
    @Test
    public void testPorcupineGetTotalCageCleanTime() {
        int numNonOrphanedPorcupines = 4;
        int expectedTotalCageCleanTime = 40;
        int determinedTotalCageCleanTime = porcupineTestObject.getTotalCageCleanTime(numNonOrphanedPorcupines);
        assertEquals("Method getTotalCageCleanTime did not return the expected result:", expectedTotalCageCleanTime, determinedTotalCageCleanTime);
    }
    

    /**
     * Below are the tests for the Fox class.
     */
    
    /**
     * This test checks if the method getFeedWindow returns the expected result for the Fox class.
     */
    @Test
    public void testFoxGetFeedWindow(){
        int[] determinedFeedWindow = foxTestObject.getFeedWindow();
        int[] expectedFeedWindow = {0,1,2};
        assertEquals("Method getFeedWindow did not return the expected result:", 
        Arrays.toString(expectedFeedWindow), Arrays.toString(determinedFeedWindow));
        if (determinedFeedWindow.length < 0 || determinedFeedWindow.length > 3){
            throw new IllegalArgumentException("The determined feed window is the wrong size.");
        }
    }
        
    /**
     * This test checks if the method getPrepTime returns the expected result for the Fox class.
     */
    @Test
    public void testFoxGetPrepTime(){
        int determinedPrepTime = foxTestObject.getPrepTime();
        int expectedPrepTime = 5;
        assertEquals("Method getPrepTime did not return the expected result:", 
        expectedPrepTime, determinedPrepTime);
        }
    
    /**
     * This test checks if the method getFeedTime returns the expected result for the Fox class.
     */
    @Test
    public void testFoxGetFeedTime(){
        int determinedFeedTime = foxTestObject.getFeedTime();
        int expectedFeedTime = 5;
        assertEquals("Method getFeedTime did not return the expected result:", 
        expectedFeedTime, determinedFeedTime);
    }
    
    /**
     * This test checks if the method getCleanTime returns the expected result for the Fox class.
     */
    @Test
    public void testFoxGetCleanTime(){
        int determinedCleanTime = foxTestObject.getCleanTime();
        int expectedCleanTime = 5;
        assertEquals("Method getCleanTime did not return the expected result:", 
        expectedCleanTime, determinedCleanTime);
    }

    /**
     * This test checks if the method getTotalFeedTime in the Fox class throws an IllegalArgumentException when the argument is not an integer.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testFoxGetTotalFeedTimeWrongArgType() throws IllegalArgumentException{
        foxTestObject.getTotalFeedTime(-1); // should throw an IllegalArgumentException
    }
    
    /**
     * This test checks if the method getTotalFeedTime returns the expected result for the Fox class.
     */
    @Test
    public void testFoxGetTotalFeedTime() {
        int numNonOrphanedFoxes = 4;
        int expectedTotalFeedTime = 25;
        int determinedTotalFeedTime = foxTestObject.getTotalFeedTime(numNonOrphanedFoxes);
        assertEquals("Method getFeedTime did not return the expected result:", expectedTotalFeedTime, determinedTotalFeedTime);
    }

    /**
     * This test checks if the method getTotalCageTime in the Fox class throws an IllegalArgumentException when the argument is not an integer.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testFoxGetTotalCageCleanTimeWrongArgType() throws IllegalArgumentException{
        foxTestObject.getTotalCageCleanTime(-1); // should throw an IllegalArgumentException
    }

    /**
     * This test checks if the method getTotalCageCleanTime returns the expected result for the Fox class.
     */
    @Test
    public void testFoxGetTotalCageCleanTime() {
        int numNonOrphanedFoxes = 4;
        int expectedTotalCageCleanTime = 20;
        int determinedTotalCageCleanTime = foxTestObject.getTotalCageCleanTime(numNonOrphanedFoxes);
        assertEquals("Method getTotalCageCleanTime did not return the expected result:", expectedTotalCageCleanTime, determinedTotalCageCleanTime);
    }

    /**
     * Below are the tests for the Racoon class.
     */
    
    /**
     * This test checks if the method getFeedWindow returns the expected result for the Racoon class
     */
     @Test
    public void testRacoonGetFeedWindow(){
        int[] determinedFeedWindow = racoonTestObject.getFeedWindow();
        int[] expectedFeedWindow = {0,1,2};
        assertEquals("Method getFeedWindow did not return the expected result:", 
        Arrays.toString(expectedFeedWindow), Arrays.toString(determinedFeedWindow));
        if (determinedFeedWindow.length < 0 || determinedFeedWindow.length > 3){
            throw new IllegalArgumentException("The determined feed window is the wrong size.");
        }
    }
        
    /**
     * This test checks if the method getPrepTime returns the expected result for the Racoon class.
     */
    @Test
    public void testRacoonGetPrepTime(){
        int determinedPrepTime = racoonTestObject.getPrepTime();
        int expectedPrepTime = 0;
        assertEquals("Method getPrepTime did not return the expected result:", 
        expectedPrepTime, determinedPrepTime);
    }
    
    /**
     * This test checks if the method getFeedTime returns the expected result for the Racoon class.
     */
    @Test
    public void testRacoonGetFeedTime(){
        int determinedFeedTime = racoonTestObject.getFeedTime();
        int expectedFeedTime = 5;
        assertEquals("Method getFeedTime did not return the expected result:", 
        expectedFeedTime, determinedFeedTime);
    }
    
    /**
     * This test checks if the method getCleanTime returns the expected result for the Racoon class.
     */
    @Test
    public void testRacoonGetCleanTime(){
        int determinedCleanTime = racoonTestObject.getCleanTime();
        int expectedCleanTime = 5;
        assertEquals("Method getCleanTime did not return the expected result:", 
        expectedCleanTime, determinedCleanTime);
    }

    /**
     * This test checks if the method getTotalFeedTime in the Racoon class throws an IllegalArgumentException when the argument is not an integer.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testRacoonGetTotalFeedTimeWrongArgType() throws IllegalArgumentException {
    racoonTestObject.getTotalFeedTime(-1); // should throw an IllegalArgumentException
    }
    
    /**
     * This test checks if the method getTotalFeedTime returns the expected result for the Racoon class.
     */
    @Test
    public void testRacoonGetTotalFeedTime() {
        int numNonOrphanedRacoons = 4;
        int expectedTotalFeedTime = 20;
        int determinedTotalFeedTime = porcupineTestObject.getTotalFeedTime(numNonOrphanedRacoons);
        assertEquals("Method getTotalFeedTime did not return the expected result:", expectedTotalFeedTime, determinedTotalFeedTime);
    }

    /**
     * This test checks if the method getTotalCageTime in the Racoon class throws an IllegalArgumentException when the argument is not an integer.
     */   
    @Test(expected = IllegalArgumentException.class)
    public void testRacoonGetTotalCageCleanTimeWrongArgType() throws IllegalArgumentException{
        racoonTestObject.getTotalCageCleanTime(-1); // should throw an IllegalArgumentException
    }
    
    /**
     * This test checks if the method getTotalCageCleanTime returns the expected result for the Racoon class.
     */
    @Test
    public void testRacoonGetTotalCageCleanTime() {
        int numNonOrphanedRacoons = 4;
        int expectedTotalCageCleanTime = 20;
        int determinedTotalCageCleanTime = racoonTestObject.getTotalCageCleanTime(numNonOrphanedRacoons);
        assertEquals("Method getTotalCageCleanTime did not return the expected result:", expectedTotalCageCleanTime, determinedTotalCageCleanTime);
    }
   
    /**
     * Below are the tests for the Beaver class.
     */

    /**
     * This test checks if the method getFeedWindow returns the expected result for the Beaver class
     */
    @Test
    public void testBeaverGetFeedWindow(){
        int[] determinedFeedWindow = beaverTestObject.getFeedWindow();
        int[] expectedFeedWindow = {8,9,10};
        assertEquals("Method getFeedWindow did not return the expected result:", 
        Arrays.toString(expectedFeedWindow), Arrays.toString(determinedFeedWindow));
        if (determinedFeedWindow.length < 0 || determinedFeedWindow.length > 3){
            throw new IllegalArgumentException("The determined feed window is the wrong size.");
        }
    }
    
    /**
     * This test checks if the method getPrepTime returns the expected result for the Beaver class.
     */
    @Test
    public void testBeaverGetPrepTime(){
        int determinedPrepTime = beaverTestObject.getPrepTime();
        int expectedPrepTime = 0;
        assertEquals("Method getPrepTime did not return the expected result:", 
        expectedPrepTime, determinedPrepTime);
    }

    /**
     * This test checks if the method getFeedTime returns the expected result for the Beaver class.
     */
    @Test
    public void testBeaverGetFeedTime(){
        int determinedFeedTime = beaverTestObject.getFeedTime();
        int expectedFeedTime = 5;
        assertEquals("Method getFeedTime did not return the expected result:", 
        expectedFeedTime, determinedFeedTime);
    }

    /**
     * This test checks if the method getCleanTime returns the expected result for the Beaver class.
     */
    @Test
    public void testBeaverGetCleanTime(){
        int determinedCleanTime = beaverTestObject.getCleanTime();
        int expectedCleanTime = 5;
        assertEquals("Method getCleanTime did not return the expected result:", 
        expectedCleanTime, determinedCleanTime);
    }

    /**
     * This test checks if the method getTotalFeedTime in the Beaver class throws an IllegalArgumentException when the argument is not an integer.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testBeaverGetTotalFeedTimeWrongArgType() throws IllegalArgumentException {
    beaverTestObject.getTotalFeedTime(-1); // should throw an IllegalArgumentException
    }
    
    /**
     * This test checks if the method getTotalFeedTime returns the expected result for the Beaver class.
     */
    @Test
    public void testBeaverGetTotalFeedTime() {
        int numNonOrphanedBeavers = 4;
        int expectedTotalFeedTime = 20;
        int determinedTotalFeedTime = porcupineTestObject.getTotalFeedTime(numNonOrphanedBeavers);
        assertEquals("Method getTotalFeedTime did not return the expected result:", expectedTotalFeedTime, determinedTotalFeedTime);
    }

    /**
     * This test checks if the method getTotalCageTime in the Beaver class throws an IllegalArgumentException when the argument is not an integer.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testBeaverGetTotalCageCleanTimeWrongArgType() throws IllegalArgumentException {
        beaverTestObject.getTotalCageCleanTime(-1); // should throw an IllegalArgumentException
    }
    
    /**
     * This test checks if the method getTotalCageCleanTime returns the expected result for the Beaver class.
     */
    @Test
    public void testBeaverGetTotalCageCleanTime() {
        int numNonOrphanedBeavers = 4;
        int expectedTotalCageCleanTime = 20;
        int determinedTotalCageCleanTime = beaverTestObject.getTotalCageCleanTime(numNonOrphanedBeavers);
        assertEquals("Method getTotalCageCleanTime did not return the expected result:", expectedTotalCageCleanTime, determinedTotalCageCleanTime);
    }
}//End of class



