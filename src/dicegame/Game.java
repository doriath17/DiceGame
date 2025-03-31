package dicegame;

public class Game {
	
	public static final int NUM_ROUNDS_DEFAULT = 1;
	
	private Player playerOne;
	private Player playerTwo;
	private int    numRounds;
	
	
	// num_rounds >= 1 (in caso di errori settato al valore di default = 1)
	public Game(Player playerOne, Player playerTwo, int numRounds) {
		this.playerOne = playerOne;
		this.playerTwo = playerTwo;
		
		setNumRounds(numRounds);
	}
	
	
	public void setNumRounds(int numRounds) {
		if (numRounds < NUM_ROUNDS_DEFAULT) {
			this.numRounds = NUM_ROUNDS_DEFAULT;
		} else {			
			this.numRounds = numRounds;
		}
	}
	
	public void setPlayerOne(Player playerOne) {
		this.playerOne = playerOne;
	}
	
	public void setPlayerTwo(Player playerTwo) {
		this.playerTwo = playerTwo;
	}
	
	
	public void play() {
		System.out.println(
				"Here we have the two players:\n" + 
				playerOne + "\n" +
				playerTwo + 
				"\n\nGAME START!!!"
		);
	
		for (int i=0; i<numRounds; i++) {
			System.out.println("\nround : " + (i+1));
			playRound();
		}
		
		System.out.println(getGameResults());
	}
	
	
	private void playRound() {
		int resultOne = playerOne.launchDice();
		int resultTwo = playerTwo.launchDice();
		
		System.out.println(
			playerOne.nickname + " : " + resultOne + "\n" + 
			playerTwo.nickname + " : " + resultTwo
		);
	}

	
	private String getGameResults() {
		int gameResult = Player.PLAYER_SCORE_ORDER.compare(playerOne, playerTwo);
		Player winner = null, loser = null;
		
		StringBuilder sb = new StringBuilder("\nAnd the winner is...\n");
		
		if (gameResult < 0) { 
			winner = playerTwo;
			loser = playerOne;
		} else if (gameResult > 0) {
			winner = playerOne;
			loser = playerTwo;
		} else {
			loser = winner = playerOne;
		}
		
		if (winner == loser) {
			sb.append("GAME TIED!!");
		} else {
			sb.append(winner.nickname + " wins the game!!\n\n");
		}
		
		sb.append(
				winner.nickname + " wins with "  + winner.getScore() + " points!\n" + 
				loser.nickname  + " loses with " + loser.getScore()  + " points.\n"
			);
		
		return sb.toString();
	}
}
