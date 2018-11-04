import java.util.*;


	public class Tableau extends AbstractCell{
		public Tableau(Suit type){
			super();
		}
		public boolean canAddTo(Card card) {
			Card topCard = this.cards.get(this.cards.size()-1);
			if (!(topCard.sameColor(card))) {
				if(card.getSuit() == type && card.getRank() == 1) {
					return true;
				}
				else {
					System.out.println("First card must be Ace of" + type);
					return false;
				}
			}
			else {
				if(type == card.getSuit()){
					Card topOfPile = cards.get(cards.size()-1);
					if(card.compareTo(topOfPile) == 1) {
						return true;
					}
					else { //if(cards.size() > 0)
						System.out.println("Next card must be one rank higher than top of pile" );
						return false;
					}
				}
				else {
					return false;
				}
			}
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
