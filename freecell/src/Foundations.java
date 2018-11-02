import java.util.*;

public class Foundations extends AbstractCell{
	
	private List<Card> cards;
	private Suit type;
	
	public Foundations(Suit type){
		this.type = type;
		cards = new ArrayList<Card>(13);
	}
    @Override
    public Iterator<Card> iterator() {
        return cards.iterator();
    }
	/**
	 * Adds a card to foundation pile with appropriate conditions
	 */
	public void add(Card card) {
		if(cards.size() == 0) {
			if(card.getSuit() == type && card.getRank() == 1) {
				cards.add(card);
			}
		}
		else if(cards.size() > 0) {
			if(type == card.getSuit()){
				Card topOfPile = cards.get(cards.size()-1);
				if(card.compareTo(topOfPile) == 1) {
					cards.add(card);
				}
			}	
		}
	}
}
