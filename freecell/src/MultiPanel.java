import javax.swing.*;
import java.awt.*;

/**
 * Displays the multipanel with card images 
 * for the Tableau piles of a free cell game
 * @author lambertk
 * @author pusztayj
 * @author dut
 * @author babikr
 * @author brandl
 */

public class MultiPanel extends AbstractPanel {

    /**
     * Constructor for an empty multipanel, displays a wire frame. 
     * @param cell - the cell 
	 */
	public MultiPanel(CellInterface cell, ViewInformer v) {
		super(cell, v);
	}
    /**
     * Paints the multiple cards face image if cards are present,
     * otherwise, paints the back side image.
	 * @param g - the graphics
	 */
	 public void paintComponent(Graphics g){
	    	super.paintComponent(g);
	    	Icon image;
	    	
	    	// initial y placement of 4
	    	int y = 8; 
	    	
	    	
	    	if ((panelCell == null) || panelCell.isEmpty()){
	    		image = Card.getBack();
	    		g.setColor(Color.yellow);
	    		int x = ((getWidth() - image.getIconWidth()) / 2);
	    		g.drawRect(x - 4, y - 4, image.getIconWidth() + 8, 
	    				(image.getIconHeight() + 8));
	    		
	    		g.setColor(Color.orange);
	    		g.drawRect(x - 3, y - 3, image.getIconWidth() + 6, 
	    				(image.getIconHeight() + 6));
	    	}
	    	
	    	else{
	    		
	    		for (int i = 0; i < panelCell.size(); i++) {
	    			y += 30;
	    			Card displayCard = panelCell.get(i);
	    			image = displayCard.getImage();
	    			int x = (getWidth() - image.getIconWidth()) / 2;
	    			image.paintIcon(this,  g,  x, y);
	    		}
	    		
	    	}
	    	
	    }
}
