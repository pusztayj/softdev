public class Tester {
    public static void main(String[] args) {
    	Deck deck = new Deck();
    	deck.shuffle();
    	Foundations a = new Foundations(Suit.heart);
    	for(int i = 0; i < 52; ++i){
    		Card card = deck.deal();
    		a.add(card);
    	}
    	for (Card card: a) {
			System.out.println(card);
		}
   	
    }	
}


