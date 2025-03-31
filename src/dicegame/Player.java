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
	
	private final String name;
	private final String surname; 
	private final String nickname;
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
				"\ndice: ["+ dice.min + ", " +  dice.max + "]";
	}
	

	public String getNickname() {
		return nickname;
	}

	public int getScore() {
		return score;
	}
	
	public int launchDice() {
		int result = dice.launch();
		score += result;
		return result;
	}
	
}
