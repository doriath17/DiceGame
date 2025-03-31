package dicegame;

public class Game {
	
	public static final int NUM_ROUNDS_DEFAULT = 1;
	
	private Player playerOne;
	private Player playerTwo;
	
	// num_rounds >= 1 (in caso di errori settato al valore di default = 1)
	public Game(Player playerOne, Player playerTwo) {
		this.playerOne = playerOne;
		this.playerTwo = playerTwo;
	}
	
	
	public void setPlayerOne(Player playerOne) {
		this.playerOne = playerOne;
	}
	
	
	public void setPlayerTwo(Player playerTwo) {
		this.playerTwo = playerTwo;
	}
	
	
	public void play(int numRounds) {
		System.out.println(
				"\nHere we have the two players:\n" + 
				playerOne + "\n" +
				playerTwo + 
				"\n\nGAME START!!!"
		);
		
		numRounds = checkNumRounds(numRounds);
		
		playerOne.resetScore();
		playerTwo.resetScore();
	
		for (int i=0; i<numRounds; i++) {
			System.out.println("\nround : " + (i+1));
			playRound();
		}
		
		System.out.println(getGameResults());
	}
	
	
	// se il numero di rounds <= 0 imposta a 1
	// se e' valido non lo cambia
	private int checkNumRounds(int numRounds) {
		if (numRounds < NUM_ROUNDS_DEFAULT) {
			return NUM_ROUNDS_DEFAULT;
		} else {			
			return numRounds;
		}
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
			sb.append("GAME TIED!!\n");
			sb.append(
					playerOne.nickname + " with " + playerOne.getScore() + " points!\n" + 
					playerTwo.nickname + " with " + playerTwo.getScore() + " points!\n"
				);
		} else {
			sb.append(winner.nickname + " wins the game!!\n\n");
			sb.append(
					winner.nickname + " wins with "  + winner.getScore() + " points!\n" + 
					loser.nickname  + " loses with " + loser.getScore()  + " points.\n"
				);
		}
		
		return sb.toString();
	}
}
