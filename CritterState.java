// previously inner class of CritterModel. Made a separate class for convenience
public  class CritterState {
	protected Class<? extends Critter> critterClass;
	protected Critter critter;
	protected Critter daddy;
	protected int count;
	protected int prev_count;
	protected int initialCount;
	protected int kills;
	protected int deaths;
	protected int moves;
	protected int foodEaten;
	protected int foodPenalty;
	protected int prev_foodPenalty = 0;
	protected int matePenalty;
	protected int prev_matePenalty = 0;
	protected Critter mate;
	private static final int MATING_PENALTY = 40;
	private static final int GLUTTON_PENALTY = 20;

	// Constructs object to represent state of the given class.
	public CritterState(Class<? extends Critter> critterClass) {
		this(critterClass, null);
	}

	// Constructs object to represent state of the given class.
	public CritterState(Class<? extends Critter> critterClass, Critter critter) {
		this.critterClass = critterClass;
		this.critter = critter;
	}

	// Set foodPenalty to make it asleep
	public void setAsleep(boolean gotoSleep){
		if (gotoSleep){
			this.prev_foodPenalty = this.foodPenalty;
			this.foodPenalty = GLUTTON_PENALTY;
		}else{
			this.foodPenalty = this.prev_foodPenalty;
		}
	}

	// Returns how many animals are alive.
	public int getCount() {
		return count;
	}

	// Returns how many times an animal of this type has died.
	public int getDeaths() {
		return deaths;
	}

	// Returns how many times an animal of this type has eaten food.
	public int getFoodEaten() {
		return foodEaten;
	}

	// Returns how many moves this type is currently being penalized
	// for eating too much food.
	public int getFoodPenalty() {
		return foodPenalty;
	}

	// Returns how many animals of this type have ever been created.
	public int getInitialCount() {
		return initialCount;
	}

	// Returns how many animals this type has killed.
	public int getKills() {
		return kills;
	}

	// Returns how many moves this type is currently frozen during mating.
	public int getMatePenalty() {
		return matePenalty;
	}

	// Returns how many times this critter has moved.
	public int getMoves() {
		return moves;
	}

	// Returns true if this animal has a love partner and has mated.
	public boolean hasMate() {
		return mate != null;
	}

	// Returns true if this class is asleep.
	public boolean isAsleep() {
		return foodPenalty > 0;
	}

	public boolean isBaby() {
		// Added this line so if isBaby is set to false by buff behavior
		// it will be shown as not baby
		return isBaby(true);
	}

	public boolean isBaby(boolean considerMoves) {
		if (considerMoves) {
			return moves < MATING_PENALTY && daddy != null;
		} else {
			return daddy != null;
		}
	}

	// Returns true if this class is currently mating.
	public boolean isMating() {
		return mate != null && matePenalty > 0;
	}

	// Resets the state of this type.
	public void reset() {
		count = 0;
		deaths = 0;
		foodEaten = 0;
		foodPenalty = 0;
		initialCount = 0;
		kills = 0;
		moves = 0;
		mate = null;
		matePenalty = 0;
		daddy = null;
	}

	public String toString() {
		return Util.toString(this);
	}

}
