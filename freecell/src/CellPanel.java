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

public class CellPanel extends JPanel implements MouseListener{

    protected CellInterface panelCell;
    private AbstractCell fromCell;

    /**
     * Constructor for an empty panel, displays a wire frame. 
     */
    public CellPanel(CellInterface cell){
        panelCell = cell;
        setBackground(new Color(0, 150, 0));
        addMouseListener(this);
    }

    /**
     * Paints the card's face image if a card is present, 
     * otherwise, paints the back side image.
     * @param g - the graphics
     */
    
    public void mouseReleased(MouseEvent e) {}
    public void mouseClicked(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
    public void mousePressed(MouseEvent e) {}
    
    public void paintComponent(Graphics g){
    	super.paintComponent(g);
    	Icon image;
    	
    	// initial y placement of 4
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
    				image.getIconHeight() + 8 + ((panelCell.size()-1) * 30));
    		
    		g.setColor(Color.orange);
    		g.drawRect(x - 3, y - 3, image.getIconWidth() + 6, 
    				image.getIconHeight() + 6 + ((panelCell.size()-1) * 30));
    		
    		Card topCard = panelCell.get();
    		//topCard.turn();
    		image = topCard.getImage();
    //		int x = ((getWidth() - image.getIconWidth()) / 2);
    		image.paintIcon(this, g, x, y);
    	}
    }
    /**
     * gets a panel cell from the model
     * @return panelCell - the cell you are getting 
     */
    public CellInterface getCell() {
    	return panelCell;
    }
    /**
     * updates the cell display in the view by repainting it
     *  @param c - the cell to update the display of
     */
    public void setCell(CellInterface c) {
    	panelCell = c;
    	repaint();
    }
}
