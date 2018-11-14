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

public class MultiPanel extends CellPanel {
    /**
     * Constructor for an empty multipanel, displays a wire frame. 
     */
	public MultiPanel(CellInterface cell) {
		super(cell);
	}
    /**
     * Paints the multiple cards face image if cards are present, otherwise, paints the back side image.
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
	    		for (int i = 0; i < panelCell.size(); i++) {
	    			Card displayCard = panelCell.get(i);
	    			//displayCard.turn();
	    			image = displayCard.getImage();
	    			int x = (getWidth() - image.getIconWidth()) / 2;
	    			image.paintIcon(this,  g,  x, y);
	    			y += 30;
	    		}
	    	}
	    }
}
