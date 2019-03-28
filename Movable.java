/**
 * Movable.java
 * Junshen (Kevin) Chen
 * 1 May 2018
 * contains an interface defining the move behavior of a Critter
 * do not modify
 */

import java.util.Random;

/**
 * interface Movable
 * Critter can optionally implement this interface to be able to move
 * and eat
 */
public interface Movable {

    Random random = new Random();
	
	/**
     * returns the move direction by some Critter implementing Movable
     * @return a direction selected
     */
    Direction getMove();

    /**
     * returns whether the Movable Critter decides to eat
     * @return true if the critter decides to eat, false if it doesn't
     */
    boolean eat(); 
}
