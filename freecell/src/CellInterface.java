import java.util.*;

/**
 * The cell interface for FreeCell game
 * @author lambertk
 * @author pusztayj
 * @author dot
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
    public boolean canRemoveFrom(Card card);
    
    public Iterator<Card> iterator();

}
