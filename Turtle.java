/* Author: Jose Medrano
 * CSid: cs8bwajv
 * Date: 2/20/19
 * Sources:
 */

import java.awt.*;
import java.util.Random;

/**
 * This class is a subclass of Critter.
 */
public class Turtle extends Critter implements Movable {
  private final int FIFTY_FIFTY = 2;
  private final int CHEAT = 5;

  /**
   * No-arg constructor that creates a turtle object.
   */
  public Turtle() {
    super("Tu");
  }

  /**
   * This cheat tricks the game into thinking that there are actually more than
   * turtles than there really are.
   */
  @Override
    public void buffBehavior(CritterState s) {
      s.count += CHEAT;
    }

  /**
   * Disable cheat; decreases count by 5.
   */
  @Override
    public void debuff(CritterState s) {
      s.count -= CHEAT;
    }

  /**
   * Sets the color of the turtle display name to green.
   * @return Color green.
   */
  @Override
    public Color getColor() {
      return Color.GREEN;
    }

  /**
   * Makes sure the turtle only moves West.
   * @return Direction west always.
   */
  @Override
    public Direction getMove() {
      return Direction.WEST;
    }

  /**
   * This method allows the turtle to eat only if all urrounding squares have
   * friendlies in them.
   * @return boolean is true if safe, false if not.
   */
  @Override
    public boolean eat() {
      if (((getNeighbor(Direction.NORTH)).equals(" ") ||
            (getNeighbor(Direction.NORTH)).equals(".") ||
            (getNeighbor(Direction.NORTH)).equals("Tu")) &&

          ((getNeighbor(Direction.SOUTH)).equals(" ") ||
           (getNeighbor(Direction.SOUTH)).equals(".") ||
           (getNeighbor(Direction.SOUTH)).equals("Tu")) &&

          ((getNeighbor(Direction.EAST)).equals(" ") ||
           (getNeighbor(Direction.EAST)).equals(".") ||
           (getNeighbor(Direction.EAST)).equals("Tu")) &&

          ((getNeighbor(Direction.WEST)).equals(" ") ||
           (getNeighbor(Direction.WEST)).equals(".") ||
           (getNeighbor(Direction.WEST)).equals("Tu"))) {

        return true;
      }
      return false;
    }

  /**
   * This method has a 50/50 chance of choosing ROAR or FORFEIT as its attack.
   * @return Attack either ROAR or FORFEIT.
   */
  @Override
    public Attack getAttack(String opponent) {
      Random random = new Random();
      int chance = random.nextInt(FIFTY_FIFTY);
      if (chance == 0) {
        return Attack.ROAR;
      } else {
        return Attack.FORFEIT;
      }
    }
}
