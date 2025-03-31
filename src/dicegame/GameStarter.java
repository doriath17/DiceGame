package dicegame;

public class GameStarter {

	public static void main(String[] args) {
		Player playerOne = new Player("Alessandro", "Fusco", "Ale", new Dice());
		Player playerTwo = new Player("Dr.", "Jeckyll", "Mr.Hide", new Dice());
		int rounds = 3;
		
		Game game1 = new Game(playerOne, playerTwo, rounds);
		
		game1.play();		
	}

}
