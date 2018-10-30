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
	
	public void add();

    public int size(Stack<Card> stack);
    
    public boolean canAddTo(Card card);

    public boolean canRemoveFrom(Card card);
	
}
