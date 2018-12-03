import java.util.ArrayList;

public class Move {

	private CellInterface fromCell;
	private CellInterface toCell;
	private int weight;
	private Game game;
	
	
	public Move(CellInterface from, CellInterface to, Game g) {
		fromCell = from;
		toCell = to;
		game = g;
		this.setWeight();
	}
	
	public String toString() {
		ArrayList<CellInterface> tempList = new ArrayList<CellInterface>();
		tempList.add(fromCell);
		tempList.add(toCell);
		return tempList.toString();
		
	}
	/*
	 * Returns the length of a spine.
	 */
//	public Integer getSpineLength(CellInterface cell) {
//		Integer spineLength = 1;
//		for(int x = cell.size()-1; x >= 0; x--) {
//			if(x == 0) {
//				break;
//			}
//			int topRank = cell.get(x).getRank();
//			String topColor = cell.get(x).getColor();
//			int bRank = cell.get(x-1).getRank();
//			String bColor = cell.get(x-1).getColor();
//			if(topColor != bColor) {
//				if(bRank - topRank == 1) {
//					spineLength++;
//					//System.out.println(x);
//				}
//				else {
//					break;
//				}
//			}
//			else {
//				break;
//			}
//		}
//		return spineLength;
//	}
//	
	
	public int getLengthAfterMove() {
		if (fromCell.getClass().equals(toCell.getClass())){
			int i = fromCell.size() - 1;
			
			if (toCell.isEmpty()) {
				int pointer = 100;
				while (i>=1) {
					Card currentCard = fromCell.get(i);
					Card nextCard = fromCell.get(i-1);
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
				return pointer;
			}
			
			//logic for when only bottom card can be moved
			Card fromCard = fromCell.get(i);
			Card thisCard = toCell.get(toCell.size() -1);
			if (!(fromCard.sameColor(thisCard)) && fromCard.compareTo(thisCard) == -1 ) {
				return i;
			}
			//logic for moving multiple cards
			int pointer = 100;
			//int pointer = 100;
			i = fromCell.size() - 1;
			while (i >= 1) {
				Card currentCard = fromCell.get(i);
				Card nextCard = fromCell.get(i - 1);
				if (!nextCard.sameColor(currentCard) && nextCard.compareTo(currentCard) == 1 && !nextCard.sameColor(thisCard) && !(nextCard.getRank() == thisCard.getRank())){
					pointer = i - 1;
					i--;
				}
				else {
					break;
				}
			}
			return pointer;
		}
		else {
			return fromCell.size() -1;
		}
	}
	public void setWeight() {
		if(fromCell instanceof Tableau) {
			int spineLen = fromCell.size() - this.getLengthAfterMove();
			int lengthAfterMove = this.getLengthAfterMove();	
			int rankOfTopPileMoved = fromCell.get(lengthAfterMove).getRank();
			
			if(toCell instanceof Foundations) {
				weight = 10000;
			}
				
			if (toCell instanceof Tableau) {
				
				//Check if moving to an empty tableau
				if (toCell.size() == 0) {
					//Avoids bouncing pile of cards between empty tableaux
					if (lengthAfterMove == 0) {
						weight = -1000;
					}
					//Gives priority to cards with higher rank to move into freecells
					else {
						if (rankOfTopPileMoved > 10) {
							weight = (rankOfTopPileMoved * 8);
						}
						else {
							weight = 50 + spineLen - lengthAfterMove;
						}
					}
				}
				//Takes care of one card in Tableau case
				else if (fromCell.size() == 1) {
					weight = 64; 
				}
				//Assigns weight if able to move to empty tableau with a pile of cards
				else {
					weight = 50 + (spineLen*3) - (lengthAfterMove*2);
				}
				//Assigns massive penalty if card bounces back and forth between piles
				if (lengthAfterMove >= 1 && toCell.size() >= 1) {
					if (fromCell.get(lengthAfterMove-1).getRank() == toCell.get(toCell.size()-1).getRank()) {
						if(fromCell.get(lengthAfterMove-1).getColor() == toCell.get(toCell.size()-1).getColor()) {
							weight = -10000;
						}	
					}
				}
				// Ensures that tableau are not being broken to have cards move pointlessly back and forth
				if (lengthAfterMove >= 1) {
					int aboveRank = fromCell.get(lengthAfterMove-1).getRank();
					String aboveColor = fromCell.get(lengthAfterMove-1).getColor();
					int cardRank = fromCell.get(lengthAfterMove-1).getRank();
					String cardColor = fromCell.get(lengthAfterMove-1).getColor();
					if(aboveRank == cardRank + 1 && !(aboveColor.equals(cardColor))) {
						weight = -1000;
					}
				}
				
				if(lengthAfterMove >= 1) {
					if(fromCell.get(lengthAfterMove-1).getRank() == 1) {
						weight += 50;
					}
				}
				if(lengthAfterMove >= 2) {
					if(fromCell.get(lengthAfterMove-2).getRank() == 1) {
						weight += 25;
					}
				}
				
				//Looks for a two move combination to move a card to a foundation pile
				if(lengthAfterMove >=1) {
					for (int x=0; x < 4; x++) {
						CellInterface hc1 = game.getFoundation().get(x);
						if(hc1.size() > 1) {
							int hr1 = hc1.get(hc1.size()-1).getRank();
							Suit hs1 = hc1.get(hc1.size()-1).getSuit();
							if (fromCell.get(lengthAfterMove-1).getRank() == hr1+1 && fromCell.get(lengthAfterMove-1).getSuit() == hs1) {
								weight += 5;
							}
						}
					}	
				}
				
				//Checks a three move combination would move a card to a foundation pile
				if(lengthAfterMove >=2) {
					for (int x=0; x < 4; x++) {
						CellInterface hc1 = game.getFoundation().get(x);
						if(hc1.size() > 1) {
							int hr1 = hc1.get(hc1.size()-1).getRank();
							Suit hs1 = hc1.get(hc1.size()-1).getSuit();
							if (fromCell.get(lengthAfterMove-2).getRank() == hr1+1 && fromCell.get(lengthAfterMove-2).getSuit() == hs1) {
								weight += 1;
							}
						}
					}	
				}
				
				//Checks if a two move combination would free up a freecell
				if(lengthAfterMove >=1) {
					for (int x=0; x < 4; x++) {
						CellInterface hc1 = game.getFreeCell().get(x);
						if(hc1.size() > 1) {
							int hr1 = hc1.get(hc1.size()-1).getRank();
							Suit hs1 = hc1.get(hc1.size()-1).getSuit();
							if (fromCell.get(lengthAfterMove-1).getRank()==hr1+1 && !(fromCell.get(lengthAfterMove-1).getSuit().equals(hs1))) {
								weight += 5;
							}
						}
					}	
				}	
				
//				//Checks a two move combination to make sure a tableau can be moved afterwards 
//				if(lengthAfterMove >=1) {
//					for (int x=0; x < 8; x++) {
//						Tableau tab = game.getTableau().get(x);
//						if(tab.size() > 1) {
//							int tabRankTop = tab.get(tab.getTopOfMovableTableau()).getRank();
//							Suit tabSuitTop = tab.get(tab.getTopOfMovableTableau()).getSuit();
//							if (fromCell.get(gpos-1).getRank() == tabRankTop+1 &&
//									!(fromCell.get(lengthAfterMove-1).getSuit().equals(tabSuitTop))) {
//								weight += 5;
//							}
//						}
//					}	
//				}	
			}
			
			
			if (toCell instanceof FreeCell) {
				weight = 30 - lengthAfterMove;  
				if (lengthAfterMove >= 1) {
					int aboveRank = fromCell.get(lengthAfterMove-1).getRank();
					String aboveColor = fromCell.get(lengthAfterMove-1).getColor();
					int cardRank = fromCell.get(lengthAfterMove-1).getRank();
					String cardColor = fromCell.get(lengthAfterMove-1).getColor();
					if(aboveRank == cardRank + 1 && !(aboveColor.equals(cardColor))) {
						weight = -1000;
					}
				}
				//Lowers weight of moves that move low value or high value cards into freecell
				if (rankOfTopPileMoved > 10 || rankOfTopPileMoved < 5) {
					weight -= (rankOfTopPileMoved / 4);
				}
				
				if(lengthAfterMove >= 1) {
					if(fromCell.get(lengthAfterMove-1).getRank() == 1) {
						weight += 8;
					}
				}
				if(lengthAfterMove >=1) {
					for (int x=0; x < 4; x++) {
						CellInterface hc1 = game.getFoundation().get(x);
						if(hc1.size() > 1) {
							int hr1 = hc1.get(hc1.size()-1).getRank();
							Suit hs1 = hc1.get(hc1.size()-1).getSuit();
							if (fromCell.get(lengthAfterMove-1).getRank() == hr1+1 && fromCell.get(lengthAfterMove-1).getSuit() == hs1) {
								weight += 5;
							}
						}
					}	
				}
				if(lengthAfterMove >=1) {
					for (int x=0; x < 8; x++) {
						CellInterface hc1 = game.getTableau().get(x);
						if(hc1.size() > 1) {
							int hr1 = hc1.get(hc1.size()-1).getRank();
							Suit hs1 = hc1.get(hc1.size()-1).getSuit();
							if (fromCell.get(lengthAfterMove-1).getRank() == hr1-1 && !(fromCell.get(lengthAfterMove-1).getSuit().equals(hs1))) {
								weight += 5;
							}
						}
					}	
				}
				if(lengthAfterMove >=2) {
					for (int x=0; x < 4; x++) {
						CellInterface hc1 = game.getFoundation().get(x);
						if(hc1.size() > 1) {
							int hr1 = hc1.get(hc1.size()-1).getRank();
							Suit hs1 = hc1.get(hc1.size()-1).getSuit();
							if (fromCell.get(lengthAfterMove-2).getRank() == hr1+1 && fromCell.get(lengthAfterMove-2).getSuit()==hs1) {
								weight += 2;
							}
						}
					}	
				}
			}
		}
		if(fromCell instanceof FreeCell) {
			if (toCell instanceof Foundations) {
				weight = 10000;
			}
			if (fromCell instanceof Tableau) {
				weight = 9999 - toCell.size();
			}
			if (fromCell instanceof FreeCell) {
				weight = -100;
			}
		}
	}
	
	/*
	 * Returns the weight of a move.
	 */
	public int getWeight() {
		return weight;
	}
	
	public CellInterface getFrom() {
		return fromCell;
	}
	public CellInterface getTo() {
		return toCell;
	}
}
