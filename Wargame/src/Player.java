import java.util.*;

/**
 * A Player.java object represents a single WarGame player
 * with their own unplayed and winnings card piles
 * @author pusztayj
 * @author dot
 * @author babikr
 * @author brandl
 * @version 1.0
 */
public class Player {

// Sets up the player's unplayed and winnings pile.

	private List<Card>  unplayed;
	private List<Card>  winnings;
	private Card currentCard;

	Player(){
		unplayed = new ArrayList<Card>();
		winnings = new ArrayList<Card>();
	}
/**
* Adds card to the player's unplayed pile
* @param card
*/
public void addToUnplayedPile(Card card) {
	this.unplayed.add(card);
}

/**
* Adds card to the player's winning pile
* @param card
*/
public void addToWinningsPile(Card card) {
	this.winnings.add(card);
}

/**
* Removes and returns a card from the player's unplayed pile
* @return the removed card
*/
public Card getCard() {
	Card remove_card = this.unplayed.get(0);
	this.unplayed.remove(0);
	this.currentCard = remove_card;
	return remove_card;
}

/**
 * Returns top card in player's unplayed pile
 * @return top card
 */
public Card seeCard() {
	//return this.unplayed.get(0);
	return this.currentCard;
}

/**
* Returns True if the player's unplayed pile is empty or False otherwise
* @return True or False
*/
public Boolean isDone() {
	if(this.unplayed.size() == 0) {
		return true;
	}
	else {
		return false;
	}
}

/**
* Returns the number of cards in the player's winnings pile
* @return number of cards (integer)
*/
public int winningsCount() {
	return this.winnings.size();
}

/**
 * Returns the length of the arrayed list of unplayed cards.
 * @return the length
 */
public int unplayedCount() {
	return this.unplayed.size();
}
}
