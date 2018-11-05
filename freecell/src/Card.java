import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 * Represents a playing card with a suit,
 * rank, image, and face up status.
 * @author lambertk
 * @author pusztayj
 * @author dut
 * @author babikr
 * @author brandl
 */

public class Card implements Comparable<Card>{

    private Suit suit;
    private int rank;
    private boolean faceUp;
    private Icon image;
    private static Icon CARD_BACK;

    /**
     * Constructor.
     * @param suit the card's suit
     * @param rank the card's rank
     */
    public Card(Suit suit, int rank){
    this.suit = suit;
    this.rank = rank;
    faceUp = false;
    image = getImageFromFile(rank, suit);
    if (CARD_BACK == null)
    CARD_BACK = getBackFromFile();
    }

    /**
     * Returns the card's face image if its face is up or its back side image otherwise.
     * @return the card's face image or the back side image
     */
    public Icon getImage(){
    if (faceUp)
       return image;
    else
       return CARD_BACK;
    }

    /**
     * Returns the back side image of a card.
     * @return the back side image of a card
     */
    public static Icon getBack(){
    if (CARD_BACK == null)
       new Card(Suit.spade, 1);
    return CARD_BACK;
    }

    
    /**
     * Turns the card over, negating its face up status.
     */
    public void turn(){
    faceUp = ! faceUp;
    }

    private Icon getImageFromFile(int rank, Suit suit){
    String fileName = "DECK/";
    fileName += rank;
    fileName += Character.toUpperCase(suit.toString().charAt(0));
    fileName += ".GIF";
    return new ImageIcon(getClass().getResource(fileName));
    }

    private Icon getBackFromFile(){
    String fileName = "DECK/CARDBACK.GIF";
    return new ImageIcon(getClass().getResource(fileName));
    }

    /**
     * Returns the card's face up status.
     * @return true if face up or false otherwise
     */
    public boolean isFaceUp(){
       return faceUp;
    }

    /**
     * Returns the card's suit.
     * @return the card's suit
     */
    public Suit getSuit(){
        return suit;
    }
    
    /**
     * Returns the card's rank
     * @return the card's rank
     */
    public int getRank(){
        return rank;
    }
    
    /**
     * Returns the color, red or black, of the card
     * @return a string of black or red for the color of the card
     */
    public String getColor() {
    	if (this.getSuit() == Suit.club || this.getSuit() == Suit.diamond) {
    		return "black";
    	}
    	else {
    		return "red";
    	}
    }

    /**
     * Compares two cards with respect to rank
     * @param a card you want to compare
     * @return 0 if equal, less than 0 if less, greater than 0 if greater
     */
    public int compareTo(Card other){
        return this.rank - other.rank;
    }
    
    /**
     * Checks to see if the card in the argument is of the same color
     * (red or black) as this card 
     * @return boolean true if they are the same color, false if not
     * @param a card you want to compare
     */
    public boolean sameColor(Card other){
    	if (this.getColor() == other.getColor()){
    		return true;
    	}
    	else {
    		return false;
    	}
    }

    /**
     * Returns the string representation of the card (rank of suit)
     * @return the string representation of the card
     */
    public String toString(){
        return rankToString(rank) + " of " + suit;
    }

    /**
     * Returns the string representation of the card for ranks greater than 10
     * @param rank of the card
     * @return the string representation of the card
     */
    static private String rankToString(int rank){
        if (rank >= 2 && rank <= 10) return rank + "";
        else if (rank == 11) return "Jack";
        else if (rank == 12) return "Queen";
        else if (rank == 13) return "King";
        else return "Ace";
    }
}
