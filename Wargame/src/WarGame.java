import java.util.*;

public class WarGame {

// string, deal, step, transfer cards (From war to winning - private), winner
	private Player player1 = new Player();
	private Player player2 = new Player();
	private List<Card>  warPile = new ArrayList<Card>();
	private String gameStatus = "";
	private Deck deck = new Deck();
	
	
	WarGame(){
		this.deck.shuffle();
	}
/**
 * Deals 26 cards to each player
 */
public void deal() {
	while(!this.deck.isEmpty()) {
		this.player1.addToUnplayedPile(this.deck.deal());
		this.player2.addToUnplayedPile(this.deck.deal());
	}
}
/**
 * Makes one move in the game, and returns the two cards played
 */
public void step() {
	Card card1 = this.player1.getCard();
	Card card2 = this.player2.getCard();
	this.warPile.add(card1);
	this.warPile.add(card2);
	this.gameStatus = "Player 1: " + "\n" + "Current Card " + card1 + "\n" + "Unplayed Pile: " + this.player1.unplayedPile.size() + "\n" + "War Pile: " + \
		this.warPile.size() + "\n" + "Winnings Pile: " + this.player1.winningsPile.size() + 
		"\n" + "\n" + "Player 2: " + "\n" + "Current Card " + card2 + "\n" + \
		"Unplayed Pile: " + this.player2.unplayedPile.size() + "\n" + "War Pile: " + \
	this.warPile.size() + "\n" + "Winnings Pile: " + this.player2.winningsPile.size();
	
}
/**
 * Transfers cards from the war pile to the player's pile
 * @param player
 */
private void transferCards(Player player) {
	while(!this.warPile.isEmpty()) {
		player.addToWinningsPile(this.warPile.remove(this.warPile.size()));
	}
}
/**
 * Returns a string indicating the player who won 
 * Or a tie if so
 * with each player's number of cards
 */
public String winner() {
	if (this.player1.isDone() || this.player2.isDone()) {
		int count1 = this.player1.winningsCount();
		int count2 = this.player2.winningsCount();
		if(count1 > count2) {
			return "Player 1 wins, " + count1 + " to " + count2 +"!";
		}
		else if (count2 > count1) {
            return "Player 2 wins, " + count2 + " to " + count1 +"!";
		}
		else {
			return "The game ends in a tie!\n";
		}
	}
}
}