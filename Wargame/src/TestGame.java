import java.util.*;
public class TestGame {
	
	public static void main(String[] args) {
		WarGame game = new WarGame();
		
		System.out.println("This is a tester application for the War Game.");
		while (!game.isDone()) {
			System.out.println(game.toString());
			game.step();

		}
		System.out.println(game.winner());
	}
}
