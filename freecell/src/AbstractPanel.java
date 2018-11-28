import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class AbstractPanel extends JPanel implements MouseListener {
	
    protected CellInterface panelCell;
    private AbstractCell fromCell;
    private ViewInformer view;

    /**
     * Constructor for an empty panel, displays a wire frame. 
     */
    public AbstractPanel(CellInterface cell, ViewInformer v){
        panelCell = cell;
        setBackground(new Color(0, 150, 0));
        addMouseListener(this);
        view = v;
    }
    
    
    public void mouseReleased(MouseEvent e) {}
    public void mouseClicked(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
    public void mousePressed(MouseEvent e) {
    	view.panelPressed(this);

    }
    
    public void paintComponent(Graphics g) {
    	super.paintComponent(g);
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
