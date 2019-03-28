/* Author: Jose Medrano
 * CSid: cs8bwajv
 * Date: 2/20/19
 * Sources: 
 */

import java.util.Random;

/**
 * Feline is a subclass of a Critter
 */
public class Feline extends Critter implements Movable {

  //counter for the getMove method before random direction                     
  private final int MOVE_LIMIT = 5;
  private final int POSSIBLE_MOVES = 4;
  private final int GO_UP = 0;
  private final int GO_LEFT = 1;
  private final int GO_DOWN = 2;
  private final int GO_RIGHT = 3;
  private int moveCount;
  private int eatCount; //counter for eating
  private Direction currDir; //current direction

  /**
   * This no-arg constructor creates a Feline object based on a
   * Critter(String) object and gives it counters to follow moves and hunger.
   */
  public Feline() {
    super("Fe");
    moveCount = 0;
    eatCount = 0;
    currDir = Direction.CENTER;
  }

  /**
   * This cheat puts our Feline to bed.
   */
  @Override
    public void buffBehavior(CritterState s){
      s.setAsleep(true);
    }

  /**
   * Disables the cheat; wakes up the Feline.
   */
  @Override
    public void debuff(CritterState s){
      s.setAsleep(false);
    }

  /**
   * This method dtermines which direction the feline should go based onj it's
   * previous five moves.
   * @return Direction is the direction the feline will travel.
   */
  @Override
    public Direction getMove() {
      Random direction = new Random();
      int decision = direction.nextInt(POSSIBLE_MOVES);
      if ((moveCount == 0) || (moveCount <= 5 && moveCount % 5 == 0)) {
        if (decision == GO_UP) {
          moveCount++;
          currDir = Direction.NORTH;
          return currDir;

        } else if (decision == GO_LEFT) {
          moveCount++;
          currDir = Direction.WEST;
          return currDir;

        } else if (decision == GO_DOWN) {
          moveCount++;
          currDir = Direction.SOUTH;
          return currDir;

        } else if (decision == GO_RIGHT) {
          moveCount++;
          currDir = Direction.EAST;
          return currDir;
        }
      }
      moveCount++;
      return currDir;
    }

  /**
   * This determines if the feline should eat or not.
   * @return boolean is whether or not the feline has ate.
   */
  @Override
    public boolean eat() {
      if (eatCount < 5) {
        eatCount++;
        return false;
      }
      if (eatCount % 5 == 0) {
        return true;
      }
      eatCount++;
      return false;
    }

  /**
   * This method makes sure that felines will always pounce.
   * @return Attack pounce always. 
   */
  public Attack getAttack(String opponent){
    return Attack.POUNCE;
  }


}
