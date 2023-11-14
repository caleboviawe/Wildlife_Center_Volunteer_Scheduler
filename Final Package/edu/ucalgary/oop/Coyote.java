/**
 * @author GYURIN (JANE) MO, CALEB OVIAWE, YANISA SRISA-ARD, EMIKO EMIKO
 * @version 1.7
 * @since 1.0
 */

package edu.ucalgary.oop;

/*
 * This class represents a coyote within the rescue centre.
 */

public class Coyote {
    /**
    * This array represents the feed window of a coyote.
    */
    private final int[] FEED_WINDOW = {19, 20, 21};
    
    /**
    * This constant represents the meal preparation time for a coyote.
    */
    private final int PREP_TIME = 10;
    
    /**
    * This constant represents the time to feed a coyote.
    */
    private final int FEED_TIME = 5;
    
    /**
    * This constant represents the time needed for cage cleaning.
    */
    private final int CLEAN_TIME = 5;

    /**
     * Returns the feed window of a coyote.
     * @return An integer array representing the feed window of a coyote.
    */
    public int[] getFeedWindow() { return this.FEED_WINDOW; }

    /**
     * Returns the meal preparation time of a coyote.
     * @return An integer representing the meal preparation time of a coyote.
    */
    public int getPrepTime() { return this.PREP_TIME; }

    /**
     * Returns the feeding time of a coyote.
     * @return An integer representing the feeding time of a coyote.
    */
    public int getFeedTime() { return this.FEED_TIME; }

     /**
     * Receives the total number of non-orphaned coyotes.
     * Calculates and returns the total feeding time of non-orphaned coyotes.
     * @return An integer representing the total feeding time of non-orphaned coyotes.
     * @throws IllegalArgumentException
    */
    public int getTotalFeedTime(int numNonOrphanedCoyotes) throws IllegalArgumentException {
        if (numNonOrphanedCoyotes < 0) {
            throw new IllegalArgumentException("numNonOrphanedCoyotes cannot be a negative number");
        }
        int totalFeedTime = getPrepTime() + getFeedTime() * numNonOrphanedCoyotes;
        return totalFeedTime;
    }

    /**
     * Returns the cage cleaning time of a coyote.
     * @return An integer representing the cage cleaning time of a coyote.
    */
    public int getCleanTime() { return this.CLEAN_TIME; }

    /**
     * Receives total number of coyote cages.
     * Calculates and returns the total cage cleaning time of all coyote cages.
     * @return An integer representing the total cage cleaning time of all coyote cages.
     * @throws IllegalArgumentException
    */
    public int getTotalCageCleanTime(int numTotalCoyotes) throws IllegalArgumentException {
        if (numTotalCoyotes < 0) {
            throw new IllegalArgumentException("numTotalCoyotes cannot be a negative number");
        }

        int totalCageCleanTime = getCleanTime() * numTotalCoyotes;
        return totalCageCleanTime;
    }

}//End of class Coyote