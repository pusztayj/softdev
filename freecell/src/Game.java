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
	private ArrayList<Tableau> tableauList;
	private ArrayList<FreeCell> freecellList;
	private ArrayList<Foundations> foundationsList;

	/**
     * Constructor for the game that creates all of the piles, the deck and distributes the 
     * cards randomly to the tableau piles.
     */
	public Game(){
		this.freecellList = new ArrayList<FreeCell>(); 
		for(int i = 0; i<4; i++){
			this.freecellList.add(new FreeCell());
		}
		this.foundationsList = new ArrayList<Foundations>();
		for(int i = 0; i < 4; i++) {
			this.foundationsList.add(new Foundations());
		}
		this.tableauList = new ArrayList<Tableau>();
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
			for(Tableau tab : tableauList) {
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
		System.out.println(fromCell.getClass());
		System.out.println(fromCell);
		System.out.println(toCell.getClass());
		System.out.println(toCell);
		return toCell.moveFrom(fromCell);
	}
	/**
	 * Creates a new game. Clears all the cards in the piles and redistributes a shuffled deck
	 * into the tableau piles. 
	 */
	public void newGame() {
		for(FreeCell i: this.freecellList){
			i.clear();
		}
		for (Foundations i: this.foundationsList) {
			i.clear();
		}
		for(Tableau i: this.tableauList) {
			i.clear();
		}
		this.setup();
		
	}
	
	
	public boolean gameHasWinner() {
		for (Foundations foundPile : foundationsList) {
			if (!(foundPile.size() ==13)) {
				return false;
			}
		
		}
		return true;
	}
	
	public boolean gameHasLoser() {
		for (FreeCell fcpile : freecellList) {
			if (!(fcpile.size() == 1)) {
				return false;
			}
			for (Tableau tabpile : tableauList) {
				if (tabpile.canMoveFrom(fcpile)) {
					return false;
				}
			}
			for (Foundations foundPile : foundationsList) {
				if (foundPile.canMoveFrom(fcpile)) {
					return false;
				}
			}
		}
		for (Tableau tabpile : tableauList) {
			for (Foundations foundPile : foundationsList) {
				if (foundPile.canMoveFrom(tabpile)) {
					return false;
				}
			}
			for (Tableau tabpile2 : tableauList) {
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
	public ArrayList<Tableau> getTableau() {
		return this.tableauList;
	}
	/**
	 * Gets the list that holds the freecells and the information within the list.
	 * @return the freecell list
	 */
	public ArrayList<FreeCell> getFreeCell() {
		return this.freecellList;
	}
	/**
	 * Gets the list that holds all the foundation piles and the information that lies 
	 * within those objects. 
	 * @return the foundations list
	 */
	public ArrayList<Foundations> getFoundation() {
		return this.foundationsList;
	}
	
}
