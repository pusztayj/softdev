
public class AITester {

	public static void main(String[] args){
		int wins = 0;
		int stuck = 0;
		int loss = 0;
		for(int i = 0; i <10000; i++) {
			Game game = new Game();
			FreeCellAI ai = new FreeCellAI(game);
			for(int j = 0; j < 150; j++) {
				ai.executeMove();
			}
			if(game.gameHasWinner()) {
					wins++;	
			}
			else if(game.gameHasLoser()) {
				loss++;
			}
			else {
				stuck++;
				}
		}
		System.out.println(wins);
		System.out.println(stuck);
		System.out.println(loss);
	}
}
