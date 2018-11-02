import java.util.Iterator;

public class Tester {
	
}
    public static void main(String[] args) {
    	Deck deck = new Deck();
    	deck.shuffle();
    	Card one = deck.deal();
    	Card two = deck.deal();
    	System.out.println(one);
    	System.out.println(two);
    	Foundations a = new Foundations(Suit.heart);   
    	a.add(one);
    	a.add(two);
    	for (Card card : a)
//    	for (Iterator<Card> iterator = a.cards.iterator(); iterator.hasNext();) {
//			Card card = iterator.next();
//			System.out.println(card);
//		}
}
