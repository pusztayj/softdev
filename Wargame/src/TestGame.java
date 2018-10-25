import java.util.*;
import java.io.*;
public class TestGame {
	
	private static WarGame game = new WarGame();
	
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
	
	public static void nextMove() {
		System.out.println(game.toString());
		game.step();
	}
}
