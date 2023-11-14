/**
 * @author GYURIN (JANE) MO, CALEB OVIAWE, YANISA SRISA-ARD, EMIKO EMIKO
 * @version 1.7
 * @since 1.0
 */

package edu.ucalgary.oop;

/*
* This class represents a beaver within the rescue centre.
*/

public class Beaver {

    /**
    * This array represents the feed window of a beaver.
    */
    private final int[] FEED_WINDOW = {8, 9, 10};
    
    /**
    * This constant represents the meal preparation time for a beaver.
    */
    private final int PREP_TIME = 0;
    
    /**
    * This constant represents the time to feed a beaver.
    */
    private final int FEED_TIME = 5;
    
    /**
    * This constant represents the time needed for cage cleaning.
    */
    private final int CLEAN_TIME = 5;

    /**
     * Returns the feed window of a beaver.
     * @return An integer array representing the feed window of a beaver.
    */
    public int[] getFeedWindow() { return this.FEED_WINDOW; }

    /**
     * Returns the meal preparation time of a beaver.
     * @return An integer representing the meal preparation time of a beaver.
    */
    public int getPrepTime() { return this.PREP_TIME; }

    /**
     * Returns the feeding time of a beaver.
     * @return An integer representing the feeding time of a beaver.
    */
    public int getFeedTime() { return this.FEED_TIME; }

    /**
     * Receives the total number of non-orphaned beavers.
     * Calculates and returns the total feeding time of non-orphaned beavers.
     * @return An integer representing the total feeding time of non-orphaned beavers.
     * @throws IllegalArgumentException
    */
    public int getTotalFeedTime(int numNonOrphanedBeavers) throws IllegalArgumentException {
        if (numNonOrphanedBeavers < 0) {
            throw new IllegalArgumentException("numNonOrphanedBeavers cannot be a negative number");
        }
        int totalFeedTime = getPrepTime() + getFeedTime() * numNonOrphanedBeavers;
        return totalFeedTime;
    }

    /**
     * Returns the cage cleaning time of a beaver.
     * @return An integer representing the cage cleaning time of a beaver.
    */
    public int getCleanTime() { return this.CLEAN_TIME; }

    /**
     * Receives total number of beaver cages.
     * Calculates and returns the total cage cleaning time of all beaver cages.
     * @return An integer representing the total cage cleaning time of all beaver cages.
     * @throws IllegalArgumentException
    */
    public int getTotalCageCleanTime(int numTotalBeavers) throws IllegalArgumentException {
        if (numTotalBeavers < 0) {
            throw new IllegalArgumentException("numTotalBeavers cannot be a negative number");
        }
        int totalCageCleanTime = getCleanTime() * numTotalBeavers;
        return totalCageCleanTime;
    }

}//End of class Beaver