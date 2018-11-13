import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * The main window for dealing from a deck of cards.
 * @author lambertk
 * @author pusztayj
 * @author dot
 * @author babikr
 * @author brandl
 * @version 1.0
 */
public class FreeCellView extends JFrame{

    private Game game;

    /**
     * Sets up the display (panels, buttons, and labels) for the game of war
     * @param game - the WarGame object
     */
    public FreeCellView(Game game){
        this.game = game;
        this.setTitle("Free Cell");


        // Top panel with labels
        JPanel headerPanel = new JPanel(new GridLayout(1,2));
        headerPanel.add(new JLabel("Free Cells", 0));
        headerPanel.add(new JLabel("Home Cells", 0));
        
        

        JPanel mainPanel = new JPanel(new GridLayout(2,8));
        mainPanel.setBackground (new Color(0,150,0));
        ArrayList<CellPanel> freecellPanels = new ArrayList<CellPanel>();
        ArrayList<CellPanel> foundationPanels = new ArrayList<CellPanel>();
        ArrayList<MultiPanel> tableauPanels = new ArrayList<MultiPanel>();
        for(int i = 0; i < 4; i++) {
        	freecellPanels.add(new CellPanel(game.getFreeCell().get(i)));
        	mainPanel.add(freecellPanels.get(i));
        }
        for(int i = 0; i < 4; i++) {
        	foundationPanels.add(new CellPanel(game.getFoundation().get(i)));
        	mainPanel.add(foundationPanels.get(i));
        }
        for(int i = 0; i < 8; i++) {
        	tableauPanels.add(new MultiPanel(game.getTableau().get(i)));
        	mainPanel.add(tableauPanels.get(i));
        }

        JButton newGameButton = new JButton("New Game");
        newGameButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
        	game.newGame();
        	FreeCellView.this.repaint();
        	
        	//Not needed, just repaint.
//        	for (int i=0; i< tableauPanels.size(); i++) {
//        		tableauPanels.get(i).setCell(game.getTableau().get(i));
//        		}
        	}
        });

        JPanel buttonPanel = new JPanel(new GridLayout(1,3));
        buttonPanel.add(newGameButton);

        //Container
        Container c = getContentPane();
        c.add(headerPanel, BorderLayout.NORTH);
        c.add(mainPanel, BorderLayout.CENTER);
        c.add(buttonPanel, BorderLayout.SOUTH);

    }
}
