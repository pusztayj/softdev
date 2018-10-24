import java.util.*;
public class Tester {
	
	public static void main(String[] args) {
		WarGame game = new WarGame();
		System.out.println("This is a tester application for the War Game.");
		
		// Test deal method
		System.out.println("Deal 26 cards to each player:");
		System.out.println("Expect each Player's Unplayed Pile to be size 26.");
		game.deal();
		System.out.println("Player 1 Unplayed Pile Length:");
		System.out.println(game.player1.unplayedCount());
		System.out.println("Player 2 Unplayed Pile Length:");
		System.out.println(game.player2.unplayedCount());
		
		
		//Test step method 
		System.out.println("One step in game. Will print each player's card and decrease unplayed pile length by 1");
		game.step();
		System.out.println(game.gameStatus);
		
		
		//Test transferCards method
		System.out.println("Player 1 winnings pile: ");
		System.out.println(game.player1.winningsCount());
		System.out.println("Test Player 1 receiving the two card war pile to winnings pile");
		game.transferCards(game.player1);
		System.out.println("Player 1 updated winnings pile: ");
		System.out.println(game.player1.winningsCount());
		//Test for player 2
		//System.out.println("Player 2 winnings pile: ");
		//System.out.println(game.player2.winningsCount);
		//System.out.println("Test Player 2 receiving the two card war pile to winnings pile");
		//game.transferCards(game.player2);
		//System.out.println("Player 2 updated winnings pile: ");
		//System.out.println(game.player2.winningsCount);
		
		//Test winner method
		System.out.println("Run game and force player 1 to win all steps");
		WarGame game2 = new WarGame();
		game2.deal();
		for (int i = 0; i < game2.player1.unplayedCount(); i++) {
			game2.step();
			game2.transferCards(game2.player1);
		}
		System.out.println(game2.winner());
		
		
		
	}
	
}
