public class Foundations extends AbstractCell{
	
	private static int maxSize = 13;
	private Suit type;
	
	public Foundations(Suit type){
		super();
		this.type = type;
	}
	
	@Override
	public boolean canAddTo(Card card) {
		if (cards.size() < maxSize) {
			if(cards.size() == 0) {
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
		else {
			return false;
		}
	}
}
