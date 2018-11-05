/**
 * The FreeCell class for FreeCell game
 * Represents the free cell pile in the Free Cell game
 * @author pusztayj
 * @author dut
 * @author babikr
 * @author brandl
 * @version 1.0
 */

public class FreeCell extends AbstractCell{
	
	/**
     * Constructor to create ArrayList from AbstractCell constructor
     */
	public FreeCell(){
		super();
	}
   
	@Override
	/**
     * Checks free cell pile rules that pile does not already have a card in it
     * @param card you want to add to the free cell
     * @return boolean true if can add that card, otherwise false
     */
	public boolean canAddTo(Card card) {
		if(cards.size() == 0){
			return true;
		}
		else {
			System.out.println("A card already exists in this free cell");
			return false;
		}
	}
	
	@Override
	/**
     * Returns true or false, depending on if we can remove a card
     * from the pile or not 
     * @param card you want to remove from the pile
     * @return true if the pile is not full, false if it is full
     */
	public boolean canRemoveFrom(Card card) {
		if (cards.size() > 0){
			return true;
		}
		else {
			System.out.println("This free cell pile is empty");
			return false;
		}
	}
	
	@Override
	/**
     * Removes the last card in the list
     * @return card on top of the pile
     */
	public Card remove() {
		return this.cards.remove(this.size() -1);
	}
}
