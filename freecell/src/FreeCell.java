public class FreeCell extends AbstractCell{
	
	public FreeCell(){
		super();
	}
   
	public boolean canAddTo(Card card) {
		if(cards.size() == 0){
			return true;
		}
		else {
			System.out.println("A card already exists in this free cell");
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
