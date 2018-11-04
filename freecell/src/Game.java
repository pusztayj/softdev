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
	private Tableau tableau1;
	private Tableau tableau2;
	private Tableau tableau3;
	private Tableau tableau4;
	private Tableau tableau5;
	private Tableau tableau6;
	private Tableau tableau7;
	private Tableau tableau8;
	
	public Game(){
		this.freecell1 = new FreeCell();
		this.freecell2 = new FreeCell();
		this.freecell3 = new FreeCell();
		this.freecell4 = new FreeCell();
		this.foundations1 = new Foundations(Suit.spade);
		this.foundations2 = new Foundations(Suit.heart);
		this.foundations3 = new Foundations(Suit.diamond);
		this.foundations4 = new Foundations(Suit.club);
		this.tableau1 = new Tableau();
		this.tableau2 = new Tableau();
		this.tableau3 = new Tableau(); 
		this.tableau4 = new Tableau();
		this.tableau5 = new Tableau();
		this.tableau6 = new Tableau();
		this.tableau7 = new Tableau();
		this.tableau8 = new Tableau();
		this.deck = new Deck();
		this.deck.shuffle();
		this.setup();
	}
	
	public void setup() {
		for(int i = 0; i<6; i++) {
			tableau1.add(this.deck.deal());
			tableau2.add(this.deck.deal());
			tableau3.add(this.deck.deal());
			tableau4.add(this.deck.deal());
			tableau5.add(this.deck.deal());
			tableau6.add(this.deck.deal());
			tableau7.add(this.deck.deal());
			tableau8.add(this.deck.deal());
		}
		tableau1.add(this.deck.deal());
		tableau2.add(this.deck.deal());
		tableau3.add(this.deck.deal());
		tableau4.add(this.deck.deal());
	}
	
	public String toString() {
		return "Tableau 1: " + this.tableau1.toString() +"\n" + "Tableau 2: " + this.tableau2.toString() + "\n" +
				"Tableau 3: " + this.tableau3.toString() +"\n" + "Tableau 4: " + this.tableau4.toString() + "\n" +
				"Tableau 5: " + this.tableau5.toString() +"\n" + "Tableau 6: " + this.tableau6.toString() + "\n" +
				"Tableau 7: " + this.tableau7.toString() +"\n" + "Tableau 8: " + this.tableau8.toString() + "\n" + 
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
		this.tableau1 = new Tableau();
		this.tableau2 = new Tableau();
		this.tableau3 = new Tableau(); 
		this.tableau4 = new Tableau();
		this.tableau5 = new Tableau();
		this.tableau6 = new Tableau();
		this.tableau7 = new Tableau();
		this.tableau8 = new Tableau();
		this.deck = new Deck();
		this.deck.shuffle();
		this.setup();
	}
}
