import java.util.ArrayList;

public class Move {

	private CellInterface fromCell;
	private CellInterface toCell;
	private int weight;
	
	public Move(CellInterface from, CellInterface to) {
		fromCell = from;
		toCell = to;
		this.setWeight();
	}
	
	public String toString() {
		ArrayList<CellInterface> tempList = new ArrayList<CellInterface>();
		tempList.add(fromCell);
		tempList.add(toCell);
		return tempList.toString();
		
	}
	/*
	 * Sets the weight of a given move
	 */
	public void setWeight() {
		//Handles all moves from a tableau pile
		if(fromCell instanceof Tableau ) {
			//Handles moving from Tableau to Tableau
			if (toCell instanceof Tableau) {
				weight = 50;
			}
			//Handles moving from tableau to freecell
			if (toCell instanceof FreeCell) {
				weight = 10;
			}
			//Handles moving from tablea to home cell
			if (toCell instanceof Foundations) {
				weight = 1000;
			}
		}
		//For all moves from a free cell
		if(fromCell instanceof FreeCell) {
			// Handles move from free cell to tableau
			if (toCell instanceof Tableau) {
				weight = 500;
			}
			// Handles move from free cell to freecell
			if(toCell instanceof FreeCell) {
				weight = -1000;
			}
			// Handles moves from freecell to home cell
			if(toCell instanceof Foundations) {
				weight = 1000;
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
