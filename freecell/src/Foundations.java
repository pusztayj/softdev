/**
 * The Foundations class for FreeCell game
 * Represents the foundations pile in the Free Cell game
 * @author pusztayj
 * @author dut
 * @author babikr
 * @author brandl
 * @version 1.0
 */

public class Foundations extends AbstractCell{
	
	private static int maxSize = 13;
	private Suit type;
	
    /**
     * Constructor to create ArrayList from AbstractCell constructor
     */
	public Foundations(){
		super();
	}
	/**
     * Returns true or false, depending on if you can move a card
     * between two piles
     * @param fromCell - the cell representing the pile you want to move from 
     * @return boolean true if the move can be made, false if not
     */
	public boolean canMoveFrom(CellInterface fromCell) {
		if (fromCell.canRemoveFrom() && this.canAddTo(fromCell.get())) {
			return true;
		}
		else {
			return false;
		}
	}
	@Override
	/**
     * Checks foundations rules that card to add to pile is of
     * same color and one rank one greater than the top card in the pile
     * @param card - card you want to add to the foundations
     * @return boolean true if can add that card, otherwise false
     */
	public boolean canAddTo(Card card) {
		if (cards.size() < maxSize) {
			if(cards.size() == 0) {
				if(card.getRank() == 1) {
					this.type = card.getSuit();
					return true;
				}
				else {
					return false;
				}
			}
			else {
				if(this.type == card.getSuit()){
					Card topOfPile = cards.get(cards.size()-1);
					if(card.compareTo(topOfPile) == 1) {
						return true;
					}
					else { 
						return false;
					}
				}
				else {
					return false;
				}
			}
		}
		else {
			return false;
		}
	}
}
