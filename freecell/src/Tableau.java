public class Tableau extends AbstractCell{
	
	private static int maxSize = 19;
	
	public Tableau(){
		super();
	}
	
	/**
     * Checks tableau rules that card to add to pile is of
     * opposite color and one rank one less than the top card in the pile
     * @param card you want to add to the tableau
     * @return boolean true if can add that card, otherwise false
     */
	public boolean canAddTo(Card card) {
		if (cards.size() < maxSize){
			Card topCard = this.cards.get(this.cards.size() -1);
			if (topCard.sameColor(card) || topCard.compareTo(card) != 1) {
				return false;
			}
			else {
				return true;
			}
		}
		else {
			return false;
		}
	}

	public boolean canRemoveFrom(Card card) {
		if (cards.size() > 0){
			return true;
		}
		else {
			System.out.println("This free cell pile is empty");
			return false;
		}
	}
}