import java.util.*;

/**
 * The cell interface for FreeCell game
 * @author pusztayj
 * @author dut
 * @author babikr
 * @author brandl
 * @version 1.0
 */

public interface CellInterface extends Iterable<Card>{
	/**
	* Method header to add a card to a pile in the game
	*/
	public void add(Card c);

	/**
	* Method header to count the number of cards in a pile
	*/
    public int size();
    
    /**
     * Returns true or false, depending on if the pile is full
     * will return true if the pile is not full and a card can be added
     * otherwise the pile is full and will return false
     */
    public boolean canAddTo(Card card);

    /**
     * Returns true or false, depending on if the pile is empty
     * will return true if the pile is not empty and a card can be removed
     * otherwise the pile is empty and will return false
     */
    public boolean canRemoveFrom();
    
    /**
     * Iterates through the content of the cells.
     */
    public Iterator<Card> iterator();
    
    /**
     * Checks the current cell's canAddTo and the fromCell's canRemoveFrom
     * @param fromCell
     * @return True if both methods return true, False otherwise
     */
    public boolean canMoveFrom(CellInterface fromCell);
    
    
    public boolean isEmpty();
    
    
    public boolean moveFrom(CellInterface fromCell);
    
    

    /**
     * Calls the remove method on the Cell's cards list
     * @return last Card in the list
     */
    public Card remove();
    
    
    /**
     * Looks at the last card in the list but does not remove it from the list
     * @return last Card in the list
     */
    public Card get(int index);
    
    /**
     * Gets the card that is at the front of the cards list.
     * @return last card in the list.
     */
    public Card get();

}
