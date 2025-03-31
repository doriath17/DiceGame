package dicegame;

import java.util.Random;

public class Dice {
	
	public static final int DICE_MIN = 1;
	public static final int DICE_MAX = 6;
	
	public final int min;
	public final int max;
	
	private final int delta;
	private static final Random randGenerator = new Random();
	
	
	public Dice(){
		min = DICE_MIN;
		max = DICE_MAX;
		delta = max - min + 1; 
	}
	
	
	public Dice(int min, int max) {
		if (min <= 0 || min >= max || max <= min) {
			this.min = DICE_MIN;
			this.max = DICE_MAX;
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