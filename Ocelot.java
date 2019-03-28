/* Author: Jose Medrano
 * CSid: cs8bwajv
 * Date: 2/20/19
 * Sources:
 */

import java.awt.*;
import java.util.*;

/**
 * This file is a subclass of a leopard.
 */
public class Ocelot extends Leopard {
  /**
   * This creates an Ocelot object with only a displayName initilized.
   */
  public Ocelot() {
    this.displayName = "Oce";
  }
 
  /**
   * This cheat increases the amount of kills ocelots have by 3.
   */ 
  @Override
    public void buffBehavior(CritterState s) {
      s.kills += 3;    
    }

  /**
   * Disable cheat; decreases ocelot kill count by 3.
   */
  @Override
    public void debuff(CritterState s) {
      s.kills -= 3;
    }

  /**
   * Sets the color of ocelots to a light gray when on the board.
   * @return Color is the color LIGHT_GRAY.
   */
  @Override
    public Color getColor() {
      return Color.LIGHT_GRAY;
    }

  /**
   * This method dtermines what kind of attack an ocelot will do.
   * @return Attack is the type of attack we will be using.
   */
  @Override
    public Attack getAttack(String opponent) {
      if (Leopard.confidence > 5) {
        if (opponent.equals("Lion") || opponent.equals("noiL") ||
            opponent.equals("Fe") || opponent.equals("Lpd")) {
          return Attack.SCRATCH;
        }
        return Attack.POUNCE;
      }
      return super.generateAttack();
    }
}
