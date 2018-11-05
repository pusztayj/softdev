import java.util.*;

public class Game {
	
	private Deck deck;
	private FreeCell freecell1;
	private FreeCell freecell2;
	private FreeCell freecell3;
	private FreeCell freecell4;
	private Foundations foundations1;
	private Foundations foundations2;
	private Foundations foundations3;
	private Foundations foundations4;

	private ArrayList<Tableau> tableauList; 
	
	public Game(){
		this.freecell1 = new FreeCell();
		this.freecell2 = new FreeCell();
		this.freecell3 = new FreeCell();
		this.freecell4 = new FreeCell();
		this.foundations1 = new Foundations(Suit.spade);
		this.foundations2 = new Foundations(Suit.heart);
		this.foundations3 = new Foundations(Suit.diamond);
		this.foundations4 = new Foundations(Suit.club);
		this.tableauList = new ArrayList<Tableau>();
		for(int i = 0; i<8; i++) {
			this.tableauList.add(new Tableau());
		}
		this.deck = new Deck();
		this.deck.shuffle();
		this.setup();
	}
	
	public void setup() {
		for(int i = 0; i<6; i++) {
			for(Tableau tab : tableauList) {
				tab.add(this.deck.deal());
			}
		}
		tableauList.get(0).add(this.deck.deal());
		tableauList.get(1).add(this.deck.deal());
		tableauList.get(2).add(this.deck.deal());
		tableauList.get(3).add(this.deck.deal());
	}
	
	public String toString() {
		String tableauString = "";
		for(int i = 0; i < 8; i++) {
			tableauString = tableauString + "Tableau " + (i+1) + ": " + this.tableauList.get(i).toString() +"\n";
		}
		return tableauString +
				"Free Cell 1: " + this.freecell1.toString() +"\n" + "Free Cell 2: " + this.freecell2.toString() +"\n" +
				"Free Cell 3: " + this.freecell3.toString() +"\n" + "Free Cell 4: " + this.freecell4.toString() +"\n" +
				"Foundation Pile (Spade): " + this.foundations1.toString() +"\n" + 
				"Foundation Pile (Heart): " + this.foundations2.toString() +"\n" +
				"Foundation Pile (Diamond): " + this.foundations3.toString() +"\n" +
				"Foundation Pile (Club): " + this.foundations4.toString();
	}
	
	/**
	 * Move takes two different piles as the parameters. Any of the three subclasses can be used
	 * but they must be wrapped in the AbstractCell parent class (for ex: (AbstractCell)tableau1)
	 * @param fromCell - cell subclass typecast as AbstractCell
	 * @param toCell - cell subclass typecast as AbstractCell
	 */
	public void move(AbstractCell fromCell, AbstractCell toCell) {
		Card fromCard = fromCell.get();
		if(fromCell.canRemoveFrom(fromCard) && toCell.canAddTo(fromCard)) {
			toCell.add(fromCell.remove());
		}
	}
	
	public void newGame() {
		this.freecell1 = new FreeCell();
		this.freecell2 = new FreeCell();
		this.freecell3 = new FreeCell();
		this.freecell4 = new FreeCell();
		this.foundations1 = new Foundations(Suit.spade);
		this.foundations2 = new Foundations(Suit.heart);
		this.foundations3 = new Foundations(Suit.diamond);
		this.foundations4 = new Foundations(Suit.club);
		this.deck = new Deck();
		this.deck.shuffle();
		this.setup();
	}
	public static void main(String[] args) {
		Game a = new Game();
		System.out.println(a.tableauList.get(2));
	}
}
