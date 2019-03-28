/* Author: Jose Medrano
 * CSid: cs8bwajv
 * Date: 2/20/19
 * Sources: 
 */

import java.awt.*;
import java.util.*;

/**
 * This class is a subclass of critter.
 */
public class Starfish extends Critter{

  /**
   * No-arg constructor with a super call to Critter(String).
   */
  public Starfish() {
    super("Patrick");
  }

  /**
   * Changes the color of the display name to pink.
   * @return Color pink.
   */
  @Override 
    public Color getColor() {
      return Color.PINK;
    }

  /**
   * This method is cheat that tricks the game into thinking there are no more
   * starfish on the board.
   */
  @Override
    public void buffBehavior(CritterState s){
      // A very humble animal, making the manager thinks there's no
      // starfish at all!!!
      s.count -= 1;
      this.displayName = "";
    }

  /**
   * Disables the cheat.
   */
  @Override
    public void debuff(CritterState s){
      s.count += 1;
      this.displayName = "Patrick";
    }

  /**
   * Allows the starfish to teleport around the map instead of moving normally.
   */
  public void teleport(Point currentLocation, Critter[][] arena){
    Random rand = new Random();
    arena[getX()][getY()] = null;
    setX(rand.nextInt(getWidth()));
    setY(rand.nextInt(getHeight()));
  }
}
