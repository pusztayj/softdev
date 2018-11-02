import java.util.*;

public class Foundations extends AbstractCell{
	
	private List<Card> cards;
	private Suit type;
	
	Foundations(Suit type){
		this.type = type;
		cards = new ArrayList<Card>();
	}
    @Override
    public Iterator<Card> iterator() {
        return cards.iterator();
    }
	/**
	 * Adds a card to foundation pile with appropriate conditions
	 */
	public void add(Card card) {
		if(cards.size() == 0 && card.getSuit() == type && card.getRank() == 1){
			cards.add(card);
			System.out.println(cards);
		}
		else if(type == card.getSuit()){
			Card topOfPile = cards.get(0);
			if(card.compareTo(topOfPile) == 1) {
				cards.add(0, card);
				System.out.println(cards);
			}
			else {
				System.out.println("Card is not one rank higher");
			}
		}
		else {
			System.out.println("Card not same type");
		}
	}
    public static void main(String[] args) {
    	Deck deck = new Deck();
    	deck.shuffle();
    	Foundations a = new Foundations(Suit.heart);
    	for(int i = 0; i < 52; ++i){
    		Card card = deck.deal();
    		a.add(card);
    	}
    	for (Iterator<Card> iterator = a.cards.iterator(); iterator.hasNext();) {
			Card card = iterator.next();
			System.out.println(card);
		}
   	
    }

}
