import java.util.*;


	public class Tableau extends AbstractCell{
		public Tableau(Suit type){
			super();
		}
		
		/**
	     * Checks tabluea rules that card to add to pile is of
	     * opposite color and one rank one less than the top card in the pile
	     * @param card you want to add to the tableau
	     * @return boolean true if can add that card, otherwise false
	     */
		public boolean canAddTo(Card card) {
			Card topCard = this.cards.get(this.cards.size()-1);
			if (!(topCard.sameColor(card))) {
				if (card.greaterByOne(topCard)) {
					return true;
				}		
			}
			else {
				return false;
			}
			
			
		public boolean canRemoveFrom(Card card) {
			if (! (cards.size() == 0)){
				return true;
			}
			else {
				System.out.println("This free cell pile is empty");
				return false;
			}
		}
