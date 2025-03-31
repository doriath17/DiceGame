package dicegame;

import java.util.Comparator;

public class Player {
	
	static final Comparator<Player> PLAYER_SCORE_ORDER = new Comparator<>() {
		@Override
		public int compare(Player p1, Player p2) {
			if (p1.score < p2.score) {
				return -1;
			} else if (p1.score > p2.score) {
				return 1;
			} else {
				return 0;
			}
		}
	};
	
	public final String name;
	public final String surname; 
	public final String nickname;
	private Dice dice;
	private int score;

	public Player(String name, String surname, String nickname, Dice dice) {
		this.name = name;
		this.surname = surname;
		this.nickname = nickname;
		this.dice = dice;
	}
	
	@Override
	public String toString() {
		return	"\nname      = " + name + 
				"\nsurname   = " + surname + 
				"\nnickname  = " + nickname + 
				"\ndice: " + dice.toString();
	}

	public int getScore() {
		return score;
	}
	
	public void resetScore() {
		score = 0;
	}
	
	public void setDice(Dice dice) {
		this.dice = dice;
		System.out.println("\nCHANGE OF DICE!\n" + nickname + " starts using a new dice: " + dice.toString() + "\n");
	}
	
	public int launchDice() {
		int result = dice.launch();
		score += result;
		return result;
	}
	
}
