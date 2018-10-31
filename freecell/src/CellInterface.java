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

public interface CellInterface {
	
	/**
	 * Method header to add a card to a pile in the game
	 */
	public void add();

	/**
	 * Method header to count the number of cards in a pile
	 * @param stack - the pile you want to know the size of
	 */
    public int size(Stack<Card> stack);
    
    /**
     * Returns true or false, depending on if the pile is full
     * will return true if the pile is not full and a card can be added
     * otherwise the pile is full and will return false
     */
    public boolean canAddTo();

    /**
     * Returns true or false, depending on if the pile is empty
     * will return true if the pile is not empty and a card can be removed
     * otherwise the pile is empty and will return false
     */
    public boolean canRemoveFrom();
	
}
