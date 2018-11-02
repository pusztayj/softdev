import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class AbstractCell implements CellInterface {
	
	protected List<Card> cards;

	
	public AbstractCell(){
		cards = new ArrayList<Card>();
	}

	 public int size(){
	 	return cards.size();
	 }
	 
	 public void add(Card c) {
		 if (this.canAddTo(c)) {
			 cards.add(c);
		 }
		 
	 }

	 public Card remove() {
        throw new UnsupportedOperationException(
                "Remove not supported");

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