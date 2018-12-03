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
					Move move = new Move(fromTableau,toTableau,this.game);
					allMoves.put(move, move.getWeight());
				}
			}
		}
		//Generates all moves from Tableau to FreeCell
		for(Tableau fromTableau: game.getTableau()) {
			for(FreeCell toFreeCell: game.getFreeCell()) {
				if(toFreeCell.canMoveFrom(fromTableau)) {
					Move move = new Move(fromTableau,toFreeCell,this.game);
					allMoves.put(move, move.getWeight());					
				}
			}
		}
		//Generates all moves from Tableau to Home cell
		for(Tableau fromTableau: game.getTableau()) {
			for(Foundations toHomeCell: game.getFoundation()) {
				if(toHomeCell.canMoveFrom(fromTableau)){
					Move move = new Move(fromTableau,toHomeCell, this.game);
					allMoves.put(move, move.getWeight());	
				}
			}
		}
		//Generates all moves from Free cells to tableau
		for(FreeCell fromFreeCell: game.getFreeCell()) {
			for(Tableau toTableau: game.getTableau()) {
				if(toTableau.canMoveFrom(fromFreeCell)){
					Move move = new Move(fromFreeCell,toTableau,this.game);
					allMoves.put(move, move.getWeight());
				}
			}
		}
		//Generates all moves from free cells to home cells
		for(FreeCell fromFreeCell: game.getFreeCell()) {
			for(Foundations toHomeCell: game.getFoundation()) {
				if(toHomeCell.canMoveFrom(fromFreeCell)){
					Move move = new Move(fromFreeCell,toHomeCell, this.game);
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
		//System.out.println(allMoves);
		for (HashMap.Entry<Move, Integer> entry : allMoves.entrySet()) {
			if (entry.getValue() >= highestWeight) {
				bestMove = entry.getKey();
				highestWeight = entry.getValue();
			}
		//System.out.println(highestWeight);
		}
		try {
			game.move(bestMove.getFrom(), bestMove.getTo());
		}
		catch (NullPointerException e) {
			;
		}

//		System.out.println(bestMove);
//		System.out.println(bestMove.getLengthAfterMove());
		
	}
	
    public static void main(String[] args){
    	Game game = new Game();
    	FreeCellAI ai = new FreeCellAI(game);
    	System.out.println(ai.generateMoves());
    }
}
