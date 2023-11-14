/**
 * @author GYURIN (JANE) MO, CALEB OVIAWE, YANISA SRISA-ARD, EMIKO EMIKO
 * @version 1.7
 * @since 1.0
 */

package edu.ucalgary.oop;

/*
 * This class represents a porcupine within the rescue centre.
 */

public class Porcupine {
    /**
    * This array represents the feed window of a porcupine.
    */
    private final int[] FEED_WINDOW = {19, 20, 21};
    
    /**
    * This constant represents the meal preparation time for a porcupine.
    */
    private final int PREP_TIME = 0;
    
    /**
    * This constant represents the time to feed a porcupine.
    */
    private final int FEED_TIME = 5;
    
    /**
    * This constant represents the time needed for cage cleaning.
    */
    private final int CLEAN_TIME = 10;

    /**
     * Returns the feed window of a porcupine.
     * @return An integer array representing the feed window of a porcupine.
    */
    public int[] getFeedWindow() { return this.FEED_WINDOW; }

    /**
     * Returns the meal preparation time of a porcupine.
     * @return An integer representing the meal preparation time of a porcupine.
    */
    public int getPrepTime() { return this.PREP_TIME; }

    /**
     * Returns the feeding time of a porcupine.
     * @return An integer representing the feeding time of a porcupine.
    */
    public int getFeedTime() { return this.FEED_TIME; }

    /**
     * Receives the total number of non-orphaned porcupines.
     * Calculates and returns the total feeding time of non-orphaned porcupines.
     * @return An integer representing the total feeding time of non-orphaned porcupines.
     * @throws IllegalArgumentException
    */
    public int getTotalFeedTime(int numNonOrphanedPorcupines) throws IllegalArgumentException {
        if (numNonOrphanedPorcupines < 0) {
            throw new IllegalArgumentException("numNonOrphanedPorcupines cannot be a negative number");
        }
        int totalFeedTime = getPrepTime() + getFeedTime() * numNonOrphanedPorcupines;
        return totalFeedTime;
    }

    /**
     * Returns the cage cleaning time of a porcupine.
     * @return An integer representing the cage cleaning time of a porcupine.
    */
    public int getCleanTime() { return this.CLEAN_TIME; }

    /**
     * Receives total number of porcupine cages.
     * Calculates and returns the total cage cleaning time of all porcupine cages.
     * @return An integer representing the total cage cleaning time of all porcupine cages.
     * @throws IllegalArgumentException
    */
    public int getTotalCageCleanTime(int numTotalPorcupines) throws IllegalArgumentException {
        if (numTotalPorcupines < 0) {
            throw new IllegalArgumentException("numTotalPorcupines cannot be a negative number");
        }
        int totalCageCleanTime = getCleanTime() * numTotalPorcupines;
        return totalCageCleanTime;
    }

}//End of class Porcupine