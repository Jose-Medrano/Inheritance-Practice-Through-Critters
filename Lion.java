/* Author: Jose Medrano
 * CSid: cs8bwajv
 * Date: 2/20/19
 * Sources:
 */

import java.awt.*;
import java.util.*;

/**
 * Sub-class of the Feline class.
 */
public class Lion extends Feline {
  private int fightWins;
  private int moveCount;
  private final int MOVE_S = 0;
  private final int MOVE_W = 5;
  private final int MOVE_N = 10;
  private final int MOVE_E = 15;
  private final int RESET = 20;
  private Direction currDir;

  /**
   * This no-arg constructor creates an object of type Lion that has variables
   * to keep track of fights won and the moves.
   */
  public Lion() {
    this.displayName = "Lion";
    fightWins = 0;
    moveCount = 0;
    currDir = Direction.CENTER;
  }

  /**
   * This cheat changes the display name of the lions into LIONS.
   */
  @Override
    public void buffBehavior(CritterState s) {
      this.displayName = "LION";
    }
  
  /**
   * Disables the cheat. In this case reverts LION back into Lion.
   */
  @Override
    public void debuff(CritterState s) {
      this.displayName = "Lion";
    }
  /**
   * Gets the color and turns the lion text yellow.
   * @return Color is the color yellow.
   */
  @Override
    public Color getColor() {
      return Color.YELLOW;
    }

  /**
   * This method determines in what direction the lion moves.
   * @return the direction in which the lion moves.
   */
  @Override
    public Direction getMove() {
      if (moveCount == MOVE_S) {
        moveCount++;
        currDir = Direction.SOUTH;
        return currDir;

      } else if (moveCount == MOVE_W) {
        moveCount++;
        currDir = Direction.WEST;
        return currDir;

      } else if (moveCount == MOVE_N) {
        moveCount++;
        currDir = Direction.NORTH;
        return currDir;

      } else if (moveCount == MOVE_E) {
        moveCount++;
        currDir = Direction.EAST;
        return currDir;

      } else if (moveCount == RESET) {
        moveCount = 0;
        return currDir;
      }
      moveCount++;
      return currDir;
    }

  /**
   * Checks to see if the lion has won a fight, and if so, eat.
   * @return boolean is true if the lion has won a fight and can eat.
   */
  @Override
    public boolean eat() {
      if (fightWins > 1) {
        fightWins = 0;
        return true;
      }
      return false;
    }

  /**
   * When the lion sleeps, it changes the amounts of fights won to 0 and
   * changes the name of the lion into noil.
   */
  @Override
    public void sleep() {
      fightWins = 0;
      this.displayName = "noiL";
    }

  /**
   * When the lion wakes up, it gets its name back.
   */
  @Override
    public void wakeup() {
      this.displayName = "Lion";
    }

  /**
   * Increments the amount of fights the lion has won.
   */
  @Override
    public void win() {
      fightWins++;
    }

}
