package dicegame;

public class GameStarter {

	public static void main(String[] args) {
		Player playerOne = new Player("Alessandro", "Fusco", "Ale", new Dice());
		Player playerTwo = new Player("Dr.", "Jeckyll", "Mr.Hide", new Dice());
		
		Game game = new Game(playerOne, playerTwo);
		
		game.play(2);
		
		Player max = new Player("Max", "Verstappen", "Max", new Dice());
		playerOne.setDice(new Dice(1, 12));
		game.setPlayerTwo(max);
		
		game.play(2);
		
	}

}
