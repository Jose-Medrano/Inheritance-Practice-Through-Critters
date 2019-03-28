/* Author: Jose Medrano
 * CSid: cs8bwajv
 * Date: 2/20/19
 * Sources:
 */

import java.awt.*;
import java.util.*;

/**
 * This class is a subclass of Feline.
 */
public class Leopard extends Feline {
  //Used for our random direction
  private final int MOVE_DIREC = 4;
  private final int MOVE_N = 0, MOVE_S = 1, MOVE_E = 2, MOVE_W = 3;
  private final int ATTACK_NUMS = 3;
  private final int ROAR = 0;
  private final int POUNCE = 1;
  private final int Scratch = 2;
  protected static int confidence;

  /**
   * This no-arg constructor creates a Leopard object with a confidence variable
   * shared amongst all Leopards and gives it a display name of Lpd.
   */
  public Leopard() {
    this.displayName = "Lpd";
    confidence = 0;
  }

  /**
   * This cheat changes the name of the display text of Leopard into
   * lalalala~~~~.
   */
  @Override
    public void buffBehavior(CritterState s) {
      this.displayName = "lalalala~~~~";
    }

  /**
   * Disables cheat; sets display name back into Lpd.
   */
  @Override
    public void debuff(CritterState s) {
      this.displayName = "Lpd";
    }

  /**
   * This method changes the color of the LEopard's display name.
   * @return Color is the color Red.
   */
  @Override
    public Color getColor() {
      return Color.RED;
    }

  /**
   * This method determines in which direction should the Leopard move depending
   * on its neighboring squares..
   * @return Direction is the direction we are moving.
   */
  @Override
    public Direction getMove() {
      Random rand = new Random();
      int direction = rand.nextInt(MOVE_DIREC);

      if ((this.getNeighbor(Direction.NORTH)).equals(".") ||
          (this.getNeighbor(Direction.NORTH)).equals("Patrick")) {
        return Direction.NORTH;    

      } else if ((this.getNeighbor(Direction.SOUTH)).equals(".") ||
          (this.getNeighbor(Direction.SOUTH)).equals("Patrick")) {
        return Direction.SOUTH;

      } else if ((this.getNeighbor(Direction.EAST)).equals(".") ||
          (this.getNeighbor(Direction.EAST)).equals("Patrick")) {
        return Direction.EAST;

      } else if((this.getNeighbor(Direction.WEST)).equals(".") ||
          (this.getNeighbor(Direction.WEST)).equals("Patrick")) {
        return Direction.WEST;

      } else { 
        if (direction == MOVE_N) {
          return Direction.NORTH;

        } else if (direction == MOVE_S) {
          return Direction.SOUTH;

        } else if (direction == MOVE_E) {
          return Direction.EAST;

        } else if (direction == MOVE_W) {
          return Direction.WEST;

        }
      }
      return Direction.CENTER;
    }

  /**
   * This method determines if the leopard is hungry based on the confidence of
   * the animal.
   * @return boolean true depending on confidence level and vice versa for
   * false.
   */
  @Override
    public boolean eat() {
      Random hunger = new Random();
      int eat = hunger.nextInt(10);
      if (eat <= confidence) {
        return true;
      }
      return false;
    }

  /**
   * Increments the leopards's confidence by one if one leopard wins a fight.
   */
  @Override
    public void win() {
      if (confidence < 10) {
        confidence++;
      }
    }

  /**
   * Decrements the leopards's confidence by one if one leopard loses a fight.
   */
  @Override
    public void lose() {
      if (confidence > 0) {
        confidence--;
      }
    }

  /**
   * This method dtermines the attack type of the leopard depending on who the
   * opponent is and the level of confidence.
   * @return Attack is the type of attack we are using.
   */
  @Override
    public Attack getAttack(String opponent) {
      if (opponent.equals("Tu") || confidence > 5) {
        return Attack.POUNCE;
      }
      return generateAttack();
    }

  /**
   * This method generates a random attack that is not forfeit.
   * @return Attack is the random atack we chose.
   */
  public Attack generateAttack() {
    Random rand = new Random();
    int decide = rand.nextInt(ATTACK_NUMS);
    if (decide == ROAR) {
      return Attack.ROAR;

    } else if (decide == POUNCE) {
      return Attack.POUNCE;

    } else {
      return Attack.SCRATCH;
    }
  }
}
