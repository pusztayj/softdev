import java.util.ArrayList;
/**
 * The Move class that generates a move between two cells and assigns
 * a weight based on how good the move is in the strategy of freecell.
 * @author pusztayj
 * @author dut
 * @author babikr
 * @author brandl
 * @version 1.0
 */
public class Move {

	private CellInterface fromCell;
	private CellInterface toCell;
	private int weight;
	private Game game;
	
	/**
	 * The Move constructor that is passed the to toCell and fromCell along with 
	 * the game and constructs a weight for how good that move is.
	 * @param from CellInterface, the source cell
	 * @param to CellInterface the destination cell
	 * @param g the game that is being played.
	 */
	public Move(CellInterface from, CellInterface to, Game g) {
		fromCell = from;
		toCell = to;
		game = g;
		this.setWeight();
	}
	/**
	 * Returns a string that represents the move with all the cards within the cells.
	 */
	public String toString() {
		ArrayList<CellInterface> tempList = new ArrayList<CellInterface>();
		tempList.add(fromCell);
		tempList.add(toCell);
		return tempList.toString();
		
	}
	/**
	 * Gets the lenght of a cell after cards would have been moved out of it. This is 
	 * very important for calculating the weight of the move. 
	 * @return int representing the length of a cell after a move
	 */
    public int getLengthAfterMove() {
        int count = 1;
        if(fromCell instanceof Tableau) {
                if(toCell instanceof Tableau) {
                        if(toCell.isEmpty()) {
                                for(int j = fromCell.size()-1; j > 0;j--) {
                                       Card currentCard = fromCell.get(j);
                                       int currentCardRank = currentCard.getRank();
                                       Card nextCard = fromCell.get(j-1);
                                       int nextCardRank = nextCard.getRank();
                                       if(nextCardRank - currentCardRank == 1 && !(nextCard.sameColor(currentCard))) {
                                               count++;
                                       }
                                       else {
                                               break;
                                       }
                                }
                        }
                        else {
                                Card bottomToCell = toCell.get();
                                int bottomToCellRank =bottomToCell.getRank();
                                for(int j = fromCell.size()-1;j>0;j--) {
                                       Card currentCard = fromCell.get(j);
                                       int currentCardRank = currentCard.getRank();
                                       if(bottomToCellRank - currentCardRank == 1 && !(currentCard.sameColor(bottomToCell))){
                                               break;
                                       }
                                       else {
                                               count++;
                                       }
                                }
                        }
                }
        }
        return fromCell.size() - count;
 }
    /**
     * Goes through the free cell strategy and assigns weights to a move based on the strategy.
     */
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
				//Checks to see if an ace is behind card
				if(lengthAfterMove >= 1) {
					if(fromCell.get(lengthAfterMove-1).getRank() == 1) {
						weight += 50;
					}
				}
				//Checks to see if ace is two cards behind
				if(lengthAfterMove >= 2) {
					if(fromCell.get(lengthAfterMove-2).getRank() == 1) {
						weight += 25;
					}
				}
				
				//Looks for a two move combination to move a card to a foundation pile
				if(lengthAfterMove >=1) {
					for (int x=0; x < 4; x++) {
						CellInterface hc1 = game.getFoundationCell(x);
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
						CellInterface hc1 = game.getFoundationCell(x);
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
						CellInterface hc1 = game.getFreeCell(x);
						if(hc1.size() > 1) {
							int hr1 = hc1.get(hc1.size()-1).getRank();
							Suit hs1 = hc1.get(hc1.size()-1).getSuit();
							if (fromCell.get(lengthAfterMove-1).getRank()==hr1+1 && !(fromCell.get(lengthAfterMove-1).getSuit().equals(hs1))) {
								weight += 5;
							}
						}
					}	
				}	
				//Checks to see a one move combination would free up tableau				
				if (lengthAfterMove >=1) {
					for (int x=0; x < 8; x ++) {
						CellInterface tab=  game.getTableauCell(x);
						if (!tab.isEmpty()){
							if (tab.canAddTo(fromCell.get(lengthAfterMove-1))){
								weight +=5;
							}
						}
					}
				}
			}
			//Sets up moves into freecells
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
				//Checks if moving top card to freecell opens up an ace
				if(lengthAfterMove >= 1) {
					if(fromCell.get(lengthAfterMove-1).getRank() == 1) {
						weight += 8;
					}
				}
				//Checks one move combination to see that will a card to get to home cell
				if(lengthAfterMove >=1) {
					for (int x=0; x < 4; x++) {
						CellInterface hc1 = game.getFoundationCell(x);
						if(hc1.size() > 1) {
							int hr1 = hc1.get(hc1.size()-1).getRank();
							Suit hs1 = hc1.get(hc1.size()-1).getSuit();
							if (fromCell.get(lengthAfterMove-1).getRank() == hr1+1 && fromCell.get(lengthAfterMove-1).getSuit() == hs1) {
								weight += 5;
							}
						}
					}	
				}
				//Checks one move combination to see that will a move a tableau pile
				if(lengthAfterMove >=1) {
					for (int x=0; x < 8; x++) {
						CellInterface hc1 = game.getTableauCell(x);
						if(hc1.size() > 1) {
							int hr1 = hc1.get(hc1.size()-1).getRank();
							Suit hs1 = hc1.get(hc1.size()-1).getSuit();
							if (fromCell.get(lengthAfterMove-1).getRank() == hr1-1 && !(fromCell.get(lengthAfterMove-1).getSuit().equals(hs1))) {
								weight += 5;
							}
						}
					}	
				}
				//Checks two move combination to see that will a card to get to home cell
				if(lengthAfterMove >=2) {
					for (int x=0; x < 4; x++) {
						CellInterface hc1 = game.getFoundationCell(x);
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
		//Assigns weight to moving cards out of freecells
		if(fromCell instanceof FreeCell) {
			if (toCell instanceof Foundations) {
				weight = 100000;
			}
			else if (fromCell instanceof Tableau) {
				weight = 9000 - toCell.size();
			}
			else if (fromCell instanceof FreeCell) {
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
	/**
	 * Returns the source cell. 
	 * @return CellInterface
	 */
	public CellInterface getFrom() {
		return fromCell;
	}
	/**
	 * Returns the destination cell.
	 * @return CellInterface
	 */
	public CellInterface getTo() {
		return toCell;
	}
}
