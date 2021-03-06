import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Represents the GUI component for painting an image of a playing card.
 * @author pusztayj
 * @author dut
 * @author babikr
 * @author brandl
 * @version 1.0
 */

public class CellPanel extends AbstractPanel {


    /**
     * Constructor for an empty panel, displays a wire frame. 
     * * @param cell - the cell 
     * @param v - the ViewInformer object
     */
    public CellPanel(CellInterface cell, ViewInformer v){
    	super(cell, v);
    }

    /**
     * Paints the card's face image if a card is present, 
     * otherwise, paints the back side image.    
     * Also paints yellow/orange borders around the piles
     * @param g - the graphics
     */
    
    public void paintComponent(Graphics g){
    	super.paintComponent(g);
    	Icon image;
    	
    	// initial y placement of 8
    	int y = 8;
    	
    	
    	if ((panelCell == null) || (panelCell.isEmpty())){
    		image = Card.getBack();
    		g.setColor(Color.yellow);
    		int x = ((getWidth() - image.getIconWidth()) / 2);
    		g.drawRect(x - 4, y - 4, image.getIconWidth() + 8, 
    				image.getIconHeight() + 8);
    		
    		g.setColor(Color.orange);
    		g.drawRect(x - 3, y - 3, image.getIconWidth() + 6, 
    				image.getIconHeight() + 6);
    	}
    	else{
    		image = Card.getBack();
    		g.setColor(Color.yellow);
    		int x = ((getWidth() - image.getIconWidth()) / 2);
    		g.drawRect(x - 4, y - 4, image.getIconWidth() + 8, 
    				image.getIconHeight() + 8);
    		
    		g.setColor(Color.orange);
    		g.drawRect(x - 3, y - 3, image.getIconWidth() + 6, 
    				image.getIconHeight() + 6);
    		
    		Card topCard = panelCell.get();

    		image = topCard.getImage();

    		image.paintIcon(this, g, x, y);
    	}
    }
}