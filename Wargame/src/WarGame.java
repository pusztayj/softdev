import java.util.*;

/**
 * A WarGame.java object represents the model for playing a game of war
 * with two players
 * @author pusztayj
 * @author dot
 * @author babikr
 * @author brandl
 * @version 1.0
 */
public class WarGame {

	private Player player1;
	private Player player2;
	private List<Card>  warPile;
	private Deck deck;
	private int moveCount;

	/**
	 * Sets the game by creating the players and deck
   * and deals the deck between the two players
	 */
	WarGame(){
		player1 = new Player();
		player2 = new Player();
		warPile = new ArrayList<Card>();
		moveCount = 0;
		deck = new Deck();
		this.deck.shuffle();
		this.deal();
	}

	/**
	 * Resets the game by constructing new players
   * and deals a new deck to the two players
	 */
	public void reset() {
		player1 = new Player();
		player2 = new Player();
		warPile = new ArrayList<Card>();
		moveCount = 0;
		deck = new Deck();
		this.deck.shuffle();
		this.deal();
	}
	/**
	 * returns String format of WarGame
	 * @return the string represetnation of the game state
	 */
	public String toString() {
		Card card1 = this.player1.seeCard();
		Card card2 = this.player2.seeCard();
		return "Player 1: " + "\n" + "Current Card: " + card1 + "\n" + "Unplayed Pile: " + this.player1.unplayedCount() + "\n" + "War Pile: " +
				this.warPile.size() + "\n" + "Winnings Pile: " + this.player1.winningsCount() +
				"\n" + "\n" + "Player 2: " + "\n" + "Current Card: " + card2 + "\n" +
				"Unplayed Pile: " + this.player2.unplayedCount() + "\n" + "War Pile: " +
			    this.warPile.size() + "\n" + "Winnings Pile: " + this.player2.winningsCount() + "\n\n" +
				"Move Count: " + this.getMoveCount() + "\n";

	}

	/**
	 * Returns number of moves in game
	 * @return integer moveCount
	 */
	public int getMoveCount() {
		return this.moveCount;
	}

	/**
	 * Deals 26 cards to each player
	 */
	private void deal() {
		while(!this.deck.isEmpty()) {
			this.player1.addToUnplayedPile(this.deck.deal());
			this.player2.addToUnplayedPile(this.deck.deal());
		}
	}
	/**
	 * Makes one move in the game, and returns the two cards played
	 */
	public void step() {
		this.moveCount ++;
		Card card1 = this.player1.getCard();
		Card card2 = this.player2.getCard();
		this.warPile.add(card1);
		this.warPile.add(card2);
		if (card1.getRank() > card2.getRank()){
			this.transferCards(this.player1);
		}
		else if (card2.getRank() > card1.getRank()) {
			this.transferCards(this.player2);
		}else {
			;
		}
	}
	/**
	 * Gets the card being played by player1
	 * @return the card being played
	 */
	public Card getCard1() {
		return this.player1.seeCard();
	}

	/**
	 * Gets the card being played by player2
	 * @return the card being played
	 */
	public Card getCard2() {
		return this.player2.seeCard();
	}

	/**
	 * Transfers cards from the war pile to the winning player's pile
	 * @param player - player to receive the cards as added to their winnings pile
	 */
	public void transferCards(Player player) {
		while(!this.warPile.isEmpty()) {
			player.addToWinningsPile(this.warPile.remove(this.warPile.size() - 1));
		}
	}

	/**
	 * Checks if WarGame is over
	 * @return True or False
	 */
	public Boolean isDone() {
		if (this.player1.isDone() || this.player2.isDone()) {
			return true;
		}
		return false;
	}

	/**
	 * Returns a string indicating the player who won
	 * with each player's number of cards
	 * @return the winner as determined by the player with
	 * the greater winnings pile at the end of the game
	 */
	public String winner() {
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
