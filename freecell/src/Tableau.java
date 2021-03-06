import java.util.ArrayList;
/**
 * The Tableau class for FreeCell game
 * Represents the Tableau pile in the Free Cell game
 * @author pusztayj
 * @author dut
 * @author babikr
 * @author brandl
 * @version 1.0
 */

public class Tableau extends AbstractCell{
	
	private static int maxSize = 19;
	//private int pointer;
	
	
    /**
     * Constructor to create ArrayList from AbstractCell constructor
     */
	public Tableau(){
		super();
		
		
	}
	
	@Override
	/**
     * Checks tableau rules that card to add to pile is of
     * opposite color and one rank one less than the top card in the pile
     * @param card you want to add to the tableau
     * @return boolean true if can add that card, otherwise false
     */
	public boolean canAddTo(Card card) {
		if (cards.size() < maxSize){
			if (this.isEmpty()) {
				return true;
			}
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

	/**
     * Returns true or false, depending on if we can remove a card
     * from the pile or not 
     * @return true if the pile is not full, false if it is full
     */
	@Override
	public boolean canRemoveFrom() {
		if (cards.size() > 0){
			return true;
		}
		else {
			//System.out.println("This free cell pile is empty");
			return false;
		}
	}
	/**
     * Returns true or false, depending on if we can remove a card
     * from the pile or not 
     * @param fromCell - the cell representing the pile you want to move from
     * @return boolean true if can move from the pile, false if not
     */
	public boolean canMoveFrom(CellInterface fromCell) {		
		//check if fromCell is a Tableau
		if (fromCell.getClass().equals(this.getClass()) && fromCell.canRemoveFrom()) {
			int i = fromCell.size() - 1;
			Card fromCard = fromCell.get(i);
			if (this.isEmpty()) {
				return true;
			}
			Card thisCard = this.get(this.size() -1);
			if (!(fromCard.sameColor(thisCard)) && fromCard.compareTo(thisCard) == -1 ) {
				return true;
			}
			int pointer = 100;
			while (i >= 1) {
				Card currentCard = fromCell.get(i);
				Card nextCard = fromCell.get(i - 1);
				if (!nextCard.sameColor(currentCard) && nextCard.compareTo(currentCard) == 1) {
					pointer = i - 1;
					i --;
					
				}
				else {
					break;
				}
				
			}
			if (pointer != 100) {
				Card firstAddedCard = fromCell.get(pointer);
				return this.canAddTo(firstAddedCard);
			}
			return false;

		}
		else {
			if (fromCell.canRemoveFrom() && this.canAddTo(fromCell.get())) {
				return true;
			}
			else {
				return false;
			}
	
		}
	
	}
	/**
     * Returns true or false, depending on if we can remove a card
     * from the pile or not 
     * @param fromCell - cell representing the pile you want to move from
     * @return boolean strue if can move from the pile, false if not
     * if can move from, will also execute the move
     */
	public boolean moveFrom(CellInterface fromCell) {
		if (this.canMoveFrom(fromCell)) {
			if (fromCell.getClass().equals(this.getClass())){
				// Loop logic goes here
				int i = fromCell.size() - 1;
				//logic for adding pile to empty card
				if (this.isEmpty()) {
					int pointer = 100;
					while (i >= 1) {
						Card currentCard = fromCell.get(i);
						Card nextCard = fromCell.get(i - 1);
						if (!nextCard.sameColor(currentCard) && nextCard.compareTo(currentCard) == 1){
							pointer = i - 1;
							i--;
						}
						else if (i == fromCell.size() - 1 ){
							pointer = fromCell.size() - 1;
							break;
						}
						else {
							break;
						}
					}
					ArrayList<Card> addList = new ArrayList<Card>();
					for (; pointer < fromCell.size(); pointer++) {
						addList.add(fromCell.get(pointer));
					}
					for (Card card : addList) {
						this.add(card);
					}
					for (int x = 0; x < addList.size(); x++) {
						fromCell.remove();
					}
					return true;
					
				}
				
				//logic for when only bottom card can be moved
				Card fromCard = fromCell.get(i);
				Card thisCard = this.get(this.size() -1);
				if (!(fromCard.sameColor(thisCard)) && fromCard.compareTo(thisCard) == -1 ) {
					this.add(fromCell.remove(i));
					return true;
				}
				
				//logic for moving multiple cards
				int pointer = 100;
				//int pointer = 100;
				i = fromCell.size() - 1;
				while (i >= 1) {
					Card currentCard = fromCell.get(i);
					Card nextCard = fromCell.get(i - 1);
					if (!nextCard.sameColor(currentCard) && nextCard.compareTo(currentCard) == 1){
						
						pointer = i - 1;
						i--;
					}
					else {
						break;
					}
				}
				ArrayList<Card> addList = new ArrayList<Card>();
				for (; pointer < fromCell.size(); pointer++) {
					addList.add(fromCell.get(pointer));
				}
				for (Card card : addList) {
					this.add(card);
				}
				for (int x = 0; x < addList.size(); x++) {
					fromCell.remove();
				}
				return true;
				
			}
			else {
				this.add(fromCell.remove());
				return true;
			}
		}
		else {
			return false;
		}
	}

	
	/**
     * Removes the last card in the list
     * @return card on top of the pile
     */
	@Override
	public Card remove() {
		return this.cards.remove(this.size() -1);
	}
	
	public Card remove(int index) {
		return this.cards.remove(index);
	}
}