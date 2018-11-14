import javax.swing.*;
import java.awt.*;

/**
 * Represents a playing card with a suit,
 * rank, image, and face up status.
 * @author lambertk
 * @author pusztayj
 * @author dut
 * @author babikr
 * @author brandl
 */

/**
 * Represents the GUI component for painting an image of a playing card.
 *
 */
public class CellPanel extends JPanel{

    protected CellInterface panelCell;

    /**
     * Constructor for an empty panel, displays a wire frame. 
     */
    public CellPanel(CellInterface cell){
        panelCell = cell;
        setBackground(new Color(0, 150, 0));
    }

    /**
     * Paints the card's face image if a card is present, otherwise, paints the back side image.
     */
    
    public void paintComponent(Graphics g){
    	super.paintComponent(g);
    	Icon image;
    	
    	// initial y placement of 0
    	int y = 0;
    	
    	
    	if ((panelCell == null) || (panelCell.isEmpty())){
    		image = Card.getBack();
    		g.setColor(Color.yellow);
    		int x = (getWidth() - image.getIconWidth()) / 2;
    		g.drawRect(x, y, image.getIconWidth(), image.getIconHeight());
    	}
    	else{
    		Card topCard = panelCell.get();
    		//topCard.turn();
    		image = topCard.getImage();
    		int x = (getWidth() - image.getIconWidth()) / 2;
    		image.paintIcon(this, g, x, y);
    	}
    }
    
    public CellInterface getCell() {
    	return panelCell;
    }
    
    public void setCell(CellInterface c) {
    	panelCell = c;
    	repaint();
    }
}
