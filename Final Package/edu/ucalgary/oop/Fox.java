/**
 * @author GYURIN (JANE) MO, CALEB OVIAWE, YANISA SRISA-ARD, EMIKO EMIKO
 * @version 1.7
 * @since 1.0
 */

package edu.ucalgary.oop;

/*
 * This class represents a fox within the rescue centre.
 */

public class Fox {
    /**
    * This array represents the feed window of a fox.
    */
    private final int[] FEED_WINDOW = {0, 1, 2};

    /**
    * This constant represents the meal preparation time for a fox.
    */
    private final int PREP_TIME = 5;
    
    /**
    * This constant represents the time to feed a fox.
    */
    private final int FEED_TIME = 5;
    
    /**
    * This constant represents the time needed for cage cleaning.
    */
    private final int CLEAN_TIME = 5;

    /**
     * Returns the feed window of a fox.
     * @return An integer array representing the feed window of a fox.
    */
    public int[] getFeedWindow() { return this.FEED_WINDOW; }

    /**
     * Returns the meal preparation time of a fox.
     * @return An integer representing the meal preparation time of a fox.
    */
    public int getPrepTime() { return this.PREP_TIME; }

    /**
     * Returns the feeding time of a fox.
     * @return An integer representing the feeding time of a fox.
    */
    public int getFeedTime() { return this.FEED_TIME; }

    /**
     * Receives the total number of non-orphaned foxes.
     * Calculates and returns the total feeding time of non-orphaned foxes.
     * @return An integer representing the total feeding time of non-orphaned foxes.
     * @throws IllegalArgumentException
    */
    public int getTotalFeedTime(int numNonOrphanedFoxes) throws IllegalArgumentException {
        if (numNonOrphanedFoxes < 0) {
            throw new IllegalArgumentException("numNonOrphanedFoxes cannot be a negative number");
        }
        int totalFeedTime = getPrepTime() + getFeedTime() * numNonOrphanedFoxes;
        return totalFeedTime;
    }

    /**
     * Returns the cage cleaning time of a fox.
     * @return An integer representing the cage cleaning time of a fox.
    */
    public int getCleanTime() { return this.CLEAN_TIME; }

    /**
     * Receives total number of fox cages.
     * Calculates and returns the total cage cleaning time of all fox cages.
     * @return An integer representing the total cage cleaning time of all fox cages.
     * @throws IllegalArgumentException
    */
    public int getTotalCageCleanTime(int numTotalFoxes) throws IllegalArgumentException {
        if (numTotalFoxes < 0) {
            throw new IllegalArgumentException("numTotalFoxes cannot be a negative number");
        }
        int totalCageCleanTime = getCleanTime() * numTotalFoxes;
        return totalCageCleanTime;
    }

}//End of class Fox