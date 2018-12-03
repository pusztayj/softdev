import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

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
    private AbstractPanel firstClick;
    private AppViewInformer vi;
    private FreeCellAI ai;
    private JLabel moveCounter;
    
    
    private class AppViewInformer implements ViewInformer{

    	  	
    	public void panelPressed(AbstractPanel panel) {
    		if(firstClick == null) {

    	    	firstClick = panel;
    	    	
    		}
    		else if (firstClick == panel){

    			firstClick = null;
    		}
    		
    	    else {
    	    	AbstractPanel secondClick = panel;

    	    	if(game.move(firstClick.getCell(), secondClick.getCell())) {
    	    		firstClick.repaint();
    	    		secondClick.repaint();
    	    		moveCounter.setText("Move Count: " + game.getMoves());
    	    		firstClick = null;
    	    	
        	    	if(game.gameHasWinner()) {
        	    		JOptionPane.showMessageDialog(null,"Congratulations! You have won!");
        	    	}
        	    	else if (game.gameHasLoser()) {
        	    		//Insert pop up for losing
        	    		JOptionPane.showMessageDialog(null,"You have lost. No more possible moves!");
        	    	}
        	    }
    	    	else {
    	    		JOptionPane.showMessageDialog(null,"Illegal move!");
    	    		firstClick = null;

    	    	}
    	    }
    	}
    }
    
    
    /**
     * Sets up the display (panels, buttons, and labels) for the game of war
     * @param game - the WarGame object
     */
    
   
    public FreeCellView(Game game){
        this.game = game;
        ai = new FreeCellAI(game);
        this.setTitle("Free Cell");
        //this.setBackground(new Color(0, 150, 0));
        Container c = getContentPane();
        GridBagLayout layout = new GridBagLayout();
        c.setLayout(layout);
        AppViewInformer vi = new AppViewInformer();
        
        
        // Define Constraints for Top Labels
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = 0;
        constraints.gridwidth = 4;
        constraints.gridheight = 1;

       

        // Create Top Labels
        JLabel freeCellLabel = new JLabel("Free Cells");
        constraints.gridx = 0;
        constraints.gridy = 0;
        layout.setConstraints(freeCellLabel, constraints);
        c.add(freeCellLabel);
        
        moveCounter = new JLabel("Move Count: " + game.getMoves());
        constraints.gridx = 2;
        constraints.gridy = 0;
        layout.setConstraints(moveCounter, constraints);
        c.add(moveCounter);
        
        JLabel homeCellLabel = new JLabel("Home Cells");
        constraints.gridx = 4;
        constraints.gridy = 0;
        layout.setConstraints(homeCellLabel, constraints);
        c.add(homeCellLabel);
        
        
        
        // Create lists for each cell type 
        ArrayList<CellPanel> freecellPanels = new ArrayList<CellPanel>();
        ArrayList<CellPanel> foundationPanels = new ArrayList<CellPanel>();
        ArrayList<MultiPanel> tableauPanels = new ArrayList<MultiPanel>();
        
        // Define Constraints for Top Cells
        constraints.fill = 1;
        constraints.weightx = .5;
        constraints.weighty = .5;
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        
        // Create Top Cells
        for(int i = 0; i < 4; i++) {
        	freecellPanels.add(new CellPanel(game.getFreeCell().get(i), vi));
        	freecellPanels.get(i).setBackground(new Color(0, 150, 0));
        	layout.setConstraints(freecellPanels.get(i), constraints);
        	constraints.gridx += 1;
        	c.add(freecellPanels.get(i));
        }
        for(int i = 0; i < 4; i++) {
        	foundationPanels.add(new CellPanel(game.getFoundation().get(i), vi));
        	foundationPanels.get(i).setBackground(new Color(0, 150, 0));
        	layout.setConstraints(foundationPanels.get(i), constraints);
        	constraints.gridx += 1;
        	c.add(foundationPanels.get(i));
        }
        
        // Define constraints for bottom cells

        constraints.weightx = 1;
        constraints.weighty = 1;
        constraints.gridx = 0;
        constraints.gridy = 2;
        
        
        // Create bottom cells 
        for(int i = 0; i < 8; i++) {
        	tableauPanels.add(new MultiPanel(game.getTableau().get(i), vi));
        	tableauPanels.get(i).setBackground(new Color(0, 150, 0));
        	layout.setConstraints(tableauPanels.get(i), constraints);
        	constraints.gridx += 1;
        	c.add(tableauPanels.get(i));
        }
        
        // Create reset button 
        JButton newGameButton = new JButton("New Game");
        JButton hint = new JButton("Hint");
        JButton newBackground = new JButton("New Background");
        
        constraints.weightx = 0;
        constraints.weighty = 0;
        constraints.gridwidth = 2;
        constraints.gridx = 3;
        constraints.gridy = 3;
        layout.setConstraints(newGameButton, constraints);
        c.add(newGameButton);
        
        constraints.weightx = 0;
        constraints.weighty = 0;
        constraints.gridwidth = 2;
        constraints.gridx = 5;
        constraints.gridy = 3;
        layout.setConstraints(hint, constraints);
        c.add(hint);
        
        constraints.weightx = 0;
        constraints.weighty = 0;
        constraints.gridwidth = 2;
        constraints.gridx = 1;
        constraints.gridy = 3;
        layout.setConstraints(newBackground, constraints);
        c.add(newBackground);
        
        
        
        // New Game Button Listener
        newGameButton.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        	game.newGame();
	        	firstClick = null;
	        	FreeCellView.this.repaint();
	        	moveCounter.setText("Move Count: " + game.getMoves());
	        	}
	        });
        
        //Hint Button Listener
        hint.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	//ai.generateMoves();
            	ai.executeMove();
            	FreeCellView.this.repaint();
	        	moveCounter.setText("Move Count: " + game.getMoves());
            	}
            });
        
        //New Background Button Listener
        newBackground.addActionListener(new ActionListener() {
        	int counter = 0;
        	public void actionPerformed(ActionEvent e) {
    			Random rand = new Random();
        		counter++;
        		if (counter > 7)
        			counter = 1;
        		// First Alternate Color: Blue
        		if (counter == 1) {
        			for(int i = 0; i < 4; i++) {
        	        	freecellPanels.get(i).setBackground(new Color(0, 0, 150));
        	        	foundationPanels.get(i).setBackground(new Color(0, 0, 150));
        			}
        	        for(int i = 0; i < 8; i++) {
        	           	tableauPanels.get(i).setBackground(new Color(0, 0, 150));
        	        }
        			
        		}
        		//Second Alternate Color: Red
        		else if (counter == 2) {
        			for(int i = 0; i < 4; i++) {
        	        	freecellPanels.get(i).setBackground(new Color(150, 0, 0));
        	        	foundationPanels.get(i).setBackground(new Color(150, 0, 0));
        			}
        	        for(int i = 0; i < 8; i++) {
        	           	tableauPanels.get(i).setBackground(new Color(150, 0, 0));
        	        }
				}
        		//Third Alternate Color: Random Green
        		else if (counter == 3) {
        			int n1 = rand.nextInt(25) + 1;
        			int n2 = rand.nextInt(150) + 1;
        			int n3 = rand.nextInt(25) + 1;
        			for(int i = 0; i < 4; i++) {
        	        	freecellPanels.get(i).setBackground(new Color(n1, n2, n3));
        	        	foundationPanels.get(i).setBackground(new Color(n1, n2, n3));
        			}
        	        for(int i = 0; i < 8; i++) {
        	           	tableauPanels.get(i).setBackground(new Color(n1, n2, n3));
        	        }
				}
        		
        		//Fourth Alternate Color: Random Blue
        		else if (counter == 4) {
        			int n1 = rand.nextInt(25) + 1;
        			int n2 = rand.nextInt(25) + 1;
        			int n3 = rand.nextInt(150) + 1;
        			for(int i = 0; i < 4; i++) {
        	        	freecellPanels.get(i).setBackground(new Color(n1, n2, n3));
        	        	foundationPanels.get(i).setBackground(new Color(n1, n2, n3));
        			}
        	        for(int i = 0; i < 8; i++) {
        	           	tableauPanels.get(i).setBackground(new Color(n1, n2, n3));
        	        }
				}
        		
        		//Fifth Alternate Color: Random Red
        		else if (counter == 5) {
        			int n1 = rand.nextInt(150) + 1;
        			int n2 = rand.nextInt(25) + 1;
        			int n3 = rand.nextInt(25) + 1;
        			for(int i = 0; i < 4; i++) {
        	        	freecellPanels.get(i).setBackground(new Color(n1, n2, n3));
        	        	foundationPanels.get(i).setBackground(new Color(n1, n2, n3));
        			}
        	        for(int i = 0; i < 8; i++) {
        	           	tableauPanels.get(i).setBackground(new Color(n1, n2, n3));
        	        }
				}
        		//Sixth Alternate Color: Black
        		else if (counter == 6) {
        			for(int i = 0; i < 4; i++) {
        	        	freecellPanels.get(i).setBackground(new Color(0, 0, 0));
        	        	foundationPanels.get(i).setBackground(new Color(0, 0, 0));
        			}
        	        for(int i = 0; i < 8; i++) {
        	           	tableauPanels.get(i).setBackground(new Color(0, 0, 0));
        	        }
				}
        		
        		//Revert back to Green
        		else {
        			for(int i = 0; i < 4; i++) {
        	        	freecellPanels.get(i).setBackground(new Color(0, 150, 0));
        	        	foundationPanels.get(i).setBackground(new Color(0, 150, 0));
        			}
        	        for(int i = 0; i < 8; i++) {
        	           	tableauPanels.get(i).setBackground(new Color(0, 150, 0));
        	        }
				}
			        	}
			        });
        
    
        
    }
    /**
     * Generates a popup telling the player they won.
     */
    public void gameWon() {
    	JOptionPane.showMessageDialog(null,"Congratulations! You won!");
    }
    /**
     * Generates a pop up telling the player that they lost.
     */
    public void gameLost() {
    	JOptionPane.showMessageDialog(null,"No more you possible moves!");
    }
    /**
     * Generates a pop up to tell the player that move is illegal
     */
    public void illegalMove() {
    	JOptionPane.showMessageDialog(null,"Illegal move!");
    }
    

}