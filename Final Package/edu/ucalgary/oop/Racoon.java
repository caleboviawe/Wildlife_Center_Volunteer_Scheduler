/**
 * @author GYURIN (JANE) MO, CALEB OVIAWE, YANISA SRISA-ARD, EMIKO EMIKO
 * @version 1.7
 * @since 1.0
 */

package edu.ucalgary.oop;

/*
 * This class represents a racoon within the rescue centre.
 */

public class Racoon {
    /**
    * This array represents the feed window of a racoon.
    */
    private final int[] FEED_WINDOW = {0, 1, 2};
    
    /**
    * This constant represents the meal preparation time for a raccoon.
    */
    private final int PREP_TIME = 0;
    
    /**
    * This constant represents the time to feed a raccoon..
    */
    private final int FEED_TIME = 5;
    
    /**
    * This constant represents the time needed for cage cleaning.
    */
    private final int CLEAN_TIME = 5;

    /**
     * Returns the feed window of a raccoon.
     * @return An integer array representing the feed window of a raccoon.
    */
    public int[] getFeedWindow() { return this.FEED_WINDOW; }

    /**
     * Returns the meal preparation time of a raccoon.
     * @return An integer representing the meal preparation time of a raccoon.
    */
    public int getPrepTime() { return this.PREP_TIME; }

    /**
     * Returns the feeding time of a raccoon.
     * @return An integer representing the feeding time of a raccoon.
    */
    public int getFeedTime() { return this.FEED_TIME; }

    /**
     * Receives the total number of non-orphaned racoons.
     * Calculates and returns the total feeding time of non-orphaned racoons.
     * @return An integer representing the total feeding time of non-orphaned racoons.
     * @throws IllegalArgumentException
    */
    public int getTotalFeedTime(int numNonOrphanedRacoons) throws IllegalArgumentException {
        if (numNonOrphanedRacoons < 0) {
            throw new IllegalArgumentException("numNonOrphanedRacoons cannot be a negative number");
        }
        int totalFeedTime = getPrepTime() + getFeedTime() * numNonOrphanedRacoons;
        return totalFeedTime;
    }

    /**
     * Returns the cage cleaning time of a raccoon.
     * @return An integer representing the cage cleaning time of a raccoon.
    */
    public int getCleanTime() { return this.CLEAN_TIME; }

    /**
     * Receives total number of racoon cages.
     * Calculates and returns the total cage cleaning time of all racoon cages.
     * @return An integer representing the total cage cleaning time of all racoon cages.
     * @throws IllegalArgumentException
    */
    public int getTotalCageCleanTime(int numTotalRacoons) throws IllegalArgumentException {
        if (numTotalRacoons < 0) {
            throw new IllegalArgumentException("numTotalRacoons cannot be a negative number");
        }
        int totalCageCleanTime = getCleanTime() * numTotalRacoons;
        return totalCageCleanTime;
    }
}//End of class Racoon