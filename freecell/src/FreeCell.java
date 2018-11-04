import java.util.*;

public class FreeCell extends AbstractCell{
//private Suit type; this isnt needed
	FreeCell(){
		super();
		//this.type = type; again, not needed. So removed from argument
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
		if (! (cards.size() == 0)){
			return true;
		}
		else {
			System.out.println("This free cell pile is empty");
			return false;
		}
	}
}
