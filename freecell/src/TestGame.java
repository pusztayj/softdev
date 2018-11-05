import java.util.ArrayList;

/**
 * A TestGame.java object represents a test for the Game model
 * @author pusztayj
 * @author dot
 * @author babikr
 * @author brandl
 * @version 1.0
 */
public class TestGame {

	private ArrayList<Tableau> tableauList; 
	
	
	/**
	 * Runs a nextMove on the war game until the game is over
	 * and a winner is determined
	 * @param args - optional string arguments
	 */
	public static void main(String[] args) {
		
		FreeCell freecell1 = new FreeCell();
		FreeCell freecell2 = new FreeCell();
		FreeCell freecell3 = new FreeCell();
		FreeCell freecell4 = new FreeCell();
		Foundations foundations1 = new Foundations(Suit.spade);
		Foundations foundations2 = new Foundations(Suit.heart);
		Foundations foundations3 = new Foundations(Suit.diamond);
		Foundations foundations4 = new Foundations(Suit.club);
		ArrayList<Tableau> tableauList = new ArrayList<Tableau>(); 
		Deck deck = new Deck();
		deck.shuffle();
		
		for(int i = 0; i<6; i++) {
			for(Tableau tab : tableauList) {
				tab.add(deck.deal());
			}
			System.out.println(tableauList.get(2));
		}
//		tableauList.get(0).add(deck.deal());
//		tableauList.get(1).add(deck.deal());
//		tableauList.get(2).add(deck.deal());
//		tableauList.get(3).add(deck.deal());
		
		
//		System.out.println("Expect 7: " + tableauList.get(2).size());
//		System.out.println("Removing card from Tableau");
//		Card fromCard = tableauList.get(2).get();
//		if(tableauList.get(2).canRemoveFrom(fromCard) && freecell1.canAddTo(fromCard)) {
//			freecell1.add(tableauList.get(2).remove());
//		}
//		System.out.println("Expect 6: " + tableauList.get(2).size());
//		System.out.println(tableauList.get(2));
//		System.out.println(freecell1);
//		
//		System.out.println("Print cards in tableau: ");
//
//		for (Card card : tableauList.get(2)) {
//			System.out.println(card);
//		}
		
	}

}