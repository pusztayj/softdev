import javax.swing.*;
import java.awt.*;

public class MultiPanel extends CellPanel {

	public MultiPanel(CellInterface cell) {
		super(cell);
	}
	
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
