
import java.util.*;
import java.io.*;

/**
 * A TestGame.java object represents a test for the WarGame model
 * @author pusztayj
 * @author dot
 * @author babikr
 * @author brandl
 * @version 1.0
 */
public class TestGame {

	/**
 * Creates a new WarGame object for testing
 */
	private static WarGame game = new WarGame();


	/**
	 * Runs a nextMove on the war game until the game is over
	 * and a winner is determined
	 * @param args - optional string arguments
	 */
	public static void main(String[] args) {

		System.out.println("This is a tester application for the War Game.");
		while (!game.isDone()) {
			nextMove();
			System.out.println("Press enter to make next move.");
			try{
				System.in.read();
			}catch (IOException e) {
				System.out.println(e);
			}
		}
		System.out.println(game.winner());
	}

	/**
	 * Takes a next step in the game by drawing the top card
	 * from the unplayed card pile of a player
	 */
	public static void nextMove() {
		game.step();
		System.out.println(game.toString());
	}
}
