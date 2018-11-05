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
	 * Returns the last card in the card arraylist (top of pile in game)
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
     * @param card you want to remove from the pile
     * @return false by default, can override in implementing classes
     */
	public boolean canRemoveFrom(Card card) {
		return false;
	}
}
