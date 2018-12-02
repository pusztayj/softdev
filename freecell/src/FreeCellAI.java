import java.util.*;

public class FreeCellAI {

	private Game game;
	//private HashMap<Move,Integer> allMoves;
	//private Move bestMove;
	//private int highestWeight;
	
	public FreeCellAI(Game game) {
		this.game = game;
	}
	
	public HashMap<Move,Integer> generateMoves() {
		HashMap<Move,Integer> allMoves = new HashMap<Move,Integer>();
		//Generate all moves between tableau piles
		for(Tableau fromTableau: game.getTableau()) {
			for(Tableau toTableau: game.getTableau()) {
				if(toTableau.canMoveFrom(fromTableau)) {
					Move move = new Move(fromTableau,toTableau);
					allMoves.put(move, move.getWeight());
				}
			}
		}
		//Generates all moves from Tableau to FreeCell
		for(Tableau fromTableau: game.getTableau()) {
			for(FreeCell toFreeCell: game.getFreeCell()) {
				if(toFreeCell.canMoveFrom(fromTableau)) {
					Move move = new Move(fromTableau,toFreeCell);
					allMoves.put(move, move.getWeight());					
				}
			}
		}
		//Generates all moves from Tableau to Home cell
		for(Tableau fromTableau: game.getTableau()) {
			for(Foundations toHomeCell: game.getFoundation()) {
				if(toHomeCell.canMoveFrom(fromTableau)){
					Move move = new Move(fromTableau,toHomeCell);
					allMoves.put(move, move.getWeight());	
				}
			}
		}
		//Generates all moves from Free cells to tableau
		for(FreeCell fromFreeCell: game.getFreeCell()) {
			for(Tableau toTableau: game.getTableau()) {
				if(toTableau.canMoveFrom(fromFreeCell)){
					Move move = new Move(fromFreeCell,toTableau);
					allMoves.put(move, move.getWeight());
				}
			}
		}
		//Generates all moves from free cells to home cells
		for(FreeCell fromFreeCell: game.getFreeCell()) {
			for(Foundations toHomeCell: game.getFoundation()) {
				if(toHomeCell.canMoveFrom(fromFreeCell)){
					Move move = new Move(fromFreeCell,toHomeCell);
					allMoves.put(move, move.getWeight());
				}
			}
		}
		return allMoves;
	}
	
	public void executeMove() {
		int highestWeight = -10000;
		Move bestMove = null;
		HashMap<Move,Integer> allMoves = this.generateMoves();
		for(Move move : allMoves.keySet()) {
			if(allMoves.get(move) >= highestWeight) {
				bestMove = move;
				highestWeight = allMoves.get(move);
			}
		}
		System.out.println(bestMove);
		System.out.println(highestWeight);
		game.move(bestMove.getFrom(), bestMove.getTo());	
	}
	
    public static void main(String[] args){
    	Game game = new Game();
    	FreeCellAI ai = new FreeCellAI(game);
    	ai.generateMoves();
    	ai.executeMove();
    	//System.out.println(ai.allMoves.size());
    }
}
