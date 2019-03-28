/* Author: Jose Medrano
 * CSid: cs8bwajv
 * Date: 2/20/19
 * Sources:
 */

import java.awt.*;

/**
 * This is a personal class for my critter.
 */
public class Jose_jrmedran extends Critter implements Movable {
  private int movement;
  private int attackType;

  /**
   * No-arg constructor that creates the Jose object
   */
  public Jose_jrmedran() {
    super("Koala");
    attackType = 0;
    movement = 0;
  }

  /**
   * The color of the koalas are blue
   * @return Color of the koalas.
   */
  @Override
    public Color getColor() {
      return Color.BLUE;
    }

  /**
   * Koalas will move West every 2nd move, East every 3rd move, and North in
   * the rest of the moves.
   * @return Direction is the direction that the koala will be moving.
   */
  @Override
    public Direction getMove() {
      if (movement % 3 == 0) {
        movement++;
        return Direction.EAST;
      }

      if (movement % 2 == 0) {
        movement++;
        return Direction.WEST;
      }
      movement++;
      return Direction.NORTH;
    }

  /**
   * The koala will either Roar or Scratch depending on how many attacks they
   * have done.
   * @return Attack the attack the koala will do.
   */
  @Override
    public Attack getAttack(String opponent) {
      if (attackType % 2 == 0) {
        attackType++;
        return Attack.ROAR;
      }
      return Attack.SCRATCH;
    }

  /**
   * Koalas always eat.
   */
  @Override
    public boolean eat() {
      return true;
    }
}
