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
	
	public boolean canMoveFrom(CellInterface fromCell) {
		return fromCell.canRemoveFrom();
	}
	
	
	
	
	
//	@Override
//	/**
//     * Checks foundations rules that card to add to pile is of
//     * same color and one rank one greater than the top card in the pile
//     * @param card you want to add to the foundations
//     * @return boolean true if can add that card, otherwise false
//     */
//	public boolean canAddTo(Card card) {
//		if (cards.size() < maxSize) {
//			if(cards.size() == 0) {
//				if(card.getRank() == 1) {
//					this.type = card.getSuit();
//					return true;
//				}
//				else {
//					//System.out.println("First card must be Ace of" + type);
//					return false;
//				}
//			}
//			else {
//				if(type == card.getSuit()){
//					Card topOfPile = cards.get(cards.size()-1);
//					if(card.compareTo(topOfPile) == 1) {
//						return true;
//					}
//					else { 
//						//System.out.println("Next card must be one rank higher than top of pile" );
//						return false;
//					}
//				}
//				else {
//					return false;
//				}
//			}
//		}
//		else {
//			return false;
//		}
//	}
}
