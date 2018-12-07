import java.util.*;
/**
 * The FreeCellAI class for FreeCell game. It generates all the possbile moves
 * and executes the move with the highest weight.
 * @author pusztayj
 * @author dut
 * @author babikr
 * @author brandl
 * @version 1.0
 */
public class FreeCellAI {

	private Game game;
	//private HashMap<Move,Integer> allMoves;
	//private Move bestMove;
	//private int highestWeight;
	/**
	 * Constructor for the FreeCellAI, must pass a game object into the object.
	 * @param game
	 */
	public FreeCellAI(Game game) {
		this.game = game;
	}
	/**
	 * Creates a hash map with all possible moves. The key is a move object
	 * and the value is the move weight which is an integer.
	 * @return HashMap with all possible moves
	 */
	public HashMap<Move,Integer> generateMoves() {
		HashMap<Move,Integer> allMoves = new HashMap<Move,Integer>();
		//Generate all moves between tableau piles
		for(int i = 0; i < 8; i++) {
			for(int j = 0; j < 8; j++) {
//		for(CellInterface fromTableau: game.getTableau()) {
//			for(CellInterface toTableau: game.getTableau()) {
				CellInterface fromTableau = game.getTableauCell(i);
				CellInterface toTableau = game.getTableauCell(j);
				if(toTableau.canMoveFrom(fromTableau)) {
					Move move = new Move(fromTableau,toTableau,this.game);
					allMoves.put(move, move.getWeight());
				}
			}
		}
		//Generates all moves from Tableau to FreeCell
		for(int i = 0; i < 8; i++) {
		//for(CellInterface fromTableau: game.getTableau()) {
			for(int j = 0; j < 4; j++) {
			//for(CellInterface toFreeCell: game.getFreeCell()) {
				CellInterface fromTableau = game.getTableauCell(i);
				CellInterface toFreeCell = game.getFreeCell(j);
				if(toFreeCell.canMoveFrom(fromTableau)) {
					Move move = new Move(fromTableau,toFreeCell,this.game);
					allMoves.put(move, move.getWeight());					
				}
			}
		}
		//Generates all moves from Tableau to Home cell
		for(int i = 0; i < 8; i++) {
		//for(CellInterface fromTableau: game.getTableau()) {
			for(int j = 0; j < 4; j++) {
			//for(CellInterface toHomeCell: game.getFoundation()) {
				CellInterface fromTableau = game.getTableauCell(i);
				CellInterface toHomeCell = game.getFoundationCell(j);
				if(toHomeCell.canMoveFrom(fromTableau)){
					Move move = new Move(fromTableau,toHomeCell, this.game);
					allMoves.put(move, move.getWeight());	
				}
			}
		}
		//Generates all moves from Free cells to tableau
		for(int i=0;i<4;i++) {
		//for(CellInterface fromFreeCell: game.getFreeCell()) {
			for(int j = 0; j < 8; j++) {
			//for(CellInterface toTableau: game.getTableau()) {
				CellInterface fromFreeCell = game.getFreeCell(i);
				CellInterface toTableau = game.getTableauCell(j);
				if(toTableau.canMoveFrom(fromFreeCell)){
					Move move = new Move(fromFreeCell,toTableau,this.game);
					allMoves.put(move, move.getWeight());
				}
			}
		}
		//Generates all moves from free cells to home cells
		for(int i = 0; i<4; i++) {
		//for(CellInterface fromFreeCell: game.getFreeCell()) {
			for(int j = 0; j < 4; j++) {
			//for(CellInterface toHomeCell: game.getFoundation()) {
				CellInterface fromFreeCell = game.getFreeCell(i);
				CellInterface toHomeCell = game.getFoundationCell(j);
				if(toHomeCell.canMoveFrom(fromFreeCell)){
					Move move = new Move(fromFreeCell,toHomeCell, this.game);
					allMoves.put(move, move.getWeight());
				}
			}
		}
		return allMoves;
	}
	/**
	 * Executes the best move in the hash map based on the highest value. 
	 */
	public void executeMove() {
		int highestWeight = -10000;
		Move bestMove = null;
		HashMap<Move,Integer> allMoves = this.generateMoves();
		for (HashMap.Entry<Move, Integer> entry : allMoves.entrySet()) {
			if (entry.getValue() >= highestWeight) {
				bestMove = entry.getKey();
				highestWeight = entry.getValue();
			}
		}
		try {
			game.move(bestMove.getFrom(), bestMove.getTo());
		}
		catch (NullPointerException e) {
			;
		}
	}
}
