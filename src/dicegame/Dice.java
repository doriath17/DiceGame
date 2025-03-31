package dicegame;

import java.util.Random;

public class Dice {
	
	static final int DICE_MIN_DEFUALT = 1;
	static final int DICE_MAX_DEFAULT = 6;
	
	final int min;
	final int max;
	
	private final int delta;
	private static final Random randGenerator = new Random();
	

	public Dice(){
		min = DICE_MIN_DEFUALT;
		max = DICE_MAX_DEFAULT;
		delta = max - min + 1; 
	}
	
	
	public Dice(int min, int max) {
		if (min <= 0 || min >= max || max <= min) {
			this.min = DICE_MIN_DEFUALT;
			this.max = DICE_MAX_DEFAULT;
		} else {
			this.min = min;
			this.max = max;
		}
		delta = max - min + 1;
	}
	
	
	public int launch() {
		return min + (randGenerator.nextInt(delta));
	}

}