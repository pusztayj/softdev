import java.util.*;

public class Player {
//len, str, add to unplayed pile, add to winnings pile, get card, is done, winnings count
	
// Instance Variables 
// Sets up the player's unplayed and winnings pile.
	
	private List<Card>  unplayed;
	private List<Card>  winnings; 
	
	
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
public void addtoWinningsPile(Card card) {
	this.winnings.add(card);
}
	
/**
* Removes and returns a card from the player's unplayed pile
* @return the removed card
*/
public Card getCard() {
	Card remove_card = this.unplayed.get(0);
	this.unplayed.remove(0);
	return remove_card;
}
	
/**
* Returns True if the player's unplyaed pile is empty or False otherwise
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

public int unplayedCount() {
	return this.unplayed.size();
}
}