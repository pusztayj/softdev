/**
 * The Game class for the freecell game. It runs the moves in the freecell game and moves the cards
 * between the various piles. 
 * @author pusztayj
 * @author dut
 * @author babikr
 * @author brandl
 * @version 1.0
 */

import java.util.*;

public class Game {
	
	private Deck deck;
	private ArrayList<CellInterface> tableauList;
	private ArrayList<CellInterface> freecellList;
	private ArrayList<CellInterface> foundationsList;
	private static int moveCount = 0;

	/**
     * Constructor for the game that creates all of the piles, the deck and distributes the 
     * cards randomly to the tableau piles.
     */
	public Game(){
		this.freecellList = new ArrayList<CellInterface>(); 
		for(int i = 0; i<4; i++){
			this.freecellList.add(new FreeCell());
		}
		this.foundationsList = new ArrayList<CellInterface>();
		for(int i = 0; i < 4; i++) {
			this.foundationsList.add(new Foundations());
		}
		this.tableauList = new ArrayList<CellInterface>();
		for(int i = 0; i<8; i++) {
			this.tableauList.add(new Tableau());
		}
		this.setup();
	}
	
	/**
	 * Deals the cards into the tableau piles. 
	 */
	public void setup() {
		this.deck = new Deck();
		this.deck.shuffle();
		for(int i = 0; i<6; i++) {
			for(CellInterface tab : tableauList) {
				Card tempCard = this.deck.deal();
				tempCard.turn();
				tab.add(tempCard);
			}
		}
		for(int i = 0; i < 4; i++) {
			Card tempCard = this.deck.deal();
			tempCard.turn();
			tableauList.get(i).add(tempCard);
		}
	}
	
	/**
	 * gets the number of legal moves made thus far
	 * @return - the number of moves
	 */
	public static int getMoves() {
		return moveCount;
	}
	

	/**
	 * Returns a string representation of the current state in the game. It will
	 * have all the cards listed in their respective piles.
     * @return String, representing the game. 
	 */
	public String toString() {
		String tableauString = "";
		for(int i = 0; i < 8; i++) {
			tableauString = tableauString + "Tableau " + (i+1) + ": " + this.tableauList.get(i).toString() +"\n";
		}
		String freecellString = "";
		for(int i = 0; i < 4; i++) {
			freecellString = freecellString + "Tableau " + (i+1) + ": " + this.freecellList.get(i).toString() + "\n"; 
		}
		String foundationsString = "";
		for(int i = 0; i < 4; i++) {
			foundationsString = foundationsString + "Foundation " + (i+1) + ": " + this.foundationsList.get(i).toString() + "\n"; 
		}
		return tableauString + freecellString + foundationsString;
	}
	
	/**
	 * Move takes two different piles as the parameters. Any of the three subclasses can be used
	 * but they must be wrapped in the AbstractCell parent class (for ex: (AbstractCell)tableau1)
	 * @param fromCell - cell subclass typecast as AbstractCell
	 * @param toCell - cell subclass typecast as AbstractCell
	 */
	public boolean move(CellInterface fromCell, CellInterface toCell) {
		if (toCell.moveFrom(fromCell)) {
			moveCount ++;
			//System.out.println(moveCount);
			return true;
		}
		else {
			return false;
		}
	}
	/**
	 * Creates a new game. Clears all the cards in the piles and redistributes a shuffled deck
	 * into the tableau piles. 
	 */
	public void newGame() {
		for(CellInterface i: this.freecellList){
			i.clear();
		}
		for (CellInterface i: this.foundationsList) {
			i.clear();
		}
		for(CellInterface i: this.tableauList) {
			i.clear();
		}
		this.setup();
		moveCount = 0;
		
	}
	
	/**
	 * Checks to see if the game has been won
	 * @return boolean - true if has been won, false if has not
	 */
	public boolean gameHasWinner() {
		for (CellInterface foundPile : foundationsList) {
			if (!(foundPile.size() ==13)) {
				return false;
			}
		
		}
		return true;
	}
	/**
	 * Checks to see if the game has been lost
	 * @return boolean - true if has been lost, false if has not
	 */
	public boolean gameHasLoser() {
		for (CellInterface fcpile : freecellList) {
			if (!(fcpile.size() == 1)) {
				return false;
			}
			for (CellInterface tabpile : tableauList) {
				if (tabpile.canMoveFrom(fcpile)) {
					return false;
				}
			}
			for (CellInterface foundPile : foundationsList) {
				if (foundPile.canMoveFrom(fcpile)) {
					return false;
				}
			}
		}
		for (CellInterface tabpile : tableauList) {
			for (CellInterface foundPile : foundationsList) {
				if (foundPile.canMoveFrom(tabpile)) {
					return false;
				}
			}
			for (CellInterface tabpile2 : tableauList) {
				if (tabpile2.canMoveFrom(tabpile)) {
					return false;
				}
			}
		}
		return true;
	}

	
	/**
	 * Gets the list that holds the information in the tableuax piles.
	 * @return the tableau list
	 */
	public CellInterface getTableauCell(int i) {
		
	//public ArrayList<CellInterface> getTableauCell(int i) {
		return this.tableauList.get(i);
	}
	/**
	 * Gets the list that holds the freecells and the information within the list.
	 * @return the freecell list
	 */
	public CellInterface getFreeCell(int i) {
	//public ArrayList<CellInterface> getFreeCell() {
		return this.freecellList.get(i);
	}
	/**
	 * Gets the list that holds all the foundation piles and the information that lies 
	 * within those objects. 
	 * @return the foundations list
	 */
	public CellInterface getFoundationCell(int i) {
	//public ArrayList<CellInterface> getFoundation() {
		return this.foundationsList.get(i);
	}
	
}