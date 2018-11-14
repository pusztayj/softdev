import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * The AbstractCell class for FreeCell game
 * @author pusztayj
 * @author dut
 * @author babikr
 * @author brandl
 * @version 1.0
 */

public class AbstractCell implements CellInterface {
	
	protected List<Card> cards;
    
	/**
     * Constructor to create array list for cards pile
     */
	public AbstractCell(){
		cards = new ArrayList<Card>();
	}
	
	/**
     * Returns a list of cards as a string
     * @return the string representation of the list
     */
	public String toString() {
		return cards.toString();
	}
	
	/**
	 * Returns the card at the specified index
	 * @param index - index for the card you want
	 * @return the last card
	 */
	public Card get(int index) {
		return cards.get(index);
	}
	
	/**
	 * Returns the last card in the card arraylist (top of pile in game)
	 * @return the last card in the stack
	 */
	public Card get() {
		return cards.get(this.size()-1);
	}

	/**
     * Returns the length of a list of cards 
     * @return the length of the list
     */
	public int size(){
		return cards.size();
	}
	
	/**
     * Calls add on the list of cards 
     * @param card object to add to the list
     */
	public void add(Card c) {
		cards.add(c);
	}
	/**
     * Checks if the card be removed from a cell
     * @param fromCell - cell object
     * @return false by default
     */
	public boolean canMoveFrom(CellInterface fromCell) {
		return false;
	}
	/**
     * Checks if the card be moved from a cell and then removes the card from the 
     * cell and adds it to the appropriate cell.
     * @param fromCell - card object to add to the list
     * @return boolean true or false if moved the card
     */
	public boolean moveFrom(CellInterface fromCell) {
		if (this.canMoveFrom(fromCell)) {
			this.add(fromCell.remove());
			return true;
		}
		else {
			return false;
		}
	}
	/**
     * Throws an exception by default on removing a card
     */
	public Card remove() {
		throw new UnsupportedOperationException("Remove not supported");
	}

	/**
     * Returns an iterator on the list of cards 
     * @param iterator object to run on a pile of cards
     * @return iterator on the cards list
     */
	public Iterator<Card> iterator() {
		return cards.iterator();
	}
	
	/**
     * Returns true or false, depending on if we can add a card
     * to the pile or not 
     * @param card you want to add to the pile
     * @return false by default, can override in implementing classes
     */
	public boolean canAddTo(Card card){
		return false;
	}
 
	/**
     * Returns true or false, depending on if we can remove a card
     * from the pile or not 
     * @return false by default, can override in implementing classes
     */
	public boolean canRemoveFrom() {
		return false;
	}
	/**
	 * Clears the cards list for a cell.
	 */
	public void clear() {
		this.cards.clear();
	}
	
	/**
	 * Checks if the cell is empty.
	 * @return boolean if the stack is empty or not 
	 */	
	public boolean isEmpty() {
		return cards.isEmpty();
	}
}
