import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AbstractCell implements CellInterface {
	protected List<Card> cards;
	
	public AbstractCell(){
		cards = new ArrayList<Card>();
	}
	
	public String toString() {
		return cards.toString();
	}
	
	/**
	 * Returns the last card in the card arraylist (top of pile in game)
	 * @return
	 */
	public Card get() {
		return cards.get(this.size()-1);
	}

	public int size(){
		return cards.size();
	}
	
	public void add(Card c) {
		cards.add(c);
	}

	public Card remove() {
		throw new UnsupportedOperationException("Remove not supported");
	}

	public Iterator<Card> iterator() {
		return cards.iterator();
	}
 
	public boolean canAddTo(Card card){
		return false;
	}
 
	public boolean canRemoveFrom(Card card) {
		return false;
	}
}
