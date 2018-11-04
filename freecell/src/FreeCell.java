public class FreeCell extends AbstractCell{
	
	public FreeCell(){
		super();
	}
   
	@Override
	public boolean canAddTo(Card card) {
		if(cards.size() == 0){
			return true;
		}
		else {
			System.out.println("A card already exists in this free cell");
			return false;
		}
	}
	
	@Override
	public boolean canRemoveFrom(Card card) {
		if (cards.size() > 0){
			return true;
		}
		else {
			System.out.println("This free cell pile is empty");
			return false;
		}
	}
	
	@Override
	public Card remove() {
		return this.cards.remove(this.size() -1);
	}
}
