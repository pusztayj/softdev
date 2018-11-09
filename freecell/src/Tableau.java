/**
 * The Tableau class for FreeCell game
 * Represents the Tableau pile in the Free Cell game
 * @author pusztayj
 * @author dut
 * @author babikr
 * @author brandl
 * @version 1.0
 */

public class Tableau extends AbstractCell{
	
	private static int maxSize = 19;
	
    /**
     * Constructor to create ArrayList from AbstractCell constructor
     */
	public Tableau(){
		super();
	}
	
	@Override
	/**
     * Checks tableau rules that card to add to pile is of
     * opposite color and one rank one less than the top card in the pile
     * @param card you want to add to the tableau
     * @return boolean true if can add that card, otherwise false
     */
	public boolean canAddTo(Card card) {
		if (cards.size() < maxSize){
			Card topCard = this.cards.get(this.cards.size() -1);
			if (topCard.sameColor(card) || topCard.compareTo(card) != 1) {
				return false;
			}
			else {
				return true;
			}
		}
		else {
			return false;
		}
	}

	/**
     * Returns true or false, depending on if we can remove a card
     * from the pile or not 
     * @param card you want to remove from the pile
     * @return true if the pile is not full, false if it is full
     */
	@Override
	public boolean canRemoveFrom() {
		if (cards.size() > 0){
			return true;
		}
		else {
			//System.out.println("This free cell pile is empty");
			return false;
		}
	}
	
	
	/**
     * Removes the last card in the list
     * @return card on top of the pile
     */
	@Override
	public Card remove() {
		return this.cards.remove(this.size() -1);
	}
}