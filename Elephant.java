/* Author: Jose Medrano
 * CSid: cs8bwajv
 * Date: 2/20/19
 * Sources:
 */

import java.util.Random;
import java.awt.*;

/**
 * This class is a subclass of Critter.
 */
public class Elephant extends Critter implements Movable {
  private final int CHEAT= 7;
  private int resetCheat;
  static int goalX;
  static int goalY;
  private Random random;

  /**
   * This no-arg constructor creates an elephant object.
   */
  public Elephant() {
    super("El");
    random = new Random();
    goalX = 0;
    goalY = 0;
    resetCheat = 0;
  }

  /**
   * This cheat vastly increases the amount of food the elephants have "Eaten".
   */
  @Override
    public void buffBehavior(CritterState s) {
      resetCheat = s.foodEaten + s.getCount()*CHEAT;
      s.foodEaten = s.foodEaten + s.getCount()*CHEAT;
    }

  /**
   * Disables cheat; sets foodEaten count back to normal.
   */
  @Override
    public void debuff(CritterState s) {
      s.foodEaten = s.foodEaten - resetCheat;
    }

  /**
   * Sets the color of the elephant display text to gray.
   * @return Color is the color Gray.
   */
  @Override
    public Color getColor() {
      return Color.GRAY;
    }

  /**
   * This method tells all elephants to move to a specific location and when
   * that location has been fulfilled it loads a new location for the herd to
   * move to.
   * @return Direction is the fastest way to get to the location.
   */
  @Override
    public Direction getMove() {
      int distanceX = java.lang.Math.abs(goalX - getX());
      int distanceY = java.lang.Math.abs(goalY - getY());
      if (goalX == getX() && goalY == getY()) {
        goalX = random.nextInt(getWidth());
        goalY = random.nextInt(getHeight());
      }
      if (distanceX == distanceY) {
        return Direction.NORTH;
      }

      if (distanceX > distanceY) {
        if (goalX < getX()) {
          return Direction.WEST;
        }
        if (goalX > getX()) {
          return Direction.EAST;
        }
      }

      if (distanceX < distanceY) {
        if (goalY < getY()) {
          return Direction.NORTH;
        }
        if (goalY > getY()) {
          return Direction.SOUTH;
        }
      }
      return Direction.CENTER;
    }

  /**
   * Elephants ALWAYS EAT.
   */
  @Override
    public boolean eat() {
      return true;
    }

  /**
   * When we want an elephant to mate, we increase its level by 2.
   */
  @Override
    public void mate() {
      level = level + 2;
    }
}
